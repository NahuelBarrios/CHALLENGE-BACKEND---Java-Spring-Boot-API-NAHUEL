package com.example.service;

import com.example.dominio.Peliculas;
import java.util.List;

public interface IPeliculasServicio {
    
    public List<Peliculas> listarPeliculas();
    
    public void guardarPeliculas(Peliculas pelicula);
    
    public void eliminarpeliculas(Peliculas pelicula);
    
    public Peliculas encontrarPelicula(Peliculas peliculas);
    
}
