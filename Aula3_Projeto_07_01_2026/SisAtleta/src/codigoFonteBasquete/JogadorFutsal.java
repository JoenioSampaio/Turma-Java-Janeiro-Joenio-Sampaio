package codigoFonteBasquete;

public class JogadorFutsal extends Atleta {
	private String PernaMaisForte;
	private Double valorPorGols;
	private int qtdGol;
	
	
	public JogadorFutsal(long identificadorConstrutor) {
		super(identificadorConstrutor);
	}
	
	

	public String getPernaMaisForte() {
		return PernaMaisForte;
	}

	public void setPernaMaisForte(String pernaMaisForteChegando) {
		PernaMaisForte = pernaMaisForteChegando;
	}

	public Double getValorPorGols() {
		return valorPorGols;
	}

	public void setValorPorGols(Double valorPorGolsChegando) {
		verificarNumeroNegativo(valorPorGolsChegando);
		this.valorPorGols = valorPorGolsChegando;
	}

	@Override // Implementar o metodo na classe pai
	protected Double calcularPagamento() {

		return valorPorGols * qtdGol;
	}

	public int getQtdGol() {
		return qtdGol;
	}

	public void setQtdGol(int qtdGolChegando) {
		verificarNumeroNegativo((double) qtdGolChegando);
		this.qtdGol = qtdGolChegando;
	}

	@Override
	protected Double calcularPatrocinio() {
		Double trintaPorCentoSalario = getSalario() * 0.3;
		Double trintaPorCentoQtdPontsxTres = (getQtdGol() * 0.3) * 4;

		return trintaPorCentoSalario + trintaPorCentoQtdPontsxTres;
	}
}
