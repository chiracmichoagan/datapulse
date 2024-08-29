## Tables 
 1. Users : Stocker les infos sur les clients
   _____________________________________________________
  |Nom de la colonne|Type de données|Description        |
  |-----------------|---------------|-------------------|
  |id               |varchar        |l'id du user       |
  |username         |varchar        |le nom  du user    |
  |email            |varchar        |email du user      |
  |password         |varchar        |password du user   |
  |created_at       |Timestamp      |date de creation   |
  |updated_at       |Timestamp      |date de modfication|
  
   
 2. Products : Stocker les infos sur les produits
   
   __________________________________________________________
  |Nom de la colonne|Type de données|Description             |
  |-----------------|---------------|------------------------|
  |id               |varchar        |l'id du produit         |
  |name             |varchar        |nom du produit          |
  |price            |varchar        |prix du produit         |
  |description     |varchar        |details sur le produit  |
  |stock quantity  |varchar        |quantité en stock       |
  |created_at       |Timestamp      |date de creation        |
  |updated_at       |Timestamp      |date de modfication     |
  |_________________|_______________|______date de modfication     |
   

 1. Orders : Stocker les infos sur les commmandes faites par les clients

   _____________________________________________________
  |Nom de la colonne|Type de données|Description        |
  |-----------------|---------------|-------------------|
  |id               |bigint         |Clé primaire       |
  |user-id          |bigint         |cle secondaire     |
  |total_comment    |Decimal        |Montant total      |
  |status           |varchar        |status (en cours)  |
  |created_at       |Timestamp      |date de creation   |
  |updated_at       |Timestamp      |date de modfication|


 1. Order Items: Stocker les  infos sur les produits inclus dans chaque commande
   
   _________________________________________________________________
  |Nom de la colonne|Type de données|Description                    |
  |-----------------|---------------|-------------------------------|
  |id               |bigint         |Clé primaire                   |
  |order-id         |bigint         |cle secondaire =>`orders`      |
  |product_id       |bigint         |cle secondaire =>`products`    |
  |quantity         |int            |qté de produits commandée      |
  |price            |decimal        |prix du produit                |
  |created_at       |Timestamp      |date de creation               |
  |updated_at       |Timestamp      |date de modfication            |



## Relations

# `users   ` -> `orders`:  un user peut faire plusieurs commandes
# `orders   ` -> `orders_items`: une commande peut avoir plusieurs items
# `product   ` -> `orders_items`: un produit peut être commandé dans une journée




## Repository

 un repository est un composant de votre application qui gère les opération de persistence (CRUD) sur les entités dans un base de donnée . En gros c'est la couche qui nous permet parler à la la BDD sans se soucier des details.


 ## Annotation @Repository

 Elle ssert à marquer une classe comme étant un repository , c'est dire un endroit oû vous allez interragire avec base de donnée .

 ## Est - ce obligatoire 

 Non ! Quand on implement déja une interface comme ``JPaReppository``, Spring dectect automatiquement notre repository

## PathVariable vs @RequestBody vs @RequestParam

@PathVariable : on l'utilise pour extrait disons une partie variable dans notre chemin d'url.
@RequestBody  : on l'utilise quand on reçois des donées via post.
@RequestParam : on l'utilise quand on a des paramètres dand l'url sous la forme `?param=valeur`.



`spring.jpa.hibernate.ddl-auto` :

cette propriété est utiliser pour spécifier la strategie de generation du schéma de la BDD lors du demarrage de l'application.
Hibernate, l'ORM utilisé par defaut  dans Spring Boot, peut automatiquement créer, mettre à jour , valider ou gerer le schema de la base de donnée en fonction de cette propriété

Voici une explication des différents valeurs qu'on peut attribuer:


1. ``none` : Desactive la gestion automatiquement du schema par Hibernate. Aucune modification du schema de la BDD ne sera effectuer au demarragen de l'application
2.  `validate ` : Hibernate vérifie que le schema de la BDD correpond à la structure Definie dans, les entitées JPA. Aucune modificaton du schema ne sera effectuée ; mais si le schema est incoreect ou ne correspond pas, une exception est lée 
3.  `update` : Hibernate met à jour le schema de la BDD pour qu'il correspond aux entitées JPA definies. cela inclut l'ajout de nouvelles tables, colonnes ou contraines, mais ne supprime ni ne modifie pas les tables ou les colonnes existantes.
4.  `create` : HIbernate supoprime le schéma existant et crée un nouveau schema à partir des entitées JPA definies . cela implique de perdre toutes les données existantes puique le schema est crée à chaque demarrage de l'application
5.  `create-drop` : Similaire à ``create`` , mais avec la particularité que le schema est suprimés lorsque l'application est arrêtées . CELA SIGNIFIE que la DBB est recrée à chaque fois que le demarrage est faite et est supprimées a chaque arrêt de l'application.
6.  

## Definition 

`Schéma` d'une BDD est une  representaton logique de la structure logique des donées, incluant les tables , les colonnes même de ces tables, les relations entre les tables, et les contraintes. IL definit comment les données sont organisées, interconnectées, et géreées pour assurer leur cohérance et intégrité.
  