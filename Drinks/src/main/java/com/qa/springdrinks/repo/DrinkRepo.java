package com.qa.springdrinks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springdrinks.domain.Drink;

public interface DrinkRepo extends JpaRepository<Drink, Long>{

}
