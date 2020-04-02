package com.semifir.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.semifir.models.Recette;

public interface RecetteRepository extends MongoRepository<Recette, String>{

	public List<Recette> findAllByNom(String nom);
	public List<Recette> findAllByDuree(long duree);
	public List<Recette> findAllByDificulte(String dificulte);

	public List<Recette> findAllByDureeBetween(long min, long max);
	
}
