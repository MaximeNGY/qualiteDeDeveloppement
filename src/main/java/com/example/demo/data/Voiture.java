package com.example.demo.data;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import net.bytebuddy.asm.Advice;


import javax.persistence.*;

@Entity
public class Voiture {
    int id;

    private int prix;
    private String marque;

    public Voiture(){
        this.marque=null;
        this.prix=0;
    }

    public Voiture(String marque, int prix){
        this.marque=marque;
        this.prix=prix;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque(){
        return marque;
    }

    public void setMarque(String marque){
        this.marque=marque;
    }

    public int getPrix(){
        return prix;
    }

    public void setPrix(int prix){
        this.prix=prix;
    }

    @Override
    public String toString(){
        return "Car{" +
                "marque" + marque +
                "prix" + prix +
                "id" + id + "}";
    }


}
