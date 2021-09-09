package proyecto1;
import java_cup.runtime.Symbol;
import proyecto1.Inicio;
import static proyecto1.Inicio.errorLexicoJS;
import static proyecto1.Inicio.agregarTokenJS;
import static proyecto1.Inicio.agregarNodoComparacion;


%%
%{
    //Código de usuario
    String cadenaComentario = "";
%}

%cup
%class scannerjs
%public
%line
%char
%column
%full
%unicode
%8bit
%state SALTO
%state COMENTARIO

digito	 	 = [0-9]
numero       = {digito}+("."{digito}*)?
letra		 = [a-zA-ZñÑ]
id			 = {letra}({letra}|{numero}|_)*
comillas	 = \"
comilla      = \'
cadena		 = {comillas}[^[\"]]*{comillas}
caracter     =  {comilla}.{comilla}
comentario 	 =	"//".*
space		 = [\ \r\t\f\t]
enter   	 = [\ \n]
%%


<YYINITIAL>		"class"            				{ agregarTokenJS("tkClass", yytext(), yyline, yycolumn);			          return new Symbol(symJS.tkClass, yyline, yycolumn, yytext());}
<YYINITIAL>     "var"                           { agregarTokenJS("tkVar", yytext(), yyline, yycolumn);                        return new Symbol(symJS.tkVar, yyline, yycolumn, yytext());}
<YYINITIAL>     "let"                           { agregarTokenJS("tkLet", yytext(), yyline, yycolumn);                        return new Symbol(symJS.tkLet, yyline, yycolumn, yytext());}
<YYINITIAL>     "const"                         { agregarTokenJS("tkConst", yytext(), yyline, yycolumn);                      return new Symbol(symJS.tkConst, yyline, yycolumn, yytext());}
<YYINITIAL>     "if"                            { agregarTokenJS("tkIf", yytext(), yyline, yycolumn);                         return new Symbol(symJS.tkIf, yyline, yycolumn, yytext());}
<YYINITIAL>     "else"                          { agregarTokenJS("tkElse", yytext(), yyline, yycolumn);                       return new Symbol(symJS.tkElse, yyline, yycolumn, yytext());}
<YYINITIAL>     "for"                           { agregarTokenJS("tkFor", yytext(), yyline, yycolumn);                        return new Symbol(symJS.tkFor, yyline, yycolumn, yytext());}
<YYINITIAL>     "while"                         { agregarTokenJS("tkWhile", yytext(), yyline, yycolumn);                      return new Symbol(symJS.tkWhile, yyline, yycolumn, yytext());}
<YYINITIAL>     "do"                            { agregarTokenJS("tkDo", yytext(), yyline, yycolumn);                         return new Symbol(symJS.tkDo, yyline, yycolumn, yytext());}
<YYINITIAL>     "switch"                        { agregarTokenJS("tkSwitch", yytext(), yyline, yycolumn);                     return new Symbol(symJS.tkSwitch, yyline, yycolumn, yytext());}
<YYINITIAL>     "case"                          { agregarTokenJS("tkCase", yytext(), yyline, yycolumn);                       return new Symbol(symJS.tkCase, yyline, yycolumn, yytext());}
<YYINITIAL>     "default"                       { agregarTokenJS("tkDefault", yytext(), yyline, yycolumn);                    return new Symbol(symJS.tkDefault, yyline, yycolumn, yytext());}
<YYINITIAL>     "console"                       { agregarTokenJS("tkConsole", yytext(), yyline, yycolumn);                    return new Symbol(symJS.tkConsole, yyline, yycolumn, yytext());}
<YYINITIAL>     "log"                           { agregarTokenJS("tkLog", yytext(), yyline, yycolumn);                        return new Symbol(symJS.tkLog, yyline, yycolumn, yytext());}
<YYINITIAL>     "break"                         { agregarTokenJS("tkBreak", yytext(), yyline, yycolumn);                      return new Symbol(symJS.tkBreak, yyline, yycolumn, yytext());}
<YYINITIAL>     "require"                       { agregarTokenJS("tkRequire", yytext(), yyline, yycolumn);                    return new Symbol(symJS.tkRequire, yyline, yycolumn, yytext());}
<YYINITIAL>     "null"                          { agregarTokenJS("tkNull", yytext(), yyline, yycolumn);                       return new Symbol(symJS.tkNull, yyline, yycolumn, yytext());}
<YYINITIAL>     "true"                          { agregarTokenJS("tkTrue", yytext(), yyline, yycolumn);                       return new Symbol(symJS.tkTrue, yyline, yycolumn, yytext());}
<YYINITIAL>     "false"                         { agregarTokenJS("tkFalse", yytext(), yyline, yycolumn);                      return new Symbol(symJS.tkFalse, yyline, yycolumn, yytext());}
<YYINITIAL>     "return"                         { agregarTokenJS("tkReturn", yytext(), yyline, yycolumn);                      return new Symbol(symJS.tkReturn, yyline, yycolumn, yytext());}



<YYINITIAL>		"="								{ agregarTokenJS("tkIgual", yytext(), yyline, yycolumn);		  return new Symbol(symJS.tkIgual, yyline, yycolumn, yytext());}		//***********************
<YYINITIAL>		":"								{ agregarTokenJS("tkDosPuntos", yytext(), yyline, yycolumn);	  return new Symbol(symJS.tkDosPuntos, yyline, yycolumn, yytext());}
<YYINITIAL>		"["								{ agregarTokenJS("tkCorcheteA", yytext(), yyline, yycolumn);	  return new Symbol(symJS.tkCorcheteA, yyline, yycolumn, yytext());}
<YYINITIAL>		"]"								{ agregarTokenJS("tkCorcheteC", yytext(), yyline, yycolumn);	  return new Symbol(symJS.tkCorcheteC, yyline, yycolumn, yytext());}
<YYINITIAL>		","								{ agregarTokenJS("tkComa", yytext(), yyline, yycolumn);			  return new Symbol(symJS.tkComa, yyline, yycolumn, yytext());}
<YYINITIAL>		";"								{ agregarTokenJS("tkPuntoComa", yytext(), yyline, yycolumn);	  return new Symbol(symJS.tkPuntoComa, yyline, yycolumn, yytext());}
<YYINITIAL>     "("                             { agregarTokenJS("tkParentesisA", yytext(), yyline, yycolumn);    return new Symbol(symJS.tkParentesisA, yyline, yycolumn, yytext());}
<YYINITIAL>     ")"                             { agregarTokenJS("tkParentesisC", yytext(), yyline, yycolumn);    return new Symbol(symJS.tkParentesisC, yyline, yycolumn, yytext());}
<YYINITIAL>     "{"                             { agregarTokenJS("tkLlaveA", yytext(), yyline, yycolumn);         return new Symbol(symJS.tkLlaveA, yyline, yycolumn, yytext());}
<YYINITIAL>     "}"                             { agregarTokenJS("tkLlaveC", yytext(), yyline, yycolumn);         return new Symbol(symJS.tkLlaveC, yyline, yycolumn, yytext());}
<YYINITIAL>     "+"                             { agregarTokenJS("tkMas", yytext(), yyline, yycolumn);            return new Symbol(symJS.tkMas, yyline, yycolumn, yytext());}
<YYINITIAL>     "-"                             { agregarTokenJS("tkMenos", yytext(), yyline, yycolumn);          return new Symbol(symJS.tkMenos, yyline, yycolumn, yytext());}
<YYINITIAL>     "*"                             { agregarTokenJS("tkPor", yytext(), yyline, yycolumn);            return new Symbol(symJS.tkPor, yyline, yycolumn, yytext());}
<YYINITIAL>     "/"                             { agregarTokenJS("tkDivision", yytext(), yyline, yycolumn);       return new Symbol(symJS.tkDivision, yyline, yycolumn, yytext());}
<YYINITIAL>     "%"                             { agregarTokenJS("tkPorcentaje", yytext(), yyline, yycolumn);     return new Symbol(symJS.tkPorcentaje, yyline, yycolumn, yytext());}
<YYINITIAL>     "**"                            { agregarTokenJS("tkPotencia", yytext(), yyline, yycolumn);       return new Symbol(symJS.tkPotencia, yyline, yycolumn, yytext());}
<YYINITIAL>     "!"                             { agregarTokenJS("tkNot", yytext(), yyline, yycolumn);            return new Symbol(symJS.tkNot, yyline, yycolumn, yytext());}
<YYINITIAL>     "&&"                            { agregarTokenJS("tkAnd", yytext(), yyline, yycolumn);            return new Symbol(symJS.tkAnd, yyline, yycolumn, yytext());}
<YYINITIAL>     "||"                            { agregarTokenJS("tkOr", yytext(), yyline, yycolumn);             return new Symbol(symJS.tkOr, yyline, yycolumn, yytext());}
<YYINITIAL>     ">"                             { agregarTokenJS("tkMayor", yytext(), yyline, yycolumn);          return new Symbol(symJS.tkMayor, yyline, yycolumn, yytext());}
<YYINITIAL>     "<"                             { agregarTokenJS("tkMenor", yytext(), yyline, yycolumn);          return new Symbol(symJS.tkMenor, yyline, yycolumn, yytext());}
<YYINITIAL>     "."                             { agregarTokenJS("tkPunto", yytext(), yyline, yycolumn);          return new Symbol(symJS.tkPunto, yyline, yycolumn, yytext());}



<YYINITIAL> 	{numero}       					{ agregarTokenJS("tkNumero", yytext(), yyline, yycolumn);		return new Symbol(symJS.tkNumero, yyline, yycolumn, yytext());}
<YYINITIAL>		{id}							{ agregarTokenJS("tkId", yytext(), yyline, yycolumn);			return new Symbol(symJS.tkId, yyline, yycolumn, yytext());}
<YYINITIAL>		{cadena}						{ agregarTokenJS("tkCadena", yytext(), yyline, yycolumn);		return new Symbol(symJS.tkCadena, yyline, yycolumn, yytext());}
<YYINITIAL>     {caracter}                      { agregarTokenJS("tkCaracter", yytext(), yyline, yycolumn);     return new Symbol(symJS.tkCaracter, yyline, yycolumn, yytext());}
<YYINITIAL> 	{space}     					{ /*Espacios en blanco, ignorados*/ }
<YYINITIAL> 	{enter}     					{ /*Saltos de linea, ignorados*/ }
<YYINITIAL>     {comentario}                    { NodoComparacion nodo = new NodoComparacion(); nodo.setComentarioUniLinea(yytext()); agregarNodoComparacion(nodo); }


<YYINITIAL>		"/*"							{ yybegin(COMENTARIO); }
<COMENTARIO>	[^"/"]					        { cadenaComentario += yytext(); }
<COMENTARIO>    {comentario}                    { cadenaComentario += yytext(); }
<COMENTARIO>	"*/"							{ String tempTxt = cadenaComentario; cadenaComentario = ""; NodoComparacion nodo = new NodoComparacion(); nodo.setComentarioMultiLinea(tempTxt); agregarNodoComparacion(nodo); yybegin(YYINITIAL); }

<YYINITIAL> . {
        String errLex = "Error léxico, caracter irreconocible: '"+yytext()+"' en la línea: "+(yyline)+" y columna: "+yycolumn;
        String error = "" + yytext();
        String errorLinea = "" + (yyline+1);
        String errorColumna = "" + (yycolumn+1);
        errorLexicoJS("Lexico", error, yyline+1, yycolumn+1);
        //System.out.println(errLex);
}