package com.example.web;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ControladorInicio {

    @GetMapping("/")
    public String inicio() {
        
        return "index"; // retorno index solo ya que predeterminadamente retorna .html
    }
    
   
}
