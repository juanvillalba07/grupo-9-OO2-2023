package com.unla.smartcity.services;

import java.util.List;

import com.unla.smartcity.entities.SensorBanioEntity;

public interface ISensorBanioService {
	
	public List<SensorBanioEntity> getAll();
	   
	public SensorBanioEntity findById(int id);
	
	public SensorBanioEntity actualizar(SensorBanioEntity sensorBanioEntity);
	
	public void desactivar(int id);
	
    public void activar(int id);

}
