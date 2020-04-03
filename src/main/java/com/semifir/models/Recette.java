package com.semifir.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Recette {
	@Id
	private String id;
	private String nom;
	private long duree;
	private String dificulte;
	private List<Etape> etape = new ArrayList<>();
	@DBRef
	private List<Ingredient> ingredients;
}
