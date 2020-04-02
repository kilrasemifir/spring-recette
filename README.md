# Spring Recette

## Presentation

Le but de cet exercice est de creer un simple CRUD de recette en SpeingBoot avec MongoDB
Il est decoupé en exercices reprenant les fondamentaux de la programmation avec SpringBoot.
Chaque Exercices est sur une branche du repository git

## Prerequis

- docker
- STS4 avec Lombok
- Connaissances minimum en JAVA (POO)

## Exercice 3:

Creer une classe **RecetteController**. Cette classe nous permettra de recuperer les requetes HTTPs et de renvoyer les reponse. Pour ce faire elle doit etre annoté des annotations:
- @RestController: definie la classe comme un controller
- @CrossOrigin: Evite des problemes de securités
- @RequestMapping("recettes"): definie les urls pour atteindre le controllers doivent commencer par "recettes/"
  
Il nous faut le service. Pour ce faire tout comme pour le repository dans le service l'on peut utiliser l'injection de dependance de Spring.

Ajouter un champs
```java
@Autowired
private RecetteService service 
```

Creer les methodes:
```java
@GetMapping("")
public List<Recette> findAll(){
    return this.service.findAll();
}

@PostMapping("")
public Recette save(@RequestBody Recette entity){
    return this.service.save(entity);
}
```

@GetMapping permet de definir la methode HTTP (ou le verbe HTTP) et l'utl qui lancera cette methode java. Ici la methode GET avec l'url "recettes/". @PostMapping("") fait de meme avec la methode POST.