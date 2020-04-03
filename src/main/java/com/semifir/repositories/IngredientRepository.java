package com.semifir.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.semifir.models.Ingredient;

public interface IngredientRepository extends MongoRepository<Ingredient, String>{

}
