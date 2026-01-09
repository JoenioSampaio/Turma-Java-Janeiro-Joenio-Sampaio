package codigoFonteBasquete;

public abstract class Atleta {
	private String nomeAtleta;
	private int idade;
	
	//Assinatura
	protected abstract Double calcularPagamento();
	
	//Ainda é herança
	public void verificarNumeroNegativo(Double valor){
        if (valor < 0){
            throw new IllegalArgumentException("O valor não ser valor negativo");
        }
    }
	
	public String getNomeAtleta() {
		return nomeAtleta;
	}
	
	public void setNomeAtleta(String nomeAtletaChegando) {
		this.nomeAtleta = nomeAtletaChegando;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idadeChegando) {
		this.idade = idadeChegando;
	} 
}

