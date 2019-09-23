package logica;

public class Cliente {

	private String cedula;
	private String nombre;
	private String apellidos;
	private String telefono;
	private boolean cuentaCorriente;
	private boolean cuentaVivienda;
	private boolean cuentaFondoInversion;
	private Cuenta miCuentaCorriente;
	private Cuenta miCuentaVivienda;
	private Cuenta miCuentaFondoInversion;

	public Cliente(String cedula, String nombre, String apellidos, String telefono, boolean cuentaCorriente,
			boolean cuentaVivienda, boolean cuentaFondoInversion, Cuenta miCuentaCorriente, Cuenta miCuentaVivienda,
			Cuenta miCuentaFondoInversion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.cuentaCorriente = cuentaCorriente;
		this.cuentaVivienda = cuentaVivienda;
		this.cuentaFondoInversion = cuentaFondoInversion;
		this.miCuentaCorriente = miCuentaCorriente;
		this.miCuentaVivienda = miCuentaVivienda;
		this.miCuentaFondoInversion = miCuentaFondoInversion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(boolean cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public boolean isCuentaVivienda() {
		return cuentaVivienda;
	}

	public void setCuentaVivienda(boolean cuentaVivienda) {
		this.cuentaVivienda = cuentaVivienda;
	}

	public boolean isCuentaFondoInversion() {
		return cuentaFondoInversion;
	}

	public void setCuentaFondoInversion(boolean cuentaFondoInversion) {
		this.cuentaFondoInversion = cuentaFondoInversion;
	}

	public Cuenta getMiCuentaCorriente() {
		return miCuentaCorriente;
	}

	public void setMiCuentaCorriente(Cuenta miCuentaCorriente) {
		this.miCuentaCorriente = miCuentaCorriente;
	}

	public Cuenta getMiCuentaVivienda() {
		return miCuentaVivienda;
	}

	public void setMiCuentaVivienda(Cuenta miCuentaVivienda) {
		this.miCuentaVivienda = miCuentaVivienda;
	}

	public Cuenta getMiCuentaFondoInversion() {
		return miCuentaFondoInversion;
	}

	public void setMiCuentaFondoInversion(Cuenta miCuentaFondoInversion) {
		this.miCuentaFondoInversion = miCuentaFondoInversion;
	}

}
