package com.semifir.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.semifir.models.Recette;

public interface RecetteRepository extends MongoRepository<Recette, String>{

}
