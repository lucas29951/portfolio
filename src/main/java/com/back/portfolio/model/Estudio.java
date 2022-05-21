
package com.back.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Lucas Rodriguez
 */

@Getter @Setter
@Entity
public class Estudio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idEstudio;
    @Basic
    private String nombre_institucion;
    private String logo;
    private String titulo;
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Estudio(){
        
    }

    public Estudio(int idEstudio, String nombre_institucion, String logo, String titulo, String entrada, String salida, Persona persona) {
        this.idEstudio = idEstudio;
        this.nombre_institucion = nombre_institucion;
        this.logo = logo;
        this.titulo = titulo;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaIn = LocalDate.parse(entrada,formatter);
        LocalDate fechaSal = LocalDate.parse(salida,formatter);
        
        this.fecha_entrada = fechaIn;
        this.fecha_salida = fechaSal;
        this.persona = persona;
    }
    
    
}
