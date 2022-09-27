package com.co.udea.mintic.developersFive;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RutaGoogle {
    @RequestMapping("/")
    public String ruta001(){
        return "BIENVENIDOS PAGINA DE GOOGLE";
    }
}
