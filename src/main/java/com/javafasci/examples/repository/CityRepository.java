package com.javafasci.examples.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javafasci.examples.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>{
	
	public City findByName(String cityName);
}
