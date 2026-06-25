# LuaBank - Documento de Negócio

## Objetivo

Documentar as entidades, regras de negócio, restrições e comportamentos do domínio do LuaBank.

---

# Entidades

## Titular

Representa uma pessoa dentro do sistema.

### Dados

- Nome
- CPF
- Telefone

### Regras

- Um CPF representa exatamente um titular.
- Um titular pode possuir múltiplas contas.
- O CPF é permanente e não pode ser alterado.

---

## Conta

Representa uma conta bancária.

### Dados

- Número da conta
- Email
- Senha
- Saldo

### Regras

- Toda conta pertence a um único titular.
- O número da conta deve ser único.
- O email deve ser único.
- O saldo nunca pode ser negativo.

---

## Chave Pix

Representa uma chave associada a uma conta.

### Tipos

- CPF
- Email
- Telefone
- Aleatória

### Regras

- Uma chave pertence a apenas uma conta.
- Uma chave deve ser única em todo o sistema.
- Uma conta pode possuir múltiplas chaves.

---

## Operação

Representa movimentações financeiras.

### Tipos

- DEPOSITO
- SAQUE
- PIX_ENVIADO
- PIX_RECEBIDO

### Regras

- Toda operação deve ser registrada.
- Operações não podem ser removidas.
- Operações compõem o extrato bancário.

---

# Regras de Negócio

## RN001 - Autenticação Obrigatória

Operações protegidas exigem usuário autenticado.

---

## RN002 - Saldo Negativo

Não é permitido:

- Saque acima do saldo.
- Pix acima do saldo.

---

## RN003 - Email Único

Não podem existir duas contas com o mesmo email.

---

## RN004 - Número da Conta

O número da conta deve ser único.

---

## RN005 - CPF Imutável

Após criação da conta o CPF não pode ser alterado.

---

## RN006 - Número da Conta Imutável

Após criação da conta o número da conta não pode ser alterado.

---

## RN007 - Pix para si mesmo

Não é permitido realizar Pix para a própria conta.

---

## RN008 - Chaves Pix

Toda chave Pix deve ser única.

---

## RN009 - Atualização de Email

Ao atualizar o email:

- O novo email deve ser único.
- Chaves Pix do tipo EMAIL devem ser atualizadas.

---

## RN010 - Atualização de Telefone

Ao atualizar o telefone:

- O formato deve ser válido.
- Chaves Pix do tipo TELEFONE devem ser atualizadas.

---

## RN011 - Exclusão de Conta

Ao excluir uma conta:

- Todas as chaves Pix associadas devem ser removidas.
- A conta deixa de existir.

---

## RN012 - Exclusão de Titular

O titular somente pode ser removido quando não possuir contas associadas.

---

## RN013 - Extrato

O extrato deve ser exibido:

- Da operação mais recente para a mais antiga.
- De forma paginada.

---

# Problemas Conhecidos

## JWT após alteração de email

O JWT utiliza o email como Subject.

Após alteração do email:

- O token atual continua válido.
- O token continua contendo o email antigo.

### Solução futura

- Logout automático
ou
- Reautenticação obrigatória