# Manual da DSL (Domain-Specific Language)
## Introdução
Esta DSL (Domain-Specific Language) permite que você escreva expressões, comandos e estruturas de controle de fluxo de uma forma simples e legível. Ela é projetada para facilitar a criação de programas com foco em cálculos, lógica e operações matemáticas. Neste manual, você encontrará informações detalhadas sobre como usar cada construção da DSL.
## Estrutura Básica
Um programa na DSL é composto por uma série de expressões e comandos. A estrutura básica de um programa é a seguinte:
```sh
program : expr EOF;
```
Isso significa que um programa consiste em uma única expressão `expr` seguida pelo final do arquivo (EOF).
## Expressões
As expressões na DSL podem ser compostas de várias maneiras, incluindo operações matemáticas, comandos e estruturas de controle. Aqui estão algumas formas de criar expressões:
### Comando de Impressão
Use o comando `print` para imprimir valores na saída padrão. Você pode imprimir uma condição, uma expressão de comparação ou uma lista:
```sh
print if min(a) < min(b): min(a); else: min(b);
print variancia(a) < variancia(b) and desvio_padrao(a) > desvio_padrao(b)
print a.add(b).remove(c).pop
```
### Estrutura de Repetição(While)
Para criar um loop `while`, use a seguinte sintaxe:
```sh
while condicao: expr ;
```
O `while` executará repetidamente a expressão `expr` enquanto a `condicao` for verdadeira.
### Estrutura de Repetição(For)
Para criar um loop `for`, use a seguinte sintaxe:
```sh
for (lista) -> VAR: expr ;
```
O `for` irá iterar sobre os elementos da `lista` e atribuir cada elemento à variável `VAR` antes de executar a `expr`.
### Igualdade
Você pode verificar a igualdade entre uma variável e uma condição, expressão de comparação ou lista:
```sh
VAR = if min(a) < min(b): min(a); else: min(b);
VAR = variancia(a) < variancia(b) and desvio_padrao(a) > desvio_padrao(b)
VAR = a.add(b).remove(c).pop
```
### Incremento e Decremento
Você pode usar os operadores `++` e `--` para incrementar ou decrementar uma variável:
```sh
VAR++
VAR--
```
### Operações Matemáticas
Você pode realizar operações matemáticas em expressões, incluindo adição, subtração, multiplicação, divisão e resto:
```sh
op + op
op - op
op * op
op / op
op % op
```
## Estruturas de Controle
A DSL também suporta estruturas de controle de fluxo, como condicionais `if`:
### Condicional(if-else)
Use o seguinte formato para criar um condicional `if-else`:
```sh
if condicao:
  expr ;
else:
  expr ;
```
Isso permite que você execute diferentes expressões com base na condição.
## Expressões de Comparação
As operações de comparação suportadas incluem:
- `and`: Operação lógica "E".
- `or`: Operação lógica "OU".
- `==`: Igualdade.
- `!=`: Diferença.
- `<`: Menor que.
- `<=`: Menor ou igual a.
- `>`: Maior que.
- `>=`: Maior ou igual a.
## Listas
Você pode criar listas de elementos separados por vírgulas:
```sh
op1, op2, op3
```
## Funções
A DSL suporta funções embutidas para realizar cálculos e manipulações de lista. Algumas das funções incluem:
- `media(lista)`: Calcula a média dos elementos em uma lista.
- `mediana(lista)`: Calcula a mediana dos elementos em uma lista.
- `desvio_padrao(lista)`: Calcula o desvio padrão dos elementos em uma lista.
- `min(lista)`: Encontra o valor mínimo em uma lista.
- `max(lista)`: Encontra o valor máximo em uma lista.
- `variancia(lista)`: Calcula a variância dos elementos em uma lista.
- `moda(lista)`: Encontra a moda dos elementos em uma lista.
## Variáveis
Você pode usar variáveis para armazenar valores e resultados intermediários. As variáveis devem começar com uma letra seguida de zero ou mais números:
```sh
l1 = 1, 2, mediana(l2), desvio_padrao(l3)
```
## Números
Números podem ser inteiros ou decimais e podem incluir um sinal de menos (para números negativos).
## Conclusão
Esta DSL oferece uma maneira flexível de expressar expressões matemáticas, comandos e estruturas de controle de forma legível e concisa. Use os elementos e construções descritos neste manual para criar programas que atendam às suas necessidades.

