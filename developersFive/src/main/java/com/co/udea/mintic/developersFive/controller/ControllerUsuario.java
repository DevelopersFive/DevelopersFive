package com.co.udea.mintic.developersFive.controller;



import java.util.ArrayList;
import java.util.Optional;

import com.co.udea.mintic.developersFive.domain.Usuario;
import com.co.udea.mintic.developersFive.services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



    @RestController
    @RequestMapping("/usuario")
    public class ControllerUsuario {


        @Autowired
        ServiceUsuario serviceUsuario;

        @GetMapping
        public ArrayList<Usuario> obtenerUsuarios(){
            return serviceUsuario.obtenerUsuarios();


        }

        @PostMapping
        public Usuario guardarUsuario(@RequestBody Usuario usuario) {
            return this.serviceUsuario.guardarUsuario(usuario);
        }


        @GetMapping(path = "/{id}")
        public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id){
            return this.serviceUsuario.obtenerPorId(id);
        }

        @GetMapping(path = "/query")
        public ArrayList<Usuario> obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){

            return this.serviceUsuario.obtenerPorPrioridad(prioridad);


        }


        @DeleteMapping(path ="/{id}")
        public String eliminaPorId(@PathVariable("id")Long id) {
            boolean ok = this.serviceUsuario.eliminaUsuario(id);

            if(ok) {
                return "Se elimina el usuario con id" + id;
            }else {
                return "No pudo eliminar el usuario con id"+id;
            }



        }


    }

