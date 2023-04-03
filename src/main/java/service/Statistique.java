package service;

import com.example.demo.data.Voiture;
import com.example.demo.data.VoitureRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class Statistique {

    VoitureRepository voitureRepository;

    public void ajouter(Voiture voiture){voitureRepository.save(voiture);}

    public Echantillon prixMoyen(){
      int prixTotal = 0;
      int nombreDeVoiture=0;
        Iterator<Voiture> voitures = voitureRepository.findAll().iterator();
        while (voitures.hasNext()){
            prixTotal=prixTotal + voitures.next().getPrix();
            nombreDeVoiture++;
        }
        return new Echantillon(nombreDeVoiture, prixTotal/nombreDeVoiture);
    }


//    public Voiture findById(int id){
//        return this.voitureRepository.findById(id);
//    }


}
