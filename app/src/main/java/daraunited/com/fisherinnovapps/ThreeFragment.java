package daraunited.com.fisherinnovapps;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class ThreeFragment extends Fragment{
     static WebView myWebViewEx;
    boolean isnotfarmer = true;
    private PrefManager prefManager;
    int sday, smonth,syear;
    public ThreeFragment() {
        // Required empty public constructor
    }
    //private TextView mTextMessage;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_three, container, false);
        //prefManager = new PrefManager(this);
        prefManager = new PrefManager(getActivity().getApplicationContext());
        //mTextMessage = (TextView) v.findViewById(R.id.message);
        isnotfarmer = prefManager.pref.getBoolean("isnotfarmer",true);
        final LinearLayout lineo = (LinearLayout) v.findViewById(R.id.lynho);
        final LinearLayout rineo = (LinearLayout) v.findViewById(R.id.lynda);
        final LinearLayout  mineo= (LinearLayout) v.findViewById(R.id.lynfi);
        final LinearLayout startlineo = (LinearLayout) v.findViewById(R.id.startlynho);
        final CalendarView prinpcalendar = (CalendarView) v.findViewById(R.id.calendarView);
        final TextView textfocus = (TextView) v.findViewById(R.id.eledate);

        final  TextView textqap = (TextView) v.findViewById(R.id.count);
        final  TextView textqat = (TextView) v.findViewById(R.id.countone);
        final  TextView textppp = (TextView) v.findViewById(R.id.countwo);
        final  CardView cardlite = (CardView) v.findViewById(R.id.card_view_two_bgk);
        final  ImageView imagelite = (ImageView) v.findViewById(R.id.thumbnailoneap);
        final  EditText textgram = (EditText) v.findViewById(R.id.Txgrm);
        final  EditText textnpo = (EditText) v.findViewById(R.id.Txnpo);
        imagelite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefManager.MyPrefEditor();
                isnotfarmer = true;
                editor.putBoolean("isnotfarmer",true);
                editor.apply();
                startlineo.setVisibility(getView().VISIBLE);
                lineo.setVisibility(getView().INVISIBLE);
            }
        });
        cardlite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefManager.MyPrefEditor();
                isnotfarmer = true;
                editor.putBoolean("isnotfarmer",true);
                editor.apply();
                startlineo.setVisibility(getView().VISIBLE);
                lineo.setVisibility(getView().INVISIBLE);
            }
        });

        textfocus.setOnClickListener(new View.OnClickListener() {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textfocus.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        sday =dayOfMonth;
                        smonth=monthOfYear;
                        syear=year;
                    }
                }, mYear, mMonth, mDay);
                dpd.show();

            }
        });
        prinpcalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                long CalendarData = prefManager.pref.getLong("dayinitialised",0);
                Calendar celc = Calendar.getInstance();
                celc.set(year, month,dayOfMonth);
                long timediff =  celc.getTimeInMillis() - CalendarData;
                long daypassed =  (timediff / (24*60*60*1000)) + 1;
                double biomassainit = Double.valueOf(prefManager.pref.getString("biomassainit","0"));
                double nombredepoiss = Double.valueOf(prefManager.pref.getString("nombredepoisson","0"));
                double poidsfinal;
                if (daypassed == 1){
                    poidsfinal = biomassainit;
                }else {
                    poidsfinal = poidsdelevage(daypassed,biomassainit);
                }
                double Ratio = 0.03;
                double qtealimpoi = poidsfinal * Ratio;
                java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
                textqap.setText(df.format(qtealimpoi) + " g");
                textqat.setText(df.format((qtealimpoi * nombredepoiss)/1000) + " Kg");
                textppp.setText(df.format(poidsfinal) + " g");
            }
        });

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startlineo.setVisibility(getView().INVISIBLE);
                lineo.setVisibility(getView().VISIBLE);
                isnotfarmer = false;
                Calendar cec = Calendar.getInstance();
                cec.set(syear, smonth,sday);
                prinpcalendar.setMinDate(cec.getTimeInMillis());
                long timediff =  prinpcalendar.getDate() - cec.getTimeInMillis();
                long daypassed =  (timediff / (24*60*60*1000)) + 1;

                if (textgram.getText().toString() != null){
                    double biomassainit = Double.valueOf(textgram.getText().toString());
                    double poidsfinal;
                    if (daypassed == 1){
                        poidsfinal = biomassainit;
                    }else {
                        poidsfinal = poidsdelevage(daypassed,biomassainit);
                    }
                    double Ratio = 0.03;
                    double qtealimpoi = poidsfinal * Ratio;
                    java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
                    textqap.setText(df.format(qtealimpoi) + " g");
                    textqat.setText(df.format((qtealimpoi * Double.valueOf(textnpo.getText().toString()))/1000) + " Kg");
                    textppp.setText(df.format(poidsfinal) + " g");
                    SharedPreferences.Editor editor = prefManager.MyPrefEditor();
                    editor.putBoolean("isnotfarmer",false);
                    editor.putLong("dayinitialised",cec.getTimeInMillis());
                    editor.putString("biomassainit",String.valueOf(biomassainit));
                    editor.putString("nombredepoisson",String.valueOf(Double.valueOf(textnpo.getText().toString())));
                    editor.apply();
                }
            }
        });
        FloatingActionButton faby = (FloatingActionButton) v.findViewById(R.id.floatingActionButyton);
        faby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Fonctionnalité désactivée, attendez la mise à jour ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        lineo.setVisibility(getView().INVISIBLE);
        //startlineo.setVisibility(getView().INVISIBLE);
        if (isnotfarmer){
            startlineo.setVisibility(getView().VISIBLE);
        }else {
            lineo.setVisibility(getView().VISIBLE);
        }

        if (!prefManager.pref.getBoolean("isnotfarmer",true)){
            startlineo.setVisibility(getView().INVISIBLE);
            lineo.setVisibility(getView().VISIBLE);
            long CalendarData = prefManager.pref.getLong("dayinitialised",0);
            prinpcalendar.setMinDate(CalendarData);
            long timediff =  prinpcalendar.getDate() - CalendarData;
            long daypassed =  (timediff / (24*60*60*1000)) + 1;
            double biomassainit = Double.valueOf(prefManager.pref.getString("biomassainit","0"));
            double nombredepoiss = Double.valueOf(prefManager.pref.getString("nombredepoisson","0"));
            double poidsfinal;
            if (daypassed == 1){
                poidsfinal = biomassainit;
            }else {
                poidsfinal = poidsdelevage(daypassed,biomassainit);
            }
            double Ratio = 0.03;
            double qtealimpoi = poidsfinal * Ratio;
            java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
            textqap.setText(df.format(qtealimpoi) + " g");
            textqat.setText(df.format((qtealimpoi * nombredepoiss)/1000) + " Kg");
            textppp.setText(df.format(poidsfinal) + " g");
        }
        mineo.setVisibility(getView().GONE);
        rineo.setVisibility(getView().GONE);
        BottomNavigationView navigation = (BottomNavigationView) v.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        //mTextMessage.setText(R.string.title_home);
                        if (isnotfarmer){
                            startlineo.setVisibility(getView().VISIBLE);
                        }else {
                            lineo.setVisibility(getView().VISIBLE);
                        }
                        mineo.setVisibility(getView().INVISIBLE);
                        rineo.setVisibility(getView().INVISIBLE);
                        return true;
                    case R.id.navigation_dashboard:
                        //mTextMessage.setText(R.string.title_dashboard);
                        startlineo.setVisibility(getView().INVISIBLE);
                        lineo.setVisibility(getView().INVISIBLE);
                        mineo.setVisibility(getView().VISIBLE);
                        rineo.setVisibility(getView().INVISIBLE);
                        return true;
                    case R.id.navigation_notifications:
                        //mTextMessage.setText(R.string.title_notifications);
                        startlineo.setVisibility(getView().INVISIBLE);
                        lineo.setVisibility(getView().INVISIBLE);
                        mineo.setVisibility(getView().INVISIBLE);
                        rineo.setVisibility(getView().VISIBLE);
                        return true;
                }
                return false;
            }

        });
        return v;

    }
    double poidsdelevage(double NombreJourElu,  double BiomassInitial){
        //calcul de du jour
        double BiomassI = BiomassInitial;
        double Ratio = 0.03;
        double poidsfi;
        double TValAliment = 0.82;
        int a =1;
        while (a < NombreJourElu){
            double poidsA=  BiomassI * Ratio;
            double alixa = poidsA * TValAliment;
            double poidsF;
            if (alixa < 7.0){
                poidsF = BiomassI + alixa;
            }else {
                poidsF = BiomassI + 7.0;
            }
            BiomassI = poidsF;
            a++;
        }
        poidsfi= BiomassI;
        return poidsfi;
    }
    public static void gobackforwbrowser(){

    }
    public static boolean cangobackforwbrowser(){
        return false;
    }

}
