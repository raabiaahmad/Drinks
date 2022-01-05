package com.qa.springdrinks.service;

import java.util.List;

public interface ServiceMethods<T>{

//	Create
	T create (T t);
	
//	Read by Id
	T getById(long id);
	
//	Read All
	List<T> getAll();
	
//	Update
	T update(long id, T t);
	
//	Delete
	boolean delete(long id);
}
