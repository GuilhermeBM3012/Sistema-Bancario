# 🏦 Sistema Bancário em Java (com Login e Chave PIX)

## 📌 Descrição

Este projeto é um **sistema bancário em Java executado no terminal**, desenvolvido para praticar conceitos de **Programação Orientada a Objetos (POO)** e lógica de programação.

O sistema permite criar contas, autenticar usuários, realizar operações financeiras e transferências utilizando **chave PIX**.

---

## 🚀 Funcionalidades

* 🧾 Criar conta com:

  * Nome do titular
  * Senha
  * Chave PIX (CPF, RG, Email ou Telefone)

* 🔐 Login com autenticação:

  * Até 3 tentativas de senha

* 💰 Depósito de valores

* 💸 Saque de valores

* 🔄 Transferência entre contas via chave PIX

* 📄 Exibição dos dados da conta logada

* 🚪 Encerramento do sistema

---

## 🧠 Conceitos Utilizados

Este projeto aplica diversos conceitos fundamentais:

* Programação Orientada a Objetos (POO)
* Classes e Objetos
* Construtores
* Encapsulamento (`private`)
* Métodos e validações
* Arrays de objetos
* Estruturas condicionais (`if`, `switch`)
* Estruturas de repetição (`while`, `do while`)
* Entrada de dados com `Scanner`
* Autenticação de usuário
* Manipulação de Strings (`equals`, `matches`)

---

## 🏗️ Estrutura do Projeto

### 📁 Classe `Banco`

Representa uma conta bancária.

**Atributos:**

* Nome do titular
* Número da conta
* Agência
* Dígito
* Saldo
* Senha
* Chave PIX

**Principais métodos:**

* `depositar(double valor)`
* `sacar(double valor)`
* `transferir(Banco destino, double valor)`
* `autenticar(String senha)`
* `getConta()`
* `getChave()`
* `mostrarInformacaoConta()`

---

### 📁 Classe `Programa`

Responsável pela execução do sistema.

**Responsabilidades:**

* Exibir menu interativo
* Criar contas
* Gerenciar login (`usuarioLogado`)
* Realizar operações bancárias
* Buscar contas por:

  * número (`buscarContaPorNumero`)
  * chave PIX (`buscarContaPorChave`)

---

## 🔐 Sistema de Login

O sistema utiliza autenticação baseada em:

* Número da conta (`ex: 1000-0`)
* Senha definida pelo usuário

O login permite até **3 tentativas**, após isso a conta é temporariamente bloqueada.

---

## 💳 Sistema de Chave PIX

Durante a criação da conta, o usuário escolhe o tipo de chave:

1. CPF
2. RG
3. Email
4. Telefone

Cada tipo possui validação específica:

* CPF → 11 dígitos
* RG → 9 dígitos
* Email → deve conter `@`
* Telefone → 10 ou 11 dígitos

---

## 🔄 Transferência

A transferência é realizada utilizando a **chave PIX da conta destino**.

✔ Validações aplicadas:

* Conta destino existente
* Valor válido (> 0)
* Saldo suficiente

---

## 💻 Como executar

### 1. Compilar o projeto

```bash
javac Banco.java Programa.java
```

### 2. Executar o sistema

```bash
java Programa
```

---

## 🖥️ Exemplo de uso

```
1- Criar conta
2- Login
3- Depositar
4- Sacar
5- Transferir valor
6- Mostrar informações
7- Sair

Escolha uma opção: 1
Nome do titular: João
Crie uma senha: 123
Confirme a senha: 123

Tipo de chave:
1- CPF
2- RG
3- EMAIL
4- TELEFONE

Digite seu email: joao@email.com
Conta criada com sucesso!
Número da conta: 1000-0
```

---

## ⚠️ Limitações

* O sistema suporta até 10 contas (uso de array fixo)
* Não há persistência de dados (os dados são perdidos ao encerrar)
* Interface apenas via terminal
* Não possui criptografia de senha

---

## 🚀 Possíveis melhorias

* 🔁 Substituir array por `ArrayList`
* 🔐 Criptografar senhas
* 💾 Persistência em banco de dados ou arquivo
* 📊 Histórico de transações
* 💳 Transferência com comprovante
* 🎨 Interface gráfica (Swing ou JavaFX)
* 🔑 Login com chave PIX

---

## 👨‍💻 Autor

Projeto desenvolvido para fins acadêmicos e prática de Java.

---

## 📌 Conclusão

Este projeto simula um sistema bancário real de forma simplificada, aplicando conceitos essenciais de programação. Ele pode ser facilmente expandido para aplicações mais robustas e profissionais.

---
