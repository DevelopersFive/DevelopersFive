package com.co.udea.mintic.developersFive.domain;

import lombok.Data;

@Data

public class Empleado {

    // Atributos
    private String nombre;
    private String correo;
    private String empresaEmpleadoPertenece;
    private String rolEmpleado;
    private int id;

    // Constructor

    public Empleado(String nombre, String correo, String empresaEmpleadoPertenece, String rolEmpleado, int id) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
        this.rolEmpleado = rolEmpleado;
        this.id = id;
    }

    // Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpresaEmpleadoPertenece() {
        return empresaEmpleadoPertenece;
    }

    public void setEmpresaEmpleadoPertenece(String empresaEmpleadoPertenece) {
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}