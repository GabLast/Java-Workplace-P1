package logica;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuenta {
	
	private String codigo;
	private Cliente propietario;
	private String fechaApertura;
	private String fechaCorte;
	private String estado;
	private String tipoDeCuenta;
	private double dineroActual;
	private int puntos;
	
	public Cuenta( String codigo, String fechaApertura, Cliente propietario, String fechaCorte, String estado, String tipoDeCuenta,
			double dineroActual, int puntos) {
		super();
		this.codigo = codigo;
		this.fechaApertura = fechaApertura;
		this.fechaCorte = fechaCorte;
		this.estado = estado;
		this.tipoDeCuenta = tipoDeCuenta;
		this.dineroActual = dineroActual;
		this.propietario = propietario;
		this.puntos = puntos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Cliente getPropietario() {
		return propietario;
	}

	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

//	public void setFechaApertura(String fechaApertura) {
//		this.fechaApertura = fechaApertura;
//	}

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

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(double d) {
		this.puntos = (int) d;
	}
	
	public boolean ingresarSaldo(double dineroIngresar) {
		
		if(getEstado().equalsIgnoreCase("Habilitada"))
		{
			setDineroActual(getDineroActual() + dineroIngresar);
			setPuntos(dineroIngresar/6 + getPuntos());
			getPropietario().setPuntos(dineroIngresar/6 + getPropietario().getPuntos());
			return true;
		}
		
		return false;
		
	}
	
	public boolean retirarMoney(double dineroRetirar) {

		if(getTipoDeCuenta().equalsIgnoreCase("Corriente")
				&& dineroRetirar <= getDineroActual())
		{
			setDineroActual(getDineroActual() - dineroRetirar);
			return true;
		}
		
		else if(getTipoDeCuenta().equalsIgnoreCase("Vivienda"))
		{
			return false;
		}
		
		else if(getTipoDeCuenta().equalsIgnoreCase("Fondo de inversión")
				&& dineroRetirar <= getDineroActual())
		{
			if(dineroRetirar > 500)
			{
				setEstado("Bloqueada");;
				return false;
			}
			
			setDineroActual(getDineroActual() - dineroRetirar);
			return true;
		}
		
		return false;
	}
	
}
