package co.edu.uco.transformate.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "tipodocumento")
public class TipoDocumento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String descripcion;
		
	
	public TipoDocumento(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
