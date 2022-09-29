package com.co.udea.mintic.developersFive.controller;

import com.co.udea.mintic.developersFive.repository.EntityEmpresa;
import com.co.udea.mintic.developersFive.services.ServiceEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControllerFrontEnd {
    @Autowired
    ServiceEmpresa serviceEmpresa;

    @GetMapping(path = "/")
    public String home(){



        return "index";
    }
    @GetMapping(path = "/pagina2")
    public String pagina2(Model modelo) {


    List<EntityEmpresa> listEmpresas = serviceEmpresa.listarTodosJPA();
        modelo.addAttribute("empresas",listEmpresas);

        return"pagina2";
    }
    /*@GetMapping (path = "/crearPersona")
    public String crearPersona (Model modelo){

        modelo.addAttribute("Nempresa", new EntityPersona() );

        return "crearPersona";

    }

    @GetMapping (path = "/editarEmpresa/{id}")
    public String editarEmpresa (Model modelo, @PathVariable("id") Long id){

        EntityEmpresa pTemp = serviceEmpresa.buscarEmpresaId(id);
        modelo.addAttribute("Eempresa", pTemp );

        return "editarEmpresa";

    }*/







}
