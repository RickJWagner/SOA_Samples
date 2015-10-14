package com.sample.fsw.sample001.bean;


import org.switchyard.component.bean.Service;

@Service(Prueba.class)
public class PruebaBean implements Prueba {
	@Override
	public String saludar(String transaccion) {
		System.out.println("PruebaBean runs!");
		return "{\"saludos\":\"Hola que tal\"}";
	}
}
