package com.example.app.PlataformaVotaciones.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping({"/view", "/"}) //Seleccionamos la ruta, al acceder a esa url, mostrará la información
                        // de este metodo.
    public String view(Model model){
        model.addAttribute("title", "PLATAFORMA DE VOTACIONES \"VOTASEGURO");
        model.addAttribute("message", "Bienvenido a VotaSeguro");
        return "view";   // Devuelve y tiene que devolver sí o sí la plantilla que hicimos en_templates.
    }
}
