package com.example.service;

import com.example.dao.IPeliculasDao;
import com.example.dominio.Peliculas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeliculasServicioImpl implements IPeliculasServicio{

    @Autowired
    private IPeliculasDao peliculasDao; 
    
    @Override
    @Transactional(readOnly = true)
    public List<Peliculas> listarPeliculas() {
        return (List<Peliculas>) peliculasDao.findAll();
    }

    @Override
    @Transactional
    public void guardarPeliculas(Peliculas pelicula) {
        peliculasDao.save(pelicula);
    }

    @Override
    @Transactional
    public void eliminarpeliculas(Peliculas pelicula) {
        peliculasDao.delete(pelicula);
    }


   @Override//corregir
    @Transactional(readOnly = true)
    public Peliculas encontrarPelicula(Peliculas peliculas) {
        return peliculasDao.findById(peliculas.getIdPeliculas()).orElse(null); // Si no encuentra, retorna null
    }
 
    
}
