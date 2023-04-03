package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface VoitureRepository extends CrudRepository<Voiture, Integer>{


}

