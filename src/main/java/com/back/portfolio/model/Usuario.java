
package com.back.portfolio.model;

import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Lucas Rodriguez
 */

@Getter @Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuario;
    @Basic
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;
    
    public Usuario(){
        
    }

    public Usuario(int idUsuario, String nombre, String apellido, String email, String username, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
}
