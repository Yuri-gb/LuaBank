# LuaBank

API bancária desenvolvida em Java com Spring Boot para estudos de arquitetura de software, APIs REST, autenticação JWT, persistência de dados e boas práticas de desenvolvimento backend.

## 🚀 Versão Atual

**v2.0 - API Bancária REST**

## Funcionalidades

### Autenticação

* Cadastro de usuários
* Login com JWT
* Validação de credenciais
* Proteção de rotas autenticadas
* Verificação de email duplicado
* Verificação de CPF duplicado

### Conta Bancária

* Criação automática de conta
* Geração automática do número da conta
* Consulta de saldo
* Consulta de perfil

### Operações Bancárias

* Depósito
* Saque
* Transferência entre contas

### Extrato

* Registro automático de movimentações
* Histórico de operações
* Ordenação por data
* Identificação de remetente e destinatário em transferências

### Tratamento de Erros

* Respostas padronizadas
* Exceções customizadas
* Códigos HTTP apropriados

## Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* Maven
* Git
* GitHub

## Arquitetura

O projeto está organizado em camadas:

```text
src/main/java/com/yurigb/luabank
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── exception
│   ├── badrequest
│   ├── conflict
│   ├── handler
│   ├── notfound
│   └── unauthorized
├── model
├── repository
├── security
└── service
```

### Responsabilidades

* Controller → Recebe e responde requisições HTTP
* Service → Regras de negócio
* Repository → Persistência de dados
* DTO → Comunicação da API
* Model → Entidades do sistema
* Security → Autenticação e autorização
* Exception → Tratamento global de erros

## Endpoints Principais

### Autenticação

```http
POST /auth/login
```

### Conta

```http
POST /contas/criar
GET  /contas/perfil
GET  /contas/saldo
```

### Operações

```http
POST /contas/depositar
POST /contas/sacar
POST /contas/transferir
GET  /contas/extrato
```

## Roadmap

### v2.0 ✅

* Cadastro de usuários
* Login com JWT
* Consulta de saldo
* Consulta de perfil
* Depósito
* Saque
* Transferência entre contas
* Extrato bancário
* Histórico de operações
* Tratamento global de exceções

### v3.0 🚧

#### Backend

* Pix
* Paginação de extrato
* Filtros de operações
* Melhorias de segurança
* Documentação completa da API

#### Frontend

* Dashboard Web
* Consulta de saldo
* Extrato visual
* Transferências
* Perfil do usuário

#### Deploy

* Backend em produção
* Banco de dados em nuvem
* Ambiente de testes

### v4.0 📋

* Cartão de crédito
* Limite de crédito
* Fatura
* Aplicativo Mobile
* QR Code
* Novas funcionalidades financeiras

## Objetivo

Projeto criado para praticar desenvolvimento backend moderno utilizando Java e Spring Boot, simulando funcionalidades presentes em sistemas bancários reais.

Além do aprendizado técnico, o projeto tem como objetivo aprofundar conhecimentos em:

* Programação Orientada a Objetos
* Arquitetura em Camadas
* APIs REST
* Spring Boot
* Spring Security
* JWT
* JPA/Hibernate
* Banco de Dados
* Documentação
* Git e GitHub

O projeto é desenvolvido de forma incremental, com foco em evolução contínua, qualidade de código e aplicação de boas práticas utilizadas em sistemas financeiros reais.

## Autor

**Yuri Gabriel**

Estudante de programação com foco em desenvolvimento backend e arquitetura de software.
