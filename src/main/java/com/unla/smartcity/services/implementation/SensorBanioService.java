package com.unla.smartcity.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.smartcity.entities.SensorBanioEntity;
import com.unla.smartcity.repositories.ISensorBanioRepository;
import com.unla.smartcity.services.ISensorBanioService;

@Service("sensorBanioService")
public class SensorBanioService implements ISensorBanioService{

	@Autowired
	@Qualifier("sensorBanioRepository")
	private ISensorBanioRepository sensorBanioRepository;
	
	@Override
	public List<SensorBanioEntity> getAll() {
		return sensorBanioRepository.findAll();
	}

	@Override
	public SensorBanioEntity findById(int id) {
		return sensorBanioRepository.findById(id);
	}

	@Override
	public SensorBanioEntity actualizar(SensorBanioEntity sensorBanio) {
		return sensorBanioRepository.save(sensorBanio);
	}

	@Override
	public void desactivar(int id) {
		SensorBanioEntity sensorBanio = findById(id);
		sensorBanio.setActivo(false);
		sensorBanioRepository.save(sensorBanio);
		
	}

	@Override
	public void activar(int id) {
		SensorBanioEntity sensorBanio = findById(id);
		sensorBanio.setActivo(true);
		sensorBanioRepository.save(sensorBanio);
		
	}

}
