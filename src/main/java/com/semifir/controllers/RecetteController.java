package com.semifir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semifir.models.Recette;
import com.semifir.services.RecetteService;

@RestController
@CrossOrigin
@RequestMapping("recettes")
public class RecetteController {

	@Autowired
	private RecetteService service;
	
	@GetMapping("")
	public List<Recette> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping("")
	public Recette save(@RequestBody Recette entity) {
		return this.service.save(entity);
	}
}
