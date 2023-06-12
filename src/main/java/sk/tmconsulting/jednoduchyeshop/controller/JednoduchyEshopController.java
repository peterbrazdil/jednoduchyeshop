package sk.tmconsulting.jednoduchyeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sk.tmconsulting.jednoduchyeshop.model.Tricko;
import sk.tmconsulting.jednoduchyeshop.service.TrickoService;

@Controller
public class JednoduchyEshopController {

    @Autowired
    private TrickoService trickoService; // Akokedy by ste vytvorili objekt TrickoService, nieco take ako TrickoService trickoService=new TrickoService();

    @GetMapping("/") // Lomitko reprezentuje hlavnu (korenovu) URL adresu, cize napr. localhost:8080
    public String uvodnaStranka() {
        return "index";

    }
    @GetMapping("/pridaj-novy-zaznam")
    public String pridajNovyZaznam(Model model){
        Tricko trickoObjekt = new Tricko(); // Vytvorili sme objekt Tricko
        model.addAttribute("trickoObjektThymeleaf", trickoObjekt);

        return "pridaj-novy-zaznam";

    }
    @PostMapping("uloz-zaznam")
    public String ulozZaznam(@ModelAttribute("trickoObjektThymeleaf") Tricko trickoObjektNaplneny){
        // Ulozenie trickoObjektNaplneny do MySQL databazy
        trickoService.ulozTricko(trickoObjektNaplneny);
        return "index"; //Presmerujeme sa na hlavnu korenovu stranku
    }
}
