package Application.model;

public class Negociacao {

	private int id;
	private String dt_negociacao;
	private int conta;
	private String ativo;
	private Double preco_cota;
	private Double totalCompra;
	private Double totalVenda;
	private int qtd_compra;
	private int qtd_venda;

	public Negociacao() {
		// TODO Auto-generated constructor stub
	}
 
	

	public Negociacao(int id, String dt_negociacao, int conta, String ativo, Double preco_cota, Double totalCompra,
			Double totalVenda, int qtd_compra, int qtd_venda) {
		super();
		this.id = id;
		this.dt_negociacao = dt_negociacao;
		this.conta = conta;
		this.ativo = ativo;
		this.preco_cota = preco_cota;
		this.totalCompra = totalCompra;
		this.totalVenda = totalVenda;
		this.qtd_compra = qtd_compra;
		this.qtd_venda = qtd_venda;
	}


	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDt_negociacao() {
		return dt_negociacao;
	}

	public void setDt_negociacao(String dt_negociacao) {
		this.dt_negociacao = dt_negociacao;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Double getPreco_cota() {
		return preco_cota;
	}

	public void setPreco_cota(Double preco_cota) {
		this.preco_cota = preco_cota;
	}

	public int getQtd_compra() {
		return qtd_compra;
	}

	public void setQtd_compra(int qtd_compra) {
		this.qtd_compra = qtd_compra;
	}

	public int getQtd_venda() {
		return qtd_venda;
	}

	public void setQtd_venda(int qtd_venda) {
		this.qtd_venda = qtd_venda;
	}

	public Double getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public Double getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(Double totalVenda) {
		this.totalVenda = totalVenda;
	}

	@Override
	public String toString() {
		return "Id = "+id+ 
				"\nData da compra = " + dt_negociacao + "\nAtivo = " + ativo + "\nPreço da cota = "
				+ String.format("%.2f", preco_cota) + "\nQtd de cota compra = " + qtd_compra + "\nQtd de cota venda = "
				+ qtd_venda + "\nTotal de compra = " + String.format("%.2f",totalCompra) + "\nTotal de venda = " + String.format("%.2f",totalVenda);
	}
}
