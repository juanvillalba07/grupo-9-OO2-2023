package com.unla.smartcity.components;

import ch.qos.logback.core.util.FixedDelay;
import com.unla.smartcity.entities.EventoEntity;
import com.unla.smartcity.entities.SensorHumedadEntity;
import com.unla.smartcity.helpers.ViewRouteHelper;
import com.unla.smartcity.services.IEventoService;
import com.unla.smartcity.services.implementation.SensorHumedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Component
public class SensorHumedadComponent {
    @Autowired
    @Qualifier("sensorHumedadService")
    SensorHumedadService sensorHumedadService;
    @Autowired
    @Qualifier("eventoService")
    IEventoService eventoService;
    private final static int segundo = 1000;
    public final static int minuto = segundo*60;

    @Scheduled(fixedDelay=minuto)
    public void medicionDeHumedad () {
        List<SensorHumedadEntity> sensores = sensorHumedadService.getAll();
        Random random = new Random();
        for (SensorHumedadEntity sensor : sensores) {
            if (sensor.isActivo()) {
                EventoEntity evento = new EventoEntity();
                sensor.setHumedadActual(sensor.getHumedadActual()+random.nextInt(5) - 2);
                sensorHumedadService.insertOrUpdate(sensor);
                if (sensor.getHumedadActual()>60) {
                    evento.setDescripcion("Sensor en reposo");
                } else {
                    evento.setDescripcion("Regadores activados");
                }
                if (sensor.getHumedadActual()>100) {
                    sensor.setHumedadActual(100);
                    sensorHumedadService.insertOrUpdate(sensor);
                }
                evento.setDispositivo(sensor);
                eventoService.agregarEvento(evento);
                }
            }
        }
    }
