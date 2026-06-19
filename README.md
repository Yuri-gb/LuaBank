# 🏦 LuaBank

API bancária REST desenvolvida com Java e Spring Boot, simulando funcionalidades presentes em instituições financeiras modernas.

🚀 **API em produção:**
https://luabank.onrender.com

📚 **Swagger/OpenAPI:**
https://luabank.onrender.com/swagger-ui/index.html

---

## ✨ Sobre o Projeto

O LuaBank foi desenvolvido com o objetivo de aplicar conceitos de desenvolvimento backend utilizados no mercado, incluindo autenticação JWT, persistência de dados, arquitetura em camadas, Docker, banco de dados PostgreSQL e deploy em nuvem.

O projeto evoluiu de uma aplicação console para uma API REST completa disponível publicamente.

---

## 🚀 Funcionalidades

### 🔐 Autenticação e Segurança

* Cadastro de contas
* Login com JWT
* Proteção de rotas autenticadas
* Criptografia de senhas com BCrypt
* Validação de credenciais
* Tratamento global de exceções

### 👤 Gestão de Contas

* Criação de contas bancárias
* Geração automática do número da conta
* Consulta de perfil
* Consulta de saldo
* Atualização de dados
* Exclusão de contas
* Múltiplas contas por titular
* Validação de email único

### 💸 Operações Bancárias

* Depósito
* Saque
* Controle de saldo
* Validação de saldo insuficiente
* Registro automático de operações

### ⚡ Sistema Pix

#### Gerenciamento de Chaves

* CPF
* Email
* Telefone
* Chave aleatória
* Listagem de chaves
* Remoção de chaves

#### Transferências

* Pix por chave
* Localização automática da conta destino
* Impedimento de auto transferência
* Validação de saldo
* Registro automático de movimentações

### 📄 Extrato

* Consulta de extrato
* Paginação
* Ordenação por data
* Histórico completo de operações

Tipos de movimentação:

* DEPÓSITO
* SAQUE
* PIX_ENVIADO
* PIX_RECEBIDO

---

## 🏗️ Arquitetura

```text
src/main/java/com/yurigb/luabank
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── exception
├── model
├── repository
├── security
└── service
```

| Camada     | Responsabilidade   |
| ---------- | ------------------ |
| Controller | Requisições HTTP   |
| Service    | Regras de negócio  |
| Repository | Persistência       |
| DTO        | Comunicação da API |
| Model      | Entidades          |
| Security   | JWT e autorização  |
| Exception  | Tratamento global  |

---

## 🛠️ Tecnologias

### Backend

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate

### Banco de Dados

* PostgreSQL
* Flyway

### Infraestrutura

* Docker
* Docker Compose
* Render

### Documentação

* Swagger/OpenAPI

### Ferramentas

* Maven
* Git
* GitHub

---

## 🔗 Principais Endpoints

### Autenticação

```http
POST /auth/login
```

### Conta

```http
POST   /contas/criar
GET    /contas/perfil
GET    /contas/saldo
PUT    /contas/atualizar
DELETE /contas
```

### Pix

```http
POST   /pix
POST   /pix/chaves
GET    /pix/chaves
DELETE /pix/chaves/{id}
```

### Extrato

```http
GET /contas/extrato
```

---

## ☁️ Deploy

A aplicação encontra-se publicada em ambiente de produção utilizando:

* Render
* Docker
* PostgreSQL Managed Database

API:

https://luabank.onrender.com

Swagger:

https://luabank.onrender.com/swagger-ui/index.html

---

## 🎯 Objetivos do Projeto

* Desenvolvimento Backend com Java
* APIs REST
* Spring Security
* JWT
* Arquitetura em Camadas
* PostgreSQL
* Docker
* Deploy em Produção
* Boas práticas de desenvolvimento

---

## 🗺️ Roadmap

### V2 ✅

* JWT
* Perfil
* Saldo
* Depósito
* Saque
* Pix
* Chaves Pix
* Extrato
* Paginação
* Atualização de conta
* Exclusão de conta
* Docker
* Deploy
* PostgreSQL em produção

### Próximos Passos 🚀

#### Infraestrutura

* AWS
* CI/CD
* Monitoramento
* Logs centralizados

#### V3

* Frontend React
* Dashboard Web
* Integração completa com a API

---

## 👨‍💻 Autor

Yuri Gabriel

Estudante de Desenvolvimento de Sistemas com foco em desenvolvimento Backend utilizando Java, Spring Boot, APIs REST e arquitetura de software.
