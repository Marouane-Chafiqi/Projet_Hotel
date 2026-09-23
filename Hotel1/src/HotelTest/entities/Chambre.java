package HotelTest.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + " | Prix : " + prix
                + " | Type : " + type
                + " | Etat : " + (etat ? "DISPONIBLE" : "OCCUPEE");
    }
}