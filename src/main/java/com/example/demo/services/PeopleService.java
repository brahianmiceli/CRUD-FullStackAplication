package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.InterfacePeopleService;
import com.example.demo.interfaces.InterfacePeople;
import com.example.demo.modelo.People;


@Service
public class PeopleService implements InterfacePeopleService{
	
	@Autowired
	private InterfacePeople data;
	
	@Override
	public List<People> Listar() {
		
		return (List<People>)data.findAll();
	}

	@Override
	public Optional<People> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(People p) {
		int res=0;
		
		People persona = data.save(p);
		if(!persona.equals(null)) {
			res=1;
		}
		return 0;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
