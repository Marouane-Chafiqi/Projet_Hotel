# Gestion d'Hôtels

Application Java qui utilise **Hibernate ORM** pour communiquer avec une base de données **MySQL 8** (via WampServer). Elle permet de gérer des hôtels, leurs chambres et les types de chambres.

## Technologies utilisées

- **Langage :** Java (JDK 8)
- **ORM :** Hibernate Core 4.3.1.Final
- **IDE :** NetBeans
- **Base de données :** MySQL 8.x (WampServer)
- **Driver JDBC :** `mysql-connector-j-8.0.33.jar`

## Configuration

Le fichier `hibernate.cfg.xml` relie Hibernate à la base de données `hotel_db`. Il définit le driver `com.mysql.cj.jdbc.Driver` (compatible avec MySQL 8), l'URL de connexion, l'utilisateur `root` et le dialecte MySQL. L'option `hbm2ddl.auto` est réglée sur `update` pour créer ou mettre à jour les tables automatiquement, et `show_sql` affiche les requêtes SQL générées dans la console. Les trois entités `Hotel`, `Chambre` et `Type` y sont déclarées.

<img width="1280" height="673" alt="1" src="https://github.com/user-attachments/assets/79e379b4-bd3d-45c6-987f-e223bfa36658" />


---

## Classes du projet

### 1. Hotel.java

Cette classe représente un **hôtel**. Elle contient l'identifiant (généré automatiquement), le nom, l'adresse et la liste des chambres de l'hôtel. La relation avec les chambres est de type `@OneToMany` : un hôtel possède plusieurs chambres. Elle dispose d'un constructeur sans arguments, obligatoire pour Hibernate, ainsi que de constructeurs avec paramètres, des getters/setters et d'une méthode `toString()`.

<img width="1280" height="666" alt="4" src="https://github.com/user-attachments/assets/89fb05b8-b56c-49a1-a604-c64555e789b7" />

<img width="1280" height="673" alt="41" src="https://github.com/user-attachments/assets/d6f50d34-0fd0-4a47-8874-51e98ec80fab" />

<img width="1280" height="669" alt="42" src="https://github.com/user-attachments/assets/124c3fb3-7151-4dd1-9f12-b35f24f96125" />

---

### 2. Chambre.java

Cette classe représente une **chambre**. Elle contient l'identifiant, le prix, le type de chambre, l'état (disponible ou occupée) et l'hôtel auquel elle appartient. La relation avec l'hôtel est de type `@ManyToOne` : plusieurs chambres appartiennent à un même hôtel. Le type est enregistré en base sous forme de texte grâce à `@Enumerated(EnumType.STRING)`. La méthode `toString()` affiche l'état sous la forme "disponible" ou "occupee".

<img width="1280" height="666" alt="3" src="https://github.com/user-attachments/assets/b7130f66-31a1-4b27-8379-8be97e391dbe" />

<img width="1280" height="668" alt="31" src="https://github.com/user-attachments/assets/91de8b79-18ed-4bdf-bd6a-e7e125b52161" />

<img width="1280" height="647" alt="32" src="https://github.com/user-attachments/assets/608966fd-0340-478f-ae56-6e6a997b75b8" />

---

### 3. Type.java

Énumération qui définit les différents types de chambres. Elle est utilisée par la classe `Chambre` et stockée en base de données sous forme de chaîne de caractères.

<img width="1274" height="678" alt="5" src="https://github.com/user-attachments/assets/b0c4a831-367a-41ac-86f5-af30288a4ec9" />

---

### 4. ChambreService.java

Classe de service qui regroupe les opérations sur les chambres (accès à la base de données via Hibernate).

<img width="1280" height="670" alt="6" src="https://github.com/user-attachments/assets/2fe46edd-e286-40a6-bcec-1a4e7f1e8f03" />

<img width="1280" height="669" alt="61" src="https://github.com/user-attachments/assets/1470d145-8771-4e06-b2b0-5e5c55b9f8bd" />

<img width="1280" height="669" alt="62" src="https://github.com/user-attachments/assets/6fb16485-7bad-45c8-ab9f-59cefd8f7195" />

<img width="1280" height="667" alt="63" src="https://github.com/user-attachments/assets/9b4c29fc-cdb2-4246-8eb5-29c4de41c042" />

<img width="1280" height="668" alt="64" src="https://github.com/user-attachments/assets/8d3c07d1-f876-4c81-b2b9-8dab02b437c4" />

<img width="1280" height="668" alt="65" src="https://github.com/user-attachments/assets/3c696cf7-56d5-491b-a020-64f90abd3646" />

---

### 5. HotelService.java

Classe de service qui regroupe les opérations sur les hôtels (accès à la base de données via Hibernate).

<img width="1280" height="668" alt="7" src="https://github.com/user-attachments/assets/23e366a8-e06b-4dfa-b3b6-32c3b49eabab" />

<img width="1280" height="672" alt="71" src="https://github.com/user-attachments/assets/867e2f08-4c9f-4223-bff2-c1304c98f8e9" />

<img width="1280" height="665" alt="72" src="https://github.com/user-attachments/assets/6ba2c99a-c9f4-48a4-82d4-0ad387c36d0c" />

<img width="1280" height="670" alt="73" src="https://github.com/user-attachments/assets/55fe2405-1d14-430c-86e6-a5f4d6a53475" />

---

### 6. Hotel1.java (classe principale)

Classe d'exécution contenant la méthode `main`. Elle ouvre la connexion avec Hibernate, crée des hôtels et des chambres, puis les enregistre dans la base de données afin de vérifier que le mapping fonctionne correctement.

https://github.com/user-attachments/assets/dd299796-a9a7-44e4-a509-8d368d9cb4bc

---

## Base de données

La base de données `hotel_db` (MySQL 8) contient les tables `hotel` et `chambre`, créées automatiquement par Hibernate.

<img width="1046" height="522" alt="Capture d&#39;écran 2026-09-23 203258" src="https://github.com/user-attachments/assets/23b5fc97-2775-41e0-9155-63978a7bf612" />
