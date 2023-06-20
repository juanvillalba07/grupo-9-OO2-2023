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
	public void InsertOrUpdate(SensorAlumbradoEntity sensorAlumbrado) {
		sensorAlumbradoRepository.save(sensorAlumbrado);
	}

	public void calcularEstado(SensorAlumbradoEntity sensorAlumbrado) {
		if (sensorAlumbrado.getLuzAmbiente() <= 7) {
			sensorAlumbrado.setEstado(true);
		} else {
			sensorAlumbrado.setEstado(false);
		}
	}

    public String calcularIntensidad(SensorAlumbradoEntity sensorAlumbrado) {
    	String mensajeAEvento = null;
		if (sensorAlumbrado.getLuzAmbiente() <= 3) {
			sensorAlumbrado.setIntensidad(100);
			mensajeAEvento= "Prender Luz en " + sensorAlumbrado.getLugar() + " al " + sensorAlumbrado.getIntensidad() + "%";
		} else if (sensorAlumbrado.getLuzAmbiente() <= 7) {
			sensorAlumbrado.setIntensidad(50);
			mensajeAEvento="Prender Luz en " + sensorAlumbrado.getLugar() + " al " + sensorAlumbrado.getIntensidad() + "%";
		} else {
			sensorAlumbrado.setIntensidad(0);
			mensajeAEvento="Apagar Luz en " + sensorAlumbrado.getLugar();
		}
		
		return mensajeAEvento;
    }
}
