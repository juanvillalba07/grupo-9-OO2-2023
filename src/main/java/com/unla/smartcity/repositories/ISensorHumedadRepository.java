package com.unla.smartcity.repositories;

import com.unla.smartcity.entities.SensorHumedadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("sensorHumedadRepository")
public interface ISensorHumedadRepository extends JpaRepository<SensorHumedadEntity, Serializable> {
    public abstract SensorHumedadEntity findById(int id);
}
