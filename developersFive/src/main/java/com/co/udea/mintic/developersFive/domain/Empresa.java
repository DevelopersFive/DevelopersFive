package com.co.udea.mintic.developersFive.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class Empresa {

    private String nombre;
    private String telefono;
    private String direccion;
    private String nit;
    private Long id;






    public Empresa(String nombre, String telefono, String direccion, String nit, Long id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nit = nit;
        this.id = id;
    }


    public Empresa() {

    }
}
