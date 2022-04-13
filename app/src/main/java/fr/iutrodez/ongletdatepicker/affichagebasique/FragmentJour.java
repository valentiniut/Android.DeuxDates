package fr.iutrodez.ongletdatepicker.affichagebasique;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.affichagebasique.R;

public class FragmentJour extends Fragment implements View.OnClickListener {

    /** Zone qui affiche le jour de la semaine associé à la date saisie */
    private TextView zoneResultat;

    private DatePicker datePicker;

    public FragmentJour() {

    }

    public static FragmentJour newInstance() {
        FragmentJour fragment = new FragmentJour();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vueDuFragment = inflater.inflate(R.layout.fragment_jour, container, false);

        vueDuFragment.findViewById(R.id.btn_rechercher_jour).setOnClickListener(this);

        datePicker = vueDuFragment.findViewById(R.id.selecteurDate);
        zoneResultat  = vueDuFragment.findViewById(R.id.resultat_jour);
        return vueDuFragment;
    }

    @Override
    public void onClick(View v) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth()+1;
        int year = datePicker.getYear();
        zoneResultat.setText("Le jour de la semaine est "+OutilDate.jourSemaine(day, month, year));
    }

    public void razResultat() {
        zoneResultat.setText("");
    }
}
