package com.unla.smartcity.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.smartcity.entities.SensorBanioEntity;

@Repository("sensorBanioRepository")
public interface ISensorBanioRepository extends JpaRepository<SensorBanioEntity, Serializable>{
    
	public abstract SensorBanioEntity findById(int id);

}
