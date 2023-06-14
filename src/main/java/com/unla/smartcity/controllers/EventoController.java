package com.unla.smartcity.controllers;

import com.unla.smartcity.helpers.ViewRouteHelper;
import com.unla.smartcity.services.IEventoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    @Qualifier("eventoService")
    private IEventoService eventoService;

    private ModelMapper modelMapper = new ModelMapper();

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AUDITOR')")
    @GetMapping("/lista-eventos")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTOS);
        mAV.addObject("eventos", eventoService.getAll());
        return mAV;
    }
}
