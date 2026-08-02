# TPUB - PFE Project

TPUB is a full-stack project designed as a PFE (Final Year Project) with a Java/Spring Boot backend, a frontend, an AI service, and a PostgreSQL database orchestrated with Docker.

## Project structure

- Backend: Spring Boot application with REST APIs, security, JPA, and database integration
- Frontend: user interface layer
- IA Service: Python-based service for AI features
- Docker: containerized deployment with PostgreSQL, backend, AI service, and pgAdmin

## Technologies

- Backend: Java 17, Spring Boot, Spring Security, JPA, Flyway
- Database: PostgreSQL (production), H2 (local/dev fallback)
- AI Service: Python, FastAPI
- Containerization: Docker + Docker Compose

## Getting started

### Prerequisites

- Java 17+
- Maven
- Docker and Docker Compose
- Python 3.12+

### Run the backend locally

```bash
cd BackEnd
./mvnw spring-boot:run
```

### Run tests

```bash
cd BackEnd
./mvnw test
```

### Run with Docker

```bash
docker compose up --build
```

## Current status

The project is being structured as a modern multi-service application with a clear separation between backend, frontend, AI logic, and infrastructure.

## Next improvements

- Implement the core business modules
- Add real API endpoints and database entities
- Improve authentication and authorization
- Add unit and integration tests
- Prepare a polished final demo and documentation
