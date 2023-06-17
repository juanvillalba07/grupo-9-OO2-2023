package com.unla.smartcity.services;

import java.util.List;

import com.unla.smartcity.entities.SensorAlumbradoEntity;
import com.unla.smartcity.models.SensorAlumbradoModel;

public interface ISensorAlumbradoService {

	public List<SensorAlumbradoEntity> getAll();
	   
	public SensorAlumbradoEntity findById(int id);
	
	public SensorAlumbradoModel findByLugar(String lugar);

	public SensorAlumbradoEntity save(SensorAlumbradoEntity sensorAlumbrado);
	
	public void desactivar(int id);
	
    public void activar(int id);
    
    public void actualizar(SensorAlumbradoEntity sensorAlumbrado);
}
