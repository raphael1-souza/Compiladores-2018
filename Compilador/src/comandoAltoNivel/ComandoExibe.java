package comandoAltoNivel;
import comandoPrimitivo.*;
import parser.Token;
import semantico.*;

public class ComandoExibe extends ComandoAltoNivel {	
	private Expressao expressao;
	private String numero;
	
	public ComandoExibe (Expressao expressao, Token token,String numero) {
		this.expressao = expressao;
		this.token = token;
		this.numero = numero;
	}
	
	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() {
		ListaComandosPrimitivos lista = new ListaComandosPrimitivos();
		PrimitivoSaida comando = new PrimitivoSaida(expressao.getTipo(),expressao.geraCodigoDestino());
		int numero = Integer.parseInt(this.numero);
		int i =0;
		while(i<numero) {
			lista.addComando(comando);
			i++;
		}
				
		return lista;
	}
	
	@Override
	public String toString() {
		return "\nComando exibe n - lexema: \"" + this.getLexema() 
		     + "\" - expressao: " +  this.expressao;
	}



}
