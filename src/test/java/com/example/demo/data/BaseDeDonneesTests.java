package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;


import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BaseDeDonneesTests {

    @MockBean
    private VoitureRepository voitureRepository;

    @Test
    void uneVoiture(){
        Voiture uneVoiture = new Voiture("Fiat", 4120);
        when(voitureRepository.save(uneVoiture)).thenReturn(uneVoiture);
        // tester les méthodes de l'interface CrudRepository qui permette d'accéder à la base de données: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
        // save, find, delete...
    }

    @Test
    void uneVoitureT(){
        Voiture uneVoiture = new Voiture("Tesla Model S", 45200);
        when(voitureRepository.save(uneVoiture)).thenReturn(uneVoiture);
    }

    @Test
    void compterVoiture(){
        Voiture teslaModelS = new Voiture("Tesla Model S", 45200);
        Voiture fiat = new Voiture("Fiat", 4120);
        when(voitureRepository.count());

    }

    @Test
    void testfindById(){voitureRepository.deleteAll();;

    }


    @Test
    void testSaveVoiture(){
        // Création d'une voiture
        Voiture uneVoiture = new Voiture("Fiat", 4120);

        // Configuration du mock
        when(voitureRepository.save(uneVoiture)).thenReturn(uneVoiture);

        // Appel de la méthode à tester
        Voiture savedVoiture = voitureRepository.save(uneVoiture);

        // Vérification
        Assert.isTrue(savedVoiture.equals(uneVoiture), "La voiture n'a pas été sauvegardée correctement");
    }

    @Test
    void testFindAllVoitures(){
        // Configuration du mock
        when(voitureRepository.findAll()).thenReturn(Collections.emptyList());

        // Appel de la méthode à tester
        List<Voiture> voitures = (List<Voiture>) voitureRepository.findAll();

        // Vérification
        Assert.isTrue(voitures.isEmpty(), "La liste de voitures n'est pas vide");
    }

    @Test
    void testFindById(){
        // Création d'une voiture
        Voiture uneVoiture = new Voiture("Fiat", 4120);

        // Configuration du mock
        when(voitureRepository.findById(1L)).thenReturn(Optional.of(uneVoiture));

        // Appel de la méthode à tester
        Optional<Voiture> foundVoiture = voitureRepository.findById(1L);

        // Vérification
        Assert.isTrue(foundVoiture.isPresent() && foundVoiture.get().equals(uneVoiture), "La voiture n'a pas été trouvée");
    }

    @Test
    void testDeleteById(){
        // Configuration du mock
        voitureRepository.deleteById(1L);

        // Vérification
        verify(voitureRepository).deleteById(1L);
    }

    @Test
    void testDeleteAll(){
        // Configuration du mock
        voitureRepository.deleteAll();

        // Vérification
        verify(voitureRepository).deleteAll();
    }

    @Test
    void testCount(){
        // Configuration du mock
        when(voitureRepository.count()).thenReturn(2L);

        // Appel de la méthode à tester
        long count = voitureRepository.count();

        // Vérification
        Assert.isTrue(count == 2L, "Le comptage des voitures n'a pas été effectué correctement");
    }

    @Test
    void testFindByMarque(){
        // Création de deux voitures
        Voiture uneVoiture = new Voiture("Fiat", 4120);
        Voiture uneAutreVoiture = new Voiture("Fiat", 3500);

        // Configuration du mock
        when(voitureRepository.findByMarque("Fiat")).thenReturn(List.of(uneVoiture, uneAutreVoiture));

        // Appel de la méthode à tester
        List<Voiture> voitures = voitureRepository.findByMarque("Fiat");

        // Vérification
        Assert.isTrue(voitures.size() == 2 && voitures.contains(uneVoiture) && voitures.contains(uneAutreVoiture), "Les voitures n'ont pas été trouvées correctement par marque");
    }

    @Test
    void testFindByMarqueContaining(){
        // Création de deux voitures
        Voiture uneVoiture = new Voiture("Fiat 500", 4120);
        Voiture uneAutreVoiture = new Voiture("Fiat Panda", 3500);

        // Configuration du mock
        when(voitureRepository.findByMarqueContaining("Fiat")).thenReturn(List.of(uneVoiture, uneAutreVoiture));

        // Appel de la méthode à tester
        List<Voiture> voitures = voitureRepository.findByMarqueContaining("Fiat");

        // Vérification
        Assert.isTrue(voitures.size() == 2 && voitures.contains(uneVoiture) && voitures.contains(uneAutreVoiture),
                "Les voitures n'ont pas été trouvées correctement par marque contenant");
    }

    @Test
    void testFindByPrixGreaterThan(){
        // Création de deux voitures
        Voiture uneVoiture = new Voiture("Fiat", 4120);
        Voiture uneAutreVoiture = new Voiture("Tesla Model S", 45200);

        // Configuration du mock
        when(voitureRepository.findByPrixGreaterThan(40000)).thenReturn(List.of(uneAutreVoiture));

        // Appel de la méthode à tester
        List<Voiture> voitures = voitureRepository.findByPrixGreaterThan(40000);

        // Vérification
        Assert.isTrue(voitures.size() == 1 && voitures.contains(uneAutreVoiture),
                "Les voitures n'ont pas été trouvées correctement par prix supérieur");
    }

    @Test
    void testFindByMarqueAndPrix(){
        // Création de deux voitures
        Voiture uneVoiture = new Voiture("Fiat", 4120);
        Voiture uneAutreVoiture = new Voiture("Fiat Panda", 3500);

        // Configuration du mock
        when(voitureRepository.findByMarqueAndPrix("Fiat", 4120)).thenReturn(List.of(uneVoiture));

        // Appel de la méthode à tester
        List<Voiture> voitures = voitureRepository.findByMarqueAndPrix("Fiat", 4120);

        // Vérification
        Assert.isTrue(voitures.size() == 1 && voitures.contains(uneVoiture),
                "Les voitures n'ont pas été trouvées correctement par marque et prix");
    }

    @Test
    void testFindAllSorted(){
        // Création de deux voitures
        Voiture uneVoiture = new Voiture("Fiat", 4120);
        Voiture uneAutreVoiture = new Voiture("Fiat Panda", 3500);

        // Configuration du mock
        when(voitureRepository.findAllByOrderByMarqueAsc()).thenReturn(List.asList(uneAutreVoiture, uneVoiture));

        // Appel de la méthode à tester
        List<Voiture> voitures = voitureRepository.findAllByOrderByMarqueAsc();

        // Vérification
        Assert.isTrue(voitures.size() == 2 && voitures.get(0).equals(uneAutreVoiture) && voitures.get(1).equals(uneVoiture),
                "Les voitures n'ont pas été triées correctement par marque croissante");
    }
}
