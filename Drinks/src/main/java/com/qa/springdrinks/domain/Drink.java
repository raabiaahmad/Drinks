package com.qa.springdrinks.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Drink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	Name of drink	
	@NotNull(message = "Please enter a drink")
	private String name;

//	Type of drink
	@Column
	private String type;

//	Flavour
	@Column
	private String flavour;
	
//	Volume of liquid in ml
	@Column
	private long volume;

//	Default  constructor
	public Drink() {	
	}

//	Constructor for testing
	public Drink(long id, String name, String type, String flavour, long volume) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.flavour = flavour;
		this.volume = volume;
	}
	
//	Constructor for creation
	public Drink(String name, String type, String flavour, long volume) {
		super();
		this.name = name;
		this.type = type;
		this.flavour = flavour;
		this.volume = volume;
	}
	
//	Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", type=" + type + ", flavour=" + flavour + ", volume=" + volume
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(flavour, name, type, volume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		return Objects.equals(flavour, other.flavour) && Objects.equals(name, other.name)
				&& Objects.equals(type, other.type) && volume == other.volume;
	}

}
