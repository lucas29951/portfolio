
package com.back.portfolio.model;

import java.util.List;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Lucas Rodriguez
 */

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPersona;
    @Basic
    private String nombre;
    private String apellido;
    private String profesion;
    private String resumen;
    private String foto;
    
    @OneToMany(mappedBy="persona", cascade= {CascadeType.ALL})
    private List<Contacto> contactos;
    
    @OneToMany(mappedBy="persona",cascade= {CascadeType.ALL})
    private List<Estudio> estudios;
    
    @OneToMany(mappedBy="idPersona",cascade=CascadeType.ALL)
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy="idPersona",cascade={CascadeType.ALL})
    private List<Proyecto> proyectos;
    
    @OneToMany(mappedBy="idPersona", cascade={CascadeType.ALL})
    private List<Tecnologia> tecnologias;
    
    public Persona(){
        super();
    }

    public Persona(int idPersona, String nombre, String apellido, String profesion, String resumen, String foto) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.resumen = resumen;
        this.foto = foto;
    }
    
}
