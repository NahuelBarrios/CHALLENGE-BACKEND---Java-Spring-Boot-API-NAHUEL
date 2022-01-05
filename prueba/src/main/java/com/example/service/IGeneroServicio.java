package com.example.service;

import com.example.dominio.Genero;
import java.util.List;

public interface IGeneroServicio {
    
    public List<Genero> listarGeneros();
    
    public void guardarGenero(Genero genero);
    
    public void eliminarGenero(Genero genero);
    
    public Genero encontrarGenero(Genero genero);
    
}
