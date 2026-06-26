# LuaBank - Contexto V2

Última atualização: Junho de 2026

---

# Visão Geral

LuaBank é uma API bancária REST desenvolvida com foco em aprendizado prático de desenvolvimento Backend utilizando Java e tecnologias modernas do ecossistema Spring.

O projeto surgiu inicialmente como uma aplicação console e evoluiu para uma API REST publicada em produção.

Atualmente o LuaBank funciona como:

* Projeto de Portfólio
* Laboratório de Backend
* Ambiente de Estudo
* Plataforma de Experimentação

O projeto não possui como objetivo atual se tornar uma instituição financeira real.

---

# Objetivos

## Objetivos Principais

* Aprender Java Backend
* Aprender Spring Boot
* Aprender APIs REST
* Aprender Spring Security
* Aprender JWT
* Aprender PostgreSQL
* Aprender Docker
* Aprender Deploy
* Aprender DevOps
* Aprender Arquitetura de Software

---

## Objetivos Secundários

* Construção de Portfólio
* Simulação de Ambiente Profissional
* Evolução Contínua de Boas Práticas
* Demonstração de Conhecimentos Técnicos

---

# Evolução do Projeto

## LuaBank V1

Aplicação Console.

Tecnologias:

* Java
* JDBC
* SQLite

Funcionalidades:

* Cadastro
* Login
* Depósito
* Saque
* Transferência
* Consulta de Saldo
* Histórico de Transações

Objetivo:

Aprender persistência de dados e organização de código.

---

## LuaBank V2

Migração para API REST.

Tecnologias:

* Java 21
* Spring Boot
* PostgreSQL
* Spring Security
* JWT
* Docker

Objetivo:

Construir uma API moderna consumível por aplicações externas.

---

# Estado Atual

Status:

Produção Ativa

Infraestrutura Atual:

* API em Produção
* HTTPS
* Domínio Próprio
* Docker
* PostgreSQL

API:

https://api.luabank.com.br

Swagger:

https://api.luabank.com.br/swagger-ui/index.html

---

# Arquitetura

Estrutura principal:

src/main/java/com/yurigb/luabank

* config
* controller
* dto
* exception
* model
* repository
* security
* service

---

# Responsabilidades das Camadas

## Controller

Responsável por:

* Receber requisições HTTP
* Validar entrada básica
* Retornar respostas HTTP

---

## Service

Responsável por:

* Regras de negócio
* Validações de domínio
* Orquestração de operações

---

## Repository

Responsável por:

* Persistência
* Consultas ao banco de dados

---

## DTO

Responsável por:

* Entrada de dados
* Saída de dados

---

## Model

Responsável por:

* Entidades do domínio

---

## Security

Responsável por:

* JWT
* Autenticação
* Autorização

---

## Exception

Responsável por:

* Tratamento global de erros

---

# Tecnologias Utilizadas

## Backend

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate

---

## Banco de Dados

* PostgreSQL

---

## Infraestrutura

* Docker
* Docker Compose
* Render
* HTTPS

---

## Documentação

* Swagger/OpenAPI

---

## Ferramentas

* Maven
* Git
* GitHub

---

# Funcionalidades Implementadas

## Autenticação

* Cadastro
* Login
* JWT
* BCrypt
* Proteção de Rotas

---

## Gestão de Conta

* Criar Conta
* Consultar Perfil
* Consultar Saldo
* Atualizar Dados
* Excluir Conta

---

## Pix

* Cadastro de Chave
* Consulta de Chaves
* Remoção de Chave
* Transferência Pix

---

## Extrato

* Consulta de Extrato
* Paginação
* Ordenação

Tipos de Operação:

* DEPOSITO
* SAQUE
* PIX_ENVIADO
* PIX_RECEBIDO

---

# Filosofia do Projeto

O objetivo atual não é aumentar continuamente a quantidade de funcionalidades.

A prioridade é aumentar a maturidade técnica do projeto através de:

* Melhor Qualidade
* Melhor Arquitetura
* Melhor Observabilidade
* Melhor Manutenção
* Melhores Práticas de Engenharia

---

# Roadmap Atual

## Sprint Qualidade

Objetivo:

Garantir estabilidade e segurança para evolução futura.

Itens:

* JUnit 5
* Mockito
* Testes Unitários
* Testes de Integração
* Cobertura de Testes

---

## Sprint DevOps

Objetivo:

Automatizar validações e entregas.

Itens:

* GitHub Actions
* Pipeline de Build
* Pipeline de Testes
* CI/CD

---

## Sprint Observabilidade

Objetivo:

Entender o comportamento da aplicação em produção.

Itens:

* Logs Estruturados
* Auditoria
* Métricas
* Monitoramento

---

## Sprint Infraestrutura

Objetivo:

Aprender infraestrutura utilizada no mercado.

Itens Planejados:

* AWS
* VPS
* Nginx
* SSL
* DNS
* Deploy Manual
* Monitoramento Avançado

---

# Próximos Recursos

Backlog Futuro:

* Recuperação de Senha
* Confirmação de Email
* MFA
* Melhorias de Segurança
* Evolução de Observabilidade

---

# Documentação Complementar

NEGOCIO.md

Documenta:

* Entidades
* Regras de Negócio
* Restrições
* Fluxos do Domínio

---

Swagger/OpenAPI

Documenta:

* Endpoints
* Requests
* Responses
* Autenticação
* Contratos da API

---

# Objetivo para Portfólio

Demonstrar conhecimento em:

* Java
* Spring Boot
* APIs REST
* Spring Security
* JWT
* PostgreSQL
* Docker
* Arquitetura em Camadas
* Boas Práticas de Backend
* Integração com Frontend
* DevOps
