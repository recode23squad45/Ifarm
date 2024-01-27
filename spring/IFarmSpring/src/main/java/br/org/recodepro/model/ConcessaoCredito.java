package br.org.recodepro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ConcessaoCredito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConcessao;

	@ManyToOne
	@JoinColumn(name = "cpf_cooperado")
	private Cooperado cooperado;

	@ManyToOne
	@JoinColumn(name = "cnpj_parceira")
	private EmpresaParceira empresaParceira;

	private float valor;
	private String dtConcessao;

	public int getIdConcessao() {
		return idConcessao;
	}

	public void setIdConcessao(int idConcessao) {
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDtConcessao() {
		return dtConcessao;
	}

	public void setDtConcessao(String dtConcessao) {
		this.dtConcessao = dtConcessao;
	}

}