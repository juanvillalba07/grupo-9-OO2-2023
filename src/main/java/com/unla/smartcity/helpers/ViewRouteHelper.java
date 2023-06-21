package com.unla.smartcity.helpers;

public class ViewRouteHelper {
	
	//User
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";
	
	//UNLa
	public final static String INDEX = "unla/index";
	
	//Redirecciones UNLa
	public final static String ROUTE = "/index";
	
	//Consultas
	public final static String CONSULTAS = "consultas/buscar";
	
	//Redirecciones consultas
	public final static String REDIRECT_CONSULTAS = "buscar";
	
	//Baños
	public final static String SENSOR_BANIO_LISTA = "sensorBanio/listaBanios";
	public final static String SENSOR_BANIO_CREAR = "sensorBanio/agregarSensor";
	public final static String SENSOR_BANIO_EDITAR = "sensorBanio/editar";
	
	//Redirecciones de Baños
	public final static String REDIRECT_SENSOR_BANIO_LISTA = "listaBanios";
	public final static String REDIRECT_SENSOR_BANIO_CREAR = "agregar-sensor";
	public final static String REDIRECT_SENSOR_BANIOS = "redirect:/sensorBanio/listaBanios";

	//Estacionamiento
	public final static String AGREGAR_SENSOR_ESTACIONAMIENTO = "estacionamiento/agregarSensor";
	public final static String SENSORES_ESTACIONAMIENTO = "estacionamiento/listaEstacionamiento";
	public final static String SENSOR_ESTACIONAMIENTO_EDITAR = "estacionamiento/editar";
	
	//Redirecciones de Estacionamiento
	public final static String REDIRECT_AGREGAR_SENSOR_ESTACIONAMIENTO = "agregarSensor";
	public final static String REDIRECT_ESTACIONAMIENTO_LISTA = "lista-lugares";
	public final static String REDIRECT_ESTACIONAMIENTO = "redirect:/estacionamiento/lista-lugares";
	
	//Alumbrado
	public final static String SENSOR_ALUMBRADO_LISTA = "alumbrado/listaAlumbrados";
	public final static String SENSOR_ALUMBRADO_CREAR = "alumbrado/agregarSensorAlumbrado";
	public final static String SENSOR_ALUMBRADO_EDITAR = "alumbrado/editar";

	//Redirecciones alumbrado
	public final static String REDIRECT_ALUMBRADO_LISTA = "lista-alumbrado";
	public final static String REDIRECT_ALUMBRADO_CREAR = "crear-alumbrado";
	public final static String REDIRECT_ALUMBRADOS = "redirect:/alumbrado/lista-alumbrado";
	
	
	//Evento
	public final static String EVENTOS_FECHA = "evento/listaEventos";
	public final static String EVENTOS_NOMBRE = "evento/ListaEventosPorNombre";
	
	//Sensor Humedad
	//Views
	public final static String SENSOR_HUMEDAD_LISTA = "sensorHumedad/listaSensorHumedad";
	public final static String SENSOR_HUMEDAD_CREAR = "sensorHumedad/agregarSensorHumedad";
	public final static String SENSOR_HUMEDAD_EDITAR = "sensorHumedad/editar";
	//Redirects
	public final static String SENSOR_HUMEDAD_LISTA_URL = "/regado/lista-mediciones";
	public final static String SENSOR_HUMEDAD_CREAR_URL = "/regado/crear-medicion";
	public final static String SENSOR_HUMEDAD_LISTA_REDIRECT = "redirect:/regado/lista-mediciones";


}
