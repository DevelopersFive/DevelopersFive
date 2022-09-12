package com.co.udea.mintic.developersFive.services;

import com.co.udea.mintic.developersFive.domain.MovimientoDinero;
import com.co.udea.mintic.developersFive.repository.RepositoryMovimientoDinero;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServiceMovimientoDinero {

    private RepositoryMovimientoDinero repositoryMovDin;

    public ServiceMovimientoDinero(RepositoryMovimientoDinero repositoryMovDin) {
        this.repositoryMovDin = repositoryMovDin;
    }

    public List<MovimientoDinero> getInformacion() {
        return this.repositoryMovDin.findAll();
    }

    public MovimientoDinero crearMovimientoDinero(MovimientoDinero newMovimientoDinero) {
        return  this.repositoryMovDin.save(newMovimientoDinero);
    }

    public MovimientoDinero actualizarMovimientoDinero(@PathVariable Long id, @RequestBody MovimientoDinero movdin) {
        MovimientoDinero movimientoDineroActual = this.repositoryMovDin.findById(id).orElseThrow();
        movimientoDineroActual.setConceptoMovimiento(movdin.getConceptoMovimiento());
        movimientoDineroActual.setMontoMovimiento(movdin.getMontoMovimiento());
        return this.repositoryMovDin.save(movimientoDineroActual);
    }

    public MovimientoDinero eliminarMovimientoDinero(Long id) {
        MovimientoDinero movimientoDineroActual = this.repositoryMovDin.findById(id).orElseThrow();
        this.repositoryMovDin.deleteById(id);
        return movimientoDineroActual;
    }
}
