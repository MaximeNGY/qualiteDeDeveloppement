package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VoitureRepository extends CrudRepository<Voiture, Integer>{
    List<Voiture> findAllByOrderByMarqueAsc();

    List<Voiture> findByMarqueAndPrix(String fiat, int i);

    List<Voiture> findByPrixGreaterThan(int i);

    List<Voiture> findByMarqueContaining(String fiat);

    List<Voiture> findByMarque(String fiat);

    // Faire un test Unitaire pour valider les méthodes CRUD.
}

