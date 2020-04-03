package com.semifir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semifir.models.Ingredient;
import com.semifir.services.IngredientService;

@RestController
@RequestMapping("ingredients")
@CrossOrigin
public class IngredientController {

	@Autowired
	private IngredientService service;
	
	@GetMapping("")
	public List<Ingredient> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping("")
	public Ingredient save(@RequestBody Ingredient entity) {
		return this.service.save(entity);
	}
	
	@GetMapping("{id}")
	public Ingredient findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	
}
