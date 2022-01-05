package com.example.web;

import com.example.dominio.Personaje;
import com.example.service.IPeliculasServicio;
import com.example.service.IPersonajeServicio;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
public class ControladorPersonajes {

    @Autowired
    private IPersonajeServicio personajeServicio;
    
    @Autowired IPeliculasServicio peliculaServicio;
    
    @GetMapping("/personaje")
    public String agregarpersonaje(Model model) //listar
    {
        var personajesAux = personajeServicio.listarPersonajes();
//        var peliculaAux = peliculaServicio.listarPeliculas();
//        String titulo;
//        for(var personaje:personajesAux)
//        {
//            for(var pelicula:peliculaAux)
//            {
//                if (personaje.getPeliculasAsociadasPersonaje().equals(pelicula.getIdPeliculas()))
//            {
//                titulo = pelicula.getTituloPeliculas();
//                
//            }
//            }
//        }
        model.addAttribute("personajes",personajesAux);
        return "modificarpersonaje";
    }
    
    @PostMapping("/buscadorpersonaje")
    public String buscarPersonaje(@RequestParam("titulo")String titulo,Model model)
    {
        var personajeLista = personajeServicio.listarPersonajes();
        
        for(var personajeAux : personajeLista)
        {
            if(personajeAux.getNombrePersonaje().equals(titulo))
            {
                model.addAttribute("personaje",personajeAux);
            }
            
        }
        
        return "personajebuscador";
    }
    
    @GetMapping("/agregarnuevopersonaje")
    public String agregarNuevoPersonaje(Personaje personaje)
    {
        return "nuevopersonaje";
    }
    
    @PostMapping("/guardarpersonajenuevo")
    public String guardarpersonajenuevo(Personaje personaje,@RequestParam("file") MultipartFile imagen)
    {
        if(!imagen.isEmpty())
        {
            Path directorioImagenes = Paths.get("src//main//resources//static/imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);
                personaje.setImagenPersonaje(imagen.getOriginalFilename());
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        personajeServicio.guardarPersonaje(personaje);
        return "redirect:/";
    }
    
    @GetMapping("/editarpersonaje/{idPersonaje}")
    public String editarpersonaje(Personaje personaje,Model model)
    {
        personaje = personajeServicio.encontrarPersonaje(personaje);
        model.addAttribute("personaje", personaje);
        return "nuevopersonaje";
    }
    
    @GetMapping("/eliminarpersonaje/{idPersonaje}")
    public String eliminarpersonaje(Personaje personaje)
    {
        personajeServicio.eliminarPersonaje(personaje);
        
        return "redirect:/";
    }
    
}
