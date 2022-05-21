
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
public class Experiencia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idExp;
    @Basic
    private String nombre_puesto;
    private String lugar;
    private String logo_empresa;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String descripcion;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Experiencia(){
        
    }

    public Experiencia(int idExp, String nombre_puesto, String lugar, String logo_empresa, String inicio, String fin, String descripcion, Persona persona) {
        this.idExp = idExp;
        this.nombre_puesto = nombre_puesto;
        this.lugar = lugar;
        this.logo_empresa = logo_empresa;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicio = LocalDate.parse(inicio,formatter);
        LocalDate fechaFin = LocalDate.parse(fin,formatter);
        
        this.fecha_inicio = fechaInicio;
        this.fecha_fin = fechaFin;
        this.descripcion = descripcion;
        this.persona = persona;
    }
    
}
