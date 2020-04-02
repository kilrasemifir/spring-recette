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

Creer une interface **RecetteRepository** dans le package **repositories**. Etendre cette classe avec l'interface **MongoRepository<Recette,String>**
```java
    public interface RecetteRepository extends MongoRepository<Recette,String>{}
```

Cette interface nous permettra de dialoguer avec la BDD Mongo.

Creer une nouvelle classe **RecetteService** dans le package service. Cette classe nous permettra de realiser le code metier de l'application. Annoter cette classe par **@Service**

Elle va avoir besoin d'un repository pour dialoguer avec la BDD. Pour ce faire l'on doit utiliser l'injection de dependance de Spring.

Ajouter un champs:
```Java
@Autowired
private RecetteRepository repo
```

L'annotation **@Autowired** permet de demander a spring de recuperer un recetteRepository deja fonctionnel.

Creer une methode **findAll** qui retourne une liste de recette sans prendre de parametre. L'on utilisera la methode **findAll** du repository pour retourner la liste.
```Java
public List<Recette> findAll(){
    return this.repo.findAll();
}
```

Faire de même avec la methode **save** qui prend en parametre une recette et qui renvoie une recette. Elle appelera la methode **save(Recette)** du repository.
