package com.qa.springdrinks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.springdrinks.domain.Drink;
import com.qa.springdrinks.repo.DrinkRepo;

@Service
public class DrinkService implements ServiceMethods<Drink>{
	
	private DrinkRepo repo;
	
//	Constructor
	public DrinkService(DrinkRepo repo) {
		this.repo = repo;
	}

	@Override
	public Drink create(Drink drink) {
		return this.repo.save(drink);
	}

	@Override
	public Drink getById(long id) {
		Optional<Drink> optionalDrink = this.repo.findById(id);
		if(optionalDrink.isPresent()) {
			return optionalDrink.get();
		}
		return null;
	}

	@Override
	public List<Drink> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Drink update(long id, Drink drink) {
		Optional<Drink> existingDrink = this.repo.findById(id);
		if (existingDrink.isPresent()) {
			Drink existing = existingDrink.get();
			existing.setName(drink.getName());
			existing.setType(drink.getType());
			existing.setFlavour(drink.getFlavour());
			existing.setVolume(drink.getVolume());
			
			return this.repo.saveAndFlush(existing);
		}
		return null;
	}
	
//	Deletes id, and boolean used to check if it has been deleted (true)
	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	

}
