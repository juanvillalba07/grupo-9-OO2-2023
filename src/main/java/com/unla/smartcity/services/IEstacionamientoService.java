package com.unla.smartcity.services;

<<<<<<< HEAD
import com.unla.smartcity.entities.SensorBanioEntity;
=======
>>>>>>> 282f5bb6dde4a5a6f68be9bb1f258e30967c7827
import com.unla.smartcity.entities.SensorEstacionamientoEntity;
import com.unla.smartcity.models.SensorEstacionamientoModel;

import java.util.List;

public interface IEstacionamientoService {
    public SensorEstacionamientoModel agregarSensor(SensorEstacionamientoEntity sensorEstacionamientoEntity);
    public List<SensorEstacionamientoEntity> getAll();
    public SensorEstacionamientoEntity getSensorById(int id);
    public void desactivar(int id);
    public void activar(int id);
    public void actualizar(SensorEstacionamientoEntity sensorEstacionamientoEntity);
}
