package Application.model;

public class Telefone {
	private long id;
	private String usuario;
	private String tipo;
	private String numero;

	public Telefone() {
		// TODO Auto-generated constructor stub
	}

	public Telefone(long id, String usuario, String tipo, String numero) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.tipo = tipo;
		this.numero = numero;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", usuario=" + usuario + ", tipo=" + tipo + ", numero=" + numero + "]";
	}

}
