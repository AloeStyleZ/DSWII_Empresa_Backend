package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Ubigeo;
import com.empresa.service.UbigeoService;
import com.empresa.util.AppSettings;
import com.empresa.entity.Pais;
import com.empresa.service.PaisService;

@RestController
@RequestMapping("/rest/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private UbigeoService ubigeoService;

	@Autowired
	private PaisService paisService;

	@GetMapping("/listaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		return paisService.listaPais();
	}
	
	@GetMapping("/listaDepartamentos")
	@ResponseBody
	public List<String> listaDepartamentos() {
		return ubigeoService.listaDepartamentos();
	}

	@GetMapping("/listaProvincias/{paramDep}")
	@ResponseBody
	public List<String> listaProvincias(@PathVariable("paramDep") String departamento) {
		return ubigeoService.listaProvincias(departamento);
	}

	@GetMapping("/listaDistritos/{paramDep}/{paramProv}")
	@ResponseBody
	public List<Ubigeo> listaDistritos(@PathVariable("paramDep") String departamento, @PathVariable("paramProv") String provincia) {
		return ubigeoService.listaDistritos(departamento, provincia);
	}
}