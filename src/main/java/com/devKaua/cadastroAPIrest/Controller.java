package com.devKaua.cadastroAPIrest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    // Primeira rota, Get pega o metodo e trasnforma numa rota
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Primeira rota";
    }
}
