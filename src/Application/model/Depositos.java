package Application.model;

public class Depositos {
	
	private int id;
	private String dt_deposito;
	private String operacao;
	private Double valorDep;
	private String depositante;
	private int statementNumber;
	
	public Depositos() {
		// TODO Auto-generated constructor stub
	}

	public Depositos(int id, String dt_deposito, String operacao, Double valorDep, String depositante,int statementNumber) {
		super();
		this.id = id;
		this.dt_deposito = dt_deposito;
		this.operacao = operacao;
		this.valorDep = valorDep;
		this.depositante = depositante;
		this.statementNumber = statementNumber;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDt_deposito() {
		return dt_deposito;
	}

	public void setDt_deposito(String dt_deposito) {
		this.dt_deposito = dt_deposito;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public Double getDepositos() {
		return valorDep;
	}

	public void setDepositos(Double valorDep) {
		this.valorDep = valorDep;
	}
	
	
	public Double getValorDep() {
		return valorDep;
	}

	public void setValorDep(Double valorDep) {
		this.valorDep = valorDep;
	}

	public String getDepositante() {
		return depositante;
	}

	public void setDepositante(String depositante) {
		this.depositante = depositante;
	}
	 
	

	public int getStatementNumber() {
		return statementNumber;
	}

	public void setStatementNumber(int statementNumber) {
		this.statementNumber = statementNumber;
	}

	@Override
	public String toString() {
		return "Id = " + id + 
				"\nData deposito = " + dt_deposito + 
				"\nTipo de deposito = " + operacao + 
				"\nDepositos = " +String.format("%.2f", valorDep)+
				"\nNome do depositante: " + depositante +
				"\nIdentificação da transação: "+ statementNumber;
	}
	
	

}
