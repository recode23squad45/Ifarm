package br.org.recodepro.ifarm.modelo;

public class ProdutoPedido {
	private Integer idProdutoPedido;
	private Integer idPedido;
	private Integer idProduto;
	private Integer quantidade;
	private Double valorTotal;

	public Integer getIdProdutoPedido() {
		return idProdutoPedido;
	}

	public void setIdProdutoPedido(Integer idProdutoPedido) {
		this.idProdutoPedido = idProdutoPedido;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
