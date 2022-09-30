package com.co.udea.mintic.developersFive.controller;

import com.co.udea.mintic.developersFive.domain.MovimientoDinero;
import com.co.udea.mintic.developersFive.services.ServiceMovimientoDinero;
import com.co.udea.mintic.developersFive.services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class ControllerMovimientoDinero {

    @Autowired
    ServiceMovimientoDinero sermovd1;

    @GetMapping("/movements")
    public List<MovimientoDinero> informacion() {
        return this.sermovd1.getInformacion();
    }

//    @PostMapping("/movements")
//    public MovimientoDinero crearEmpleado(@RequestBody MovimientoDinero movdin) {
//        return this.sermovd1.crearMovimientoDinero(movdin);
//    }

    @PostMapping("/movements")
    public RedirectView crearEmpleado(@ModelAttribute MovimientoDinero movdin, Model model) {
        model.addAttribute(movdin);
        this.sermovd1.crearMovimientoDinero(movdin);
        return new RedirectView("/user");
    }

    @PutMapping("/movements/{id}")
    public MovimientoDinero actualizarEmpresa(@PathVariable Long id, @RequestBody MovimientoDinero movdin) {
        return this.sermovd1.actualizarMovimientoDinero(id, movdin);
    }

    @DeleteMapping("/movements/{id}")
    public MovimientoDinero eliminarEmpresa(@PathVariable(value = "id") Long id) {
        return this.sermovd1.eliminarMovimientoDinero(id);
    }
}
