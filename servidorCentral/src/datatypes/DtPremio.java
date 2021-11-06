package datatypes;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DtPremio {
	private String descripcion;
	private int cantidad;
	private List<String> ganadores = null;
	
	public DtPremio(String descripcionm, int cantidadd, List<String> ganadoress){
		descripcion = descripcionm;
		cantidad = cantidadd;
		ganadores = ganadoress;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<String> getGanadores() {
		return ganadores;
	}
}