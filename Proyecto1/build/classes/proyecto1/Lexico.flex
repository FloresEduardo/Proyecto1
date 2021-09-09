package proyecto1;
import java_cup.runtime.Symbol;
import proyecto1.Inicio;
import static proyecto1.Inicio.errorLexico;
import static proyecto1.Inicio.agregarToken;


%%
%{
    //Código de usuario
    String cadenaTexto = "";
%}

%cup
%class scanner
%public
%line
%char
%column
%full
%ignorecase
%unicode
%8bit
%state SALTO
%state COMENTARIO

digito	 	 = [0-9]
//numero		 = {digito}+("."{[\ ]|digito}+)?
numero       = {digito}+("."{digito}*)?
letra		 = [a-zA-ZñÑ]
id			 = {letra}({letra}|{numero}|_)*
comillas	 = \"
//comilla      = \'
cadena		 = {comillas}[^[\"]]*{comillas}
comentario 	 =	"##".*
space		 = [\ \r\t\f\t]
enter   	 = [\ \n]
//paraComML    = [\*][#]
//comentarioML = ([#][\*][.]*([\*])+[#])
//path         = "^(([A-Z]:)?[\.]?[\\{1,2}/]?.*[\\{1,2}/])*(.+)\.(.+)"
//path         = {comillas}([A-Z]:)?([\\]({letra}|{numero}|_|".")({letra}|{numero}|_|[\ ]|".")*)+{comillas}

%%


<YYINITIAL>		"DefinirGlobales"				{ agregarToken("tkDefinirGlobales", yytext(), yyline, yycolumn);			return new Symbol(sym.tkDefinirGlobales, yyline, yycolumn, yytext());}
<YYINITIAL>		"GenerarReporteEstadistico"		{ agregarToken("tkGenerarReporteEstadistico", yytext(), yyline, yycolumn);	return new Symbol(sym.tkGenerarReporteEstadistico, yyline, yycolumn, yytext());}
<YYINITIAL>		"String"						{ agregarToken("tkString", yytext(), yyline, yycolumn);						return new Symbol(sym.tkString, yyline, yycolumn, yytext());}
<YYINITIAL>		"Double"						{ agregarToken("tkDouble", yytext(), yyline, yycolumn);						return new Symbol(sym.tkDouble, yyline, yycolumn, yytext());}
<YYINITIAL>		"GraficaBarras"					{ agregarToken("tkGraficaBarras", yytext(), yyline, yycolumn);				return new Symbol(sym.tkGraficaBarras, yyline, yycolumn, yytext());}
<YYINITIAL>		"titulo"						{ agregarToken("tkTitulo", yytext(), yyline, yycolumn);						return new Symbol(sym.tkTitulo, yyline, yycolumn, yytext());}
<YYINITIAL>		"EjeX"							{ agregarToken("tkEjeX", yytext(), yyline, yycolumn);						return new Symbol(sym.tkEjeX, yyline, yycolumn, yytext());}
<YYINITIAL>		"Valores"						{ agregarToken("tkValores", yytext(), yyline, yycolumn);					return new Symbol(sym.tkValores, yyline, yycolumn, yytext());}
<YYINITIAL>		"TituloX"						{ agregarToken("tkTituloX", yytext(), yyline, yycolumn);					return new Symbol(sym.tkTituloX, yyline, yycolumn, yytext());}
<YYINITIAL>		"TituloY"						{ agregarToken("tkTituloY", yytext(), yyline, yycolumn);					return new Symbol(sym.tkTituloY, yyline, yycolumn, yytext());}
<YYINITIAL>		"GraficaPie"					{ agregarToken("tkGraficaPie", yytext(), yyline, yycolumn);					return new Symbol(sym.tkGraficaPie, yyline, yycolumn, yytext());}
<YYINITIAL>		"GraficaLineas"					{ agregarToken("tkGraficaLineas", yytext(), yyline, yycolumn);				return new Symbol(sym.tkGraficaLineas, yyline, yycolumn, yytext());}
<YYINITIAL>		"Archivo"						{ agregarToken("tkArchivo", yytext(), yyline, yycolumn);				    return new Symbol(sym.tkArchivo, yyline, yycolumn, yytext());}
<YYINITIAL>		"PuntajeGeneral"				{ agregarToken("tkPuntajeGeneral", yytext(), yyline, yycolumn);				return new Symbol(sym.tkPuntajeGeneral, yyline, yycolumn, yytext());}
<YYINITIAL>		"PuntajeEspecifico"				{ agregarToken("tkPuntajeEspecifico", yytext(), yyline, yycolumn);			return new Symbol(sym.tkPuntajeEspecifico, yyline, yycolumn, yytext());}
<YYINITIAL>     "Compare"                       { agregarToken("tkCompare", yytext(), yyline, yycolumn);                    return new Symbol(sym.tkCompare, yyline, yycolumn, yytext());}


<YYINITIAL>		"="								{ agregarToken("tkIgual", yytext(), yyline, yycolumn);			return new Symbol(sym.tkIgual, yyline, yycolumn, yytext());}		//***********************
<YYINITIAL>		":"								{ agregarToken("tkDosPuntos", yytext(), yyline, yycolumn);		return new Symbol(sym.tkDosPuntos, yyline, yycolumn, yytext());}
<YYINITIAL>		"["								{ agregarToken("tkCorcheteA", yytext(), yyline, yycolumn);		return new Symbol(sym.tkCorcheteA, yyline, yycolumn, yytext());}
<YYINITIAL>		"]"								{ agregarToken("tkCorcheteC", yytext(), yyline, yycolumn);		return new Symbol(sym.tkCorcheteC, yyline, yycolumn, yytext());}
<YYINITIAL>		","								{ agregarToken("tkComa", yytext(), yyline, yycolumn);			return new Symbol(sym.tkComa, yyline, yycolumn, yytext());}
<YYINITIAL>		";"								{ agregarToken("tkPuntoComa", yytext(), yyline, yycolumn);		return new Symbol(sym.tkPuntoComa, yyline, yycolumn, yytext());}
<YYINITIAL>		"$"								{ agregarToken("tkDolar", yytext(), yyline, yycolumn);			return new Symbol(sym.tkDolar, yyline, yycolumn, yytext());}
<YYINITIAL>     "("                             { agregarToken("tkParentesisA", yytext(), yyline, yycolumn);    return new Symbol(sym.tkParentesisA, yyline, yycolumn, yytext());}
<YYINITIAL>     ")"                             { agregarToken("tkParentesisC", yytext(), yyline, yycolumn);    return new Symbol(sym.tkParentesisC, yyline, yycolumn, yytext());}


<YYINITIAL> 	{numero}       					{ agregarToken("tkNumero", yytext(), yyline, yycolumn);		return new Symbol(sym.tkNumero, yyline, yycolumn, yytext());}
<YYINITIAL>		{id}							{ agregarToken("tkId", yytext(), yyline, yycolumn);			return new Symbol(sym.tkId, yyline, yycolumn, yytext());}
<YYINITIAL>		{cadena}						{ agregarToken("tkCadena", yytext(), yyline, yycolumn);		return new Symbol(sym.tkCadena, yyline, yycolumn, yytext());}
//<YYINITIAL>     {path}                          { agregarToken("tkPath", yytext(), yyline, yycolumn);       return new Symbol(sym.tkPath, yyline, yycolumn, yytext());}
<YYINITIAL> 	{space}     					{ 	/*Espacios en blanco, ignorados*/ }
<YYINITIAL> 	{enter}     					{ 	/*Saltos de linea, ignorados*/}
<YYINITIAL>     {comentario}                    {   /*Comentarios, ignorados*/}


<YYINITIAL>		"{"								{ agregarToken("tkLlaveA", yytext(), yyline, yycolumn);		return new Symbol(sym.tkLlaveA, yyline, yycolumn, yytext());}
<YYINITIAL>		"}"								{ agregarToken("tkLlaveC", yytext(), yyline, yycolumn);		return new Symbol(sym.tkLlaveC, yyline, yycolumn, yytext());}

//<YYINITIAL>     {comentarioML}                   {   /*Comentarios, ignorados*/}

<YYINITIAL>		"#*"							{ yybegin(COMENTARIO); }
<COMENTARIO>	[^"#"]					        {	/*Todo lo que venga sera ignorado, excepto "*#" */ }
<COMENTARIO>    {comentario}                    {   /*Comentarios, ignorados*/}
<COMENTARIO>	"*#"							{ yybegin(YYINITIAL); }

<YYINITIAL> . {
        String errLex = "Error léxico, caracter irreconocible: '"+yytext()+"' en la línea: "+(yyline)+" y columna: "+yycolumn;
        String error = "" + yytext();
        String errorLinea = "" + (yyline+1);
        String errorColumna = "" + (yycolumn+1);
        errorLexico("Lexico", error, errorLinea, errorColumna);
        //System.err.println(errLex);
}