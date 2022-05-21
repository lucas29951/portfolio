
package com.back.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Lucas Rodriguez
 */

@Getter @Setter
@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idContacto;
    @Basic
    private String nombre_info;
    private String info;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Contacto(){
        
    }

    public Contacto(int idContacto, String nombre_info, String info, Persona persona) {
        this.idContacto = idContacto;
        this.nombre_info = nombre_info;
        this.info = info;
        this.persona = persona;
    }
    
}
