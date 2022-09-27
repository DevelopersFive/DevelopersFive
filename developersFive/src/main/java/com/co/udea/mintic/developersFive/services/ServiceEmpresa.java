package com.co.udea.mintic.developersFive.services;

import com.co.udea.mintic.developersFive.domain.Empresa;
import com.co.udea.mintic.developersFive.repository.EntityEmpresa;
import com.co.udea.mintic.developersFive.repository.EntityPermisos;
import com.co.udea.mintic.developersFive.repository.RepositoryEmpresa;
import com.co.udea.mintic.developersFive.repository.RepositoryPermisos;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service


public class ServiceEmpresa {



        @Getter
        @Setter
        //private String nombrePrograma;
        @Autowired
        RepositoryEmpresa repositoryEmpresa;

        @Autowired
        RepositoryPermisos repositoryPermisos;
        ArrayList <Empresa> listaP;

        ArrayList<Empresa> listaE;

        public ServiceEmpresa(ArrayList<Empresa> listaE) {
            this.listaE = listaE;
        }


        public boolean addEmpresa(Empresa empresa){


            Empresa objEmpresa= new Empresa();
            objEmpresa.setNombre(empresa.getNombre());
            objEmpresa.setTelefono(empresa.getTelefono());
            objEmpresa.setDireccion(empresa.getDireccion());
            objEmpresa.setNit(empresa.getNit());
            objEmpresa.setId(empresa.getId());

            listaE.add(objEmpresa);

            return Boolean.TRUE;

        }

        public ArrayList<Empresa> listar(){

            System.out.println("Metodo listar del service ");

            return listaE;

        }

        public Empresa buscarEmpresa (int id){

            Empresa empresa = null;

            for (Empresa e:listaE ) {
                if (e.getId() == id){
                    return e;
                }
            }

            return empresa;
        }


        public boolean addEmpresaNit(Empresa empresa, String nit){


            Empresa objEmpresa = new Empresa();
            objEmpresa.setNombre(empresa.getNombre());
            objEmpresa.setTelefono(empresa.getTelefono());
            objEmpresa.setDireccion(empresa.getDireccion());
            objEmpresa.setNit(empresa.getNit());
            objEmpresa.setId(empresa.getId());


            System.out.println("Creo la empresa con Nit: ");

            listaE.add(objEmpresa);

            return Boolean.TRUE;

        }
    public Boolean borrarEmpresa(Empresa empresa){
        listaE.remove(empresa);
        return Boolean.TRUE;
    }

    //JPA

    public List<EntityEmpresa> listarTodosJPA (){

        List<EntityEmpresa> list = repositoryEmpresa.findAll();

        return  list;

    }

    public Boolean insertarEmpresaJPA(EntityEmpresa empresa){
        try {
            repositoryEmpresa.save(empresa);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }




    public Boolean actualizarTodoJPA (EntityEmpresa empresa){

        try {
            repositoryEmpresa.save(empresa);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;


    }


    public void actualizarParcialJPA (EntityEmpresa empresa){

        EntityEmpresa perTemp =  repositoryEmpresa.findById(empresa.getId()).orElse(null);

        if (empresa.getNombre() != null){
            perTemp.setNombre(empresa.getNombre());
        }else if (empresa.getTelefono() != null){
            perTemp.setTelefono(empresa.getTelefono());
        }else if (empresa.getDireccion() != null){
            perTemp.setDireccion(empresa.getDireccion());
        }else if (empresa.getNit() != null){
            perTemp.setNit(empresa.getNit());
        }else if (empresa.getId() != null){
            perTemp.setId(empresa.getId());
        }else if (empresa.getPassword() != null){
            perTemp.setPassword(empresa.getPassword());


        }

        repositoryEmpresa.save(perTemp);

    }

    public void borrarEmpresaJPA (Long id){

        repositoryEmpresa.deleteById(id);
    }



    public EntityEmpresa buscarEmpresaId (Long id){

        EntityEmpresa perTemp =  repositoryEmpresa.findById(id).orElse(null);

        return perTemp;
    }







}
