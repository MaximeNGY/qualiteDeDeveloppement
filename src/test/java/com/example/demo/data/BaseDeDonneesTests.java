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
        // tester les méthodes de l'interface CrudRepository qui permette d'accéder à la base de données: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
        // save, find, delete...

    @Test
    void uneVoiture(){
        Voiture uneVoiture = new Voiture("Fiat", 4120);
        when(voitureRepository.save(uneVoiture)).thenReturn(uneVoiture);
    }

    @Test
    void uneVoitureT(){
        Voiture uneVoiture = new Voiture("Tesla Model S", 45200);
        when(voitureRepository.save(uneVoiture)).thenReturn(uneVoiture);
    }

    void testCompterVoitures() {
        // Créer deux voitures
        Voiture fiat = new Voiture("Fiat", 4120);
        Voiture teslaModelS = new Voiture("Tesla Model S", 45200);

        // Enregistrer les deux voitures
        voitureRepository.save(fiat);
        voitureRepository.save(teslaModelS);

        // Vérifier le nombre total de voitures enregistrées dans la base de données
        long totalVoitures = voitureRepository.count();
        Assert.isTrue(totalVoitures == 2, "Le nombre total de voitures enregistrées doit être égal à 2");
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
    void testDeleteAll(){
        // Configuration du mock
        voitureRepository.deleteAll();

        // Vérification
        verify(voitureRepository).deleteAll();
    }

    @Test
    void testFindByMarque() {
        Voiture uneVoiture = new Voiture("Fiat", 4120);
        Voiture uneAutreVoiture = new Voiture("Fiat", 5500);

        // Créer une liste de voitures pour simuler le retour de la méthode findByMarque()
        List<Voiture> voituresFiat = Arrays.asList(uneVoiture, uneAutreVoiture);
        when(voitureRepository.findByMarque("Fiat")).thenReturn(voituresFiat);

        // Appeler la méthode findByMarque() et vérifier le résultat
        List<Voiture> resultat = voitureRepository.findByMarque("Fiat");
        Assert.isTrue(resultat.size() == 2, "La méthode findByMarque() doit retourner 2 voitures pour la marque Fiat");
        Assert.isTrue(resultat.containsAll(voituresFiat), "La liste retournée doit contenir les deux voitures créées");
    }

    @Test
    void testFindByMarqueContaining() {
        // Création de deux voitures
        Voiture uneVoiture = new Voiture("Fiat 500", 4120);
        Voiture uneAutreVoiture = new Voiture("Fiat Panda", 3500);

        // Configuration du mock
        when(voitureRepository.findByMarqueContaining("Fiat")).thenReturn(Arrays.asList(uneVoiture, uneAutreVoiture));

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
        when(voitureRepository.findByPrixGreaterThan(40000)).thenReturn(Arrays.asList(uneAutreVoiture));

        // Appel de la méthode à tester
        List<Voiture> voitures = voitureRepository.findByPrixGreaterThan(40000);

        // Vérification
        Assert.isTrue(voitures.size() == 1 && voitures.contains(uneAutreVoiture),
                "Les voitures n'ont pas été trouvées correctement par prix supérieur");
    }

    @Test
    void testFindAllSorted(){
        // Création de deux voitures
        Voiture uneVoiture = new Voiture("Fiat", 4120);
        Voiture uneAutreVoiture = new Voiture("Fiat Panda", 3500);

        // Configuration du mock
        when(voitureRepository.findAllByOrderByMarqueAsc()).thenReturn(Arrays.asList(uneAutreVoiture, uneVoiture));

        // Appel de la méthode à tester
        List<Voiture> voitures = voitureRepository.findAllByOrderByMarqueAsc();

        // Vérification
        Assert.isTrue(voitures.size() == 2 && voitures.get(0).equals(uneAutreVoiture) && voitures.get(1).equals(uneVoiture),
                "Les voitures n'ont pas été triées correctement par marque croissante");
    }


//    @Test
//    void testFindById(){
//        // Création d'une voiture
//        Voiture uneVoiture = new Voiture("Fiat", 4120);
//
//        // Configuration du mock
//        when(voitureRepository.findById(1L)).thenReturn(Optional.of(uneVoiture));
//
//        // Appel de la méthode à tester
//        Optional<Voiture> foundVoiture = voitureRepository.findById(1L);
//
//        // Vérification
//        Assert.isTrue(foundVoiture.isPresent() && foundVoiture.get().equals(uneVoiture), "La voiture n'a pas été trouvée");
//    }
//
//    @Test
//    void testDeleteById(){
//        // Configuration du mock
//        voitureRepository.deleteById(1L);
//
//        // Vérification
//        verify(voitureRepository).deleteById(1L);
//    }
//
//
//    @Test
//    void testCount(){
//        // Configuration du mock
//        when(voitureRepository.count()).thenReturn(2L);
//
//        // Appel de la méthode à tester
//        long count = voitureRepository.count();
//
//        // Vérification
//        Assert.isTrue(count == 2L, "Le comptage des voitures n'a pas été effectué correctement");
//    }
//
//
//
//
//    @Test
//    void testFindByMarqueAndPrix(){
//        // Création de deux voitures
//        Voiture uneVoiture = new Voiture("Fiat", 4120);
//        Voiture uneAutreVoiture = new Voiture("Fiat Panda", 3500);
//
//        // Configuration du mock
//        when(voitureRepository.findByMarqueAndPrix("Fiat", 4120)).thenReturn(List.of(uneVoiture));
//
//        // Appel de la méthode à tester
//        List<Voiture> voitures = voitureRepository.findByMarqueAndPrix("Fiat", 4120);
//
//        // Vérification
//        Assert.isTrue(voitures.size() == 1 && voitures.contains(uneVoiture),
//                "Les voitures n'ont pas été trouvées correctement par marque et prix");
//    }
//
}
