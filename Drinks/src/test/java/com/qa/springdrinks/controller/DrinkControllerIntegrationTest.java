package com.qa.springdrinks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springdrinks.domain.Drink;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:drink-schema.sql", "classpath:drink-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

@ActiveProfiles("test")
public class DrinkControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		Drink entry = new Drink("Latte", "Hot", "Coffee", 200);
		Drink result = new Drink(2L, "Latte", "Hot", "Coffee", 200);
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(post("/drink/create")
				.content(entryAsJSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		List<Drink> output = new ArrayList <>();
		output.add(new Drink (1L,"Mirinda", "Fizzy", "Strawberry", 300));

		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/drink/readAll"))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		Drink entry = new Drink (1L,"Mirinda", "Fizzy", "Strawberry", 300);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/drink/readById/1"))
				.andExpect(status().isOk())
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Drink entry = new Drink ("Mirinda", "Fizzy", "Strawberry", 300);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		Drink updated = new Drink (1L, "Mirinda", "Fizzy", "Strawberry", 300);
		String updatedAsJSON = this.mapper.writeValueAsString(updated);
		
		mvc.perform(put("/drink/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(updatedAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/drink/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
