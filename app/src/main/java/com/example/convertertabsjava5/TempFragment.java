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

public class TempFragment extends Fragment {

    // Noms de variables clairs et humains
    private RadioGroup groupeOptionsTemp;
    private RadioButton boutonCelsiusVersFahr;
    private EditText champSaisieTemperature;
    private Button boutonCalculer;
    private TextView texteResultat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // On gonfle la vue à partir du layout XML
        View vueFragment = inflater.inflate(R.layout.fragment_temp, container, false);

        // LIAISON AVEC LE XML (Utilisation des nouveaux IDs humanisés)
        groupeOptionsTemp = vueFragment.findViewById(R.id.groupeConversionTemp);
        boutonCelsiusVersFahr = vueFragment.findViewById(R.id.radioCelsiusVersFahr);
        champSaisieTemperature = vueFragment.findViewById(R.id.champSaisieTemperature);
        boutonCalculer = vueFragment.findViewById(R.id.boutonCalculerTemp);
        texteResultat = vueFragment.findViewById(R.id.affichageResultatTemp);

        // Action lors du clic sur le bouton
        boutonCalculer.setOnClickListener(v -> effectuerLaConversion());

        return vueFragment;
    }

    /**
     * Méthode pour gérer la logique de conversion de température
     */
    private void effectuerLaConversion() {
        String texteSaisi = champSaisieTemperature.getText().toString().trim();

        // 1. Vérification si le champ est vide
        if (TextUtils.isEmpty(texteSaisi)) {
            Toast.makeText(getContext(), "Veuillez entrer une température", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double valeurInitiale = Double.parseDouble(texteSaisi);
            double resultat;
            String uniteSymbole;

            // 2. Choix de la formule selon l'option sélectionnée
            if (boutonCelsiusVersFahr.isChecked()) {
                // Celsius vers Fahrenheit : (C * 9/5) + 32
                resultat = (valeurInitiale * 9.0 / 5.0) + 32;
                uniteSymbole = " °F";
            } else {
                // Fahrenheit vers Celsius : (F - 32) * 5/9
                resultat = (valeurInitiale - 32) * 5.0 / 9.0;
                uniteSymbole = " °C";
            }

            // 3. Affichage du résultat formaté à 1 chiffre après la virgule
            String resultatFormate = String.format("%.1f", resultat);
            texteResultat.setText("Température : " + resultatFormate + uniteSymbole);

        } catch (NumberFormatException e) {
            // 4. Gestion d'erreur si la saisie n'est pas un nombre valide
            Toast.makeText(getContext(), "Erreur : saisie numérique invalide", Toast.LENGTH_SHORT).show();
        }
    }
}