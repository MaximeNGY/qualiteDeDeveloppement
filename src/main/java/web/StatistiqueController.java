package web;

import com.example.demo.data.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.Echantillon;
import service.Statistique;

@RestController
public class StatistiqueController {

    @Autowired
    private Statistique statistique;

    @GetMapping(value = "/statistique")
    public Echantillon getStatistique(){return statistique.prixMoyen();}

    @GetMapping(value = "/statistique/{id}")
    public @ResponseBody Voiture getVoitureById(@PathVariable("id")int id){
        return statistique.findById(id);
    }

    @GetMapping("/voiture")
    public void creerVoiture(@RequestBody Voiture voiture){
        statistique.ajouter(voiture);
    }
}

