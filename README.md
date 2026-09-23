# Projet Hotel1 :

Application Java (NetBeans) avec **Hibernate** et **MySQL**.

---

## 1. Création des hôtels et des chambres

<img width="423" height="291" alt="1" src="https://github.com/user-attachments/assets/0fddb903-feb1-417d-9151-1695a78e7bf8" />


Création de **Hotel Mensour** (Marrakech, ID 10) et **Zephyr** (Agadir, ID 11), puis de leurs chambres (ID 24 à 28).

---

## 2. Recherche par ID et affichage de toutes les chambres

<img width="450" height="461" alt="2" src="https://github.com/user-attachments/assets/f880af9e-610a-4585-99c7-436a56d89883" />


`FIND BY ID` retourne la chambre 24. `FIND ALL` affiche toutes les chambres.

---

## 3. Recherche par prix

<img width="454" height="67" alt="3" src="https://github.com/user-attachments/assets/4eebd55d-6db9-40d3-a556-992f19c96fc8" />


Affiche les chambres dont le prix est 500.0.

---

## 4. Recherche par état

<img width="437" height="298" alt="4" src="https://github.com/user-attachments/assets/256a89d8-d9e7-4e15-aa8e-de99f04667b6" />


Affiche les chambres **DISPONIBLES**.

---

## 5. Recherche par état et prix, modification et suppression

<img width="424" height="407" alt="5" src="https://github.com/user-attachments/assets/912a947a-c389-4425-a078-33b189668924" />


- **Recherche** : l'état et le prix maximum sont saisis dans la console, puis les chambres sont filtrées.
- **UPDATE** : le prix de la chambre 24 passe de 500.0 à 700.0.
- **DELETE** : la chambre 28 est supprimée avec succès.
