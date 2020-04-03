package com.semifir.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Ingredient {

	@Id
	private String id;
	private String nom;
	private String unite;
}
