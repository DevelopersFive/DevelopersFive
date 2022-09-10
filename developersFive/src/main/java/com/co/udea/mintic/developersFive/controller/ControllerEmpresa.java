package com.co.udea.mintic.developersFive.controller;

import com.co.udea.mintic.developersFive.domain.Empresa;
import com.co.udea.mintic.developersFive.services.ServiceEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/empresa")

public class ControllerEmpresa{

        @Autowired
        ServiceEmpresa serviceEmpresa;

        /*
        @GetMapping (path = "/udea/mintic/program", produces = "application/json")
        public ResponseEntity <String> callServicePrograma(){

            Empresa empresa = new Empresa();

            empresa.setNombre("DevelopersFive");
            empresa.setTelefono("3003000000");
            empresa.setDireccion("cll 11 11 11");
            empresa.setNit("80000000 0");
            empresa.setId(1);

            String salida = serviceEmpresa.inscribirEmpresa(empresa);

            return new ResponseEntity<String>(salida, HttpStatus.NOT_FOUND);

        }


        @GetMapping (path = "/udea/mintic/doWhile", produces = "application/json")
        public ArrayList doWhileController(){

            ArrayList<String> salida = new ArrayList<>();
            salida = serviceEmpresa.doWhile(7);

            return salida;

        }*/

        @GetMapping (path = "/udea/mintic/listaEmpresas", produces = MediaType.APPLICATION_JSON_VALUE)
        public ArrayList<Empresa> listaEmpresas (){
            System.out.println("Ingreso al metodo listaPersonas");

            return serviceEmpresa.listar();

        }

        @PostMapping(path = "/udea/mintic/inscribirEmpresa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
        public  ResponseEntity <Empresa> inscribirEmpresa (@RequestBody Empresa empresa){

            boolean salida = serviceEmpresa.addEmpresa(empresa);


            if(salida == true){

                return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);

            }else {

                return new ResponseEntity("Error de Ejecución ", HttpStatus.INTERNAL_SERVER_ERROR);
            }



        }


        @GetMapping (path = "/udea/mintic/buscarEmpresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Empresa> buscarEmpresa (@PathVariable int id){
            Empresa e = serviceEmpresa.buscarEmpresa(id);
            if ( e != null){
                return new ResponseEntity<Empresa>(e, HttpStatus.OK);
            }else{
                return new ResponseEntity("Error de Ejecución ", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


       @PostMapping (path = "/udea/mintic/inscribirEmpresa/{nit}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
        public  ResponseEntity <Empresa> inscribirEmpresaCondicional (@RequestBody Empresa empresa, @PathVariable String nit){




            switch (nit){
                case "nit":
                    serviceEmpresa.addEmpresaNit(empresa, nit);
                    break;

                default:
                    return new ResponseEntity("Error de Ejecución ", HttpStatus.INTERNAL_SERVER_ERROR);

            }
            return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
        }
      @PutMapping ( path = "/udea/mintic/actualizarEmpresa", produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity <Empresa> actualizarEmpresa(@RequestParam int id, @RequestParam String nombreModificado){
          Empresa e = serviceEmpresa.buscarEmpresa(id);
          e.setNombre(nombreModificado);
          System.out.println("Metod PUT");
          return new ResponseEntity<Empresa>(e, HttpStatus.OK);
      }

    @DeleteMapping (path = "/udea/mintic/borrarEmpresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Boolean> borrarEmpresa (@PathVariable int id){
        Empresa e = serviceEmpresa.buscarEmpresa(id);
        Boolean salida = serviceEmpresa.borrarEmpresa(e);
        return new ResponseEntity<Boolean>(salida, HttpStatus.OK);
    }


}


