package co.edu.uco.transformate.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "entrenador")
public class Entrenador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String identificacion;
	private String nombre;
	private String apellido;
	private String contraseña;
	private int salario;
	@ManyToOne
	@JoinColumn(name = "id_tipodocumento")
	private TipoDocumento tipodocumento;
	@ManyToOne
	@JoinColumn(name = "id_gimnasio")
	private Gimnasio gimnasio;
	
	
	public Entrenador(String identificacion, String nombre, String apellido, String contraseña, int salario,
			TipoDocumento tipodocumento, Gimnasio gimnasio) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.salario = salario;
		this.tipodocumento = tipodocumento;
		this.gimnasio = gimnasio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public TipoDocumento getTipodocumento() {
		return tipodocumento;
	}
	public void setTipodocumento(TipoDocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public Gimnasio getGimnasio() {
		return gimnasio;
	}
	public void setGimnasio(Gimnasio gimnasio) {
		this.gimnasio = gimnasio;
	}
}
