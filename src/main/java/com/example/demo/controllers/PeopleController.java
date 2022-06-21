package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.InterfacePeopleService;
import com.example.demo.modelo.People;

@Controller
@RequestMapping
public class PeopleController {
	
	@Autowired
	private InterfacePeopleService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<People> peoples = service.Listar();
		model.addAttribute("peoples",peoples);
		return "index";
	}
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("people", new People());
		return "form.html";
	}
	@PostMapping("/save")
	public String save(@Valid People p,Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<People>persona=service.listarId(id);
		model.addAttribute("people", persona);
		return "form.html";
	}
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
	
}
