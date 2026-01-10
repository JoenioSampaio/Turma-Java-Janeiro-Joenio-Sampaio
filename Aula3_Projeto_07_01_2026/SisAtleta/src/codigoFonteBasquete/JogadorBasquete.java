package codigoFonteBasquete;

public class JogadorBasquete extends Atleta {
	private String BracoMaisForte;
	private Double valorPorPontos;
	private int qtdPts;

	public String getBracoMaisForte() {
		return BracoMaisForte;
	}

	public void setBracoMaisForte(String bracoMaisForte) {
		BracoMaisForte = bracoMaisForte;
	}

	public Double getValorPorPontos() {
		return valorPorPontos;
	}

	public void setValorPorPontos(Double valorPorPontosChegando) {
		verificarNumeroNegativo(valorPorPontosChegando);
		this.valorPorPontos = valorPorPontosChegando;
	}

	@Override
	protected Double calcularPagamento() {

		return valorPorPontos * qtdPts;
	}

	public int getQtdPts() {
		return qtdPts;
	}

	public void setQtdPts(int qtdPtsChegando) {
		verificarNumeroNegativo((double) qtdPtsChegando);
		this.qtdPts = qtdPtsChegando;
	}

	@Override
	protected Double calcularPatrocinio() {
		Double vintePorCentoSalario = getSalario() * 0.2;
		Double vintePorCentoQtdPontsxTres = (getQtdPts() * 0.2) * 3;

		return vintePorCentoSalario + vintePorCentoQtdPontsxTres;
	}
}
