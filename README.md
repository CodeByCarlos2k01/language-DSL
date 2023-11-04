# Projeto de Compiladores


# Do que se trata ?

Neste projeto, fizemos uma Linguagem Específica de Domínio(DSL) voltada para facilitar a realização de tarefas relacionadas a análises estatísticas. A DSL foi criada como parte de um projeto acadêmico com o objetivo de simplificar e agilizar o processo de análise de dados estatísticos, tornando-o mais acessível para usuários com diferentes níveis de experiência em estatística e programação.


# Instruções para Compilação

## 1. Compilação da Descrição da Linguagem Fonte: 

```
java -jar antlr.jar -o src-gen Expr.g4
```
Ao executar este comando, o ANTLR irá ler o Expr.g4 arquivo de gramática e gerar o código Java (analisadores e lexers) com base nas regras gramaticais definidas nesse arquivo. O código gerado será colocado no src-gen diretório.


## 2. Compilação dos Programas em Java:

```
javac -cp antlr.jar:. -d classes src/*.java src-gen/*.java
```
Este comando utiliza o compilador Java. O arquivo antlr.jar, que contém as bibliotecas de runtime permitidas para os códigos gerados pelo ANTLR, é adicionado ao CLASSPATH. O compilador processa todos os arquivos Java encontrados nos diretórios "src" (contendo os arquivos escritos pelo programador) e "src-gen" (contendo os arquivos gerados automaticamente). Os arquivos compilados serão armazenados no diretório "classes".

## 3. Execução do Programa:

```
java -cp antlr.jar:classes Main
```

Este comando executa a classe Main do compilador. Os arquivos binários das classes estão localizados no diretório "classes".

## Equipe:
  ### 1. Carlos Eduardo Cabral
  ### 2. Ênio Ferreiro da Silva
  ### 3. Lais Silva
  ### 4. Pedro Lucas Hirschle
  ### 5. Riquelme Lopes da Silva

## Meu Linkedin:
[![Meu Linkedin](https://github.com/CodeByCarlos01/language-DSL/assets/107969946/61414064-abc7-4bdd-9b32-f7397a035336)](https://www.linkedin.com/in/carlos-eduh/)
