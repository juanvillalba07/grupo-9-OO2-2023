package com.unla.smartcity.services;

import java.util.List;

import com.unla.smartcity.entities.SensorAlumbradoEntity;
import com.unla.smartcity.models.SensorAlumbradoModel;

public interface ISensorAlumbradoService {

	public List<SensorAlumbradoEntity> getAll();
	   
	public SensorAlumbradoEntity findById(int id);
	
	public SensorAlumbradoModel findByLugar(String lugar);
	
    public void InsertOrUpdate(SensorAlumbradoEntity sensorAlumbrado);
	
	public void desactivar(int id);
	
    public void activar(int id);
       
    public String calcularIntensidad(SensorAlumbradoEntity sensorAlumbrado);
    
    public void calcularEstado(SensorAlumbradoEntity sensorAlumbrado);


}
