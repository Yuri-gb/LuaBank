# Documento de Requisitos

## Descrição geral do sistema

O sistema bancário tem como objetivo fornecer funcionalidades financeiras básicas via terminal, permitindo o gerenciamento de contas, autenticação de usuários e realização de operações bancárias.

O sistema permitirá que usuários realizem operações como saque, depósito, transferência e consulta de saldo, além de persistir os dados utilizando banco de dados SQLite.

---

# Descrição geral dos usuários

## Administrador
Possui acesso às funcionalidades administrativas e gerenciamento geral do sistema.

## Cliente
Possui acesso às operações bancárias da própria conta.

---

# Requisitos funcionais

## [RF001] Criar conta
Descrição:
O sistema deve permitir o cadastro de novas contas bancárias contendo os dados do titular.

---

## [RF002] Autenticação de usuário
Descrição:
O sistema deve permitir autenticação utilizando credenciais válidas.

---

## [RF003] Realizar saque
Descrição:
O sistema deve permitir saques bancários caso exista saldo suficiente na conta.

---

## [RF004] Realizar depósito
Descrição:
O sistema deve permitir depósitos em contas cadastradas.

---

## [RF005] Realizar transferência
Descrição:
O sistema deve permitir transferências entre contas válidas.

---

## [RF006] Consultar saldo
Descrição:
O sistema deve permitir a visualização do saldo atual da conta.

---

## [RF007] Visualizar dados da conta
Descrição:
O sistema deve permitir a visualização das informações da conta e do titular.

## [RF008] Visualizar extrato

Descrição:
O sistema deve permitir a visualização do histórico de transações da conta.

---

## [RF009] Registrar transações

Descrição:
O sistema deve registrar depósitos, saques e transferências realizadas pelos usuários.