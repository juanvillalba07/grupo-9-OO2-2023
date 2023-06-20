package com.unla.smartcity.components;

import com.unla.smartcity.entities.EventoEntity;
import com.unla.smartcity.entities.SensorHumedadEntity;
import com.unla.smartcity.services.IEventoService;
import com.unla.smartcity.services.ISensorHumedadService;
import com.unla.smartcity.services.implementation.SensorHumedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class EventosSensorHumedadComponent {
    @Autowired
    @Qualifier("sensorHumedadService")
    ISensorHumedadService sensorHumedadService;
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
                if (sensor.isEstado()) {
                    sensor.setHumedadActual(sensor.getHumedadActual()+1);
                } else {
                    sensor.setHumedadActual(sensor.getHumedadActual()+random.nextInt(5) - 2);
                }
                EventoEntity evento = new EventoEntity();
                sensorHumedadService.calcularEstado(sensor);
                sensorHumedadService.insertOrUpdate(sensor);
                if (sensor.getHumedadActual()>60) {
                    evento.setDescripcion("Sensor en reposo, humedad: "+sensor.getHumedadActual()+"%");
                } else {
                    evento.setDescripcion("Regadores activados, humedad: "+sensor.getHumedadActual()+"%");
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
