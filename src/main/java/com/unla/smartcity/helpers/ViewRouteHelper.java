package com.unla.smartcity.helpers;

public class ViewRouteHelper {
	
	//USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";
	
	//UNLa
	public final static String INDEX = "unla/index";
	
	/**** Redirects ****/
	public final static String ROUTE = "/index";
	
	//Baños
	public final static String SENSOR_BANIO_LISTA = "sensorBanio/listaBanios";
	public final static String SENSOR_BANIO_CREAR = "sensorBanio/agregarSensor";
	public final static String SENSOR_BANIO_EDITAR = "sensorBanio/editar";
	
	//Redirecciones Baños
	public final static String REDIRECT_SENSOR_BANIO_LISTA = "listaBanios";
	public final static String REDIRECT_SENSOR_BANIO_CREAR = "agregar-sensor";
	public final static String REDIRECT_SENSOR_BANIOS = "redirect:/sensorBanio/listaBanios";

	//Estacionamiento
	public final static String AGREGAR_SENSOR_ESTACIONAMIENTO = "estacionamiento/agregarSensor";
	public final static String SENSORES_ESTACIONAMIENTO = "estacionamiento/listaEstacionamiento";
	public final static String SENSOR_ESTACIONAMIENTO_EDITAR = "estacionamiento/editar";
	public final static String REDIRECT_AGREGAR_SENSOR_ESTACIONAMIENTO = "agregarSensor";
	public final static String REDIRECT_ESTACIONAMIENTO_LISTA = "listaEstacionamiento";
	public final static String REDIRECT_ESTACIONAMIENTO = "redirect:/estacionamiento/listaEstacionamiento";
}
