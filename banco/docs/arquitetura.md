# Arquitetura do Sistema

O projeto está organizado em módulos separados por responsabilidade, visando facilitar manutenção, organização e escalabilidade do sistema. 

---

# Estrutura de Pastas

## src/app
Responsável pela execução principal do sistema.

### Main.java
Ponto de entrada da aplicação.

### Menu.java
Responsável pela interação do usuário com o sistema via terminal.

---

## src/auth
Responsável pelo sistema de autenticação e controle de acesso.

### Autenticavel.java
Interface que define comportamentos relacionados à autenticação.

### AuthService.java
Gerencia validações e operações de login.

---

## src/dao
Responsável pela persistência e manipulação de dados no banco SQLite.

### ContaDAO.java
Gerencia operações relacionadas às contas bancárias.

### TitularDAO.java
Gerencia operações relacionadas aos titulares.

### TransacaoDAO.java
Gerencia persistência e consultas das transações bancárias.

---

## src/database
Responsável pela configuração e conexão com o banco de dados.

### Conexao.java
Gerencia a conexão com o SQLite.

### DatabaseUtil.java
Fornece utilitários auxiliares para manipulação do banco.

---

## src/model
Contém as entidades principais do sistema.

### Conta.java
Classe base das contas bancárias.

### ContaNormal.java
Representa contas comuns.

### ContaMenor.java
Representa contas para menores de idade.

### Cartao.java
Representa cartões vinculados às contas.

### Titular.java
Representa os titulares das contas.

### Transacao.java
Representa uma movimentação bancária realizada no sistema.

Possui informações como:
- valor
- tipo da operação
- data
- descrição
- identificador da transação

---

## src/transacao
Responsável pelas regras e comportamentos relacionados às movimentações bancárias.

### Transacional.java
Interface que define comportamentos transacionais do sistema.

### TransacaoService.java
Responsável pelas regras de negócio das transações.

Gerencia funcionalidades como:
- registro de movimentações
- geração de extrato
- validações de operações
- histórico de transações

---

## data
Armazena os arquivos físicos do banco SQLite.

### banco.db
Banco de dados principal do sistema.

---

## lib
Bibliotecas externas utilizadas pelo sistema.

---

## docs
Documentação técnica e organizacional do projeto.

Contém:
- arquitetura
- requisitos
- roadmap
- regras de negócio
- documentação técnica