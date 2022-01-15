package com.example.web;

import com.example.dominio.Peliculas;
import com.example.service.IPeliculasServicio;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
public class ControladorPeliculas {

    @Autowired
    private IPeliculasServicio peliculasServicio;
    
    @GetMapping("/pelicula")
    public String agregarpelicula(Model model)
    {
        var peliculasAux = peliculasServicio.listarPeliculas();
        model.addAttribute("peliculas",peliculasAux);
        
        return "modificarpelicula";
    }
    
    @PostMapping("/buscadorpelicula")
    public String buscarPersonaje(@RequestParam("titulo")String titulo,Model model)
    {
        var peliculaLista = peliculasServicio.listarPeliculas();
        
        if(titulo.isEmpty())
        {
            return "redirect:/";
        }
        
        for(var peliculaAux : peliculaLista)
        {
            if(peliculaAux.getTituloPeliculas().equals(titulo))
            {
                model.addAttribute("pelicula",peliculaAux);
            }
            
        }
        
        return "peliculabuscador";
    }
    
    @GetMapping("/agregarnuevapelicula")
    public String agregarnuevapelicula(Peliculas peliculas)
    {
        return "nuevapelicula";
    }
    
    @PostMapping("/guardarpeliculanueva")
    public String guardarpeliculanueva(Peliculas peliculas,@RequestParam("file") MultipartFile imagen)
    {
        if(!imagen.isEmpty())
        {
            Path directorioImagenes = Paths.get("src//main//resources//static/imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);
                peliculas.setImagenPeliculas(imagen.getOriginalFilename());
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        peliculasServicio.guardarPeliculas(peliculas);
        
        return "redirect:/";
    }
    
    @GetMapping("/editarpelicula/{idPeliculas}")
    public String editarpelicula(Peliculas peliculas,Model model)
    {
        peliculas = peliculasServicio.encontrarPelicula(peliculas);
        model.addAttribute("peliculas", peliculas); // Le paso el mismo nombre que la clase, ya que al no encontrar una pelicula, me va a dar null. entonces se crea 1 nuevo. pq si paso otro nombre al model, no me toma el agregarPeliculas
        return "nuevapelicula";
    }
    
    @GetMapping("/eliminarpelicula/{idPeliculas}")
    public String eliminarpelicula(Peliculas peliculas)
    {
        peliculasServicio.eliminarpeliculas(peliculas);
        
        return "redirect:/";
    }
    
}
