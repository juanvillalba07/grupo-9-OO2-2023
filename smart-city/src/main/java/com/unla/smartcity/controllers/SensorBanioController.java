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

import com.unla.smartcity.entities.SensorBanio;
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
		
		List<SensorBanio> banios = sensorBanioService.getAll();	
		
		mAV.addObject("banios", banios);
		mAV.addObject("banio", new SensorBanioModel());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/crear") //http://localhost:8080/sensorBanio/crear
	public ModelAndView crear() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_BANIO_CREAR);
		mAV.addObject("banio", new SensorBanioModel());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/save")
	public RedirectView guardar(@Valid @ModelAttribute("sensorBanio") SensorBanio sensorBanio, BindingResult result, 
			Model model, RedirectAttributes attribute) {
		
		List<SensorBanio> banios = sensorBanioService.getAll();	
		
		if(result.hasErrors()) {
			model.addAttribute("banio", sensorBanio);
			model.addAttribute("banios", banios);
			System.out.println("Existieron errores en el formulario!");
			return new RedirectView(ViewRouteHelper.REDIRECT_SENSOR_BANIO_CREAR);
		}
		sensorBanioService.save(sensorBanio);
		//System.out.println("Banio creado exitosamente!");
		attribute.addFlashAttribute("success", "Baño Guardado con Exito!");
		return new RedirectView(ViewRouteHelper.REDIRECT_SENSOR_BANIO_LISTA);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/update/{id}") //http://localhost:8080/sensorBanio/update
	public String editar(@PathVariable("id") int idBanio, Model model, 
			RedirectAttributes attribute) {
		 //ModelAndView mAV = new ModelAndView(ViewRouteHelper.BANIO_UPDATE);
		
		SensorBanio banio = null;
		
		if(idBanio > 0 ) {
	      banio = sensorBanioService.findById(idBanio);
		}
	    
		if(banio == null) {
	      attribute.addFlashAttribute("error", "ATENCION: El ID del Baño no existe");
	      return ViewRouteHelper.REDIRECT_SENSOR_BANIOS ;
	    }
		
	    model.addAttribute("banio", banio);
	    System.out.println("Banio editado exitosamente!");
	    return ViewRouteHelper.SENSOR_BANIO_EDITAR;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idBanio, RedirectAttributes attribute) {

        SensorBanio banio = null;
		
		if(idBanio > 0 ) {
	      banio = sensorBanioService.findById(idBanio);
		}
	    
		if(banio == null) {
	      attribute.addFlashAttribute("error", "ATENCION: El ID del Baño no existe");
	      return ViewRouteHelper.REDIRECT_SENSOR_BANIOS ;
	    }
		sensorBanioService.remove(idBanio); //lo  borro por ID, tendria que inactivarlo
		//banio.setLibre(false);
		attribute.addFlashAttribute("warning", "Baño Eliminado con Exito!");
		return ViewRouteHelper.REDIRECT_SENSOR_BANIOS;
	}
	
}
