package fr.iutrodez.ongletdatepicker.affichagebasique;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.affichagebasique.R;

public class FragmentEcart extends Fragment implements View.OnClickListener {

    /** Zone qui affiche le jour de la semaine associé à la date saisie */
    private TextView zoneResultat;

    private DatePicker date1Picker, date2Picker;

    public FragmentEcart() {

    }

    public static FragmentEcart newInstance() {
        FragmentEcart fragment = new FragmentEcart();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vueDuFragment = inflater.inflate(R.layout.fragment_ecart, container, false);

        vueDuFragment.findViewById(R.id.btn_ecart_date).setOnClickListener(this);

        date1Picker = vueDuFragment.findViewById(R.id.selecteurDate1);
        date2Picker = vueDuFragment.findViewById(R.id.selecteurDate2);
        zoneResultat  = vueDuFragment.findViewById(R.id.resultat_ecart);
        return vueDuFragment;
    }

    @Override
    public void onClick(View v) {
        int jour1 = date1Picker.getDayOfMonth();
        int mois1 = date1Picker.getMonth()+1;
        int an1 = date1Picker.getYear();

        int jour2 = date2Picker.getDayOfMonth();
        int mois2 = date2Picker.getMonth()+1;
        int an2 = date2Picker.getYear();

        String resultat = Integer.toString(OutilDate.ecartDate(jour1, mois1, an1, jour2, mois2, an2));
        zoneResultat.setText(resultat + getResources().getString(R.string.resultat_ecart));
    }

    public void razResultat() {
        zoneResultat.setText("");
    }
}
