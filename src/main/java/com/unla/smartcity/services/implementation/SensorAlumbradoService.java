package com.unla.smartcity.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.smartcity.entities.SensorAlumbradoEntity;
import com.unla.smartcity.models.SensorAlumbradoModel;
import com.unla.smartcity.repositories.ISensorAlumbradoRepository;
import com.unla.smartcity.services.ISensorAlumbradoService;

@Service("sensorAlumbradoService")
public class SensorAlumbradoService implements ISensorAlumbradoService {

	@Autowired
	@Qualifier("sensorAlumbradoRepository")
	private ISensorAlumbradoRepository sensorAlumbradoRepository;

	@Override
	public List<SensorAlumbradoEntity> getAll() {
		return sensorAlumbradoRepository.findAll();
	}

	@Override
	public SensorAlumbradoEntity findById(int id) {
		return sensorAlumbradoRepository.findById(id);
	}

	@Override
	public SensorAlumbradoModel findByLugar(String lugar) {
		return sensorAlumbradoRepository.findByLugar(lugar);
	}

	@Override
	public SensorAlumbradoEntity save(SensorAlumbradoEntity sensorAlumbrado) {
		return sensorAlumbradoRepository.save(sensorAlumbrado);
	}

	@Override
	public void desactivar(int id) {
		SensorAlumbradoEntity sensorAlumbradoEntity = findById(id);
	    sensorAlumbradoEntity.setActivo(false);
	    sensorAlumbradoRepository.save(sensorAlumbradoEntity);
	}

	@Override
	public void activar(int id) {
		SensorAlumbradoEntity sensorAlumbradoEntity = findById(id);
	    sensorAlumbradoEntity.setActivo(true);
	    sensorAlumbradoRepository.save(sensorAlumbradoEntity);		
	}

	@Override
	public void actualizar(SensorAlumbradoEntity sensorAlumbrado) {
		sensorAlumbradoRepository.save(sensorAlumbrado);
	}
	
}
