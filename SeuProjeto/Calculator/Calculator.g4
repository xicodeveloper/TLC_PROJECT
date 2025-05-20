grammar Calculator;

options {
    language = CSharp;
}

computation : expression EOF;

expression : expression '+' term
           | expression '-' term
           | term
           ;

term : term '*' factor
     | term '/' factor
     | factor
     ;

factor : '(' expression ')'
       | NUMBER
       ;

NUMBER : DIGIT+ ('.' DIGIT+)?;
DIGIT  : [0-9];
WS     : [ \t\r\n]+ -> skip;