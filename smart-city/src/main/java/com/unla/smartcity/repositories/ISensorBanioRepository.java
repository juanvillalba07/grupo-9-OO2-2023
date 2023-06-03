package com.unla.smartcity.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.smartcity.entities.SensorBanio;
import com.unla.smartcity.models.SensorBanioModel;

@Repository("sensorBanioRepository")
public interface ISensorBanioRepository extends JpaRepository<SensorBanio, Serializable>{
    
	public abstract SensorBanio findById(int id);

	public abstract SensorBanioModel findByEdificio(String edificio);
}
