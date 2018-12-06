package comandoAltoNivel;

import comandoPrimitivo.ListaComandosPrimitivos;
import parser.Token;

public abstract class ComandoAltoNivel {
	
	public Token token;
		
	public String getLexema() {
		return token.image;
	}
		
	public abstract ListaComandosPrimitivos geraListaComandosPrimitivos();	
		
	public abstract String toString();

}
