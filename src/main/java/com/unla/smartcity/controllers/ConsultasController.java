package com.unla.smartcity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.smartcity.entities.SensorBanioEntity;
import com.unla.smartcity.entities.SensorEstacionamientoEntity;
import com.unla.smartcity.helpers.ViewRouteHelper;
import com.unla.smartcity.models.SensorBanioModel;
import com.unla.smartcity.models.SensorEstacionamientoModel;
import com.unla.smartcity.services.IEstacionamientoService;
import com.unla.smartcity.services.ISensorBanioService;

@Controller
@RequestMapping("/consultas")
public class ConsultasController {
	
	@Autowired
	@Qualifier("sensorBanioService")
	private ISensorBanioService sensorBanioService;
	
	@Autowired
    @Qualifier("estacionamientoService")
    private IEstacionamientoService estacionamientoService;
	
	@GetMapping("/buscar") //http://localhost:8080/consultas/buscar
	public ModelAndView buscar() {
      ModelAndView mAV = new ModelAndView(ViewRouteHelper.CONSULTAS_BUSCAR);
	
	  return mAV;
	}
	
	@GetMapping("/sensorBanio") //http://localhost:8080/consultas/sensorBanio
	public ModelAndView sensorBanio() {
      ModelAndView mAV = new ModelAndView(ViewRouteHelper.CONSULTAS_SENSOR_BANIO);
      List<SensorBanioEntity> banios = sensorBanioService.getAll();	
		
		mAV.addObject("banios", banios);
		mAV.addObject("banio", new SensorBanioModel());
	  return mAV;
	}
	
	@GetMapping("/sensorEstacionamiento") //http://localhost:8080/consultas/sensorEstacionamiento
	public ModelAndView sensorEstacionamiento() {
      ModelAndView mAV = new ModelAndView(ViewRouteHelper.CONSULTAS_SENSOR_ESTACIONAMIENTO);
      List<SensorEstacionamientoEntity> estacionamientos = estacionamientoService.getAll();	
		
		mAV.addObject("estacionamientos", estacionamientos);
		mAV.addObject("estacionamiento", new SensorEstacionamientoModel());
	  return mAV;
	}
}
