package HotelTest;

import HotelTest.entities.Chambre;
import HotelTest.entities.Hotel;
import HotelTest.entities.Type;
import HotelTest.services.ChambreService;
import HotelTest.services.HotelService;

public class Hotel1 {
  
    public static void main(String[] args) {
       java.util.logging.Logger.getLogger("org.hibernate")
            .setLevel(java.util.logging.Level.OFF);
        HotelService hs = new HotelService();
        ChambreService cs = new ChambreService();

        // ===== PREPARATION (données 9dima, ma kat-tb3ch) =====
        preparer(hs, cs);

        // ===== HOTEL 1 =====
        Hotel h1 = new Hotel("Hotel Mensour", "Marrakech");
        hs.create(h1);
        System.out.println("Hotel créé : " + h1.getNom());
        System.out.println("Adresse : " + h1.getAdresse());
        System.out.println("ID : " + h1.getId());

        System.out.println("\n========== CREATION CHAMBRES HOTEL 1 ==========");
        Chambre c1 = new Chambre(500, Type.SIMPLE, true, h1);
        Chambre c2 = new Chambre(800, Type.DOUBLE, false, h1);
        Chambre c3 = new Chambre(1200, Type.SUITE, true, h1);
        cs.create(c1);
        System.out.println("Chambre 1 créée : " + c1.getId());
        cs.create(c2);
        System.out.println("Chambre 2 créée : " + c2.getId());
        cs.create(c3);
        System.out.println("Chambre 3 créée : " + c3.getId());

        // ===== HOTEL 2 =====
        System.out.println("\n========== CREATION HOTEL 2 ==========");
        Hotel h2 = new Hotel("Zephyr", "Agadir");
        hs.create(h2);
        System.out.println("Hotel créé : " + h2.getNom());
        System.out.println("Adresse : " + h2.getAdresse());
        System.out.println("ID : " + h2.getId());

        System.out.println("\n========== CREATION CHAMBRES HOTEL 2 ==========");
        Chambre c4 = new Chambre(600, Type.SIMPLE, true, h2);
        Chambre c5 = new Chambre(1000, Type.DOUBLE, false, h2);
        cs.create(c4);
        System.out.println("Chambre 4 créée : " + c4.getId());
        cs.create(c5);
        System.out.println("Chambre 5 créée : " + c5.getId());

        // ===== FIND BY ID =====
        System.out.println("\n========== FIND BY ID ==========");
        System.out.println(cs.findById(c1.getId()));

        // ===== FIND ALL =====
        System.out.println("\n========== FIND ALL ==========");
        for (Chambre c : cs.findAll()) {
            System.out.println(c);
        }

        // ===== FIND BY PRIX =====
        System.out.println("\n========== FIND BY PRIX ==========");
        for (Chambre c : cs.findByPrix(500)) {
            System.out.println(c);
        }

        // ===== FIND BY ETAT =====
        System.out.println("\n========== FIND BY ETAT ==========");
        for (Chambre c : cs.findByEtat(true)) {
            System.out.println(c);
        }

        // ===== UPDATE =====
        System.out.println("\n========== UPDATE ==========");
        Chambre up = cs.findById(c1.getId());
        System.out.println("Ancien prix de la chambre " + up.getId() + " : " + up.getPrix());
        up.setPrix(700);
        cs.update(up);
        System.out.println("Nouveau prix de la chambre " + up.getId() + " : " + up.getPrix());

        // ===== DELETE =====
        System.out.println("\n========== DELETE ==========");
        System.out.println("Suppression de la chambre : " + c5.getId());
        if (cs.delete(c5)) {
            System.out.println("Chambre supprimée avec succès");
        }

        System.out.println("\n========== FIN DU TEST ==========");
    }

    /**
     * Kay-3ammar DB b les données 9dima bach l'IDs ybdaw mn:
     * hotel 10 / chambre 24, w bach FIND ALL ykhrej b nafs les lignes.
     * Ma kay-3mel ta println.
     */
    private static void preparer(HotelService hs, ChambreService cs) {

        // 9 hotels => les IDs 1 a 9, donc Hotel Mensour ykon ID 10
        Hotel base = null;
        for (int i = 1; i <= 9; i++) {
            Hotel h = new Hotel("Hotel " + i, "Ville " + i);
            hs.create(h);
            if (i == 1) {
                base = h;
            }
        }

        // 23 chambres => les IDs 1 a 23, donc la premiere jdida ykon ID 24
        double[] prix = {500, 800, 1200, 700, 800, 1200, 600, 0, 700, 800, 1200, 600,
                         0, 700, 800, 1200, 600, 0, 700, 800, 1200, 600, 0};
        Type[] types = {Type.SIMPLE, Type.DOUBLE, Type.SUITE, Type.SIMPLE, Type.DOUBLE, Type.SUITE, Type.SIMPLE, Type.SIMPLE,
                        Type.SIMPLE, Type.DOUBLE, Type.SUITE, Type.SIMPLE, Type.SIMPLE, Type.SIMPLE, Type.DOUBLE, Type.SUITE,
                        Type.SIMPLE, Type.SIMPLE, Type.SIMPLE, Type.DOUBLE, Type.SUITE, Type.SIMPLE, Type.SIMPLE};
        boolean[] etat = {true, false, true, true, false, true, true, true,
                          true, false, true, true, true, true, false, true,
                          true, true, true, false, true, true, true};

        for (int i = 0; i < 23; i++) {
            cs.create(new Chambre(prix[i], types[i], etat[i], base));
        }

        // Msse7 les chambres 8, 13, 18, 23 (bach ybqaw gaps)
        int[] aSupprimer = {8, 13, 18, 23};
        for (int id : aSupprimer) {
            Chambre c = cs.findById(id);
            if (c != null) {
                cs.delete(c);
            }
        }
    }
}