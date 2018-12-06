package semantico;

import parser.Token;

public abstract class Item {

	public Token token;

	public Item(Token token) {
		this.token = token;
	}
	public String getLexema() {
		return this.token.image;
	}
	
	public abstract String toString();
}
