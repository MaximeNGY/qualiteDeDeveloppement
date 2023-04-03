package service;

public class Echantillon {

    int nombreDeVoiture;

    int prixMoyen;

    public Echantillon(){}

    public Echantillon(int nombreDeVoiture, int prixMoyen){
        this.nombreDeVoiture=nombreDeVoiture;
        this.prixMoyen=prixMoyen;
    }

    public int getNombreDeVoiture(){
        return nombreDeVoiture;
    }

    public void setNombreDeVoiture(int nombreDeVoiture){
        this.nombreDeVoiture=nombreDeVoiture;
    }

    public int getPrixMoyen(){return prixMoyen;}

    public  void setPrixMoyen(int prixMoyen){
        this.prixMoyen=prixMoyen;
    }



}
