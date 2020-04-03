package com.semifir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.semifir.models.Ingredient;
import com.semifir.repositories.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository repo;
	
	public List<Ingredient> findAll(){
		return this.repo.findAll();
	}
	
	public Ingredient save(Ingredient entity) {
		return this.repo.save(entity);
	}
	
	public Ingredient findById(String id) {
		Optional<Ingredient> optional =  this.repo.findById(id);
		if (optional.isPresent()) return optional.get();
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'id ("+id+") de l'ingredient n'est pas valide");
	}
	
	
	
}
