package com.co.udea.mintic.developersFive.domain;

public class MovimientoDinero {

    //Atributos
    private double montoMovimiento;
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

    // Métodos
    public double montos() {
        return -1;
    }

    public String usuarioEncargado() {
        return "-1";
    }
}
