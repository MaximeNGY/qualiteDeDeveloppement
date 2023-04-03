package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;


import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;

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

}
