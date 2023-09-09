grammar Expr;

program: expr EOF;

expr: expr expr+                                        #Comandos
    | 'print' (op|cond|comp)                            #Print
    | 'while' comp ':' expr ';'                         #Loop
    | VAR '=' (cond|comp|op)                            #Igualdade
    | VAR ('++'|'--')                                   #IncrementoDecremento
    | (op|cond)                                         #Operacao
    ;

cond: 'if' comp ':' expr ';' ('else' ':' expr ';')?     #Condicional
    ;

comp: '(' comp ')'                                      #Parentese
    | comp 'and' comp                                   #And
    | comp 'or' comp                                    #Or
    | op '==' op                                        #Igual
    | op '!=' op                                        #Diferente
    | op '<' op                                         #Menor
    | op '<=' op                                        #MenorIgual
    | op '>' op                                         #Maior
    | op '>=' op                                        #MaiorIgual
    ;

op:  '(' op ')'                                         #Parenteses
    | op '/' op                                         #Divisao
    | op '*' op                                         #Produto
    | op '%' op                                         #Resto
    | op '+' op                                         #Soma
    | op '-' op                                         #Subtracao
    | com                                               #Comando
    ;

com:  'media' '(' com ')'                               #Media
    | 'mediana' '(' com ')'                             #Mediana
    | 'desvio_padrao' '(' com ')'                       #DPadrao
    | 'min' '(' com ')'                                 #Minimo
    | 'max' '(' com ')'                                 #Maximo
    | 'variancia' '(' com ')'                           #Variancia
    | 'moda' '(' com ')'                                #Moda
    | NUM (',' NUM)*                                    #Lista
    | func                                              #Funcao
    ;

func: func '.add' '(' op ')'                            #Add
    | func '.remove' '(' op ')'                         #Remove
    | func '.pop' ('(' ')')?                            #Pop
    | VAR                                               #Variavel
    ;

NUM: '-'? DIGIT ('.' DIGIT)?;
VAR: [a-zA-Z][0-9]*;
DIGIT: [0-9]+;
SPACE: (' '|'\n') -> skip;