grammar PICO;

@header {
namespace SeuProjeto.Generated;
}

program: statement* EOF;

statement: read_stmt
         | print_stmt
         | assign_stmt
         | if_stmt
         | while_stmt
         ;

read_stmt: 'read' ID ';';
print_stmt: 'print' expression ';';
assign_stmt: ID '=' expression ';';

if_stmt: 
    'if' condition 'then' 
    thenBlock=statements 
    ('else' elseBlock=statements)? 
    'end' ';';

while_stmt: 'while' condition 'do' statements 'end' ';';

statements: statement*;

condition: expression rel_op expression;
rel_op: '==' | '!=' | '>' | '<' | '>=' | '<=';

expression: term (('+' | '-') term)*;
term: factor (('*' | '/') factor)*;
factor: NUMBER | ID | '(' expression ')';

ID: [a-zA-Z][a-zA-Z0-9]*;
NUMBER: [0-9]+;
WS: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;