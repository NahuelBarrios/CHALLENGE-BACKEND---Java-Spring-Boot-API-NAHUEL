package com.example.dao;

import com.example.dominio.Peliculas;
import org.springframework.data.repository.CrudRepository;

public interface IPeliculasDao extends CrudRepository<Peliculas,Long> {
    
}
