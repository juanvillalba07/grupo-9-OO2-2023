package com.unla.smartcity.components;

import com.unla.smartcity.entities.EventoEntity;
import com.unla.smartcity.entities.SensorEstacionamientoEntity;
import com.unla.smartcity.enums.Estado;
import com.unla.smartcity.models.DispositivoModel;
import com.unla.smartcity.models.EventoModel;
import com.unla.smartcity.services.IEstacionamientoService;
import com.unla.smartcity.services.IEventoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventosEstacionamientoComponent {
	
    @Autowired
    private IEstacionamientoService estacionamientoService;
    @Autowired
    private IEventoService eventoService;

    @Scheduled(fixedDelay=40000)
    public void evento1() {
        SensorEstacionamientoEntity sensor1 = estacionamientoService.getSensorById(4);
        sensor1.setEstado(Estado.OCUPADO);
        estacionamientoService.actualizar(sensor1);
        EventoEntity evento = new EventoEntity();
        evento.setDescripcion("Se estaciono un auto en el lugar "+sensor1.getLugar());
        evento.setFechaHora(LocalDateTime.now());
        evento.setDispositivo(sensor1);
        eventoService.agregarEvento(evento);

        SensorEstacionamientoEntity sensor3 = estacionamientoService.getSensorById(5);
        sensor3.setEstado(Estado.OCUPADO);
        estacionamientoService.actualizar(sensor3);
        EventoEntity evento2 = new EventoEntity();
        evento2.setDescripcion("Se estaciono un auto en el lugar "+sensor3.getLugar());
        evento2.setFechaHora(LocalDateTime.now());
        evento2.setDispositivo(sensor3);
        eventoService.agregarEvento(evento2);
    }

    @Scheduled(fixedDelay=30000)
    public void evento2() {
        SensorEstacionamientoEntity sensor = estacionamientoService.getSensorById(4);
        sensor.setEstado(Estado.LIBRE);
        estacionamientoService.actualizar(sensor);
        EventoEntity evento = new EventoEntity();
        evento.setDescripcion("Se libero el lugar "+sensor.getLugar());
        evento.setFechaHora(LocalDateTime.now());
        evento.setDispositivo(sensor);
        eventoService.agregarEvento(evento);

        SensorEstacionamientoEntity sensor3 = estacionamientoService.getSensorById(5);
        sensor3.setEstado(Estado.LIBRE);
        estacionamientoService.actualizar(sensor3);
        EventoEntity evento2 = new EventoEntity();
        evento2.setDescripcion("Se libero el lugar "+sensor3.getLugar());
        evento2.setFechaHora(LocalDateTime.now());
        evento2.setDispositivo(sensor3);
        eventoService.agregarEvento(evento2);
    }

}
