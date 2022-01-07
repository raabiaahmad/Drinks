package com.qa.springdrinks.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DrinkTest {
	
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
	}
	
	@Test
	public void testNoIdConstructor() {
		Drink drink = new Drink("Caramel Macchiato", "Hot", "Caramel", 250);
		assertNotNull(drink.getName());
		assertNotNull(drink.getType());
		assertNotNull(drink.getFlavour());
		assertNotNull(drink.getVolume());
		
		assertEquals(drink.getName(), "Caramel Macchiato");
		assertEquals(drink.getType(), "Hot");
		assertEquals(drink.getFlavour(), "Caramel");
		assertEquals(drink.getVolume(), 250);
	}
	
	@Test
	public void testWithIdConstructor() {
		Drink drink = new Drink(1L, "Passion Mango", "Smoothie", "Passionfruit", 300);
		assertNotNull(drink.getId());
		assertNotNull(drink.getName());
		assertNotNull(drink.getType());
		assertNotNull(drink.getFlavour());
		assertNotNull(drink.getVolume());
		
		assertEquals(drink.getId(), 1L);
		assertEquals(drink.getName(), "Passion Mango");
		assertEquals(drink.getType(), "Smoothie");
		assertEquals(drink.getFlavour(), "Passionfruit");
		assertEquals(drink.getVolume(), 300);
	}
	
	@Test
	public void testSetters() {
		Drink drink = new Drink();
		
		drink.setId(2L);
		drink.setName("Mojito");
		drink.setType("Cold");
		drink.setFlavour("Passionfruit");
		drink.setVolume(200);
		
		assertNotNull(drink.getId());
		assertNotNull(drink.getName());
		assertNotNull(drink.getType());
		assertNotNull(drink.getFlavour());
		assertNotNull(drink.getVolume());
		
		assertEquals(drink.getId(), 2L);
		assertEquals(drink.getName(), "Mojito");
		assertEquals(drink.getType(), "Cold");
		assertEquals(drink.getFlavour(), "Passionfruit");
		assertEquals(drink.getVolume(), 200);
	}
	
	
}
