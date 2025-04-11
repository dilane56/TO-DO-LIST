# API de Gestion de Tâches

## Aperçu
L'API de gestion des tâches permet de créer, lire, mettre à jour et supprimer des tâches dans un système organisé. Elle est conçue pour gérer des informations telles que le titre, la description et le statut des tâches (à faire, en cours, terminé). Cette API repose sur Spring Boot et suit une architecture REST pour garantir une interaction efficace avec les clients.

## Fonctionnalités
- **Créer une tâche** : Ajoutez une nouvelle tâche avec un titre, une description et un statut.
- **Afficher toutes les tâches** : Liste complète de toutes les tâches créées.
- **Rechercher une tâche par ID** : Récupérez une tâche spécifique à l'aide de son identifiant unique.
- **Rechercher des tâches par statut** : Filtrer les tâches en fonction de leur état (à faire, en cours, terminé).
- **Mettre à jour une tâche** : Modifier les informations d'une tâche existante.
- **Supprimer une tâche** : Supprimez une tâche par son identifiant.

## Prérequis
Pour exécuter l'API, vous avez besoin de :
- Java 11 ou supérieur
- Maven ou Gradle pour gérer les dépendances
- Une base de données relationnelle (par exemple MySQL, PostgreSQL)

## Installation
1. Clonez le dépôt :
   ```bash
   git clone https://github.com/votre-utilisateur/todolist-api.git
Accédez au répertoire :
  ```bash
  cd todolist-api
 ```

2. Configurez les datasources  sur votre IDE pour pouvoir utiliser la base de donnée


3. Compilez et lancez l'application :
  ```bash
./mvnw spring-boot:run
```

L'API sera accessible à l'adresse suivante : http://localhost:8080/tasks

## Endpoints de l'API
1. Ajouter une tâche
   URL : /tasks
   
   - **Méthode HTTP : POST**
   
   
   Description : Ajoute une nouvelle tâche au système.
   
   Paramètres :
   
   Requête JSON avec les champs :
   title (obligatoire) : Le titre de la tâche.
   description : La description détaillée.
   statut (obligatoire) : Le statut de la tâche (A_FAIRE, EN_COURS, TERMINE).
   Exemple de requête :
   
   
   POST /tasks
   Content-Type: application/json
   
   {
     "title": "Acheter des courses",
     "description": "Faire les courses pour la semaine",
     "statut": "A_FAIRE"
   }
   Exemple de réponse :
   
   
   {
     "id": 1,
     "title": "Acheter des courses",
     "description": "Faire les courses pour la semaine",
     "statut": "A_FAIRE"
   }

2. Afficher toutes les tâches  URL : /tasks

- **Méthode HTTP : GET**

Description : Récupère la liste de toutes les tâches disponibles.

Exemple de requête :


GET /tasks
Exemple de réponse :


[
  {
    "id": 1,
    "title": "Acheter des courses",
    "description": "Faire les courses pour la semaine",
    "statut": "A_FAIRE"
  },
  {
    "id": 2,
    "title": "Réviser les examens",
    "description": "Étudier pour les examens de la semaine prochaine",
    "statut": "EN_COURS"
  }
]

3. Rechercher une tâche par ID  URL : /tasks/{id}

   - **Méthode HTTP : GET**
   
   Description : Récupère une tâche spécifique par son identifiant.
   
   Paramètres :
   
   id : Identifiant unique de la tâche.
   Exemple de requête :
   
   
   GET /tasks/1
   Exemple de réponse :
   
   
   {
     "id": 1,
     "title": "Acheter des courses",
     "description": "Faire les courses pour la semaine",
     "statut": "A_FAIRE"
   }

4. Rechercher des tâches par statut URL : /tasks/statut/{statut}

   - **Méthode HTTP : GET**
   
   Description : Récupère les tâches correspondant à un statut donné.
   
   Paramètres :
   
   statut : Le statut de la tâche (A_FAIRE, EN_COURS, TERMINE).
   Exemple de requête :
   
   
   GET /tasks/statut/A_FAIRE
   Exemple de réponse :
   
   
   [
     {
       "id": 1,
       "title": "Acheter des courses",
       "description": "Faire les courses pour la semaine",
       "statut": "A_FAIRE"
     }
   ]

5. Mettre à jour une tâche URL : /tasks/update/{id}

   - **Méthode HTTP : PUT**
   
   Description : Met à jour les informations d'une tâche existante.
   
   Paramètres :
   
   id : Identifiant de la tâche à modifier.
   Requête JSON avec les champs à mettre à jour :
   title : Nouveau titre.
   description : Nouvelle description.
   statut : Nouveau statut.
   Exemple de requête :
   
   
   PUT /tasks/update/1
   Content-Type: application/json
   
   {
     "title": "Acheter des légumes",
     "description": "Faire les courses pour la semaine (priorité : légumes)",
     "statut": "EN_COURS"
   }
   Exemple de réponse :
   
   
   {
     "id": 1,
     "title": "Acheter des légumes",
     "description": "Faire les courses pour la semaine (priorité : légumes)",
     "statut": "EN_COURS"
   }

6. Supprimer une tâche URL : /tasks/delete/{id}

- **Méthode HTTP : DELETE**

   Description : Supprime une tâche spécifique par son identifiant.
   
   Paramètres :
   
   id : Identifiant de la tâche à supprimer.
   Exemple de requête :
   
   
   DELETE /tasks/delete/1
   Exemple de réponse :
   
   {
     "message": "La tâche avec l'ID 1 a été supprimée avec succès."
   }
   Technologies utilisées
   Spring Boot : Framework pour construire l'API.
   Jakarta Validation : Validation des données entrantes.
   Swagger/OpenAPI : Documentation des endpoints.
   JUnit : Tests unitaires et d'intégration.
   Contribution
   Les contributions sont les bienvenues ! Pour contribuer :
   
   Forkez ce dépôt.
   Créez une branche pour vos modifications :
   
   git checkout -b ajout-de-fonctionnalite
   Poussez vos modifications et soumettez une Pull Request.


