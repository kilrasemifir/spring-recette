package com.semifir.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.semifir.models.Recette;

public interface RecetteRepository extends MongoRepository<Recette, String>{

	public List<Recette> findAllByNom(String nom);
}
