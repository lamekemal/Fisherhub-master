package daraunited.com.fisherinnovapps;

import android.os.Build;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class Costeval extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costeval);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryReds));
        }
        final EditText TMAIS = (EditText) findViewById(R.id.TxDAYNUM);
        final SeekBar SMAIS = (SeekBar) findViewById(R.id.SMAIS);
        TMAIS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)  {
                try {
                    EditText TMAIS = (EditText) findViewById(R.id.TxDAYNUM);
                    SeekBar SMAIS = (SeekBar) findViewById(R.id.SMAIS);
                    String varsx = TMAIS.getText().toString();
                    SMAIS.setMax(360);
                    SMAIS.setProgress(Integer.parseInt(varsx));
                } catch (Exception e) {

                }}

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        SMAIS.setMax(360);
        SMAIS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                EditText TMAIS = (EditText) findViewById(R.id.TxDAYNUM);
                SeekBar SMAIS = (SeekBar) findViewById(R.id.SMAIS);
                TMAIS.setText(Integer.toString(progress));
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relcalc();
            }
        });
    }

    public  void relcalc(){
        EditText TMAIS = (EditText) findViewById(R.id.TxDAYNUM);
        EditText TMAISef = (EditText) findViewById(R.id.TxNUMBER);
        EditText TMAISpx =(EditText) findViewById(R.id.TxPNBUM);
        TextView TMVIEW = (TextView) findViewById(R.id.textView4cr);
        TextView TRVIEW = (TextView) findViewById(R.id.textView4crd);
        String varsjr = TMAIS.getText().toString();
        String varsef = TMAISef.getText().toString();
        String varspx = TMAISpx.getText().toString();
        double varfinalpv;
        long varpvf = 0;
        long cvvv = 0;
        long lvvv = 0;
        try {
            //double pvxa = Integer.valueOf(varspx) * (((1800 - Integer.valueOf(varspx))/1800) * Integer.valueOf(varspx));
            double pvxb = Integer.valueOf(varspx) *1.4;
            double pvxc = (Integer.valueOf(varspx) * 1800)/1000;
            double dddf = (( 5.5 * Integer.valueOf(varsjr))/1000) * Integer.valueOf(varsef);
            cvvv = Math.round(dddf);
            varfinalpv = (pvxc+pvxb) /2; // + pvxb +pvxc
            varpvf = Math.round(varfinalpv);
            lvvv =  Math.round(varfinalpv * dddf);
        } catch (NumberFormatException e) {
            varfinalpv = 0;
        }
        String varfinalastr = "Le prix de vente recommandé pour un poisson est de : "+ "\n" + varpvf + "F CFA";
        String varfinalstr = "Au bout de " + varsjr + " Jours, on auras un besoin total en aliment de:" + "\n" + String.valueOf(cvvv)
                + " Kg" + "\n" + "Soit une dépense d'alimentation total de:"+ "\n" + lvvv + "F CFA";
        TMVIEW.setText(varfinalastr);
        TRVIEW.setText(varfinalstr);
    }

}
