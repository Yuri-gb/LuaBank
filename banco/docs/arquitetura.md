# Arquitetura do Sistema

## Estrutura Geral

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
Define comportamentos relacionados à autenticação.

### AuthService.java
Gerencia validações e operações de login.

---

## src/banco/dao
Responsável pela persistência de dados.

### ContaDAO.java
Gerencia operações relacionadas às contas.

### TitularDAO.java
Gerencia operações relacionadas aos titulares.

---

## src/banco/database
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

---

## data
Armazena os arquivos físicos do banco SQLite.

---

## lib
Bibliotecas externas utilizadas pelo sistema.

---

## docs
Documentação técnica e organizacional do projeto.