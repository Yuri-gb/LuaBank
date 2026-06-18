# 🏦 LuaBank

API bancária REST desenvolvida com Java e Spring Boot, simulando funcionalidades presentes em instituições financeiras modernas.

O projeto foi criado com foco no estudo de desenvolvimento backend, arquitetura em camadas, autenticação JWT, persistência de dados, regras de negócio e boas práticas utilizadas em aplicações corporativas.

---

## 🚀 Funcionalidades

### 🔐 Autenticação e Segurança

* Cadastro de contas
* Login com JWT
* Proteção de rotas autenticadas
* Criptografia de senhas com BCrypt
* Validação de credenciais
* Tratamento global de exceções

---

### 👤 Gestão de Contas

* Criação de contas bancárias
* Geração automática do número da conta
* Consulta de perfil
* Consulta de saldo
* Atualização de dados da conta
* Exclusão de contas
* Suporte a múltiplas contas por titular
* Validação de email único

---

### 💸 Operações Bancárias

* Depósito
* Saque
* Controle de saldo
* Validação de saldo insuficiente
* Registro automático das operações

---

### ⚡ Sistema Pix

#### Gerenciamento de Chaves Pix

* Cadastro de chave CPF
* Cadastro de chave Email
* Cadastro de chave Telefone
* Cadastro de chave Aleatória
* Listagem de chaves
* Remoção de chaves

#### Transferências Pix

* Envio de Pix por chave
* Localização automática da conta destino
* Impedimento de Pix para si mesmo
* Validação de saldo
* Registro automático de movimentações

---

### 📄 Extrato Bancário

* Consulta de extrato
* Paginação de resultados
* Histórico de operações
* Ordenação por data
* Identificação de remetente e destinatário
* Registro de:

  * DEPÓSITO
  * SAQUE
  * PIX_ENVIADO
  * PIX_RECEBIDO

---

### ✅ Validações

* CPF obrigatório
* Telefone obrigatório
* Email obrigatório
* Senha obrigatória
* Idade mínima
* Email válido
* Tratamento de Bean Validation
* Mensagens personalizadas de erro

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

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
│   ├── notfound
│   ├── unauthorized
│   └── handler
├── model
├── repository
├── security
└── service
```

### Responsabilidades

| Camada     | Responsabilidade                   |
| ---------- | ---------------------------------- |
| Controller | Recebe e responde requisições HTTP |
| Service    | Implementa regras de negócio       |
| Repository | Persistência de dados              |
| DTO        | Comunicação da API                 |
| Model      | Entidades do domínio               |
| Security   | Autenticação e autorização         |
| Exception  | Tratamento global de erros         |

---

## 🛠️ Tecnologias

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* PostgreSQL
* Flyway
* Maven
* Swagger / OpenAPI
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

## 📚 Documentação

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui.html
```

ou

```text
http://localhost:8080/swagger-ui/index.html
```

(dependendo da versão utilizada)

---

## 🎯 Objetivos do Projeto

* Praticar desenvolvimento backend com Java
* Aplicar arquitetura em camadas
* Construir APIs REST
* Trabalhar com autenticação JWT
* Utilizar Spring Security
* Aplicar JPA/Hibernate
* Implementar regras de negócio reais
* Aprender modelagem de dados
* Evoluir para ambientes de produção

---

## 🗺️ Roadmap

### V2 ✅

* Autenticação JWT
* Perfil
* Saldo
* Depósito
* Saque
* Sistema Pix
* Chaves Pix
* Extrato
* Paginação
* Atualização de conta
* Exclusão de conta
* Múltiplas contas por titular
* Tratamento global de exceções

### Próxima Etapa 🚀

#### Infraestrutura

* Docker
* Docker Compose
* Deploy
* AWS

#### V3

* Dashboard Web
* Frontend React
* Integração completa com a API
* Melhor experiência do usuário

---

## 👨‍💻 Autor

**Yuri Gabriel**

Estudante de Desenvolvimento de Sistemas com foco em desenvolvimento backend utilizando Java, Spring Boot e arquitetura de software.
