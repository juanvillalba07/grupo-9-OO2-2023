package com.unla.smartcity.controllers;

import com.unla.smartcity.entities.SensorEstacionamientoEntity;
import com.unla.smartcity.helpers.ViewRouteHelper;
import com.unla.smartcity.models.SensorEstacionamientoModel;
import com.unla.smartcity.services.IEstacionamientoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/estacionamiento")
public class EstacionamientoController {

    @Autowired
    @Qualifier("estacionamientoService")
    private IEstacionamientoService estacionamientoService;

    private ModelMapper modelMapper = new ModelMapper();

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/lista-lugares")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORES_ESTACIONAMIENTO);
        mAV.addObject("sensores", estacionamientoService.getAll());
        return mAV;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/agregar-sensor")
    public ModelAndView crear() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AGREGAR_SENSOR_ESTACIONAMIENTO);
        mAV.addObject("sensor", new SensorEstacionamientoModel());
        return mAV;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int idSensor) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_ESTACIONAMIENTO_EDITAR);
        mAV.addObject("sensor", estacionamientoService.getSensorById(idSensor));
        return mAV;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/guardar")
    public RedirectView guardar(@Valid @ModelAttribute("sensorEstacionamiento") SensorEstacionamientoModel sensorEstacionamientoModel, BindingResult result,
                                Model model, RedirectAttributes attribute) {

        List<SensorEstacionamientoEntity> sensores = estacionamientoService.getAll();

        if(result.hasErrors()) {
            model.addAttribute("sensor", sensorEstacionamientoModel);
            model.addAttribute("sensores", sensores);
            System.out.println("Existieron errores en el formulario!");
            return new RedirectView(ViewRouteHelper.REDIRECT_AGREGAR_SENSOR_ESTACIONAMIENTO);
        }

        estacionamientoService.agregarSensor(modelMapper.map(sensorEstacionamientoModel, SensorEstacionamientoEntity.class));
        attribute.addFlashAttribute("success", "Sensor Guardado con Exito!");
        return new RedirectView(ViewRouteHelper.REDIRECT_ESTACIONAMIENTO_LISTA);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/actualizar-sensor")
    public RedirectView editar(@ModelAttribute("sensorEstacionamiento") SensorEstacionamientoModel sensorEstacionamientoModel) {
		if(sensorEstacionamientoModel.getId() > 0) {
			SensorEstacionamientoEntity sensorEstacionamientoEntity = estacionamientoService.getSensorById(sensorEstacionamientoModel.getId());
            sensorEstacionamientoEntity.setNombre(sensorEstacionamientoModel.getNombre());
            estacionamientoService.actualizar(sensorEstacionamientoEntity);
		}
		return new RedirectView(ViewRouteHelper.REDIRECT_ESTACIONAMIENTO_LISTA);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/desactivar-sensor/{id}")
    public RedirectView desactivar(@PathVariable("id") int idSensor) {
        estacionamientoService.desactivar(idSensor);
        return new RedirectView(ViewRouteHelper.REDIRECT_ESTACIONAMIENTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/activar-sensor/{id}")
    public RedirectView activar(@PathVariable("id") int idSensor) {
        estacionamientoService.activar(idSensor);
        return new RedirectView(ViewRouteHelper.REDIRECT_ESTACIONAMIENTO);
    }
}
