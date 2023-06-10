package com.unla.smartcity.repositories;

import com.unla.smartcity.entities.SensorEstacionamientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository("sensorEstacionamientoRepository")
public interface ISensorEstacionamientoRepository extends JpaRepository<SensorEstacionamientoEntity, Serializable> {

    public abstract SensorEstacionamientoEntity findById(int id);

}
