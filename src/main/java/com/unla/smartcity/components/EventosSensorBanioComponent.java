package com.unla.smartcity.components;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.smartcity.entities.EventoEntity;
import com.unla.smartcity.entities.SensorBanioEntity;
import com.unla.smartcity.enums.Estado;
import com.unla.smartcity.services.IEventoService;
import com.unla.smartcity.services.ISensorBanioService;

//@Component
public class EventosSensorBanioComponent {
	
    @Autowired
    private ISensorBanioService sensorBanioService;
    @Autowired
    private IEventoService eventoService;

    @Scheduled(fixedDelay=40000)
    public void evento1() {
        SensorBanioEntity sensor1 = sensorBanioService.findById(6);
        sensor1.setEstado(Estado.OCUPADO);
        sensorBanioService.actualizar(sensor1);
        EventoEntity evento = new EventoEntity();
        evento.setDescripcion("Este baño va a estar ocupado a las "+sensor1.getHoraInicialLimpieza());
        evento.setFechaHora(LocalDateTime.now());
        evento.setDispositivo(sensor1);
        eventoService.agregarEvento(evento);

        SensorBanioEntity sensor3 = sensorBanioService.findById(7);
        sensor3.setEstado(Estado.OCUPADO);
        sensorBanioService.actualizar(sensor3);
        EventoEntity evento2 = new EventoEntity();
        evento2.setDescripcion("Este baño va a estar ocupado a las "+sensor3.getHoraInicialLimpieza());
        evento2.setFechaHora(LocalDateTime.now());
        evento2.setDispositivo(sensor3);
        eventoService.agregarEvento(evento2);
    }

    @Scheduled(fixedDelay=30000)
    public void evento2() {
    	SensorBanioEntity sensor = sensorBanioService.findById(6);
        sensor.setEstado(Estado.LIBRE);
        sensorBanioService.actualizar(sensor);
        EventoEntity evento = new EventoEntity();
        evento.setDescripcion("Se libera el baño a las "+sensor.getHoraFinalLimpieza());
        evento.setFechaHora(LocalDateTime.now());
        evento.setDispositivo(sensor);
        eventoService.agregarEvento(evento);

        SensorBanioEntity sensor3 = sensorBanioService.findById(7);
        sensor3.setEstado(Estado.OCUPADO);
        sensorBanioService.actualizar(sensor3);
        EventoEntity evento2 = new EventoEntity();
        evento2.setDescripcion("Se libera el baño a las "+sensor3.getHoraFinalLimpieza());
        evento2.setFechaHora(LocalDateTime.now());
        evento2.setDispositivo(sensor3);
        eventoService.agregarEvento(evento2);
    }
 
}