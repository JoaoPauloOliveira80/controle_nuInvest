package Application.model;

public class Proventos {
	
	private int id;
	private String dt_recebimeto;
	private String ativo;
	private Double valorDep;
	
	
	public Proventos() {
		// TODO Auto-generated constructor stub
	}

	public Proventos(int id, String dt_recebimeto, String ativo, Double valorDep) {
		super();
		this.id = id;
		this.dt_recebimeto = dt_recebimeto;
		this.ativo = ativo;
		this.valorDep = valorDep;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getDt_recebimeto() {
		return dt_recebimeto;
	}

	public void setDt_recebimeto(String dt_recebimeto) {
		this.dt_recebimeto = dt_recebimeto;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String operacao) {
		this.ativo = operacao;
	}

	public Double getValorDep() {
		return valorDep;
	}

	public void setValorDep(Double valorDep) {
		this.valorDep = valorDep;
	}

	
	@Override
	public String toString() {
		return "id =" + id + 
				"\nData =" + dt_recebimeto + 
				"\nAtivo =" + ativo + 
				"\nValor recebido =" + valorDep;
	}
	
	
}
