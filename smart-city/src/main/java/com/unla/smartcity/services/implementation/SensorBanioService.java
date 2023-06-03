package com.unla.smartcity.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.smartcity.entities.SensorBanio;
import com.unla.smartcity.models.SensorBanioModel;
import com.unla.smartcity.repositories.ISensorBanioRepository;
import com.unla.smartcity.services.ISensorBanioService;


@Service("sensorBanioService")
public class SensorBanioService implements ISensorBanioService{

	@Autowired
	@Qualifier("sensorBanioRepository")
	private ISensorBanioRepository sensorBanioRepository;
	
	@Override
	public List<SensorBanio> getAll() {
		return sensorBanioRepository.findAll();
	}

	@Override
	public SensorBanio findById(int id) {
		return sensorBanioRepository.findById(id);
	}

	@Override
	public SensorBanioModel findByEdificio(String edificio) {
		return sensorBanioRepository.findByEdificio(edificio);
	}

	@Override
	public SensorBanio save(SensorBanio sensorBanio) {
		return sensorBanioRepository.save(sensorBanio);
	}

	@Override
	public boolean remove(int id) {
		try {
			sensorBanioRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
