package com.co.udea.mintic.developersFive.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "movimientoDinero")
@Data
public class MovimientoDinero {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "montoMovimiento")
    private double montoMovimiento;
    @Column(name = "conceptoMovimiento")
    private String conceptoMovimiento;

    // Constructor

    public MovimientoDinero() {
    }

    public MovimientoDinero(double montoMovimiento, String conceptoMovimiento) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public double crearMonto() {
        return -1;
    }

    public String usuarioEncargadoRegistroMovimiento() {
        return "-1";
    }

}
