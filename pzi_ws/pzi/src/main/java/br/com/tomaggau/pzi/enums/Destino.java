package br.com.tomaggau.pzi.enums;

public enum Destino {
	
	USUARIO("U"),
	GRUPO("G");
	
	private String descricao;
	 
	Destino(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }

}
