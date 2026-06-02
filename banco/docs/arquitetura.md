# Objetivos Arquiteturais

* Separação de responsabilidades
* Facilidade de manutenção
* Escalabilidade
* Reutilização de código
* Preparação para migração para API REST
* Facilitar futura integração com interface web

---

# Status Atual da V1

## Funcionalidades Implementadas

### Autenticação

* Cadastro de usuário
* Login
* Validação de credenciais
* Verificação de email duplicado
* Verificação de CPF duplicado

### Conta Bancária

* Criação automática de conta
* Geração automática do número da conta
* Consulta de saldo
* Persistência no SQLite

### Operações Bancárias

* Depósito
* Saque

### Transações

* Registro de depósitos
* Registro de saques
* Histórico de movimentações

### Extrato

* Consulta de transações
* Ordenação por data
* Exibição do histórico completo

### Banco de Dados

* SQLite integrado
* Criação automática das tabelas
* Persistência de dados

---

# Funcionalidades Planejadas para V2

### API REST

* Spring Boot
* Controllers
* DTOs
* Repositories
* Validações

### Segurança

* Hash de senhas
* JWT
* Controle de acesso

### Operações Bancárias

* Transferência entre contas
* Melhor tratamento de erros
* Transações de banco de dados

### Banco de Dados

* Migração SQLite → PostgreSQL ou MySQL

---

# Funcionalidades Planejadas para V3

### Interface Web

* Login
* Dashboard
* Consulta de saldo
* Extrato
* Transferência

### Integração

* Consumo da API REST
* Atualização dinâmica dos dados

### Experiência do Usuário

* Layout responsivo
* Melhor usabilidade
* Navegação intuitiva

---

# Evolução Planejada

V1
↓
Sistema Console + SQLite

✔ Cadastro
✔ Login
✔ Conta Bancária
✔ Depósito
✔ Saque
✔ Histórico de Transações
✔ Extrato

V2
↓
API REST + Spring Boot

✔ Controllers
✔ Services
✔ Repositories
✔ DTOs
✔ PostgreSQL/MySQL
✔ Transferência
✔ JWT

V3
↓
Interface Web

✔ Dashboard
✔ Login
✔ Extrato
✔ Transferência
✔ Integração Front-end + API

Resultado
↓
Sistema Bancário Completo

---

# Objetivo para Portfólio

Demonstrar conhecimento em:

* Java
* Programação Orientada a Objetos
* JDBC
* SQLite
* SQL
* DAO Pattern
* Arquitetura em Camadas
* APIs REST
* Spring Boot
* PostgreSQL/MySQL
* Front-end
* Arquitetura de Software
* Integração Full Stack
