package br.org.recodepro.ifarm.modelo;

public class ConcessaoCredito {

	private Integer idConcessao;
	private Cooperado cooperado;
	private EmpresaParceira empresaParceira;
	private Double valor;
	private String dtConcessao;

	public Integer getIdConcessao() {
		return idConcessao;
	}

	public void setIdConcessao(Integer idConcessao) {
		this.idConcessao = idConcessao;
	}

	public Cooperado getCooperado() {
		return cooperado;
	}

	public void setCooperado(Cooperado cooperado) {
		this.cooperado = cooperado;
	}

	public EmpresaParceira getEmpresaParceira() {
		return empresaParceira;
	}

	public void setEmpresaParceira(EmpresaParceira empresaParceira) {
		this.empresaParceira = empresaParceira;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDtConcessao() {
		return dtConcessao;
	}

	public void setDtConcessao(String dtConcessao) {
		this.dtConcessao = dtConcessao;
	}
}
