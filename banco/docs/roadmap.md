# Sistema Bancário — Roadmap de Desenvolvimento

## 🎯 Objetivo Geral

Desenvolver um sistema bancário completo, evoluindo gradualmente de uma aplicação Java console para uma API REST e posteriormente uma interface web.

---

# V1 — Sistema Bancário Funcional

## Objetivo

Criar uma versão funcional do sistema utilizando Java e SQLite, aplicando conceitos de Programação Orientada a Objetos, persistência de dados e arquitetura em camadas.

## Tecnologias

* Java
* SQLite
* JDBC

## Funcionalidades

### Autenticação

* Cadastro de usuário
* Login
* Validação de credenciais
* Verificação de email duplicado
* Verificação de CPF duplicado

### Conta Bancária

* Criação automática de conta ao cadastrar usuário
* Geração automática do número da conta
* Consulta de saldo
* Persistência de dados

### Operações Bancárias

* Depósito
* Saque
* Transferência entre contas

### Transações

* Registro de depósitos
* Registro de saques
* Registro de transferências
* Histórico de movimentações

### Extrato

* Consulta de transações da conta
* Ordenação por data
* Exibição do histórico completo

## Estrutura

```text
src/
├── app/
├── auth/
├── dao/
├── database/
├── model/
├── service/
└── transacao/
```

## Arquitetura Utilizada

### Model

Representação das entidades do sistema.

Exemplos:

* Titular
* Conta
* ContaNormal
* ContaMenor
* Cartao
* Transacao

### DAO

Responsável pelo acesso ao banco de dados.

Exemplos:

* TitularDAO
* ContaDAO
* TransacaoDAO

### Service

Responsável pelas regras de negócio.

Exemplos:

* AuthService
* ContaService
* TransacaoService

### Database

Configuração e inicialização do banco.

Exemplos:

* Conexao
* DatabaseUtil
* DatabaseInitializer

## Aprendizados

* Programação Orientada a Objetos
* Encapsulamento
* Herança
* Polimorfismo
* JDBC
* SQL
* DAO Pattern
* Separação de responsabilidades
* Arquitetura em camadas
* Manipulação de listas
* Tratamento de exceções
* Modelagem de banco de dados

## Funcionalidades Pendentes

* Finalizar transferência entre contas
* Cartão virtual
* Melhorar formatação do extrato
* Testes da aplicação
* Tratamento avançado de erros

## Critério de Conclusão

* Cadastro funcional
* Login funcional
* Conta criada automaticamente
* Depósito funcional
* Saque funcional
* Transferência funcional
* Histórico de transações funcional
* Extrato funcional
* Dados persistidos no SQLite
* Sem erros críticos
* Testes básicos concluídos

---

# V2 — Backend Profissional

## Objetivo

Transformar o sistema em uma API REST e migrar para um banco de dados utilizado no mercado.

## Tecnologias

* Java
* Spring Boot
* MySQL ou PostgreSQL
* Spring Data JPA

## Funcionalidades

### API REST

Endpoints para:

* Cadastro
* Login
* Contas
* Depósitos
* Saques
* Transferências
* Extratos

### Arquitetura

* Controllers
* Services
* Repositories
* DTOs
* Exceptions
* Validation

### Segurança

* Hash de senhas
* JWT
* Controle de acesso

## Aprendizados

* REST API
* HTTP
* JSON
* Spring Boot
* JPA/Hibernate
* Banco cliente-servidor
* Arquitetura REST

## Critério de Conclusão

* API funcionando
* Banco migrado
* Operações disponíveis via HTTP
* Documentação da API

---

# V3 — Interface Web

## Objetivo

Criar uma interface web consumindo a API desenvolvida na V2.

## Tecnologias

### Opção 1

* HTML
* CSS
* JavaScript

### Opção 2

* React

### Opção 3

* Angular

## Funcionalidades

### Interface

* Login
* Dashboard
* Consulta de saldo
* Extrato
* Transferência

### Integração

* Consumo da API REST
* Atualização dinâmica dos dados

### UX

* Responsividade
* Navegação intuitiva
* Melhor experiência visual

## Aprendizados

* Front-end
* Integração API
* Full Stack
* Organização de aplicações modernas

## Critério de Conclusão

* Front-end conectado à API
* Fluxo completo funcionando
* Aplicação utilizável através do navegador

---

# Resultado Final

## Backend

* Java
* Spring Boot
* REST API

## Banco

* PostgreSQL ou MySQL

## Front-end

* React, Angular ou JavaScript

## Funcionalidades

* Cadastro
* Login
* Conta Bancária
* Depósito
* Saque
* Transferência
* Extrato

---

# Evolução do Projeto

V1
↓
Sistema funcional com SQLite

V2
↓
API REST + Banco profissional

V3
↓
Interface Web integrada

Resultado
↓
Sistema Bancário Completo

---

## Objetivo para Portfólio

Demonstrar conhecimento em:

* Java
* SQL
* JDBC
* POO
* DAO Pattern
* Arquitetura em Camadas
* APIs REST
* Spring Boot
* Banco de Dados
* Front-end
* Arquitetura de Software
* Integração Full Stack
