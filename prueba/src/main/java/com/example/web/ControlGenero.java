package com.example.web;

import com.example.dominio.Genero;
import com.example.service.IGeneroServicio;
import java.io.IOException;
import java.nio.file.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
public class ControlGenero {
    
    @Autowired
    private IGeneroServicio generoServicio;
    
    @GetMapping("/genero")
    public String agregarGenero(Model model) //listar
    {
        var generosAux = generoServicio.listarGeneros();
        
        model.addAttribute("generos",generosAux);        
        
        return "modificargenero";
    }
 
    @GetMapping("/agregarnuevogenero")
    public String agregarNuevoGenero(Genero genero)
    {
        return "nuevogenero";
    }
    
    @PostMapping("/guardargeneronuevo")
    public String guardarGeneroNuevo(Genero genero,@RequestParam("file") MultipartFile imagen)
    {
        if(!imagen.isEmpty())
        {
            Path directorioImagenes = Paths.get("src//main//resources//static/imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);
                genero.setImagenGenero(imagen.getOriginalFilename());
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        generoServicio.guardarGenero(genero);
        return "redirect:/";
    }
    
    @GetMapping("/editargenero/{idGenero}")
    public String editarpersonaje(Genero genero,Model model)
    {
        genero = generoServicio.encontrarGenero(genero);
        model.addAttribute("genero", genero);
        return "nuevogenero";
    }
    
    @GetMapping("/eliminargenero/{idGenero}")
    public String eliminarpersonaje(Genero genero)
    {
        generoServicio.eliminarGenero(genero);
        
        return "redirect:/";
    }
    
}
