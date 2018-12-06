package comandoAltoNivel;

import comandoPrimitivo.*;
import parser.*;
import semantico.*;

public class ComandoMatrix3D extends ComandoAltoNivel 
{
	private Token varDimensaoX;
	private Token varDimensaoY;
	private Token varDimensaoZ;
	private Expressao expInicializacao;
	private Expressao expCondicaoParada;
	private ListaComandosAltoNivel listaComandosAltoNivelMatrix;
	
	public ComandoMatrix3D( Token matrix3D, Token varCtrlA, Token varCtrlB, Token varCtrlC,
			Expressao expInicializacao, Expressao expCondicaoParada, ListaComandosAltoNivel lstCmdAltoNivelMatrix ) 
	{
		this.token = matrix3D;
		this.varDimensaoX = varCtrlA;
		this.varDimensaoY = varCtrlB;
		this.varDimensaoZ = varCtrlC;
		this.expInicializacao = expInicializacao;
		this.expCondicaoParada = expCondicaoParada;
		this.listaComandosAltoNivelMatrix = lstCmdAltoNivelMatrix;
	}
	
	public String toString()
	{
		return "\nComando Matrix3D - lexema: \"" + this.getLexema() 
	     + "\" - variaveis de controle: " + this.getVarDimensaoX() 
	     + "-" + this.getVarDimensaoY() 
	     + "-" + this.getVarDimensaoZ()  
	     + "- limites " + this.getExpInicializacao() + " to " 
	     + this.getExpCondicaoParada() + " - lista comandos : " 
	     + this.getListaComandosAltoNivelMatrix();
		
	}

	// Cria e retorna uma expressao do tipo var <- var + 1 posfixa
	private Expressao gerarExpressaoIncremento( Token var )
	{
		Expressao expIncrementa = new Expressao();
		expIncrementa.addListaExpPosFixa( new Operando( TipoDado.NUMERO, TipoElemento.VAR, var, Sinal.POS) );
		expIncrementa.addListaExpPosFixa( new Operando( TipoDado.NUMERO, TipoElemento.CTE, new Token(0, "1.0"), Sinal.POS) );
		expIncrementa.addListaExpPosFixa( new Operador(TipoOperador.SOMA, new Token(0, "+")));
		
		return expIncrementa;
	}
	
	// Gera expressao de parada (posFixa) do tipo 
	// var < limiteSuperior + 1 que é equivalente a var <= limite superior  para cada variavel das dimensoes
	private Expressao gerarExpressaoParada( Token var )
	{
		Expressao expCondicaoParada = new Expressao();
		expCondicaoParada.addListaExpPosFixa( new Operando( TipoDado.NUMERO, TipoElemento.VAR, var, Sinal.POS) );
		expCondicaoParada.addListaExpPosFixa( this.getExpCondicaoParada().getListaExpPosFixa().getFirst() );
		expCondicaoParada.addListaExpPosFixa( new Operando( TipoDado.NUMERO, TipoElemento.CTE, new Token(0, "1.0"), Sinal.POS) );
		expCondicaoParada.addListaExpPosFixa( new Operador( TipoOperador.SOMA, new Token(0, "+")) );
		expCondicaoParada.addListaExpPosFixa( new Operador( TipoOperador.MENOR, new Token(0, "<" ) ) );
		
		return expCondicaoParada;
	}
	
	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() 
	{
		ListaComandosAltoNivel listaInicializacao, listaPasso, listaComandosTrue; 
		Token varDimZ = this.getVarDimensaoZ();
		Token varDimX = this.getVarDimensaoX();
		Token varDimY = this.getVarDimensaoY();
		
		// Laço 1D : Laco mais interno cujo corpo é o bloco de instrucoes do Matrix3D		
		// Cria a inicializacao e o passo adequados e repassa ao comando PARA	
		listaInicializacao = new ListaComandosAltoNivel();
		listaInicializacao.addComando( new ComandoAtribuicao( Compilador.tabela.pesquisaTabela( varDimZ.image), this.getExpInicializacao(), varDimZ));
		
		listaPasso = new ListaComandosAltoNivel();
		listaPasso.addComando( new ComandoAtribuicao( Compilador.tabela.pesquisaTabela( varDimZ.image ), this.gerarExpressaoIncremento(varDimZ), varDimZ) );
		ComandoAltoNivel laco1D = new ComandoPara( listaInicializacao, this.gerarExpressaoParada(varDimZ), listaPasso, this.listaComandosAltoNivelMatrix, varDimZ );
		
		listaComandosTrue = new ListaComandosAltoNivel();
		listaComandosTrue.addComando( laco1D );
		
		// Laço 2D - Laco intermediario : Seu bloco de instrucoes eh o laco 1D que esta em listaComandosTrue
		listaInicializacao = new ListaComandosAltoNivel();
		listaInicializacao.addComando( new ComandoAtribuicao( Compilador.tabela.pesquisaTabela( varDimY.image), this.getExpInicializacao(), varDimY));
		
		listaPasso = new ListaComandosAltoNivel();
		listaPasso.addComando( new ComandoAtribuicao( Compilador.tabela.pesquisaTabela( varDimY.image ), this.gerarExpressaoIncremento(varDimY), varDimY) );
		ComandoAltoNivel laco2D = new ComandoPara( listaInicializacao, this.gerarExpressaoParada(varDimY), listaPasso, listaComandosTrue, varDimY );
		
		listaComandosTrue = new ListaComandosAltoNivel();
		listaComandosTrue.addComando( laco2D );
		
		// Laco 3D - Laco mais externo : Seu bloco de instrucoes eh o lado 2D encapsulado
		listaInicializacao = new ListaComandosAltoNivel();
		listaInicializacao.addComando( new ComandoAtribuicao( Compilador.tabela.pesquisaTabela( varDimX.image), this.getExpInicializacao(), varDimX));
		
		listaPasso = new ListaComandosAltoNivel();
		listaPasso.addComando( new ComandoAtribuicao( Compilador.tabela.pesquisaTabela( varDimX.image ), this.gerarExpressaoIncremento(varDimX), varDimX) );
		ComandoAltoNivel laco3D = new ComandoPara( listaInicializacao, this.gerarExpressaoParada(varDimX), listaPasso, listaComandosTrue, varDimX );
		
		return laco3D.geraListaComandosPrimitivos();
	}

	public Expressao getExpInicializacao() 
	{
		return this.expInicializacao;
	}

	public Expressao getExpCondicaoParada() 
	{
		return this.expCondicaoParada;
	}

	public ListaComandosAltoNivel getListaComandosAltoNivelMatrix() 
	{
		return this.listaComandosAltoNivelMatrix;
	}

	public Token getVarDimensaoX() 
	{
		return varDimensaoX;
	}

	public void setVarDimensaoX(Token varDimensaoX) 
	{
		this.varDimensaoX = varDimensaoX;
	}

	public Token getVarDimensaoY() 
	{
		return varDimensaoY;
	}

	public void setVarDimensaoY(Token varDimensaoY) 
	{
		this.varDimensaoY = varDimensaoY;
	}

	public Token getVarDimensaoZ() 
	{
		return varDimensaoZ;
	}
	
}
