package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.People;

public interface InterfacePeople extends CrudRepository<People,Integer> {
	

}
