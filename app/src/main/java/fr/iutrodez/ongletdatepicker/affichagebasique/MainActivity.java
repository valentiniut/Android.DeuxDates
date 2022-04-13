package fr.iutrodez.ongletdatepicker.affichagebasique;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.affichagebasique.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager2 gestionnairePagination = findViewById(R.id.activity_main_viewpager);
        TabLayout gestionnaireOnglet = findViewById(R.id.tab_layout);

        gestionnairePagination.setAdapter(new AdaptateurPage(this));

        final String[] titreOnglet = {getString(R.string.onglet_jour), getString(R.string.onglet_ecart)};

        new TabLayoutMediator(gestionnaireOnglet, gestionnairePagination,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(titreOnglet[position]);
                    }
                }).attach();

        gestionnaireOnglet.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    public void onTabSelected(TabLayout.Tab tab) {
                        /*
                         * On récupère le numéro du fragment courant
                         * La méthode getCurrrentItem renvoie le numéro (ou la position, conformément
                         * à ce qui a été fait dans la classe AdaptateurPage) du fragment
                         * actuellement affiché.
                         */
                        int numFragCourant = gestionnairePagination.getCurrentItem();
                        /*
                         * on réucpère le fragment courant (celui qui est affiché) à partir de
                         * son identifiant, grâce à la méthode findFragmentByTag
                         * Par convention, un identifiant de fragment est de la forme
                         * f suivi du numéro du fragment. Donc f0 ou f1, par exemple
                         */
                        Fragment courant =
                                getSupportFragmentManager().findFragmentByTag("f" +numFragCourant);
                         /*
                         * Il faut ensuite appliquer la méthode razResultat sur le fragment courant
                         * Au préalable, on convertit l'instance "courant" en FragmentJour ou
                         * FragmentEcart, selon le numéro du fragment courant
                         */
                        if (numFragCourant == 0) {
                            ((FragmentJour) courant).razResultat();
                        } else {
                            ((FragmentEcart) courant).razResultat();
                        }
                    }
                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        // ne rien faire
                    }
                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        // ne rien faire
                    }
                }
        );
    }
}