package br.org.recodepro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProdutoPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProdutoPedido;

	@ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;

	private int quantidade;
	private float valorTotal;

	public int getIdProdutoPedido() {
		return idProdutoPedido;
	}

	public void setIdProdutoPedido(int idProdutoPedido) {
		this.idProdutoPedido = idProdutoPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

}