package com.co.udea.mintic.developersFive.controller;

import com.co.udea.mintic.developersFive.services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerFrontend {

    @Autowired
    ServiceUsuario serviceUsuario;

    @GetMapping (path = "/")
    public String home(){

        return "index";
    }

    @GetMapping (path = "/dashboard")
    public String dashboard(){



            return "dashboard";
        }



    @GetMapping (path = "/pagina2prueba")
    public String pagina2prueba(){



        return "index";
    }

    @GetMapping (path = "/crearUsuario")
    public String crearUsuario (){



        return "crearUsuario";

    }

}





