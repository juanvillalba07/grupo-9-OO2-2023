package com.unla.smartcity.services;

import java.util.List;

import com.unla.smartcity.entities.SensorBanio;
import com.unla.smartcity.models.SensorBanioModel;

public interface ISensorBanioService {
	
	public List<SensorBanio> getAll();
	   
	public SensorBanio findById(int id);
	
	public SensorBanioModel findByEdificio(String edificio);

	public SensorBanio save(SensorBanio banio);
	
	public boolean remove(int id);
}
