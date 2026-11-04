# Tackle Eventual Consistency with Domain Events

This repository holds the hands-on material for a 2023 conference mini-lab. It shows how to deal with eventual consistency between aggregates and external systems by using domain events. The example domain has authors, books and publishers. Authors register and write books, and books are offered to an external publisher service to be published.

## Main technologies

- Java with Spring Boot 3 (Web, Data JPA)
- PostgreSQL, run locally with Docker Compose
- Liquibase for database migrations
- Lombok
- JUnit 5, H2, MockServer and ArchUnit for tests

## Structure

The application follows a combined clean, hexagonal and onion architecture. Each layer is a separate package:

- domain: the core domain model (Author, Book, Genre, Publisher)
- domaininteraction: flows, DTOs, mappers and the ports used by the domain
- command: REST endpoints that change state
- query: REST endpoints and views for reading data
- data: JPA entities, repositories and data service implementations
- acl: an anti-corruption layer that wraps the external publisher service
- process: a placeholder for process or event handling logic

Other contents:

- http: ready-made HTTP request files for trying out the commands and queries
- src/main/resources: application settings and Liquibase changelogs
- src/test: unit and integration tests, plus ArchUnit tests that enforce the layering rules

## Status

This was workshop material for a single conference session and is no longer actively maintained.