package com.semifir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.semifir.models.Ingredient;
import com.semifir.models.Recette;
import com.semifir.repositories.RecetteRepository;

@Service
public class RecetteService {

	@Autowired
	private RecetteRepository repo;
	@Autowired
	private IngredientService ingredientService;
	
	public List<Recette> findAll(){
		return this.repo.findAll();
	}
	
	public Recette save(Recette entity) {
		for(Ingredient ingredient: entity.getIngredients())
			this.ingredientService.save(ingredient);
		return this.repo.save(entity);
	}
	
	public Recette findById(String id) {
		Optional<Recette> optional =  this.repo.findById(id);
		if (optional.isPresent()) return optional.get();
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'id ("+id+") de la recette n'est pas valide");
	}
	
	public List<Recette> findByNom(String nom){
		return this.repo.findAllByNom(nom);
	}
	
	public List<Recette> findByDificulte(String dificulte){
		return this.repo.findAllByDificulte(dificulte);
	}
	
	public List<Recette> findAllByDuree(long duree){
		return this.repo.findAllByDuree(duree);
	}
	
	public List<Recette> findAllByDuree(long min, long max){
		return this.repo.findAllByDureeBetween(min, max);
	}
	
}
