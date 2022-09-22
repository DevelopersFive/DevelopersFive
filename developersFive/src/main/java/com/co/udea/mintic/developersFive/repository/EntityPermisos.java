package com.co.udea.mintic.developersFive.repository;

import lombok.Data;

import javax.persistence.*;



@Data
@Entity
@Table(name = "permisos")
public class EntityPermisos {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        @Column (name = "lectura")
        private Boolean lectura;
        @Column (name = "escritura")
        private Boolean escritura;
        @Column (name = "actualizar")
        private Boolean actualizar;
        @Column (name = "borrar")
        private Boolean borrar;
        @JoinColumn (name = "id_empresa", referencedColumnName = "id")
        @ManyToOne (optional = false)
        private EntityEmpresa idEmpresa;

        public EntityPermisos() {
        }

        public EntityPermisos(Boolean lectura, Boolean escritura, Boolean actualizar, Boolean borrar, EntityEmpresa idEmpresa) {
            this.lectura = lectura;
            this.escritura = escritura;
            this.actualizar = actualizar;
            this.borrar = borrar;
            this.idEmpresa = idEmpresa;
    }

}