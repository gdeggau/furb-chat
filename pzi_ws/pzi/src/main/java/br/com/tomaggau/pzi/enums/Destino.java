package br.com.tomaggau.pzi.enums;

public enum Destino {
	
	USUARIO('U'),
	GRUPO('G');
	
	private char descricao;
	 
	Destino(char descricao) {
        this.descricao = descricao;
    }
 
    public char getDescricao() {
        return descricao;
    }

}
