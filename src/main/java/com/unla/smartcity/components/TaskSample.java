package com.unla.smartcity.components;

import com.unla.smartcity.entities.SensorEstacionamientoEntity;
import com.unla.smartcity.enums.Estado;
import com.unla.smartcity.services.IEstacionamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskSample {

	@Autowired
	private IEstacionamientoService estacionamientoService;

	@Scheduled(fixedDelay=5000)
	public void runJob() {

	}
}
