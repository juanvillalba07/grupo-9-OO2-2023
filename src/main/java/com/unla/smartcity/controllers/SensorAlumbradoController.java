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

import com.unla.smartcity.entities.SensorAlumbradoEntity;
import com.unla.smartcity.helpers.ViewRouteHelper;
import com.unla.smartcity.models.SensorAlumbradoModel;
import com.unla.smartcity.services.ISensorAlumbradoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/alumbrado")
public class SensorAlumbradoController {
	
	@Autowired
	@Qualifier("sensorAlumbradoService")
	private ISensorAlumbradoService sensorAlumbradoService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/lista-alumbrado") 
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.SENSOR_ALUMBRADO_LISTA);
		
		mV.addObject("alumbrados", sensorAlumbradoService.getAll());
		return mV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/crear-alumbrado") 
	public ModelAndView crear() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.SENSOR_ALUMBRADO_CREAR);
		mV.addObject("alumbrado", new SensorAlumbradoModel());
		return mV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/guardar-alumbrado")
	public RedirectView guardar(@Valid @ModelAttribute("sensorAlumbrado") SensorAlumbradoEntity 
			sensorAlumbrado, BindingResult result, Model model, RedirectAttributes attribute) {

		List<SensorAlumbradoEntity> alumbrados = sensorAlumbradoService.getAll();

		if (result.hasErrors()) {
			model.addAttribute("alumbrado", sensorAlumbrado);
			model.addAttribute("alumbrados", alumbrados);
			System.out.println("Existieron errores en el formulario!");
			return new RedirectView(ViewRouteHelper.REDIRECT_ALUMBRADO_CREAR);
		}
		sensorAlumbradoService.save(sensorAlumbrado);
		attribute.addFlashAttribute("success", "Alumbrado Guardado con Exito!");
		return new RedirectView(ViewRouteHelper.REDIRECT_ALUMBRADO_LISTA);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/editar-alumbrado/{id}") // http://localhost:8080/sensorBanio/update
	public String editar(@PathVariable("id") int idAlumbrado, Model model, RedirectAttributes attribute) {
		SensorAlumbradoEntity alumbrado = null;

		if (idAlumbrado > 0) {
			alumbrado = sensorAlumbradoService.findById(idAlumbrado);
		}
		if (alumbrado == null) {
			attribute.addFlashAttribute("error", "ATENCION: El ID del Alumbrado no existe");
			return ViewRouteHelper.REDIRECT_ALUMBRADO_LISTA;
		}
		model.addAttribute("alumbrado", alumbrado);
		System.out.println("Alumbrado editado exitosamente!");
		return ViewRouteHelper.REDIRECT_ALUMBRADOS;
	}

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/desactivar-alumbrado/{id}")
    public RedirectView desactivar(@PathVariable("id") int idAlumbrado, RedirectAttributes attribute) {
        sensorAlumbradoService.desactivar(idAlumbrado);
		attribute.addFlashAttribute("warning", "Alumbrado desactivado!");
        return new RedirectView(ViewRouteHelper.REDIRECT_ALUMBRADOS);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/activar-alumbrado/{id}")
    public RedirectView activar(@PathVariable("id") int idAlumbrado, RedirectAttributes attribute) {
        sensorAlumbradoService.activar(idAlumbrado);
		attribute.addFlashAttribute("warning", "Alumbrado activado!");
        return new RedirectView(ViewRouteHelper.REDIRECT_ALUMBRADOS);
    }}
