package com.example.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


@Data
@Entity
@Table(name = "peliculas", schema = "disney")
public class Peliculas implements Serializable{

       private static final long serialVersionUID = 1L;
                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeliculas;
    //@NotEmpty
    private String imagenPeliculas;
    //@NotEmpty
    private String tituloPeliculas;
    //@NotEmpty
    private Integer fechaCreacion;
    //@NotEmpty
    private Integer calificacionPeliculas;
   // @NotEmpty
    private Integer personajesAsociados;
    
    
}
