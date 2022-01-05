package com.example.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "personaje", schema = "disney")
public class Personaje implements Serializable{
  
    private static final long serialVersionUID = 1L;
                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonaje;
    //@NotEmpty
    private String imagenPersonaje;
    //@NotEmpty
    private String nombrePersonaje;
    //@NotEmpty
    private String edadPersona;
    //@NotEmpty
    private String pesoPersonaje;
   //@NotEmpty
    private String historiaPersonaje;
    //@NotEmpty
    private Integer peliculasAsociadasPersonaje;
}