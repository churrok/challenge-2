package com.example.restservice;


import java.time.LocalDate;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// ./gradlew build
//http://localhost:8080/Tasa


@RestController
public class TasaController {

	String marca;
	float monto;

	@GetMapping("/Hola")
	public Tasa hola(){
		Tasa tasa = new Tasa(0, "AMEX");
		return tasa;
	}

	@GetMapping("/Tasa")
	public Tasa tasa(@RequestParam String marca
	, @RequestParam String monto) {
		
		this.marca = marca.toUpperCase();
		this.monto = Float.parseFloat(monto);
		Tasa ret = new Tasa(calcularTasa(this.monto,this.marca), this.marca);
		return ret;
		
	}
	public static float calcularTasa(float monto,String marca ) {
		
		float tasa = 0;
		LocalDate fecha = LocalDate.now();
		float mes = fecha.getMonthValue();
		float anio = fecha.getYear() % 1000;
		if(anio > 100) anio = anio % 100;
		System.out.println("mes:" + mes + "anio:" + anio);
		System.out.println(mes/anio/100);
		if(marca.equals("VISA")) tasa = monto * ((mes/anio)/100);
		if(marca.equals("NARA")) tasa =   (float) (monto * ((fecha.getDayOfMonth() * 0.5)/100));
		if(marca.equals("AMEX")) tasa =  (float) (monto * ((mes * 0.1)/100)); 
		return tasa;
	}
}
