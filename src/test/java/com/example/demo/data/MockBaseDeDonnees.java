package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.mock.mockito.MockBean;

@MockBean
public class MockBaseDeDonnees {

    private VoitureRepository voitureRepository;

    @Test
    void testInsertionUneVoiture(){
        Voiture voiture = new Voiture("Ferrari", 100000);
        when(voitureRepository.save(voiture)).thenReturn(voiture);
        when(voitureRepository.findAll(voiture)).thenReturn(voiture);
    }

}
