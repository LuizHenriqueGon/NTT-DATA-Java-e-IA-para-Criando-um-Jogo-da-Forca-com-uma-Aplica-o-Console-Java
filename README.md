# NTT-DATA-Java-e-IA-para-Criando-um-Jogo-da-Forca-com-uma-Aplica-o-Console-Java

# Jogo da Forca com Programação Orientada a Objetos em Java

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
--

## 📜 Descrição do Projeto

Este projeto é uma aplicação de console que simula o clássico **Jogo da Forca**, desenvolvido em Java com foco na aplicação prática dos conceitos de **Programação Orientada a Objetos (POO)**. A aplicação evoluiu de uma estrutura básica para um sistema robusto e desacoplado, onde um `ControladorDoJogo` gerencia a interação entre a lógica da partida, a interface com o usuário e a fonte de dados das palavras.

O sistema permite que o jogador escolha categorias de palavras e níveis de dificuldade, oferece um sistema de dicas e rastreia a pontuação, tudo através de uma interface de console interativa que fornece feedback claro para cada ação.

## ✨ Funcionalidades Principais

  * **Gerenciamento da Partida**:

      * Seleção de categorias de palavras (ex: `frutas`, `paises`, `profissoes`) carregadas dinamicamente de arquivos de texto.
      * Seleção de níveis de dificuldade (`Fácil`, `Médio`, `Difícil`) que alteram o número de tentativas.

  * **Jogabilidade Clássica**:

      * O jogador tenta adivinhar a palavra letra por letra.
      * Representação visual do enforcado em arte ASCII que progride a cada erro.
      * Feedback sobre letras corretas, incorretas e já tentadas.

  * **Recursos Adicionais**:

      * **Sistema de Dicas**: O jogador tem um limite de **três dicas** por partida para revelar uma letra.
      * **Gerenciamento de Jogador**: O sistema rastreia o nome e a pontuação do jogador entre as partidas.
      * **Jogar Novamente**: Ao final de uma partida, o jogador pode escolher iniciar uma nova sem reiniciar a aplicação.

  * **Interface Informativa**:

      * O sistema fornece **feedback claro e detalhado** após cada jogada, mostrando a palavra mascarada, letras erradas, tentativas e dicas restantes.

## 🧠 Conceitos de POO e Boas Práticas Aplicados

O projeto foi estruturado para aplicar os pilares da POO e seguir boas práticas de desenvolvimento de software:

  * **Abstração**: As interfaces `InterfaceUsuario` e `ArmazenamentoPalavras` definem os contratos para a UI e para a fonte de dados, permitindo que as implementações concretas sejam trocadas sem afetar o resto do sistema.
  * **Encapsulamento**: Atributos das classes de modelo (`JogoDaForca`, `Jogador`) são `private`, com acesso controlado por métodos públicos, garantindo a integridade dos dados.
  * **Polimorfismo**: O `ControladorDoJogo` opera sobre as interfaces, permitindo que diferentes implementações (ex: `ConsoleUI`) sejam usadas de forma polimórfica.
  * **Composição**: A classe `ControladorDoJogo` é composta por uma `InterfaceUsuario` e um `Jogador`, modelando a relação "tem-um".

### Outras Práticas Adotadas:

  * **Separação de Responsabilidades (Padrão Controller)**:
      * `ControladorDoJogo`: Atua como um *Controller*, orquestrando o fluxo de dados entre o modelo e a visão.
      * `JogoDaForca` / `Jogador`: Atuam como *Model*, contendo os dados e a lógica de negócio.
      * `ConsoleUI`: Atua como *View*, responsável apenas pela apresentação dos dados.
  * **Java Enums**: Para tipos seguros como `Dificuldade` e `EstadoDoJogo`.
  * **Tratamento de Exceções**: O sistema lida com `IOException` durante a leitura de arquivos, evitando que a aplicação quebre e informando o usuário sobre o problema.

## 📂 Estrutura do Projeto

```
/
├── palavras/
│   ├── frutas.txt
│   ├── paises.txt
│   └── profissoes.txt
├── src/
│   ├── Main.java                 # Ponto de entrada da aplicação
│   ├── ControladorDoJogo.java     # Camada de controle e orquestração
│   ├── JogoDaForca.java
│   └── Jogador.java
│   ├── InterfaceUsuario.java
│   └── ConsoleUI.java
│   ├── ArmazenamentoPalavras.java
│   └── BancoDePalavras.java
│   ├── Dificuldade.java
│   └── EstadoDoJogo.java
│   └── EntradaInvalidaException.java
└── CriandoumJogodaForca.iml
```

## 🚀 Como Executar o Projeto

### Pré-requisitos

  * JDK 8 ou superior.
  * Git.

### Passos

1.  **Clone o repositório:**

    ```bash
    git clone [URL-DO-SEU-REPOSITORIO-NO-GITHUB]
    ```

2.  **Navegue até o diretório do projeto:**

    ```bash
    cd [NOME-DA-PASTA-DO-PROJETO]
    ```

3.  **Execute a aplicação (via IDE - recomendado):**

      * Abra o projeto em uma IDE como o IntelliJ IDEA.
      * Abra o arquivo `src/Main.java`.
      * Clique no ícone de "play" (▶️) ao lado do método `main` para compilar e executar a aplicação.

4.  **Execute a aplicação (via terminal):**

      * Compile os arquivos Java:
        ```bash
        javac -d out src/*.java
        ```
      * Execute a classe principal:
        ```bash
        java -cp out Main
        ```

## 🖼️ Exemplo de Uso

**Seleção de Categoria e Dificuldade:**

```
Bem-vindo ao Jogo da Forca! Qual é o seu nome? Luiz
Olá, Luiz! Vamos começar.

Escolha uma categoria:
1 - paises
2 - profissoes
3 - frutas
Opção: 2

Escolha o nível de dificuldade:
1 - FACIL (8 tentativas)
2 - MEDIO (6 tentativas)
3 - DIFICIL (4 tentativas)
Opção: 3
```

**Partida em Andamento:**

```
================ JOGO DA FORCA ================
  +---+
  |   |
  |   O
  |  /|\
  |
  |
=======

Palavra: P R O _ _ A M A _ O R
Letras erradas: [E, S, T]
Tentativas restantes: 1
Dicas restantes: 2
Digite uma letra (ou '1' para dica): G
```
