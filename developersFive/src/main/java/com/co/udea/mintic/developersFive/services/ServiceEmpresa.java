package com.co.udea.mintic.developersFive.services;

import com.co.udea.mintic.developersFive.domain.Empresa;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service


public class ServiceEmpresa {



        @Getter
        @Setter
        private String nombrePrograma;

        ArrayList<Empresa> listaE;

        public ServiceEmpresa(ArrayList<Empresa> listaE) {
            this.listaE = listaE;
        }

        public String inscribirEmpresa(Empresa empresa){

            String inscripcion = "la empresa " + empresa.getNombre() + " " + " Con numero Nit: " + empresa.getNit() + "  Quedo inscrito a la aplicacion "  ;

            return inscripcion;
        }


        public ArrayList doWhile(int a){
            ArrayList <String> objTraza = new ArrayList();
            do {
                System.out.println("Hola Mundo " + a);
                objTraza.add("Hola Mundo  " + String.valueOf(a));
                a++;
            }while(a<10);

            return objTraza;
        }

        public boolean addEmpresa(Empresa empresa){


            Empresa objEmpresa= new Empresa();
            objEmpresa.setNombre(objEmpresa.getNombre());
            objEmpresa.setTelefono(objEmpresa.getTelefono());
            objEmpresa.setDireccion(objEmpresa.getDireccion());
            objEmpresa.setNit(objEmpresa.getNit());
            objEmpresa.setId(objEmpresa.getId());

            listaE.add(objEmpresa);

            return Boolean.TRUE;

        }

        public ArrayList<Empresa> listar (){

            System.out.println("Metodo listar del service");

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





}
