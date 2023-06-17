package com.unla.smartcity.services.implementation;

import com.unla.smartcity.entities.SensorEstacionamientoEntity;
import com.unla.smartcity.enums.Estado;
import com.unla.smartcity.models.SensorEstacionamientoModel;
import com.unla.smartcity.repositories.ISensorEstacionamientoRepository;
import com.unla.smartcity.services.IEstacionamientoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("estacionamientoService")
public class EstacionamientoService implements IEstacionamientoService {
    @Autowired
    @Qualifier("sensorEstacionamientoRepository")
    private ISensorEstacionamientoRepository sensorEstacionamientoRepository;

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public SensorEstacionamientoModel agregarSensor(SensorEstacionamientoEntity sensorEstacionamientoEntity) {
        sensorEstacionamientoEntity.setActivo(true);
        sensorEstacionamientoEntity.setEstado(Estado.LIBRE);
        SensorEstacionamientoEntity nuevoSensor = sensorEstacionamientoRepository.save(sensorEstacionamientoEntity);
        return modelMapper.map(nuevoSensor, SensorEstacionamientoModel.class);
    }

    @Override
    public List<SensorEstacionamientoEntity> getAll() {
        return sensorEstacionamientoRepository.findAll();
    }

    @Override
    public SensorEstacionamientoEntity getSensorById(int id) {
        return sensorEstacionamientoRepository.findById(id);
    }

    @Override
    public void desactivar(int id) {
        SensorEstacionamientoEntity sensorEstacionamientoEntity = getSensorById(id);
        sensorEstacionamientoEntity.setActivo(false);
        sensorEstacionamientoRepository.save(sensorEstacionamientoEntity);
    }

    @Override
    public void activar(int id) {
        SensorEstacionamientoEntity sensorEstacionamientoEntity = getSensorById(id);
        sensorEstacionamientoEntity.setActivo(true);
        sensorEstacionamientoRepository.save(sensorEstacionamientoEntity);
    }

    @Override
    public void actualizar(SensorEstacionamientoEntity sensorEstacionamientoEntity) {
        sensorEstacionamientoRepository.save(sensorEstacionamientoEntity);
    }
}
