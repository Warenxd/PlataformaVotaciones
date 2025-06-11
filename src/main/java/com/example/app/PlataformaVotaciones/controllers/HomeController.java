package com.example.app.PlataformaVotaciones.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/menu", "/"}) //Seleccionamos la ruta, al acceder a esa url, mostrará la información
                        // de este metodo.
    public String home(){
        return "menu";   // Devuelve y tiene que devolver sí o sí la plantilla que hicimos en_templates.
    }
}
