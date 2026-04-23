# 💳 Sistema Bancário em Java (Console)

## 📌 Descrição

Este projeto é um sistema bancário simples desenvolvido em **Java**, executado via **console**, que simula operações básicas de um banco digital.

O sistema permite criar contas, autenticar usuários e realizar operações financeiras como depósitos, saques e transferências, além de exibir informações da conta.

---

## ⚙️ Funcionalidades

* ✅ Criação de conta com validações

* 🔐 Login com autenticação e limite de tentativas
 
* 💰 Depósito de valores
  
* 💸 Saque com verificação de saldo
  
* 🔁 Transferência entre contas via chave
  
* 📄 Exibição de dados da conta
  
* 🚫 Bloqueio temporário após tentativas inválidas

---

## 🏗️ Estrutura do Projeto

O projeto é composto por duas classes principais:

### 🔹 `Banco`

Responsável por representar uma conta bancária.

**Principais atributos:**

* `nomeTitular`
* `numeroContaBancaria`
* `agencia`
* `digito`
* `saldoConta`
* `senha`
* `chave` (tipo PIX: CPF, email, telefone ou RG)

**Principais métodos:**

* `depositar(double valor)`
* `sacar(double valor)`
* `transferir(Banco destino, double valor)`
* `autenticar(String senha)`
* `mostrarInformacaoConta()`

---

### 🔹 `Programa`

Responsável pela execução do sistema e interação com o usuário.

**Funcionalidades:**

* Menu interativo
* Controle de contas em um array
* Login e sessão do usuário
* Busca de contas por:

  * Número (`buscarConta_por_NumConta`)
  * Chave (`buscarConta_por_Chave`)

---

## ▶️ Como Executar

### Pré-requisitos:

* Java JDK 8 ou superior instalado

### Passos:

1. Compile os arquivos:

```bash
javac Banco.java Programa.java
```

2. Execute o programa:

```bash
java Programa
```

---

## 🧠 Regras de Negócio

* Senha deve ter mais de 4 caracteres
  
* Chaves seguem validações:
  * CPF → 11 dígitos
  * Email → deve conter "@"
  * Telefone → 10 ou 11 dígitos
  * RG → 9 dígitos
   
* Transferência:
  * Valor máximo: R$5000
  * Não pode transferir para si mesmo
    
* Saque:
  * Não pode exceder o saldo
    
* Login:
  * Máximo de 3 tentativas

---

## 📊 Exemplo de Uso

```text
1- Criar conta
2- Login
3- Depositar
4- Sacar
5- Transferir valor
6- Mostrar as informações da sua conta
7- Sair
```

---

## 🚀 Possíveis Melhorias

* Persistência de dados (arquivo ou banco de dados)
  
* Interface gráfica (Swing/JavaFX)
  
* Criptografia de senha
  
* Sistema de múltiplos usuários simultâneos
  
* Implementação de histórico de transações

---

## 👨‍💻 Autor

Guilherme Barone Milani

---

## 📌 Observação

Este projeto não deve ser utilizado em produção, pois não possui mecanismos de segurança robustos (como criptografia de dados e autenticação segura).

Projeto desenvolvido para fins educacionais, com foco em:

* Programação Orientada a Objetos (POO)
  
* Estruturas de controle (if/else, loops)
  
* Manipulação de arrays
  
* Boas práticas básicas em Java
---
