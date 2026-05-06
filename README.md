# LAB-5-Convertisseur-Temp-rature-Distance-Fragments-Onglets-

**Auteur :** Zaynab Bellafrikh (4IIR-G2)  
**Institution :** EMSI - École Marocaine des Sciences de l'Ingénieur

Ce projet est une application Android développée en **Java** dans le cadre d'un laboratoire. Elle permet de convertir des unités de **Distance** (Kilomètres/Miles) et de **Température** (Celsius/Fahrenheit) via une interface moderne et fluide.

##  Fonctionnalités

L'application propose deux outils de conversion distincts accessibles par onglets :

1.  **Convertisseur de Distance :**
    *   Conversion bi-directionnelle : Kilomètres vers Miles et Miles vers Kilomètres.
    *   Précision à deux décimales.
2.  **Convertisseur de Température :**
    *   Conversion bi-directionnelle : Celsius vers Fahrenheit et Fahrenheit vers Celsius.
    *   Gestion des températures négatives.
    *   Précision d'un chiffre après la virgule.

##  Architecture Technique

Le code a été entièrement refactorisé pour être "humain", lisible et robuste.

### Composants Android utilisés :
*   **ViewPager2 & TabLayout :** Pour une navigation fluide par balayage (swipe) entre les convertisseurs.
*   **Fragments :** Chaque outil de conversion est isolé dans son propre fragment (`DistanceFragment` et `TempFragment`) pour une meilleure maintenance.
*   **TabLayoutMediator :** Utilisé dans la `MainActivity` pour lier dynamiquement les titres des onglets au contenu.

### Structure du Code :
*   **`MainActivity.java`** : Gère l'initialisation de l'interface et la configuration des onglets.
*   **`ViewPagerAdapter.java`** : L'adaptateur qui distribue les fragments selon l'onglet sélectionné.
*   **Logiciels de conversion** : Calculs mathématiques précis avec gestion des erreurs via des blocs `try-catch` pour éviter les plantages en cas de saisie invalide.
    

<img width="371" height="802" alt="image" src="https://github.com/user-attachments/assets/4347aea9-cb4d-4240-884d-87fa00c39eaf" />
<img width="376" height="798" alt="image" src="https://github.com/user-attachments/assets/28792cfa-4bf4-4d8a-a592-a767e885c064" />

<img width="372" height="816" alt="image" src="https://github.com/user-attachments/assets/c0b26f2e-fb4f-4f89-b9ea-e4094a315c7b" />
<img width="377" height="797" alt="image" src="https://github.com/user-attachments/assets/367293e8-6a1d-407f-acf3-f09090dd17f2" />

<img width="358" height="793" alt="image" src="https://github.com/user-attachments/assets/e64f9825-01fc-4af5-9ef0-daf48e879625" />

