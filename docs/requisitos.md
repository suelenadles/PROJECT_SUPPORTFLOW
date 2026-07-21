Projeto SupportFlow
Documento de Requisitos
1. Visão Geral

O SupportFlow é uma plataforma de gerenciamento de atendimentos (Help Desk) criada para organizar e facilitar a comunicação entre clientes e equipes de suporte.

A plataforma permite que clientes registrem solicitações, acompanhem o andamento dos chamados e recebam atualizações, enquanto atendentes conseguem organizar demandas, priorizar problemas e acompanhar o histórico de cada atendimento.

2. Objetivo do Projeto

Criar uma solução simples e eficiente para gerenciamento de chamados, simulando um sistema utilizado por empresas que oferecem suporte aos seus clientes.

O sistema tem como objetivo:

Centralizar solicitações de atendimento;
Organizar chamados por prioridade e categoria;
Melhorar o acompanhamento dos problemas;
Registrar todo o histórico de comunicação;
Facilitar a gestão da equipe de suporte.
3. Perfis de Usuário
Cliente

Usuário responsável por abrir solicitações e acompanhar seus atendimentos.

Permissões:

Criar uma conta;
Realizar login;
Abrir chamados;
Visualizar seus chamados;
Acompanhar o andamento das solicitações;
Enviar mensagens dentro do chamado.
Atendente

Usuário responsável por realizar os atendimentos e solucionar problemas.

Permissões:

Visualizar chamados disponíveis;
Assumir atendimentos;
Alterar status dos chamados;
Responder clientes;
Consultar histórico de interações.
Administrador

Usuário responsável pela gestão da plataforma.

Permissões:

Gerenciar usuários;
Visualizar todos os chamados;
Gerenciar categorias;
Acompanhar métricas de atendimento.
4. Requisitos Funcionais
Usuários

RF01 - O sistema deve permitir o cadastro de usuários.

RF02 - O sistema deve permitir autenticação utilizando email e senha.

RF03 - O sistema deve diferenciar usuários por perfil de acesso.

Chamados

RF04 - O cliente deve conseguir abrir um chamado.

RF05 - O chamado deve possuir título, descrição, categoria e prioridade.

RF06 - O sistema deve permitir alteração do status do chamado.

RF07 - O sistema deve armazenar o histórico de interações.

Atendimento

RF08 - O atendente deve conseguir assumir um chamado.

RF09 - O atendente deve conseguir responder ao cliente.

RF10 - O cliente deve conseguir acompanhar a resolução do chamado.

5. Regras de Negócio

RN01 - Todo chamado deve possuir um cliente responsável.

RN02 - Todo novo chamado deve iniciar com o status ABERTO.

RN03 - Apenas atendentes e administradores podem alterar o status do chamado.

RN04 - Chamados finalizados não podem receber novas interações.

RN05 - Todas as interações devem permanecer registradas no histórico.

6. Fluxo do Chamado
ABERTO
   ↓
EM_ATENDIMENTO
   ↓
RESOLVIDO
   ↓
FECHADO
7. Categorias de Chamados
Acesso
Financeiro
Erro no sistema
Dúvida
Solicitação de melhoria
8. Níveis de Prioridade
BAIXA
MÉDIA
ALTA
URGENTE
9. Tecnologias
Backend
Java 21
Spring Boot
Spring Data JPA
Spring Security
JWT
Banco de Dados
PostgreSQL
Ferramentas
Maven
Docker
Git/GitHub
Swagger/OpenAPI
Testes
JUnit
Mockito
10. Modelo Inicial de Entidades
Usuário (User)

Responsável pelos usuários do sistema.

Atributos:

id
nome
email
senha
perfil
Chamado (Ticket)

Representa uma solicitação de atendimento.

Atributos:

id
título
descrição
categoria
prioridade
status
data de criação
cliente responsável
atendente responsável
Interação (Interaction)

Representa as mensagens trocadas durante um atendimento.

Atributos:

id
mensagem
data
usuário responsável
chamado relacionado
11. Futuras Melhorias

Possíveis evoluções do projeto:

Dashboard com métricas de atendimento;
Controle de SLA;
Notificações por email;
Upload de arquivos nos chamados;
Chat em tempo real;
Integração com WhatsApp;
Uso de inteligência artificial para classificação automática dos chamados;
Mensageria com RabbitMQ.