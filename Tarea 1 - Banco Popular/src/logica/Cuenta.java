package logica;

import java.util.Date;

public class Cuenta {
	
	private String codigo;
	private Date fechaApertura = new Date();
	private Date fechaCorte;
	private String estado;
	private String tipoDeCuenta;
	private double dineroActual;
	
	public Cuenta(String codigo, Date fechaApertura, Date fechaCorte, String estado, String tipoDeCuenta,
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

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaCorte() {
		return fechaCorte;
	}

	public void setFechaCorte(Date fechaCorte) {
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
