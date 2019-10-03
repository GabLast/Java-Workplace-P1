package logica;

import java.util.Date;

public class Prestamo {

	private String id;
	private Date fechaInicio;
	private Date fechaEntrega;
	private String idCliente;
	private Publicacion publicacion;
	private boolean estado;
	private boolean prorrogado;
	private double multaPorRetraso;
	
	public Prestamo(String id, Date fechaEntrega, String idCliente, Publicacion publicacion) {
		super();
		this.id = id;
		this.fechaEntrega = fechaEntrega;
		this.idCliente = idCliente;
		this.publicacion = publicacion;
		this.estado = true;
		this.prorrogado = false;
		this.fechaInicio = new Date();		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isProrrogado() {
		return prorrogado;
	}

	public void setProrrogado(boolean prorrogado) {
		this.prorrogado = prorrogado;
	}
	
	public double getMultaPorRetraso() {
		return multaPorRetraso;
	}

	public void setMultaPorRetraso(double multaPorRetraso) {
		this.multaPorRetraso = multaPorRetraso;
	}

	public void verificarRetraso()
	{
		double cantidad = 0;
		
		int dias = fechaEntrega.compareTo(fechaInicio);
		
		if(dias > 0)
		{
			cantidad += dias * 100;
		}
		else
		
		multaPorRetraso = cantidad;
	}
}
