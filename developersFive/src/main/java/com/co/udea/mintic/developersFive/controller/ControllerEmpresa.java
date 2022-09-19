package com.co.udea.mintic.developersFive.controller;

import com.co.udea.mintic.developersFive.domain.Empresa;
import com.co.udea.mintic.developersFive.repository.EntityEmpresa;
import com.co.udea.mintic.developersFive.services.ServiceEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/empresa")

public class ControllerEmpresa{

        @Autowired
        ServiceEmpresa serviceEmpresa;



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

    @PatchMapping (path = "/udea/mintic/actualizarEP", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> actualizarEmpresaParcial (){

        String retorno = "Actualizacion Parcial de dominio Empresa";
        System.out.println("Ok, metodo patch");
        return new ResponseEntity<String >(retorno, HttpStatus.OK);

    }

    //JPA

    @GetMapping (path = "/udea/mintic/listarTodosJPA", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> listarTodo (){

        return  new ResponseEntity<Object>(serviceEmpresa.listarTodosJPA(), HttpStatus.OK);

    }

    @PostMapping (path = "/udea/mintic/insertarEmpresaJPA", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Boolean> insertarEmpresa (@RequestBody EntityEmpresa empresa){

        return new ResponseEntity<Boolean>(serviceEmpresa.insertarEmpresaJPA(empresa), HttpStatus.OK)  ;

    }

    @PutMapping (path = "/udea/mintic/actualizarTodoJPA")
    public RedirectView actualizarTodoJPA (@ModelAttribute EntityEmpresa empresa, Model modelo){

        modelo.addAttribute(empresa);
        if (serviceEmpresa.actualizarTodoJPA(empresa).equals(Boolean.TRUE)){
            return new RedirectView("/pagina2");
        }else{

            return new RedirectView("/error");
        }

    }

    @PatchMapping (path = "/udea/mintic/actualizarParcialJPA", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertarParcialJPA (@RequestBody EntityEmpresa empresa){

        serviceEmpresa.actualizarParcialJPA(empresa);
    }

    @DeleteMapping("/udea/mintic/borrarEmpresaJPA/{id}")
    public RedirectView borrarEmpresaJPA(@PathVariable("id") Long id) {
        serviceEmpresa.deleteEmpresaById(id);
        return new RedirectView("/pagina2");
    }

   /* @PostMapping (path = "/udea/mintic/insertarEmpresaNit")
    public RedirectView insertarEmpresaNit (@ModelAttribute EntityEmpresa empresa, Model modelo){
        modelo.addAttribute(empresa);
        if (serviceEmpresa.insertarEmpresaNit (empresa).equals(Boolean.TRUE)){
            return new RedirectView("/pagina2");
        }else{

            return new RedirectView("/error");
        }

    }*/



}





