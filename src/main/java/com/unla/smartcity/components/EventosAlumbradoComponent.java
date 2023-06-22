package com.unla.smartcity.components;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.smartcity.entities.EventoEntity;
import com.unla.smartcity.entities.SensorAlumbradoEntity;
import com.unla.smartcity.services.IEventoService;
import com.unla.smartcity.services.ISensorAlumbradoService;
import java.util.Random;

@Component
public class EventosAlumbradoComponent {

	@Autowired
	ISensorAlumbradoService alumbradoService;

	@Autowired
	IEventoService eventoService;

	@Scheduled(fixedDelay = 20000)
	public void evento1() {
		SensorAlumbradoEntity sensor1 = alumbradoService.findById(1);
		EventoEntity evento = new EventoEntity();
		alumbradoService.calcularEstado(sensor1);
		alumbradoService.InsertOrUpdate(sensor1);
		evento.setDescripcion(alumbradoService.calcularIntensidad(sensor1));
		evento.setDispositivo(sensor1);
		alumbradoService.InsertOrUpdate(sensor1);
		eventoService.agregarEvento(evento);

		SensorAlumbradoEntity sensor2 = alumbradoService.findById(2);
		EventoEntity evento2 = new EventoEntity();
		alumbradoService.calcularEstado(sensor2);
		alumbradoService.InsertOrUpdate(sensor2);
		evento2.setDescripcion(alumbradoService.calcularIntensidad(sensor2));
		evento2.setDispositivo(sensor2);
		alumbradoService.InsertOrUpdate(sensor2);
		eventoService.agregarEvento(evento2);	
		
		SensorAlumbradoEntity sensor3 = alumbradoService.findById(3);
		EventoEntity evento3 = new EventoEntity();
		alumbradoService.calcularEstado(sensor3);
		alumbradoService.InsertOrUpdate(sensor3);
		evento3.setDescripcion(alumbradoService.calcularIntensidad(sensor3));
		evento3.setDispositivo(sensor3);
		alumbradoService.InsertOrUpdate(sensor3);
		eventoService.agregarEvento(evento3);
	}

	@Scheduled(fixedDelay = 10000)
	public void evento2() {
		SensorAlumbradoEntity sensor1 = alumbradoService.findById(1);
		EventoEntity evento = new EventoEntity();
		alumbradoService.calcularEstado(sensor1);
		sensor1.setLuzAmbiente((int)Math.random()*10+1);
		alumbradoService.InsertOrUpdate(sensor1);
		evento.setDescripcion(alumbradoService.calcularIntensidad(sensor1));
		evento.setDispositivo(sensor1);
		alumbradoService.InsertOrUpdate(sensor1);
		eventoService.agregarEvento(evento);

		SensorAlumbradoEntity sensor2 = alumbradoService.findById(2);
		EventoEntity evento2 = new EventoEntity();
		alumbradoService.calcularEstado(sensor2);
		sensor2.setLuzAmbiente((int)Math.random()*10+1);
		alumbradoService.InsertOrUpdate(sensor2);
		evento2.setDescripcion(alumbradoService.calcularIntensidad(sensor2));
		evento2.setDispositivo(sensor2);
		alumbradoService.InsertOrUpdate(sensor2);
		eventoService.agregarEvento(evento2);	
		
		SensorAlumbradoEntity sensor3 = alumbradoService.findById(3);
		EventoEntity evento3 = new EventoEntity();
		alumbradoService.calcularEstado(sensor3);
		sensor3.setLuzAmbiente((int)Math.random()*10+1);
		alumbradoService.InsertOrUpdate(sensor3);
		evento3.setDescripcion(alumbradoService.calcularIntensidad(sensor3));
		evento3.setDispositivo(sensor3);
		alumbradoService.InsertOrUpdate(sensor3);
		eventoService.agregarEvento(evento3);
	}	
}