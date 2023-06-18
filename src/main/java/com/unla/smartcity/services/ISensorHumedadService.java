package com.unla.smartcity.services;

import com.unla.smartcity.entities.SensorAlumbradoEntity;
import com.unla.smartcity.entities.SensorHumedadEntity;
import com.unla.smartcity.models.SensorHumedadModel;

import java.util.List;


public interface ISensorHumedadService {
    public List<SensorHumedadEntity> getAll();

    public SensorHumedadEntity findById (int id);
    public SensorHumedadEntity insertOrUpdate (SensorHumedadEntity sensorHumedadEntity);
    public void calcularEstado(SensorHumedadEntity sensorHumedadEntity);
    public void desactivar(int id);
    public void activar(int id);

}
