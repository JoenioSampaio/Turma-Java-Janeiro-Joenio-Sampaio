package model;

public class FuncionarioTerceirizado extends FuncionarioInterno{
	private String funcao;
	private String empresa;
	
	
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
}
