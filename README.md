# Compiladores2022.2
Códigos Desenvolvidos pela disciplina Compiladores
no semestre 2022.2


# Estrutura de Arquivos:

Os arquivos deste projeto estão organizados nos seguintes arquivos e pastas:

**src**: Programas em Java escritos pelo programador

**src-gen**: Programas em Java gerados automaticamente pelo ANTLR ou outras ferramentas.

**classes**: Arquivos .class gerados pela compilados dos códigos fontes.

**antlr.jar**: Ferramenta ANTLR versão 4 baixada do site antlr.org

**Expr.g4**: Linguagem de expressões desenvolvida na sala

**input.exp**: Exemplo da linguagem


# Comandos para Compilar

## 1. Compilar a descrição da linguagem fonte:

```
java -jar antlr.jar -o src-gen Expr.g4
```
O comando acima executa o gerador ANTLR que converte a descrição da gramática (Expr.g4) em
programas Java (Analisadores léxicos e sintáticos). Os códigos dos analisadores gerados serão armazendados na pasta src-gen.



## 2. Compilar programas em Java:


```
javac -cp antlr.jar:. -d classes src/*.java src-gen/*.java
```
O comando acima executa o compilador Java. O arquivo antlr.jar, que contem as bibliotecas
runtime utilizadas pelo código gerado pelo antlr são adicionadas ao CLASSPATH. O compilador
compila todos os arquivos java que estão no diretório "src" (arquivo escritos pelo programador)
e no diretório "src-gen" (arquivos gerados automáticamente). 

O arquivos binários compilados gerados pelo javac serão armazenados no diretório classes.


## 3. Executar o programa:

```
java -cp antlr.jar:classes Main
```

O comando acima executa a classe Main do compilador. Os arquivos binários das classes estão localizades no diretório "classes". Para a classe poder ser executada é necessário também incluir os arquivos do runtime do antlr.jar.

