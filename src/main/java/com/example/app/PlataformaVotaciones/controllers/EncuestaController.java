package com.example.app.PlataformaVotaciones.controllers;

import com.example.app.PlataformaVotaciones.entities.EncuestaFormulario;
import com.example.app.PlataformaVotaciones.entities.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class EncuestaController {

    @GetMapping("/encuesta")
    public String showFormulario(Model model){
        EncuestaFormulario formulario = new EncuestaFormulario();

        List<Question> questions = Arrays.asList(
                askQuestion("Animal favorito", "Gato", "Perro", "Rogbailer", "Jose")
        );
        formulario.setQuestions(questions);
        model.addAttribute("formulario", formulario);
        return "encuesta";
    }

    @PostMapping("/encuesta")
    public String processFormulario(@ModelAttribute EncuestaFormulario formulario, Model model) {
        model.addAttribute("respuestas", formulario.getQuestions());
        return "resultado";
    }




    private Question askQuestion(String _text, String... _options){
        Question q = new Question();
        q.setText(_text);
        q.setOptions(Arrays.asList(_options));
        return q;
    }
}
