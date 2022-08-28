package com.co.udea.mintic.developersFive.domain;

import lombok.Data;

@Data

public class Empleado {
    private String nombre;
    private String correo_Electronico;
    private String empresa_Pertenece;
    private String rol_Empleado;
    private int id;
}
