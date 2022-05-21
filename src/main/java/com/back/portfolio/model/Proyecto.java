
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
public class Proyecto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idProyecto;
    @Basic
    private String nombre_proyecto;
    private LocalDate fecha_realizacion;
    private String descripcion;
    private String enlace_proyecto;
    private String imagen_demo;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Proyecto(){
        
    }

    public Proyecto(int idProyecto, String nombre_proyecto, String fecha, String descripcion, String enlace_proyecto, String imagen_demo, Persona persona) {
        this.idProyecto = idProyecto;
        this.nombre_proyecto = nombre_proyecto;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaRe = LocalDate.parse(fecha,formatter);
        
        this.fecha_realizacion = fechaRe;
        this.descripcion = descripcion;
        this.enlace_proyecto = enlace_proyecto;
        this.imagen_demo = imagen_demo;
        this.persona = persona;
    }
    
    
}
