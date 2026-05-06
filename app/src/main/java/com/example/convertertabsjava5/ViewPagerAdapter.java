package com.example.convertertabsjava5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Adaptateur permettant de gérer la navigation entre les différents onglets (Fragments).
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    // On définit clairement le nombre d'onglets disponibles
    private static final int NOMBRE_TOTAL_ONGLETS = 2;

    // Index des onglets pour rendre le code plus lisible (plus "humain")
    public static final int ONGLET_DISTANCE = 0;
    public static final int ONGLET_TEMPERATURE = 1;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Selon la position de l'onglet, on affiche le fragment correspondant
        switch (position) {
            case ONGLET_DISTANCE:
                return new DistanceFragment();

            case ONGLET_TEMPERATURE:
                return new TempFragment();

            default:
                // Par sécurité, on retourne le premier fragment par défaut
                return new DistanceFragment();
        }
    }

    @Override
    public int getItemCount() {
        // Retourne le nombre total d'onglets à afficher
        return NOMBRE_TOTAL_ONGLETS;
    }
}