lexer grammar DCPU;

LABEL	:	('_' | LETTER | DIGIT) + ':';

OPCODE
	:	'SET' | 'ADD' | 'SUB';
OPERAND       
	:	REGISTER
		| LITERAL
		| '[' + REGISTER + ']'
		| '[' + LITERAL + ']';
fragment REGISTER
	:	'A' | 'B';
fragment LITERAL
	:	'1';
COMMENT_BEGIN	
	:	';';
fragment LETTER
	:	'a' .. 'z'
	|	'A' .. 'Z';
fragment DIGIT
	:	'0' .. '9';
fragment WS	
	:	(' ' | '\r' | '\t' | '\u000C');