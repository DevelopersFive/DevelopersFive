package com.co.udea.mintic.developersFive.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Empresa {

    private String nombre;
    private String telefono;
    private String direccion;
    private String nit;
    private int id;
    //private ArrayLIst<Empresa> empresa;
    //private ArrayList<Transaccion>transaccion;


    public Empresa(String nombre, String telefono, String direccion, String nit, int id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nit = nit;
        this.id = id;
    }

    public Empresa() {

    }
}
