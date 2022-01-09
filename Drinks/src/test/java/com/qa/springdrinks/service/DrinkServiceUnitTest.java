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
	
	
//	@Test
//	public void getByIdTest() {
//		Drink correctOutput = new Drink(3L, "Sprite", "Fizzy", "Lime", 300);
//		
//		long correctIdInput = 3L;
//		long invalidIdInput = 4L;
//		
//		Optional<Drink> correctIdOutput = Optional.ofNullable((Drink) correctOutput);
//		Optional<Drink> invalidIdOutput = Optional.ofNullable(null);
//		
//		Mockito.when(this.repo.findById(3L)).thenReturn(correctIdOutput);
//		Mockito.when(this.repo.findById(4L)).thenReturn(invalidIdOutput);
//		
//		assertEquals(correctIdOutput.get(), this.service.getById(correctIdInput));
//		assertEquals(invalidIdOutput.get(), this.service.getById(invalidIdInput));
//		
//		Mockito.verify(this.repo, Mockito.times(1)).findById(3L);
//		Mockito.verify(this.repo, Mockito.times(1)).findById(4L);
//	}
//	
//	
//	@Test
//	public void updateTest() {
//		long id = 1L;
//		
//		Drink existingDrink = new Drink(id, "Hot Chocolate", "Hot", "Chocolate", 350);
//		Drink newValues = new Drink(id, "Latte", "Hot", "Coffee", 300);
//		Drink updatedDrink = new Drink(id, newValues.getName(), newValues.getType(), newValues.getFlavour(), newValues.getVolume());
//	
//		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existingDrink));
//		Mockito.when(this.repo.save(updatedDrink)).thenReturn(updatedDrink);
//		
//		assertEquals(updatedDrink, this.service.update(id, newValues));
//		
//		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
//		Mockito.verify(this.repo, Mockito.times(1)).save(updatedDrink);	
//	}
	
	
	@Test
	public void deleteTest() {
		long newId = 1L;
		
		Mockito.when(this.repo.existsById(newId)).thenReturn(false);
		assertEquals(true, this.service.delete(newId));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(newId);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(newId);
	}
	
}
