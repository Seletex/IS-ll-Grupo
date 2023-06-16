package co.edu.uco.transformate.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "recepcionista")
public class Recepcionista implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String identificacion;
	private String nombre;
	private String apellido;
	private int salario;
	@ManyToOne
	@JoinColumn (name="id_gimnasio")
	private Gimnasio gimnasio;
	@ManyToOne
	@JoinColumn (name="id_tipodocumento")
	private TipoDocumento documento;
	
	
	public Recepcionista(String identificacion, String nombre, String apellido, int salario, Gimnasio gimnasio,
			TipoDocumento documento) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.gimnasio = gimnasio;
		this.documento = documento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public Gimnasio getGimnasio() {
		return gimnasio;
	}
	public void setGimnasio(Gimnasio gimnasio) {
		this.gimnasio = gimnasio;
	}
	public TipoDocumento getDocumento() {
		return documento;
	}
	public void setDocumento(TipoDocumento documento) {
		this.documento = documento;
	}
}
