package com.unla.smartcity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.smartcity.entities.SensorBanioEntity;
import com.unla.smartcity.helpers.ViewRouteHelper;
import com.unla.smartcity.models.SensorBanioModel;
import com.unla.smartcity.services.ISensorBanioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/sensorBanio") //http://localhost:8080/sensorBanio
public class SensorBanioController {
   
	@Autowired
	@Qualifier("sensorBanioService")
	private ISensorBanioService sensorBanioService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listaBanios") //http://localhost:8080/sensorBanio/listaBanios
	public ModelAndView index() {
       ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_BANIO_LISTA);
		
		List<SensorBanioEntity> banios = sensorBanioService.getAll();	
		
		mAV.addObject("banios", banios);
		mAV.addObject("banio", new SensorBanioModel());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/agregar-sensor") //http://localhost:8080/sensorBanio/agregar-sensor
	public ModelAndView crear() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_BANIO_CREAR);
		mAV.addObject("banio", new SensorBanioModel());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/editar/{id}") //http://localhost:8080/sensorBanio/editar
	public String editar(@PathVariable("id") int idBanio, Model model, 
			RedirectAttributes attribute) {
		 //ModelAndView mAV = new ModelAndView(ViewRouteHelper.BANIO_UPDATE);
		
		SensorBanioEntity banio = null;
		
		if(idBanio > 0 ) {
	      banio = sensorBanioService.findById(idBanio);
		}
	    
		if(banio == null) {
	      attribute.addFlashAttribute("error", "ATENCION: El ID del Baño no existe");
	      return ViewRouteHelper.REDIRECT_SENSOR_BANIOS ;
	    }
		
	    model.addAttribute("banio", banio);
	    System.out.println("Sensor Editado Exitosamente!");
	    return ViewRouteHelper.SENSOR_BANIO_EDITAR;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/guardar")
	public RedirectView guardar(@Valid @ModelAttribute("sensorBanio") SensorBanioEntity sensorBanio, BindingResult result, 
			Model model, RedirectAttributes attribute) {
		
		List<SensorBanioEntity> banios = sensorBanioService.getAll();	
		
		if(result.hasErrors()) {
			model.addAttribute("banio", sensorBanio);
			model.addAttribute("banios", banios);
			System.out.println("Existieron errores en el formulario!");
			return new RedirectView(ViewRouteHelper.REDIRECT_SENSOR_BANIO_CREAR);
		}
		sensorBanioService.actualizar(sensorBanio);
		
		attribute.addFlashAttribute("success", "Sensor Guardado con Exito!");
		return new RedirectView(ViewRouteHelper.REDIRECT_SENSOR_BANIO_LISTA);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/desactivar-sensor/{id}")
	public String desactivar(@PathVariable("id") int idBanio, RedirectAttributes attribute) {

        sensorBanioService.desactivar(idBanio); //lo  borro por ID, tendria que inactivarlo
		//banio.setLibre(false);
		attribute.addFlashAttribute("success", "Sensor Desactivado con Exito!");
		return ViewRouteHelper.REDIRECT_SENSOR_BANIOS;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/activar-sensor/{id}")
	public String activar(@PathVariable("id") int idBanio, RedirectAttributes attribute) {

        sensorBanioService.activar(idBanio); 
		attribute.addFlashAttribute("success", "Sensor Activado con Exito!");
		return ViewRouteHelper.REDIRECT_SENSOR_BANIOS;
	}
	
}
