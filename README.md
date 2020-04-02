# Spring Recette

## Presentation

Le but de cet exercice est de creer un simple CRUD de recette en SpeingBoot avec MongoDB
Il est decoupé en exercices reprenant les fondamentaux de la programmation avec SpringBoot.
Chaque Exercices est sur une branche du repository git

## Prerequis

- docker
- STS4 avec Lombok
- Connaissances minimum en JAVA (POO)

## Exercice 1:

Creer 4 packages dans le même package que l'application:
- controllers
- services
- repositories
- models
  
Dans le package model, creer une classe Recette avec les champs:
```java
private String id;
private String nom;
private long duree;
private String dificulte;
```

Pour dire a spring que cette classe est destiné a la representé une entité de Mongo, il faut ajouter l'annotation **@Document** au dessus de la definition de la classe. Il faut aussi definir le champs qui servira d'id avec l'annotation **@Id**.