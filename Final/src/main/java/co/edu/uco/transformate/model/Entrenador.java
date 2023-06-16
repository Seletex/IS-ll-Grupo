package co.edu.uco.transformate.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table (name = "entrenador")
public class Entrenador implements Serializable {
	
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
	
	
	public Entrenador(String identificacion, String nombre, String apellido, int salario, Gimnasio gimnasio,
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
	
	
}
