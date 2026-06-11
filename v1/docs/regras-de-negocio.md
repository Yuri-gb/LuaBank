# Regras de Negócio

- O usuário deve estar autenticado
- Uma conta não pode sacar além do saldo
- Cada conta possui um titular
- Transferências exigem saldo suficiente
- O sistema deve registrar operações financeiras
- Um titular pode ter va# Regras de Negócio

## RN001 - Saldo negativo
O sistema não deve permitir que contas realizem saques ou transferências acima do saldo disponível.

---

## RN002 - Autenticação obrigatória
O usuário deve estar autenticado para acessar operações bancárias.

---

## RN003 - Validação de dados
Os dados informados pelo usuário devem ser validados antes do cadastro.

---

## RN004 - Transferência bancária
Transferências somente poderão ocorrer entre contas válidas.

---

## RN005 - Persistência
As informações do sistema devem permanecer salvas após o encerramento da aplicação.rias contas desde que o email seja diferente 

## RN006 - Registro obrigatório

Toda operação financeira deve gerar um registro de transação.

---

## RN007 - Extrato bancário

O extrato deve exibir as transações da conta ordenadas da mais recente para a mais antiga.

---

## RN008 - Integridade da transferência

Uma transferência deve atualizar simultaneamente a conta de origem e a conta de destino.