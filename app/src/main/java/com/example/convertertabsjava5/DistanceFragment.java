package com.example.convertertabsjava5;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    // Variables avec noms explicites
    private RadioGroup groupeOptionsDistance;
    private RadioButton boutonKmVersMiles;
    private EditText champSaisieValeur;
    private Button boutonCalculer;
    private TextView texteResultat;

    // Utilisation d'une constante pour la précision
    private static final double TAUX_KM_VERS_MILES = 0.621371;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Gonflage de la vue
        View vueFragment = inflater.inflate(R.layout.fragment_distance, container, false);

        // LIAISON AVEC LE XML (Vérifiez bien que ces IDs existent dans votre fragment_distance.xml)
        groupeOptionsDistance = vueFragment.findViewById(R.id.groupeConversionDistance);
        boutonKmVersMiles = vueFragment.findViewById(R.id.radioKmVersMiles);
        champSaisieValeur = vueFragment.findViewById(R.id.champSaisieDistance);
        boutonCalculer = vueFragment.findViewById(R.id.boutonCalculerDistance);
        texteResultat = vueFragment.findViewById(R.id.affichageResultatDistance);

        // Écouteur de clic
        boutonCalculer.setOnClickListener(v -> calculerLaDistance());

        return vueFragment;
    }

    private void calculerLaDistance() {
        String texteSaisi = champSaisieValeur.getText().toString().trim();

        // 1. Vérification de sécurité : champ vide
        if (TextUtils.isEmpty(texteSaisi)) {
            Toast.makeText(getContext(), "Veuillez entrer un nombre", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double valeurSaisie = Double.parseDouble(texteSaisi);
            double resultatFinal;
            String uniteFinale;

            // 2. Logique de conversion selon le bouton coché
            if (boutonKmVersMiles.isChecked()) {
                resultatFinal = valeurSaisie * TAUX_KM_VERS_MILES;
                uniteFinale = " miles";
            } else {
                resultatFinal = valeurSaisie / TAUX_KM_VERS_MILES;
                uniteFinale = " km";
            }

            // 3. Formatage du résultat (2 chiffres après la virgule)
            String resultatTexte = String.format("%.2f", resultatFinal);
            texteResultat.setText("Résultat : " + resultatTexte + uniteFinale);

        } catch (NumberFormatException e) {
            // 4. Sécurité : si l'utilisateur a réussi à entrer autre chose qu'un nombre
            Toast.makeText(getContext(), "Saisie invalide", Toast.LENGTH_SHORT).show();
        }
    }
}