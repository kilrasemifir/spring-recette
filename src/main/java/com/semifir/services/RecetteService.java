package com.semifir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semifir.models.Recette;
import com.semifir.repositories.RecetteRepository;

@Service
public class RecetteService {

	@Autowired
	private RecetteRepository repo;
	
	public List<Recette> findAll(){
		return this.repo.findAll();
	}
	
	public Recette save(Recette entity) {
		return this.repo.save(entity);
	}
	
	
}
