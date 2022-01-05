package com.example.service;

import com.example.dao.IPersonajeDao;
import com.example.dominio.Personaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonajeServicioImpl implements IPersonajeServicio{

    
    @Autowired
    private IPersonajeDao personajeDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Personaje> listarPersonajes() {
        return (List<Personaje>) personajeDao.findAll();
    }

    @Override
    @Transactional
    public void guardarPersonaje(Personaje personaje) {
        personajeDao.save(personaje);
    }

    @Override
    @Transactional
    public void eliminarPersonaje(Personaje personaje) {
        personajeDao.delete(personaje);
    }

    @Override//corregir
    @Transactional(readOnly = true)
    public Personaje encontrarPersonaje(Personaje personaje) {
        return personajeDao.findById(personaje.getIdPersonaje()).orElse(null); // Si no encuentra, retorna null
    }
    
    
}
