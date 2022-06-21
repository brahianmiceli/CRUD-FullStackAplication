package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.People;

@Repository
public interface InterfacePeopleService {
	public List<People>Listar();
	
	public Optional<People>listarId(int id);
	
	public int save(People p);
	
	public void delete(int id);
	
}
