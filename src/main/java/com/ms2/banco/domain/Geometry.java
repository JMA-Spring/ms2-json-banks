package com.ms2.banco.domain;

public class Geometry {
	private String type;
	private Double[] coordinates = new Double[2];
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Double[] coordinates) {
		this.coordinates = coordinates;
	}
	

}
