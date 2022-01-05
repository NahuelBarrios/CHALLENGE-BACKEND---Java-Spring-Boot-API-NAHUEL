package com.example.service;

import com.example.dao.IGeneroDao;
import com.example.dominio.Genero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServicioImpl implements IGeneroServicio {

    @Autowired
    private IGeneroDao generoDao;
    
    @Override
    public List<Genero> listarGeneros() {
        return (List<Genero>) generoDao.findAll();
    }

    @Override
    public void guardarGenero(Genero genero) {
        generoDao.save(genero);
    }

    @Override
    public void eliminarGenero(Genero genero) {
        generoDao.delete(genero);
    }

    @Override
    public Genero encontrarGenero(Genero genero) {
        return generoDao.findById(genero.getIdGenero()).orElse(null);
    }
    
}
