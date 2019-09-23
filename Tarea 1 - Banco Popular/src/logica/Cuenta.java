package logica;

public class Cuenta {
	
	private String codigo;
	private String fechaApertura;
	private String fechaCorte;
	private String estado;
	private String tipoDeCuenta;
	private double dineroActual;
	
	public Cuenta(String codigo, String fechaApertura, String fechaCorte, String estado, String tipoDeCuenta,
			double dineroActual) {
		super();
		this.codigo = codigo;
		this.fechaApertura = fechaApertura;
		this.fechaCorte = fechaCorte;
		this.estado = estado;
		this.tipoDeCuenta = tipoDeCuenta;
		this.dineroActual = dineroActual;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getFechaCorte() {
		return fechaCorte;
	}

	public void setFechaCorte(String fechaCorte) {
		this.fechaCorte = fechaCorte;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public void setTipoDeCuenta(String tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}

	public double getDineroActual() {
		return dineroActual;
	}

	public void setDineroActual(double dineroActual) {
		this.dineroActual = dineroActual;
	}
	
	
}
