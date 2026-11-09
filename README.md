# Task Manager — Spring Boot + Angular

Application fullstack de gestion de tâches collaborative. Ce projet est développé dans le cadre de ma préparation au stage de fin d'études (M1 Informatique).

## 🎯 Objectif

Construire une API REST robuste avec Spring Boot et une interface utilisateur moderne avec Angular, en respectant les bonnes pratiques de développement (tests unitaires, Docker, CI/CD).

## 🛠 Stack Technique

### Backend
- **Java 21** (LTS)
- **Spring Boot 3.4.2**
- **Spring Web** (API REST)
- **Spring Data JPA** (accès aux données)
- **Spring Security** (sécurité, à venir avec JWT)
- **PostgreSQL 16** (base de données)
- **Springdoc OpenAPI (Swagger)** (documentation de l'API)
- **JUnit 5 & Mockito** (tests unitaires, à venir)
- **Maven** (gestion des dépendances)

### Frontend (en cours de développement)
- **Angular** (dernière version)
- **TypeScript**
- **RxJS** / **HttpClient**

### DevOps
- **Docker** & **Docker Compose** (conteneurisation de la base de données et de l'application)

## 🏗 Architecture du Backend

Le backend suit une architecture en couches classique (Layered Architecture) :

- `controller` : Points d'entrée de l'API REST.
- `dto` : Data Transfer Objects (requêtes et réponses).
- `entity` : Modèle de données JPA.
- `repository` : Interfaces Spring Data JPA.
- `service` : Logique métier.
- `config` : Configuration de l'application (Sécurité, Swagger).

## 🚀 Lancer le projet en local

### Prérequis
- Java 21
- Docker Desktop
- Maven

### 1. Lancer la base de données (PostgreSQL)
À la racine du projet, lancez :
```bash
docker compose up -d