# 🏗️ Arquitetura do SupportFlow

## Objetivo

Este documento descreve a arquitetura utilizada no SupportFlow, a organização do projeto e os padrões adotados durante o desenvolvimento.

Os requisitos funcionais e regras de negócio estão documentados em `REQUISITOS.md`.

---

# Arquitetura

O projeto segue uma arquitetura em camadas (Layered Architecture), separando responsabilidades para facilitar manutenção, testes e evolução da aplicação.

```
Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
PostgreSQL
```

Cada camada possui uma responsabilidade específica.

| Camada | Responsabilidade |
|---------|------------------|
| Controller | Receber requisições HTTP e retornar respostas |
| Service | Implementar as regras de negócio |
| Repository | Comunicação com o banco de dados |
| Domain | Representação das entidades e enums |
| DTO | Objetos utilizados na comunicação entre cliente e servidor |

---

# Estrutura do Projeto

```
com.supportflow.helpdesk
│
├── config
├── controller
├── domain
│   ├── entity
│   └── enums
├── dto
├── exception
├── mapper
├── repository
├── security
├── service
├── util
└── SupportflowApplication
```

---

# Tecnologias

- Java 25
- Spring Boot 4.0.7
- Spring Data JPA
- Hibernate
- PostgreSQL 18
- Maven
- Git

---

# Convenções

- Packages escritos em letras minúsculas.
- Uma responsabilidade por classe.
- Controllers não contêm regras de negócio.
- Services concentram a lógica da aplicação.
- Repositories acessam exclusivamente o banco de dados.
- DTOs são utilizados para entrada e saída de dados da API.

---

# Evolução

A arquitetura foi planejada para permitir a inclusão de novos módulos, como autenticação, anexos, notificações e dashboard, sem necessidade de grandes alterações na estrutura existente.