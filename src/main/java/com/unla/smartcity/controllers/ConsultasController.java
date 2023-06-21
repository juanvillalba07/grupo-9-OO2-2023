package com.unla.smartcity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.smartcity.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/consultas")
public class ConsultasController {
	
	
	@GetMapping("/buscar") //http://localhost:8080/consultas/buscar
	public ModelAndView buscar() {
      ModelAndView mAV = new ModelAndView(ViewRouteHelper.CONSULTAS);
	
	  return mAV;
	}
}
