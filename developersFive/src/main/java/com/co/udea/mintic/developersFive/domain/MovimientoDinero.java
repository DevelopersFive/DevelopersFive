package com.co.udea.mintic.developersFive.domain;

import javax.persistence.*;

@Entity
@Table(name = "movimientoDinero")
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

    public MovimientoDinero(double montoMovimiento, String conceptoMovimiento) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }

    // Getters and Setters

    public double getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }


    public MovimientoDinero() {

    }
}
