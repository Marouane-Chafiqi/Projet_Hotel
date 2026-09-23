/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelTest.entities;

import java.lang.ProcessBuilder.Redirect.Type;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Admin
 */
@Entity
public class Chambre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double prix;
    
    @Enumerated(EnumType.STRING)
    private Type type;
    private boolean etat;
    
    @ManyToOne
    private Hotel hotel;
    
    public Chambre() {
    }
    

    public Chambre(double prix, Type type, boolean etat, Hotel hotel) {
        this.prix = prix;
        this.type = type;
        this.etat = etat;
        this.hotel = hotel;
    }

    public Chambre(int i, HotelTest.entities.Type type, boolean b, Hotel h1) {
        
    }

  

    public long getId() {
        return id;
    }

    public double getPrix() {
        return prix;
    }

    public Type getType() {
        return type;
    }

    public boolean isEtat() {
        return etat;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
   
    @Override
    public String toString(){
         return "Chambre{" + "id=" + id + ", prix=" + prix + ", type=" + type + ", etat=" + (etat ? "disponible" : "occupee") + '}';
    }
    
}
