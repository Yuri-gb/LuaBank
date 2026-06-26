# LuaBank - Guia para Frontend

## Autenticação

A API utiliza JWT.

Todas as rotas protegidas exigem:

Authorization: Bearer TOKEN

---

## Login

Fluxo:

Login
↓
Recebe JWT
↓
Armazena JWT
↓
Acessa áreas protegidas

---

## Logout

Remover JWT armazenado localmente.

---

## Atualização de Email

Após atualização de email:

- Recomenda-se realizar novo login.
- O JWT atual permanece contendo o email antigo.

---

## Extrato

Características:

- Paginado
- Ordenado por data decrescente

---

## Pix

Restrições:

- Não é permitido Pix para a própria conta.
- É necessário saldo suficiente.

---

## Perfil

Campos editáveis:

- Nome
- Telefone
- Email

Campos bloqueados:

- CPF
- Número da conta

---

## Tratamento de Erros

O frontend deve exibir mensagens retornadas pela API.

Casos comuns:

- Email já cadastrado
- Conta não encontrada
- Saldo insuficiente
- Chave Pix não encontrada
- Token inválido