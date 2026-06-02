# Arquitetura do Sistema

O projeto está organizado em módulos separados por responsabilidade, visando facilitar manutenção, organização, reutilização de código e escalabilidade do sistema.

A arquitetura segue o padrão de separação em camadas, onde cada módulo possui uma responsabilidade específica dentro da aplicação.

---

# Estrutura de Pastas

## src/app

Responsável pela execução principal do sistema e interação com o usuário.

### Main.java

Ponto de entrada da aplicação.

Responsável por iniciar o sistema.

### Menu.java

Responsável pela interação com o usuário através do terminal.

Funções principais:

* Exibição dos menus
* Recebimento de entradas do usuário
* Encaminhamento das solicitações para as camadas de serviço

---

## src/auth

Responsável pelo sistema de autenticação e controle de acesso.

### Autenticavel.java

Interface que define comportamentos relacionados à autenticação.

### AuthService.java

Responsável pelas regras de negócio relacionadas à autenticação.

Funções:

* Cadastro de usuários
* Login
* Validação de credenciais
* Verificação de email duplicado
* Verificação de CPF duplicado
* Validação de dados cadastrais

---

## src/dao

Responsável pela persistência e recuperação de dados no banco SQLite.

### ContaDAO.java

Gerencia operações relacionadas às contas bancárias.

Responsabilidades:

* Inserir contas
* Buscar contas
* Atualizar saldo
* Atualizar número da conta

### TitularDAO.java

Gerencia operações relacionadas aos titulares.

Responsabilidades:

* Inserir titulares
* Buscar titulares
* Consultar usuários por email
* Consultar usuários por CPF

### TransacaoDAO.java

Gerencia operações relacionadas às transações bancárias.

Responsabilidades:

* Registrar transações
* Buscar histórico de movimentações
* Consultar transações por conta
* Gerar dados para extrato

---

## src/database

Responsável pela configuração, inicialização e conexão com o banco de dados.

### Conexao.java

Gerencia a conexão com o banco SQLite.

### DatabaseUtil.java

Fornece métodos auxiliares para execução de comandos SQL.

### DatabaseInitializer.java

Responsável pela criação e inicialização das tabelas do sistema.

Funções:

* Criar tabela de titulares
* Criar tabela de contas
* Criar tabela de transações

---

## src/model

Contém as entidades principais do sistema.

### Titular.java

Representa o usuário proprietário da conta.

Principais atributos:

* id
* nome
* idade
* cpf
* email
* senha

### Conta.java

Representa uma conta bancária.

Principais atributos:

* id
* número da conta
* saldo
* titular

### ContaNormal.java

Representa contas bancárias comuns.

### ContaMenor.java

Representa contas destinadas a menores de idade.

### Cartao.java

Representa cartões vinculados às contas.

### Transacao.java

Representa uma movimentação financeira realizada no sistema.

Principais atributos:

* id
* tipo
* valor
* data
* conta de origem
* conta de destino

Tipos suportados:

* DEPOSITO
* SAQUE
* TRANSFERENCIA

---

## src/service

Responsável pelas regras de negócio da aplicação.

### AuthService.java

Gerencia autenticação e validação de usuários.

### ContaService.java

Gerencia operações relacionadas às contas.

Responsabilidades:

* Criação de contas
* Geração do número da conta
* Atualização de saldo

### TransacaoService.java

Gerencia operações financeiras.

Responsabilidades:

* Depósito
* Saque
* Transferência
* Registro de movimentações
* Geração de extrato
* Histórico de transações
* Validação de operações financeiras

---

## src/transacao

Responsável pelas abstrações relacionadas às transações do sistema.

### Transacional.java

Interface destinada à definição de comportamentos transacionais comuns.

Atualmente reservada para futuras expansões do sistema.

Possíveis usos futuros:

* Pix
* TED
* DOC
* Pagamentos
* Transferências especializadas

---

## data

Armazena os arquivos físicos do banco de dados.

### banco.db

Banco de dados SQLite utilizado pela aplicação.

Responsável por armazenar:

* Titulares
* Contas
* Transações

---

## lib

Armazena bibliotecas externas utilizadas pelo projeto.

Exemplo:

* JDBC SQLite Driver

---

## docs

Contém toda a documentação do projeto.

Arquivos:

* arquitetura.md
* requisitos.md
* casos-de-uso.md
* regras-de-negocio.md
* roadmap.md

---

# Fluxo da Aplicação

```text
Usuário
    ↓
Menu
    ↓
Service
    ↓
DAO
    ↓
SQLite
```

Exemplo:

```text
Usuário
    ↓
Menu
    ↓
TransacaoService
    ↓
TransacaoDAO
    ↓
Banco de Dados
```

---

# Objetivos Arquiteturais

* Separação de responsabilidades
* Facilidade de manutenção
* Escalabilidade
* Reutilização de código
* Preparação para migração para API REST
* Facilitar futura integração com interface web

---

# Evolução Planejada

V1
↓
Sistema Console + SQLite

V2
↓
API REST com Spring Boot

V3
↓
Interface Web

Resultado
↓
Sistema Bancário Completo
