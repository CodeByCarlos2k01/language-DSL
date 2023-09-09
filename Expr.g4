grammar Expr;

program: expr EOF;

expr: expr expr+                                        #Comandos
    | 'print' (cond|comp|list)                          #Print
    | 'while' comp ':' expr ';'                         #While
    | 'for' '(' list ')' '->' VAR ':' expr ';'          #For
    | VAR '=' (cond|comp|list)                          #Igualdade
    | VAR ('++'|'--')                                   #IncrementoDecremento
    | (op|cond)                                         #Operacao
    ;

cond: 'if' comp ':' expr ';' ('else' ':' expr ';')?     #Condicional
    ;

comp: '(' comp ')'                                      #Parentese
    | comp 'and' comp                                   #And
    | comp 'or' comp                                    #Or
    | list '==' list                                    #Igual
    | list '!=' list                                    #Diferente
    | list '<' list                                     #Menor
    | list '<=' list                                    #MenorIgual
    | list '>' list                                     #Maior
    | list '>=' list                                    #MaiorIgual
    ;

list: op (',' op)*                                      #Lista
    ;

op:  '(' op ')'                                         #Parenteses
    | op '/' op                                         #Divisao
    | op '*' op                                         #Produto
    | op '%' op                                         #Resto
    | op '+' op                                         #Soma
    | op '-' op                                         #Subtracao
    | com                                               #Comando
    ;

com:  'media' '(' list ')'                              #Media
    | 'mediana' '(' list ')'                            #Mediana
    | 'desvio_padrao' '(' list ')'                      #DPadrao
    | 'min' '(' list ')'                                #Minimo
    | 'max' '(' list ')'                                #Maximo
    | 'variancia' '(' list ')'                          #Variancia
    | 'moda' '(' list ')'                               #Moda
    | NUM                                               #Numero
    | func                                              #Funcao
    ;

func: func '.add' '(' list ')'                          #Add
    | func '.remove' '(' list ')'                       #Remove
    | func '.pop' ('(' ')')?                            #Pop
    | VAR                                               #Variavel
    ;

NUM: '-'? DIGIT ('.' DIGIT)?;
VAR: [a-zA-Z][0-9]*;
DIGIT: [0-9]+;
SPACE: (' '|'\n') -> skip;
