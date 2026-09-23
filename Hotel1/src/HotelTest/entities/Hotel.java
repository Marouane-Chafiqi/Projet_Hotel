/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelTest.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Admin
 */
@Entity
public class Hotel {
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String adress;
    
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    private List<Chambre> chambres;
    private String adresse;

    public Hotel() {
    }
    
    public Hotel(String nom, String adresse) {
    this.nom = nom;
    this.adresse = adresse;
}

    public Hotel(long id, String nom, String adress, List<Chambre> chambres) {
        this.id = id;
        this.nom = nom;
        this.adress = adress;
        this.chambres = chambres;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdress() {
        return adress;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }
    
    @Override
    public String toString() {
        String adresse = null;
        return "Hotel{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + '}';

    }
}
