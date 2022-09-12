package com.co.udea.mintic.developersFive.services;
import com.co.udea.mintic.developersFive.domain.Empresa;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class ServiciosUsuario {

    @Getter
    @Setter
    //private String nombrePrograma;

    ArrayList<Usuario> listaUser;

    public ServiciosUsuario(ArrayList<Usuario> listaUser) {
        this.listaUser = listaUser;
    }

    public boolean addUsuario(Usuario usuario){


        Empresa objUsuario= new Usuario();
        objUsuario.setNombre(usuario.getNombre());
        objUsuario.setNit(usuario.getApellido());
        objUsuario.setTelefono(usuario.getTelefono());
        objUsuario.setDireccion(usuario.getDireccion());
        objUsuario.setId(usuario.getCedula());

        listaUser.add(objUsuario);

        return Boolean.TRUE;

    }

    public ArrayList<Usuario> listar(){

        System.out.println("Metodo listar del servicio ");

        return listaUser;

    }

    public Usuario buscarUsuario (int Cedula){

        Usuario usuario = null;

        for (Usuario u:listaUser ) {
            if (u.getCedula() == Cedula){
                return u;
            }
        }

        return usuario;
    }


    public boolean addUsuariocedula(Usuario usuario, int Cedula){


        Empresa objUsuario = new Usuario();
        objUsuario.setNombre(usuario.getNombre());
        objUsuario.setApelllido(usuario.getApellido());
        objUsuario.setTelefono(usuario.getTelefono());
        objUsuario.setDireccion(usuario.getDireccion());
        objUsuario.setCedula(usuario.getCedula());


        System.out.println("Se crea el usuario con el numero de cedula: ");

        listaUser.add(objUsuario);

        return Boolean.TRUE;

    }
    public Boolean borrarUsuario(Usuario usuario){
        listaUser.remove(usuario);
        return Boolean.TRUE;
    }





}






