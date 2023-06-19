package com.unla.smartcity.services.implementation;

import com.unla.smartcity.entities.SensorHumedadEntity;
import com.unla.smartcity.helpers.ViewRouteHelper;
import com.unla.smartcity.models.SensorHumedadModel;
import com.unla.smartcity.repositories.ISensorHumedadRepository;
import com.unla.smartcity.services.ISensorHumedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.ModelMBean;
import java.util.List;

@Service("sensorHumedadService")
public class SensorHumedadService implements ISensorHumedadService {

    @Autowired
    @Qualifier("sensorHumedadRepository")
    private ISensorHumedadRepository sensorHumedadRepository;

    public List<SensorHumedadEntity> getAll(){
        return sensorHumedadRepository.findAll();
    };

    public SensorHumedadEntity findById (int id){
        return sensorHumedadRepository.findById(id);
    };
    public SensorHumedadEntity insertOrUpdate (SensorHumedadEntity sensorHumedadEntity){
        return sensorHumedadRepository.save(sensorHumedadEntity);
    };

    public void desactivar(int id){
        SensorHumedadEntity sensor = findById(id);
        sensor.setActivo(false);
        sensorHumedadRepository.save(sensor);
    };
    public void activar(int id){
        SensorHumedadEntity sensor = findById(id);
        sensor.setActivo(true);
        sensorHumedadRepository.save(sensor);
    };

    public void calcularEstado(SensorHumedadEntity sensorHumedadEntity) {
        if (sensorHumedadEntity.getHumedadActual()> 60) {
            sensorHumedadEntity.setEstado(false);
        } else {
            sensorHumedadEntity.setEstado(true);
        }
    }
}
