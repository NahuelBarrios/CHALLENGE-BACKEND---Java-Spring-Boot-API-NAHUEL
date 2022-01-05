package com.example.web;

import com.example.dao.IRolDao;
import com.example.dao.IUsuarioDao;
import com.example.dominio.Rol;
import com.example.dominio.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ControladorRegistro {

    @Autowired
    private IUsuarioDao usuarioServicio;

    @Autowired
    private IRolDao rolDao;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/registronuevo")
    public String registro(Usuario usuario) {
        return "registro";
    }

    @PostMapping("/guardarnuevoregistro")
    public String guardarUsuarioNuevo(Usuario usuario) {
        if (usuario != null) {
            String rol = "ROLE_USER";
            Long idAux;
            Rol rolAux = new Rol();
            String pass = usuario.getPassword();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            usuario.setPassword(encoder.encode(pass));
            idAux = usuario.getIdUsuario();
            rolAux.setNombre("ROLE_USER");
            rolAux.setIdUsuario(idAux);
            rolDao.save(rolAux);
            usuarioServicio.save(usuario);
        }
        return "redirect:/login";
    }
}
