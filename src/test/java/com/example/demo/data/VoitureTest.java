package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture uneVoiture = new Voiture();
        System.out.println(uneVoiture.getPrix() + uneVoiture.getMarque());

        Assert.isNull(uneVoiture.getMarque(), "la marque n'est pas défini");
        Assert.isTrue(uneVoiture.getPrix()==0, "le prix est à 0");
    }

    @Test
    void instantierVoiture(){
        System.out.println("La vrai voiture :");

        Voiture uneVraiVoiture = new Voiture("Mercedes", 100000);
        System.out.println(uneVraiVoiture.getPrix() + uneVraiVoiture.getMarque());

        Assert.isTrue(uneVraiVoiture.getPrix()==100000);
        Assert.isTrue(uneVraiVoiture.getMarque()=="Mercedes");
    }

}
