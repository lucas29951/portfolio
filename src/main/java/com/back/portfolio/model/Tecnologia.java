
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
public class Tecnologia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idTec;
    @Basic
    private String nombre_tecno;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Tecnologia(){
        
    }

    public Tecnologia(int idTec, String nombre_tecno, Persona persona) {
        this.idTec = idTec;
        this.nombre_tecno = nombre_tecno;
        this.persona = persona;
    }
    
}
