package com.unla.smartcity.controllers;

import com.unla.smartcity.entities.SensorAlumbradoEntity;
import com.unla.smartcity.entities.SensorBanioEntity;
import com.unla.smartcity.entities.SensorHumedadEntity;
import com.unla.smartcity.helpers.ViewRouteHelper;
import com.unla.smartcity.models.SensorAlumbradoModel;
import com.unla.smartcity.models.SensorHumedadModel;
import com.unla.smartcity.services.ISensorAlumbradoService;
import com.unla.smartcity.services.ISensorHumedadService;
import jakarta.validation.Valid;
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
@RequestMapping("/regado")
public class SensorHumedadController {
    @Autowired
    @Qualifier("sensorHumedadService")
    private ISensorHumedadService sensorHumedadService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/lista-mediciones")
    public ModelAndView index (){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.SENSOR_HUMEDAD_LISTA);
        mV.addObject("mediciones", sensorHumedadService.getAll());
        return mV;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/crear-medicion")
    public ModelAndView crear() {
        ModelAndView mV = new ModelAndView(ViewRouteHelper.SENSOR_HUMEDAD_CREAR);
        mV.addObject("medicion", new SensorHumedadModel());
        return mV;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/guardar-medicion")
    public RedirectView create (@Valid @ModelAttribute("medicion") SensorHumedadEntity sensorHumedadEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new RedirectView(ViewRouteHelper.SENSOR_HUMEDAD_CREAR_URL);
        } else {
            sensorHumedadService.calcularEstado(sensorHumedadEntity);
            sensorHumedadService.insertOrUpdate(sensorHumedadEntity);
        }
        return new RedirectView(ViewRouteHelper.SENSOR_HUMEDAD_LISTA_URL);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) {
        ModelAndView mV = new ModelAndView(ViewRouteHelper.SENSOR_HUMEDAD_EDITAR);
        SensorHumedadEntity medicion = sensorHumedadService.findById(id);
        mV.addObject("medicion", medicion);
        return mV;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/activar-sensor/{id}")
    public String activar (@PathVariable("id") int id) {
        sensorHumedadService.activar(id);
        return ViewRouteHelper.SENSOR_HUMEDAD_LISTA_REDIRECT;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/desactivar-sensor/{id}")
    public String desactivar (@PathVariable("id") int id) {
        sensorHumedadService.desactivar(id);
        return ViewRouteHelper.SENSOR_HUMEDAD_LISTA_REDIRECT;
    }

}
