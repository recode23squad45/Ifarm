package br.org.recodepro.ifarm.modelo;

public class Cooperado {

	private String cpf;
	private String nomeCooperado;
	private String endereco;
	private String telefone;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCooperado() {
		return nomeCooperado;
	}

	public void setNomeCooperado(String nomeCooperado) {
		this.nomeCooperado = nomeCooperado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
