package com.co.udea.mintic.developersFive.controller;

import com.co.udea.mintic.developersFive.domain.Empleado;
import com.co.udea.mintic.developersFive.domain.MovimientoDinero;
import com.co.udea.mintic.developersFive.services.ServiceMovimientoDinero;
import com.co.udea.mintic.developersFive.services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerMovimientoDinero {

    @Autowired
    ServiceMovimientoDinero sermovd1;

    @GetMapping(/*"/movements"*/path = "/udea/mintic/movements", produces = "application/json")
    public List<MovimientoDinero> informacion() {
        return this.sermovd1.getInformacion();
    }

    @PostMapping(/*"/movements"*/path = "/udea/mintic/movements", produces = "application/json")
    public MovimientoDinero crearEmpleado(@RequestBody MovimientoDinero movdin) {
        return this.sermovd1.crearMovimientoDinero(movdin);
    }

    @PutMapping(/*"/movements/{id}"*/path = "/udea/mintic/movements/{id}", produces = "application/json")
    public MovimientoDinero actualizarEmpresa(@PathVariable Long id, @RequestBody MovimientoDinero movdin) {
        return this.sermovd1.actualizarMovimientoDinero(id, movdin);
    }

    @DeleteMapping(/*"/movements/{id}"*/path = "/udea/mintic/movements/{id}", produces = "application/json")
    public MovimientoDinero eliminarEmpresa(@PathVariable(value = "id") Long id) {
        return this.sermovd1.eliminarMovimientoDinero(id);
    }
}
