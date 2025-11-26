# 📚 Sistema de Gerenciamento de Biblioteca

Este projeto é um sistema de console desenvolvido para gerenciamento básico de uma biblioteca, permitindo cadastro, busca, listagem, ordenação e remoção de livros em memória, sem utilização de banco de dados ou interface gráfica, conforme requisitos acadêmicos.

O sistema foi implementado em Java, utilizando como estrutura principal uma lista dinâmica (ArrayList), aplicando manualmente algoritmos clássicos de busca linear e ordenação Bubble Sort, além de modularização e validação de dados de entrada.

# 🚀 Funcionalidades

* ✅ Cadastro de livros (título, autor, ano e ISBN)

* 🔍 Busca por:

  * Título
  * Autor
  * Ano de publicação

* 📋 Listagem de livros ordenados por:

  * Título (ordem alfabética)
  * Autor (ordem alfabética)
  * Ano (ordem crescente)

* 🗑️ Remoção de livro via ISBN

* 💾 Dados mantidos em memória durante a execução

* ⚠️ Validação de entradas para garantir integridade dos dados

# 🧠 Conceitos aplicados

* Estruturas de dados: List, ArrayList

* Algoritmos de busca: Busca Linear

* Algoritmos de ordenação: Bubble Sort (implementado manualmente)

* Princípios de programação:

  * Lógica e fluxo de controle

  * Modularização (separação em classes)

  * Abstração e encapsulamento

  * Validação com expressões regulares

* Entrada/saída via console com Scanner

# 🛠️ Estrutura do projeto

Biblioteca.java	-----> Gerencia a coleção de livros e as operações de busca/ordenação/remover

Livro.java ----->	Representa a entidade livro

Validador.java ----->	Valida os dados informados pelo usuário

Main.java -----> Menu e interação via console

# 📌 Observações

* O sistema não persiste dados após encerrar a aplicação

* Não utiliza SGBD ou interface gráfica por não serem exigidos nesta etapa do projeto

* Ideal para demonstrar uso de algoritmos em memória e manipulação de coleções
