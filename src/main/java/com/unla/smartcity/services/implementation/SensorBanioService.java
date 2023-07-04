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
	public SensorBanioEntity actualizar(SensorBanioEntity sensorBanioEntity) {
		return sensorBanioRepository.save(sensorBanioEntity);
	}

	@Override
	public void desactivar(int id) {
		SensorBanioEntity sensorBanioEntity = findById(id);
		sensorBanioEntity.setActivo(false);
		sensorBanioRepository.save(sensorBanioEntity);
		
	}

	@Override
	public void activar(int id) {
		SensorBanioEntity sensorBanioEntity = findById(id);
		sensorBanioEntity.setActivo(true);
		sensorBanioRepository.save(sensorBanioEntity);
		
	}

	@Override
	public boolean eliminar(int id) {
		try {
			sensorBanioRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}


}
