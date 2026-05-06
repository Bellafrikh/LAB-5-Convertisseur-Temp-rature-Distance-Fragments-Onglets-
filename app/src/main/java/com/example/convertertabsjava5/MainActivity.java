package com.example.convertertabsjava5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * Activité principale gérant la navigation par onglets.
 */
public class MainActivity extends AppCompatActivity {

    // Variables avec des noms explicites
    private TabLayout barreOnglets;
    private ViewPager2 visionneusePages;
    private ViewPagerAdapter adaptateurPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialisation des composants (Liaison avec le XML humanisé)
        // Note : On utilise les IDs définis dans le nouveau activity_main.xml
        barreOnglets = findViewById(R.id.tabLayoutMenu);
        visionneusePages = findViewById(R.id.visionneusePages);

        // 2. Configuration de l'adaptateur de fragments
        // Assurez-vous que votre fichier s'appelle bien ViewPagerAdapter.java
        adaptateurPages = new ViewPagerAdapter(this);
        visionneusePages.setAdapter(adaptateurPages);

        // 3. Configuration du Mediator pour lier les onglets et le balayage (swipe)
        configurerNavigationOnglets();
    }

    /**
     * Relie le TabLayout au ViewPager2 et définit le texte des onglets.
     */
    private void configurerNavigationOnglets() {
        new TabLayoutMediator(barreOnglets, visionneusePages, (onglet, position) -> {
            switch (position) {
                case 0:
                    onglet.setText("Distances");
                    break;
                case 1:
                    onglet.setText("Températures");
                    break;
                default:
                    onglet.setText("Onglet " + (position + 1));
                    break;
            }
        }).attach();
    }
}