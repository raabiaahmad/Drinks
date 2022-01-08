package com.qa.springdrinks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springdrinks.domain.Drink;
import com.qa.springdrinks.repo.DrinkRepo;

@SpringBootTest
public class DrinkServiceUnitTest {
	
	@Autowired
	private DrinkService service;
	
	@MockBean
	private DrinkRepo repo;
	
	@Test
	public void createTest() {
		Drink input = new Drink("Hot Chocolate", "Hot", "Chocolate", 350);
		Drink output = new Drink(1L, "Hot Chocolate", "Hot", "Chocolate", 350);
	
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
	// Verifies the number of times the method is run
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
	@Test
	public void getAllTest() {
		List<Drink> output = new ArrayList<Drink>();
		output.add(new Drink(1L, "Hot Chocolate", "Hot", "Chocolate", 350));
		output.add(new Drink(2L, "Caramel Macchiato", "Hot", "Carmel", 200));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		assertEquals(output, this.service.getAll());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getByIdTest() {
		
	}
	
}
