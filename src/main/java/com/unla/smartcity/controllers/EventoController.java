package com.unla.smartcity.controllers;

import com.unla.smartcity.helpers.ViewRouteHelper;
import com.unla.smartcity.models.EventoModel;
import com.unla.smartcity.services.IEventoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    @Qualifier("eventoService")
    private IEventoService eventoService;

    private ModelMapper modelMapper = new ModelMapper();

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AUDITOR')")
    @GetMapping()
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTOS);
        return mAV;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AUDITOR')")
    @GetMapping("/listaEventos")
    public void getEventosByFecha(@RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
                        @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
                        Model model) {
        List<EventoModel> eventoModels = eventoService.getEventosByFecha(fechaInicio, fechaFin);
        model.addAttribute("eventos", eventoModels);
    }
}
