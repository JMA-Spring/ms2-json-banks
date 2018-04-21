package com.ms2.banco.domain;

public class Banco {
	private String type;
	private Geometry geometry;
	private Propiedades propiedades;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	public Propiedades getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(Propiedades propiedades) {
		this.propiedades = propiedades;
	}
	
	

}
