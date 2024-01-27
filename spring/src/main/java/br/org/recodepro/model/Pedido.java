package br.org.recodepro.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	private String dtEntrega;
	private String tipoPedido;
	private String status;
	private float valorTotal;
	@OneToMany(mappedBy = "pedido")
	private List<ProdutoPedido> listaProdutos;
	private String cnpjCliente;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(String dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ProdutoPedido> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ProdutoPedido> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public String getCnpjCliente() {
		return cnpjCliente;
	}

	public void setCnpjCliente(String cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}

}