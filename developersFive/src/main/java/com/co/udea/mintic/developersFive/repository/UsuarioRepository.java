package com.co.udea.mintic.developersFive.repository;

import com.co.udea.mintic.developersFive.domain.Usuario;
import org.springframework.data.repository.CrudRepository;



import java.util.ArrayList;




public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    public abstract ArrayList<Usuario> findByPrioridad(Integer prioridad);



}
