package com.co.udea.mintic.developersFive.controller;

import com.co.udea.mintic.developersFive.domain.MovimientoDinero;
import com.co.udea.mintic.developersFive.services.ServiceMovimientoDinero;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerMovimientoDinero {

    ServiceMovimientoDinero sermovd1;

    public ControllerMovimientoDinero(ServiceMovimientoDinero sermovd1) {
        this.sermovd1 = sermovd1;
    }

    @GetMapping("/movements")
    public List<MovimientoDinero> informacion() {
        return this.sermovd1.getInformacion();
    }

    @PostMapping("/movements")
    public MovimientoDinero crearEmpleado(@RequestBody MovimientoDinero movdin) {
        return this.sermovd1.crearMovimientoDinero(movdin);
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
