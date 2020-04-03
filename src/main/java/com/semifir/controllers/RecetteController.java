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

import com.semifir.models.Etape;
import com.semifir.models.Ingredient;
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
	
	@GetMapping("{id}")
	public Recette findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/nom/{nom}")
	public List<Recette> findByNom(@PathVariable String nom){
		return this.service.findByNom(nom);
	}
	
	@GetMapping("/dificulte/{dificulte}")
	public List<Recette> findByduree(@PathVariable String dificulte){
		return this.service.findByDificulte(dificulte);
	}
	
	@GetMapping("/duree/{duree}")
	public List<Recette> findByduree(@PathVariable long duree){
		return this.service.findAllByDuree(duree);
	}
	
	@GetMapping("/duree/min/{min}/max/{max}")
	public List<Recette> findByduree(@PathVariable long min, @PathVariable long max){
		return this.service.findAllByDuree(min, max);
	}
	
	@PostMapping("{rid}/ingredients/{iid}")
	public Recette addIngredient(@PathVariable String rid, @PathVariable String iid) {
		return this.service.addIngredient(rid, iid);
	}
	
	@PostMapping("{id}/ingredients")
	public Recette addIngredient(@PathVariable String id, @RequestBody Ingredient ingredient) {
		return this.service.addIngredient(id, ingredient);
	}
	
	@PostMapping("{id}/recettes")
	public Recette addEtape(@PathVariable String id, @RequestBody Etape etape) {
		return this.service.addEtape(id, etape);
	}
	
	@GetMapping("/ingredients/{iid}")
	public List<Recette> findByIngredients(@PathVariable String iid){
		return this.service.findByIngredient(iid);
	}
}
