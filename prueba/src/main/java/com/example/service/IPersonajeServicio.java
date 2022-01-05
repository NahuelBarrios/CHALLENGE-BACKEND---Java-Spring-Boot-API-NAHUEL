package com.example.service;

import com.example.dominio.Personaje;
import java.util.List;

public interface IPersonajeServicio {
    
    public List<Personaje> listarPersonajes();
    
    public void guardarPersonaje(Personaje personaje);
    
    public void eliminarPersonaje(Personaje personaje);
    
    public Personaje encontrarPersonaje(Personaje personaje);
    
    
}
