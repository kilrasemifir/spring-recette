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

Ouvrir postman. Lancer une requete:
```HTTP
GET localhost:8080/recettes
```
Si le server vous repond "[]" vous avec reussis a recuperer des informations de la base de donnée.

faite la requete suivante:
```HTTP
POST localhost:8080/recettes
```
avec comme body (Dans le panel de requete, Body->raw et Text->JON)
```JSON
{
    "nom":"ma recette",
    "duree":100,
    "dificulte":"FACILE"
}
```
Le serveur devrai vous renvoyer l'object en generant le champ id.

Exercice 4:

Ajoutons d'autres methodes.

Dans le service ajouter une methode findById qui prend en parametre String id et qui renvoie "Optional<Recette>". Elle renvera le retour de la methode findById du repository. 

Dans le controller, ajouter une methode findById:
```java
@GetMapping("{id}")
public Optional<Recette> findById(@PathVariable String id){
    return this.service.findById(id);
}
```

L'Optional contient la recette. Mais pour eviter d'avoir des exception (NullPointerException), le repository nous renvoie un optional qui encapsule la recette. Ainsi si l'id de la recette n'est pas le bon, il ne renvoie pas directement un null.

Pour verifier s'il contient quelque chose, l'on utilise:
```java
if (optional.isPresent()){
    Recette recette = optional.get();
    // faire quelque chose avec la recette.
} else {
    throw new ResponseStatusException(HTTPStatus.NOT_FOUND, "L'id("+id+") de ka recette n'est pas valide.)");
}
```
Si l'optional est vide, alors l'id de notre recette n'est pas valide. Il faut alors informer les utilisateurs de notre serveur que l'id est mauvaise. Pour ce faire, l'on utilise le statu de reponse HTTP 404 grace a la leve d'exception ResponceStatusException en lui donnant en arguments le code d'erreur (NOT_FOUND) et le message.

Le **@PathVariable** permet de recuperer une variable dans l'url. Ici la variable "id". il est important que le nom du parametre soit le meme que celui definie dans l'url.

Changer la methode findById du service pour ajouter la gestion de l'erreur et renvoyer la recette sans l'optional. Faire les changement necessaire dans le controller.

## Exercice 5:

Ajoutons une recherche par nom de recette.

Dans le Repository nous devons Creer une nouvelle methode pour chercher par nom... findAllByNom(String nom). FindAll permet de chercher sur toutes les recettes. By Nom permet de chercher par nom. Attention il est necessaire que recette (le model) possede un getter et un setter pour le champ chercher (ici nom). L'on commence toujour le nom du champ par une majuscule.
```java
public List<Recette> findAllByNom(String nom);
```

Dans le service creer une methode portant le meme nom, appelant la methode du repository et ayant le meme type de retour et le meme parametre.

Dans le controller creer une methode findByNom avec l'annotation **@GetMapping("nom/{nom}")** qui appel la methode du service. Il devra utiliser le pathvariable de l'exercice presedant pour recuperer le nom de l'url.

## Exercice 6:

Faire de meme pour les champs:
- duree
- dificulte

## Exercice 7:

Creer une methode pour recuperer les recettes avec une fourchette de duree: deux methodes:

1. Dans le repository

Dans le repository ajouter une methode:
```Java
public List<Recette> findAllByDureeBetween(long min, long max);
```

Cette methode prend deux parametres et recupere toutes les recettes qui ont une duree comprise entre min et max.

Creer une methode dans le service qui appel la methode du repository.

Creer une methode dans me controller en methode GET et avec l'url "duree/min/{min}/max/{max}" et qui appel la methode du service en renvoyant la liste de recette.

2. Creer une dans le service:
```Java
public List<Recette> findAllByDureeBetween(String duree){
    if (duree.equal("RAPIDE"))
        return this.repository.findAllByDureeBetween(0,20);
    if (duree.equal("NORMAL"))
        return this.repository.findAllByDureeBetween(20,60);
    if (duree.equal("LONG"))
        return this.repository.findAllByDureeBetween(60,2_000);
}
```

Cette methode permet de chercher dans des plages horraires.

Creer une methode dans le controller pour utiliser cette methode. Elle sera sur l'url "duree/plage/{duree}"

## Exercice 8

Ajoutons des etapes a notre recette.

Dans le package model ajouter une classe "Etape" definissant les champs:
- String nom
- String description

Pas besoin de document. Mais penser a ajouter @Data pour avoir les getters et les setters.

Ajouter une liste d'etapes portant le noms "etapes" dans votre classe recette. Initier la avec une arrayList.

Essayer avec postman de poster l'objet suivant:
```java
{
    "nom":"crepes",
    "duree":20,
    "dificulte":"FACILE",
    "etapes":[
        {
            "nom":"preparation",
            "description":"tout melanger"
        },
        {
            "nom":"cuisson",
            "desciption":"cuire dans une poele"
        }
    ]
}
```

Les etapes sont des objects compris directement dans la recette. Si la recette est supprimer ils le sont aussi. on parle de collection d'etapes dans la classe recette.

## Exercice 9:

Creer un model Ingredient ayant un nom et un champ "String unit".

Il devra aller dans la base de donnée. il faut donc l'annotation @Document et @Data. noublier pas d'ajouter un champs "@Id private String id;"

Creer un crud pour les ingredient avec les methode findAll save et findById.

Dans postman poster un ingredient.

## Exercice 10:

Ajouter a votre classe recette une liste d'ingredients portant le nom ingredients. annoter la par "@DBref"

Poster une recette avec une propriete ingredients qui prend une liste comportant un objet {"id":<id de votre ingredient>}.

Pour creer une recette vous devez deja rentrer un ingredient deja en bdd.

Pour changer cette fonctionnalité, aller dans le service des recette. Ajouter par injection le service des ingredients. Dans la methode save du service des recette, avant de sauvegarder dans la bdd votre recette, ajouter chaqu'un des ingredients a la bdd grace a la methodde save du service des ingredients.

Dans ce cas, si l'ingredient ne possede pas d'id il sera ajouter a la bdd. Sinon il sera lier a un deja existant.

## Exercice 11 :(Non corrigé)

Ajouter les methodes pour ajouter un ingredient a la recette en recuperant l'id de la recette et l'id de l'ingredient. Dans le service recette, recuperer la recette grace a findById et recuperer l'ingredient grace a findById du service des ingredient.
Ajouter la la list des ingredients l'ingredient.
Sauvegarder la recette.

Faire de meme avec les etapes en recuperant le body contenant l'etape a ajouter.

Faire une methode pour chercher les recettes en fonction d'un ingredient.

