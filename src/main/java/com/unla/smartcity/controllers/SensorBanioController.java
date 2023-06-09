package com.unla.smartcity.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
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
import com.unla.smartcity.enums.Estado;
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
	
	private ModelMapper modelMapper = new ModelMapper();
	
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
	public ModelAndView editar(@PathVariable("id") int idSensorBanio) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_BANIO_EDITAR);
        mAV.addObject("sensor", sensorBanioService.findById(idSensorBanio));
        return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/actualizar-sensor")
    public RedirectView editar(@ModelAttribute("sensorBanioModel") SensorBanioModel sensorBanioModel,
    		RedirectAttributes attribute) {
		if(sensorBanioModel.getId() > 0) {
			SensorBanioEntity sensorBanioEntity = sensorBanioService.findById(sensorBanioModel.getId());
			sensorBanioEntity.setNombre(sensorBanioModel.getNombre());
			sensorBanioEntity.setEdificio(sensorBanioModel.getEdificio());
			sensorBanioEntity.setTurno(sensorBanioModel.getTurno());
			sensorBanioEntity.setHoraInicialLimpieza(sensorBanioModel.getHoraInicialLimpieza());
			sensorBanioEntity.setHoraFinalLimpieza(sensorBanioModel.getHoraFinalLimpieza());
            sensorBanioService.actualizar(sensorBanioEntity);
		}
		/*if(sensorBanioModel.getId() == null) {
			attribute.addFlashAttribute("error", "ATENCION: El ID del Sensor del Baño no existe");
		     return new RedirectView(ViewRouteHelper.REDIRECT_SENSOR_BANIOS);
		}*/
		attribute.addFlashAttribute("success", "Sensor Editado con Exito!");
		return new RedirectView(ViewRouteHelper.REDIRECT_SENSOR_BANIO_LISTA);
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/guardar")
	public RedirectView guardar(@Valid @ModelAttribute("sensorBanioModel") SensorBanioModel sensorBanioModel, BindingResult result, 
			Model model, RedirectAttributes attribute) {
		SensorBanioEntity sensorBanioEntity = modelMapper.map(sensorBanioModel, SensorBanioEntity.class);
		List<SensorBanioEntity> banios = sensorBanioService.getAll();	
		
		if(result.hasErrors()) {
			model.addAttribute("banio", sensorBanioModel);
			model.addAttribute("banios", banios);
			System.out.println("Existieron errores en el formulario!");
			return new RedirectView(ViewRouteHelper.REDIRECT_SENSOR_BANIO_CREAR);
		}
		sensorBanioEntity.setActivo(true);
		sensorBanioEntity.setEstado(Estado.LIBRE);
		sensorBanioService.actualizar(sensorBanioEntity);
		attribute.addFlashAttribute("success", "Sensor Guardado con Exito!");
		return new RedirectView(ViewRouteHelper.REDIRECT_SENSOR_BANIO_LISTA);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/desactivar-sensor/{id}") //http://localhost:8080/sensorBanio/desactivar-sensor/id
	public String desactivar(@PathVariable("id") int idBanio, RedirectAttributes attribute) {

        sensorBanioService.desactivar(idBanio); //desactivo por id
		attribute.addFlashAttribute("success", "Sensor Desactivado con Exito!");
		return ViewRouteHelper.REDIRECT_SENSOR_BANIOS;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/activar-sensor/{id}") //http://localhost:8080/sensorBanio/activar-sensor/id
	public String activar(@PathVariable("id") int idBanio, RedirectAttributes attribute) {

        sensorBanioService.activar(idBanio); //activo por id
		attribute.addFlashAttribute("success", "Sensor Activado con Exito!");
		return ViewRouteHelper.REDIRECT_SENSOR_BANIOS;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/eliminar-sensor/{id}") //http://localhost:8080/sensorBanio/eliminar-sensor/id
	public String eliminar(@PathVariable("id") int idSensorBanio, RedirectAttributes attribute) {

		sensorBanioService.eliminar(idSensorBanio); 
		attribute.addFlashAttribute("warning", "Sensor Eliminado con Exito!");
		return ViewRouteHelper.REDIRECT_SENSOR_BANIOS;
	}
	
}
