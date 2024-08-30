## Tables

1.  Users : Stocker les infos sur les clients

---

| Nom de la colonne | Type de données | Description         |
| ----------------- | --------------- | ------------------- |
| id                | varchar         | l'id du user        |
| username          | varchar         | le nom du user      |
| email             | varchar         | email du user       |
| password          | varchar         | password du user    |
| created_at        | Timestamp       | date de creation    |
| updated_at        | Timestamp       | date de modfication |

2.  Products : Stocker les infos sur les produits

---

| Nom de la colonne          | Type de données        | Description                 |
| -------------------------- | ---------------------- | --------------------------- |
| id                         | varchar                | l'id du produit             |
| name                       | varchar                | nom du produit              |
| price                      | varchar                | prix du produit             |
| description                | varchar                | details sur le produit      |
| stock quantity             | varchar                | quantité en stock           |
| created_at                 | Timestamp              | date de creation            |
| updated_at                 | Timestamp              | date de modfication         |
| **\*\*\*\***\_**\*\*\*\*** | **\*\***\_\_\_**\*\*** | **\_\_**date de modfication |

1.  Orders : Stocker les infos sur les commmandes faites par les clients

---

| Nom de la colonne | Type de données | Description         |
| ----------------- | --------------- | ------------------- |
| id                | bigint          | Clé primaire        |
| user-id           | bigint          | cle secondaire      |
| total_comment     | Decimal         | Montant total       |
| status            | varchar         | status (en cours)   |
| created_at        | Timestamp       | date de creation    |
| updated_at        | Timestamp       | date de modfication |

1.  Order Items: Stocker les infos sur les produits inclus dans chaque commande

---

| Nom de la colonne | Type de données | Description                 |
| ----------------- | --------------- | --------------------------- |
| id                | bigint          | Clé primaire                |
| order-id          | bigint          | cle secondaire =>`orders`   |
| product_id        | bigint          | cle secondaire =>`products` |
| quantity          | int             | qté de produits commandée   |
| price             | decimal         | prix du produit             |
| created_at        | Timestamp       | date de creation            |
| updated_at        | Timestamp       | date de modfication         |

## Relations

# `users   ` -> `orders`: un user peut faire plusieurs commandes

# `orders   ` -> `orders_items`: une commande peut avoir plusieurs items

# `product   ` -> `orders_items`: un produit peut être commandé dans une journée

## Repository

un repository est un composant de votre application qui gère les opération de persistence (CRUD) sur les entités dans un base de donnée . En gros c'est la couche qui nous permet parler à la la BDD sans se soucier des details.

## Annotation @Repository

Elle sert à marquer une classe comme étant un repository , c'est dire un endroit oû vous allez interragire avec base de donnée .

## Est - ce obligatoire

Non ! Quand on implement déja une interface comme `JPaReppository`, Spring dectect automatiquement notre repository

## PathVariable vs @RequestBody vs @RequestParam

@PathVariable : on l'utilise pour extrait disons une partie variable dans notre chemin d'url.
@RequestBody : on l'utilise quand on reçois des donées via post.
@RequestParam : on l'utilise quand on a des paramètres dand l'url sous la forme `?param=valeur`.

`spring.jpa.hibernate.ddl-auto` :

cette propriété est utiliser pour spécifier la strategie de generation du schéma de la BDD lors du demarrage de l'application.
Hibernate, l'ORM utilisé par defaut dans Spring Boot, peut automatiquement créer, mettre à jour , valider ou gerer le schema de la base de donnée en fonction de cette propriété

Voici une explication des différents valeurs qu'on peut attribuer:

1. ``none` : Desactive la gestion automatiquement du schema par Hibernate. Aucune modification du schema de la BDD ne sera effectuer au demarragen de l'application
2. `validate ` : Hibernate vérifie que le schema de la BDD correpond à la structure Definie dans, les entitées JPA. Aucune modificaton du schema ne sera effectuée ; mais si le schema est incoreect ou ne correspond pas, une exception est lée
3. `update` : Hibernate met à jour le schema de la BDD pour qu'il correspond aux entitées JPA definies. cela inclut l'ajout de nouvelles tables, colonnes ou contraines, mais ne supprime ni ne modifie pas les tables ou les colonnes existantes.
4. `create` : HIbernate supoprime le schéma existant et crée un nouveau schema à partir des entitées JPA definies . cela implique de perdre toutes les données existantes puique le schema est crée à chaque demarrage de l'application
5. `create-drop` : Similaire à `create` , mais avec la particularité que le schema est suprimés lorsque l'application est arrêtées . CELA SIGNIFIE que la DBB est recrée à chaque fois que le demarrage est faite et est supprimées a chaque arrêt de l'application.
6.

## Definition

`Schéma` d'une BDD est une representaton logique de la structure logique des donées, incluant les tables , les colonnes même de ces tables, les relations entre les tables, et les contraintes. IL definit comment les données sont organisées, interconnectées, et géreées pour assurer leur cohérance et intégrité.


1. `@Entity ` : L'annotation `@Entity` en Java est utilisée pour marquer une classe comme une entité JPA (Java Persistence API), ce qui signifie que cette classe correspond à une table dans une base de données relationnelle. Chaque instance de cette classe représente une ligne dans la table. L'annotation `@Entity` indique également que cette classe peut être gérée par le gestionnaire d'entités JPA pour les opérations de persistance, comme les insertions, les mises à jour, et les suppressions.


2. `@id` : L'annotation `@Id` en Java est utilisée pour indiquer que l'attribut d'une entité est la clé primaire. Elle est souvent utilisée dans le contexte de JPA (Java Persistence API) pour identifier l'attribut unique qui différencie chaque instance de l'entité dans la base de données. Lorsqu'une classe est marquée comme une entité JPA avec `@Entity`, l'annotation `@Id` est utilisée sur le champ qui servira de clé primaire dans la table correspondante de la base de données.


3. ` @Bas` : L'annotation `@Bas` en Java n'est pas standard dans le langage ou les frameworks couramment utilisés comme Spring ou Hibernate. Si vous faites référence à une annotation spécifique qui serait liée à une bibliothèque ou un framework particulier, il serait utile de connaître le contexte exact dans lequel elle est utilisée pour fournir une explication appropriée.

Si c'est une annotation personnalisée, elle pourrait être définie dans le code pour un usage spécifique. Dans ce cas, vous pouvez consulter le code source ou la documentation associée pour en savoir plus. 

4. `@Temporal` :L'annotation `@Temporal` en Java est utilisée pour indiquer le type de données temporelles que vous souhaitez stocker dans une base de données lorsqu'un champ est de type `java.util.Date` ou `java.util.Calendar`. Elle permet de spécifier si la date, l'heure, ou les deux doivent être stockées.

Elle prend comme paramètre une des trois valeurs suivantes :

- `TemporalType.DATE` : Pour stocker uniquement la date.
- `TemporalType.TIME` : Pour stocker uniquement l'heure.
- `TemporalType.TIMESTAMP` : Pour stocker la date et l'heure.

Voici un exemple :

```java
@Temporal(TemporalType.DATE)
private Date birthDate;
```

Dans cet exemple, seule la date sera stockée en base de données, sans l'heure.

5. `@Transient ` :
   L'annotation `@Transient` en Java est utilisée pour indiquer qu'un champ d'une entité ne doit pas être persisté dans la base de données. Autrement dit, JPA ignorera ce champ lors de l'opération de mapping entre l'entité et la base de données.

Voici un exemple :

```java
@Entity
public class User {
    @Id
    private Long id;

    private String name;

    @Transient
    private int age; // Ce champ ne sera pas enregistré dans la base de données
}
```

Dans cet exemple, le champ `age` ne sera pas sauvegardé dans la base de données.
indique qu'un attribut ne doit pasn être persistant cet attribut nr sera donc jamais prise en compte lors de l'execution des réquêt

6. `@lob` : L'annotation `@Lob` en Java est utilisée pour indiquer que le type de l'attribut d'une entité JPA est de grande taille et qu'il doit être stocké comme un type de données "Large Object" dans la base de données. Cela signifie que l'attribut peut contenir des données volumineuses, comme un texte long (`CLOB` pour `Character Large Object`) ou des fichiers binaires (`BLOB` pour `Binary Large Object`), tels que des images ou des vidéos.
   indique que la colonne correpondante en base de données est un LOB (large object)


7. `@Table` :  L'annotation `@Table` en Java est utilisée pour spécifier la table de la base de données qui doit être mappée à l'entité JPA correspondante. Si cette annotation n'est pas utilisée, le nom de la table par défaut est le même que celui de l'entité. Avec `@Table`, vous pouvez définir des options comme le nom de la table (`name`), le schéma (`schema`), les index (`indexes`), et les contraintes uniques (`uniqueConstraints`), offrant ainsi un contrôle plus fin sur la façon dont l'entité est mappée à la base de données.
   permet de definir les infos sur la table representant cette entité en BDD

8. `@Column` : L'annotation `@Column` en Java est utilisée pour spécifier les détails d'une colonne dans une table de base de données lorsque vous mappez une entité JPA. Cette annotation vous permet de personnaliser le nom de la colonne (`name`), de définir si la colonne peut être nulle (`nullable`), de définir la longueur pour les types `String` (`length`), ainsi que d'autres attributs comme `unique`, `insertable`, et `updatable`. Si elle n'est pas spécifiée, les paramètres par défaut sont utilisés, par exemple le nom de la colonne correspondra au nom de l'attribut de l'entité.
   permet de declarer les infos relative à la colonne sur la quelle un attribut doit être mappé.Si cette attribut est absent le nom dela colonne coresponde au nom de l'attribut

Les types de Relations :

1. One-to-one
