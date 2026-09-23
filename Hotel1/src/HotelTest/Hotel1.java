package HotelTest;

import HotelTest.entities.Chambre;
import HotelTest.entities.Hotel;
import HotelTest.entities.Type;
import HotelTest.services.ChambreService;
import HotelTest.services.HotelService;

public class Hotel1 {

    public static void main(String[] args) {

        HotelService hs = new HotelService();
        ChambreService cs = new ChambreService();

       
        Hotel h1 = new Hotel("Atlas", "Casablanca");
        Hotel h2 = new Hotel("Hivernage", "Marrakech");

        hs.create(h1);
        hs.create(h2);

       
        cs.create(new Chambre(400, Type.SIMPLE, true, h1));
        cs.create(new Chambre(650, Type.DOUBLE, false, h1));
        cs.create(new Chambre(900, Type.SUITE, true, h1));
        cs.create(new Chambre(500, Type.F1, true, h2));
        cs.create(new Chambre(700, Type.F2, false, h2));

        // 3) Afficher les chambres par hotel
        for (Hotel h : hs.findAll()) {

            System.out.println("=== Chambres de " + h.getNom() + " ===");

            for (Chambre c : cs.findByHotel(h.getId())) {
                System.out.println(c);
            }
        }
    }
}
