package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface VoitureRepository extends CrudRepository<Voiture, Integer>{

}

