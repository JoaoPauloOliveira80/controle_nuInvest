package Application.model;

public class Movimentacao {
	
	private int id;
	private String dt_recib;
	private String ativo;
	private Double proventos;
	
	public Movimentacao() {
		// TODO Auto-generated constructor stub
	}

	public Movimentacao(int id, String dt_recib, String ativo, Double proventos) {
		super();
		this.id = id;
		this.dt_recib = dt_recib;
		this.ativo = ativo;
		this.proventos = proventos;
	} 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDt_recib() {
		return dt_recib;
	}

	public void setDt_recib(String dt_recib) {
		this.dt_recib = dt_recib;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Double getProventos() {
		return proventos;
	}

	public void setProventos(Double proventos) {
		this.proventos = proventos;
	}

	@Override
	public String toString() {
		return "Id=" + id + 
				"\nDt_recib=" + dt_recib + 
				"\nAtivo=" + ativo + 
				"\nProventos=" +String.format("%.2f", proventos);
	}
	
	

}
