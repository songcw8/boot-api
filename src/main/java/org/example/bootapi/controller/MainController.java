package org.example.bootapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "뿡다닥!");
        model.addAttribute("message", "쿼카");
        return "index";
    }
}
