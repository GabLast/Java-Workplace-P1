package logico;

public class Boleta {

	private String codigo;
	private float precioVenta;
	private String codigoSala;
	private String asiento;
	private String hora;
	private Pelicula peliculaProyectada;
	
	public Boleta(String codigo, float precioVenta, String codigoSala, String asiento, String hora,
			Pelicula peliculaProyectada) {
		super();
		this.codigo = codigo;
		this.precioVenta = precioVenta;
		this.codigoSala = codigoSala;
		this.asiento = asiento;
		this.hora = hora;
		this.peliculaProyectada = peliculaProyectada;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getCodigoSala() {
		return codigoSala;
	}

	public void setCodigoSala(String codigoSala) {
		this.codigoSala = codigoSala;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Pelicula getPeliculaProyectada() {
		return peliculaProyectada;
	}

	public void setPeliculaProyectada(Pelicula peliculaProyectada) {
		this.peliculaProyectada = peliculaProyectada;
	}
	
	
}
