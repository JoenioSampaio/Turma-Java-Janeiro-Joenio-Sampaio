package codigoFonteBasquete;

public abstract class Atleta {
	private String nomeAtleta;
	private int idade;
	private Double patrocinio;
	private Double salario;

	// Assinatura
	protected abstract Double calcularPagamento();

	protected abstract Double calcularPatrocinio();

	// Ainda é herança
	public void verificarNumeroNegativo(Double valor) {
		if (valor < 0) {
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

	// Get e Set Patrocionio
	public Double getPatrocinio() {
		return patrocinio;
	}

	public void setPatrocinio(Double patrocinio) {
		this.patrocinio = patrocinio;
	}

	// Get e Set Salario
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
