# 🗄️ Banco de Dados

## Objetivo

Este documento descreve o modelo de dados utilizado pelo SupportFlow, apresentando as entidades, seus relacionamentos e as principais regras de persistência.

A modelagem foi construída a partir do domínio da aplicação, buscando simplicidade, escalabilidade e facilidade de manutenção.

---

# Banco de Dados

O SupportFlow utiliza um banco de dados relacional PostgreSQL.

As entidades foram modeladas utilizando JPA/Hibernate seguindo o padrão Code First, onde as tabelas são geradas a partir das entidades Java.

---

# Modelo Conceitual

```
User
 ├── id
 ├── name
 ├── email
 ├── password
 ├── role
 ├── created_at
 └── updated_at

Category
 ├── id
 ├── name
 ├── description
 ├── created_at
 └── updated_at

Ticket
 ├── id
 ├── title
 ├── description
 ├── status
 ├── priority
 ├── requester_id
 ├── assigned_technician_id
 ├── category_id
 ├── created_at
 ├── updated_at
 └── closed_at

Comment
 ├── id
 ├── message
 ├── ticket_id
 ├── author_id
 └── created_at

Attachment
 ├── id
 ├── file_name
 ├── file_path
 ├── content_type
 ├── ticket_id
 └── created_at
```

---

# Relacionamentos

```
User
 │
 ├──────────────┐
 │              │
 │              ▼
 │          Ticket (requester)
 │
 └──────────────► Comment (author)

Category
      │
      ▼
   Ticket

Ticket
 ├────────► Comment
 └────────► Attachment
```

---

# Cardinalidade

| Origem | Destino | Relacionamento |
|--------|---------|----------------|
| User | Ticket | 1:N |
| User | Comment | 1:N |
| Category | Ticket | 1:N |
| Ticket | Comment | 1:N |
| Ticket | Attachment | 1:N |

---

# Convenções

- Tabelas nomeadas no plural.
- Chaves primárias do tipo `BIGINT`.
- Chaves geradas automaticamente (`IDENTITY`).
- Enums armazenados como `STRING`.
- Datas utilizando `LocalDateTime`.
- Relacionamentos modelados com JPA/Hibernate.

---

# Evolução

O modelo foi projetado para permitir futuras expansões, como:

- autenticação e autorização;
- notificações;
- histórico de alterações;
- SLA;
- dashboard gerencial;
- múltiplos anexos por chamado;
- auditoria completa.