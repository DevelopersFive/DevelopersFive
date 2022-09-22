package com.co.udea.mintic.developersFive.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class EntityEmpresa {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column (name = "nombre")
        private String nombre;
        @Column (name = "telefono")
        private String telefono;
        @Column (name = "direccion")
        private String direccion;
        @Column (name = "nit")
        private String nit;
        @Column (name = "Password")
        private String password;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
        @JsonIgnore
        private Collection<EntityPermisos> permisosCollection;


}