# Projeto Branco

Sistema bancário desenvolvido em Java para estudos de Programação Orientada a Objetos, persistência de dados, arquitetura de software e boas práticas de desenvolvimento.

## 🚀 Versão Atual

**v1.0 - Sistema Bancário Funcional**

## Funcionalidades

### Autenticação

* Cadastro de usuários
* Login
* Validação de credenciais
* Verificação de email duplicado
* Verificação de CPF duplicado

### Conta Bancária

* Criação automática de conta
* Geração automática do número da conta
* Consulta de saldo

### Operações Bancárias

* Depósito
* Saque

### Transações

* Registro de movimentações
* Histórico de transações

### Extrato

* Consulta de extrato
* Ordenação por data
* Exibição do histórico completo

## Tecnologias Utilizadas

* Java
* SQLite
* JDBC
* Git
* GitHub

## Arquitetura

O projeto está organizado em camadas:

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

### Responsabilidades

* **Model** → Entidades do sistema
* **DAO** → Persistência de dados
* **Service** → Regras de negócio
* **Database** → Configuração e inicialização do banco

## Execução do Projeto

O projeto deve ser executado pela pasta raiz `BANCO/`.

Isso é necessário para garantir o funcionamento correto dos caminhos relativos utilizados pelo SQLite e evitar problemas de duplicidade do banco de dados.

Estrutura esperada:

```text
BANCO/
├── src/
├── data/
├── docs/
├── lib/
```

O banco de dados será criado automaticamente em:

```text
data/banco.db
```

## Roadmap

### V1 ✅

* Cadastro
* Login
* Conta Bancária
* Depósito
* Saque
* Histórico de Transações
* Extrato

### V2 🚧

* Spring Boot
* API REST
* PostgreSQL ou MySQL
* JWT
* Transferência entre contas

### V3 📋

* Interface Web
* Dashboard
* Integração com API REST

## Objetivo

Projeto criado para praticar conceitos de desenvolvimento backend e evolução contínua em Java.

Além do aprendizado técnico, o projeto também tem como objetivo desenvolver conhecimentos em:

* Programação Orientada a Objetos
* Arquitetura de Software
* Arquitetura em Camadas
* SQL
* JDBC
* Persistência de Dados
* Documentação
* Git e GitHub
* APIs REST
* Spring Boot
* Desenvolvimento Full Stack

## Autor

Yuri Gabriel

Estudante de Desenvolvimento de Sistemas e entusiasta de desenvolvimento backend.
