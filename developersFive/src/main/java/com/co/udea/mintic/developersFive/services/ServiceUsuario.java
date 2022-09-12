package com.co.udea.mintic.developersFive.services;



import java.util.ArrayList;
import java.util.Optional;

import com.co.udea.mintic.developersFive.domain.Usuario;
import com.co.udea.mintic.developersFive.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




    @Service
    public class ServiceUsuario {


        @Autowired
        UsuarioRepository usuarioRepository;

        public ArrayList<Usuario> obtenerUsuarios(){

            return (ArrayList<Usuario>) usuarioRepository.findAll();
        }

        public Usuario guardarUsuario(Usuario usuario) {

            return usuarioRepository.save(usuario);
        }

        public Optional<Usuario> obtenerPorId(Long id){
            return usuarioRepository.findById(id);
        }

        public ArrayList<Usuario> obtenerPorPrioridad (Integer prioridad){
            return usuarioRepository.findByPrioridad(prioridad);
        }

        public boolean eliminaUsuario(Long id) {

            try {

                usuarioRepository.deleteById(id);
                return true;

            }catch(Exception err) {
                return false;
            }


        }


    }

