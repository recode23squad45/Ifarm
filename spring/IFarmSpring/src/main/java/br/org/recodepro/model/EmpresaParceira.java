package br.org.recodepro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmpresaParceira {

	@Id
	private String cnpj;
	private String nomeEmpresa;
	private String contatoEmpresa;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getContatoEmpresa() {
		return contatoEmpresa;
	}

	public void setContatoEmpresa(String contatoEmpresa) {
		this.contatoEmpresa = contatoEmpresa;
	}

}