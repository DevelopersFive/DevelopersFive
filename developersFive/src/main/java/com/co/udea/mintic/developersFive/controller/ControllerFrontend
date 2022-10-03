package com.co.udea.mintic.developersFive.controller;

import com.co.udea.mintic.developersFive.repository.EntityEmpresa;
import com.co.udea.mintic.developersFive.services.ServiceEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ControllerFrontEnd {
    @Autowired
    ServiceEmpresa serviceEmpresa;

    @GetMapping(path = "/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal){



        return "index";
    }
    @GetMapping(path = "/pagina2")
    public String pagina2(Model modelo, @AuthenticationPrincipal OidcUser principal) {
        if(principal!=null){
            List<EntityEmpresa> listEmpresas = serviceEmpresa.listarTodosJPA();
            modelo.addAttribute("empresas",listEmpresas);

            return"pagina2";
        }
        return "index";



    }
    @GetMapping (path = "/crearEmpresa")
    public String crearEmpresa (Model modelo){

        modelo.addAttribute("Nempresa", new EntityEmpresa() );

        return "crearEmpresa";

    }

    @GetMapping (path = "/editarEmpresa/{id}")
    public String editarEmpresa (Model modelo, @PathVariable("id") Long id){

        EntityEmpresa pTemp = serviceEmpresa.buscarEmpresaId(id);
        modelo.addAttribute("Eempresa", pTemp );

        return "editarEmpresa";

    }








}
