package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


@Data
@Entity
@Table(name = "genero", schema = "disney")
public class Genero {

    private static final long serialVersionUID = 1L;
                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;
    //@NotEmpty
    private String nombreGenero;
    //@NotEmpty
    private String imagenGenero;
    //@NotEmpty
    private Integer peliculaAsociada;
    
}
