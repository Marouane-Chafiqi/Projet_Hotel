# Projet Hotel :

Application Java (NetBeans) avec **Hibernate** et **MySQL**.
Elle permet de créer des hôtels et des chambres, de les rechercher, de modifier un prix et de supprimer une chambre.

---

## 1. Création des hôtels et des chambres

<img width="558" height="307" alt="Capture d&#39;écran 2026-09-23 215752" src="https://github.com/user-attachments/assets/b0a39191-226f-49cf-9f28-e4058dea4b1c" />


Deux hôtels sont créés : **Hotel Mensour** (Marrakech, ID 10) et **Zephyr** (Agadir, ID 11).
Les 5 chambres sont ensuite ajoutées (ID 24 à 28).

---

## 2. Recherche par ID et affichage de toutes les chambres

<img width="474" height="463" alt="Capture d&#39;écran 2026-09-23 215801" src="https://github.com/user-attachments/assets/9bf57683-8fd3-488b-b6b3-cd4119ca679f" />


`FIND BY ID` retourne la chambre 24.
`FIND ALL` affiche toutes les chambres de la base.

---

## 3. Recherche par prix

<img width="466" height="71" alt="Capture d&#39;écran 2026-09-23 215809" src="https://github.com/user-attachments/assets/b24d2cc1-00b4-4081-9611-7b0840bcd438" />


Affiche les chambres dont le prix est **500.0** (chambres 1 et 24).

---

## 4. Recherche par état

<img width="505" height="296" alt="Capture d&#39;écran 2026-09-23 215815" src="https://github.com/user-attachments/assets/394ae5a9-039c-40e5-b00e-5fef88df3f80" />


Affiche uniquement les chambres à l'état **DISPONIBLE**.

---

## 5. Modification et suppression

<img width="456" height="163" alt="Capture d&#39;écran 2026-09-23 215820" src="https://github.com/user-attachments/assets/e5f005cb-2269-474d-951a-6d0c6e08d514" />


`UPDATE` : le prix de la chambre 24 passe de 500.0 à **700.0**.
`DELETE` : la chambre 28 est supprimée avec succès.
