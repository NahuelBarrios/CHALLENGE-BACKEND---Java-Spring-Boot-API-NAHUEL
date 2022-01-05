package com.example.dao;

import com.example.dominio.Genero;
import org.springframework.data.repository.CrudRepository;

public interface IGeneroDao extends CrudRepository<Genero,Long>{
    
}
