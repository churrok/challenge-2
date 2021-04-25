package com.example.restservice;

public class Tasa {

	private final float monto;
	private String marca;
	

	public Tasa(float monto,String marca) {
		this.monto = monto;
		this.marca= marca;
	}

	public float getMonto() {
		return monto;
	}
	public String getMarca(){
		return marca;
	}

	
}
