package daraunited.com.fisherinnovapps;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.PublicKey;

public class Calkpage extends AppCompatActivity {
    double shardemaxvalue;
    String[] foodsummary = new String[50];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calkpage);
        attriblist();
        //final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        VariableAttribListe(R.id.TMAIS,R.id.SMAIS);
        VariableAttribListe(R.id.TCMAC,R.id.SCMAC);
        VariableAttribListe(R.id.TBLE,R.id.SBLE);
        VariableAttribListe(R.id.TSOJA,R.id.SSOJA);
        VariableAttribListe(R.id.TCOTON,R.id.SCOTON);
        VariableAttribListe(R.id.TDRE,R.id.SDRE);
        VariableAttribListe(R.id.TPAL,R.id.SPAL);
        VariableAttribListe(R.id.TARA,R.id.SARA);
        VariableAttribListe(R.id.TFPO,R.id.SFPO);
        VariableAttribListe(R.id.THR,R.id.SHR);
        VariableAttribListe(R.id.TCH,R.id.SCH);
        VariableAttribListe(R.id.TLYS,R.id.SLYS);
        VariableAttribListe(R.id.TMET,R.id.SMET);
        VariableAttribListe(R.id.TPHB,R.id.SPHB);
        VariableAttribListe(R.id.TSEL,R.id.SSEL);
        VariableAttribListe(R.id.TPRMX,R.id.SPRMX);
        VariableAttribListe(R.id.TSFER,R.id.SSFER);
        VariableAttribListe(R.id.TCPONT,R.id.SCPONT);
        VariableAttribListe(R.id.TCCHAIR,R.id.SCCHAIR);
        VariableAttribListe(R.id.TSOJAG,R.id.SSOJAG);
        VariableAttribListe(R.id.TSMAIS,R.id.SSMAIS);
        VariableAttribListe(R.id.TSRIZ,R.id.SSRIZ);
        VariableAttribListe(R.id.TMOR,R.id.MOR);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryReds));
        }
       /*setToNull(R.id.TMAIS);
        setToNull(R.id.TCMAC);
        setToNull(R.id.TBLE);
        setToNull(R.id.TDRE);
        setToNull(R.id.TSOJA);
        setToNull(R.id.TCOTON);
        setToNull(R.id.TPAL);
        setToNull(R.id.TARA);
        setToNull(R.id.TFPO);
        setToNull(R.id.THR);
        setToNull(R.id.TCH);
        setToNull(R.id.TLYS);
        setToNull(R.id.TMET);
        setToNull(R.id.TPHB);
        setToNull(R.id.TSEL);
        setToNull(R.id.TPRMX);
        setToNull(R.id.TSFER);
        setToNull(R.id.TCPONT);
        setToNull(R.id.TCCHAIR);
        setToNull(R.id.TSOJAG);
        setToNull(R.id.TSMAIS);
        setToNull(R.id.TSRIZ);
        setToNull(R.id.TMOR);*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), MainCommande.class);
                //startActivityForResult(myIntent, 0);
                Snackbar.make(view, "Fonctionnalité désactivée, attendez la mise à jour ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fabx = (FloatingActionButton) findViewById(R.id.floatingActionB);
        fabx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), MainAnalyse.class);
                Bundle ePzl= new Bundle();
                ePzl.putStringArray("FOODSUMMARY", foodsummary);
                myIntent.putExtras(ePzl);
                startActivity(myIntent);

            }
        });
    }
    public void attriblist(){
        EditText TMAIS = (EditText) findViewById(R.id.TMAIS);
        TMAIS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)  {
                try {
                    EditText TMAIS = (EditText) findViewById(R.id.TMAIS);
                    SeekBar SMAIS = (SeekBar) findViewById(R.id.SMAIS);
                    String varsx = TMAIS.getText().toString();
                    SMAIS.setMax(100);
                    EMCalc();
                    SMAIS.setProgress(Integer.parseInt(varsx));
                } catch (Exception e) {
                    EditText TMAIS = (EditText) findViewById(R.id.TMAIS);
                    TMAIS.setText("0");
                }}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        SeekBar SMAIS = (SeekBar) findViewById(R.id.SMAIS);
        SMAIS.setMax(100);
        SMAIS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                SeekBar SMAIS = (SeekBar) findViewById(R.id.SMAIS);
                EditText TMAIS = (EditText) findViewById(R.id.TMAIS);
                TMAIS.setText(Integer.toString(progress));
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void VariableAttribListe(final Integer IDTEXT, final Integer IDSEEK){
        final EditText TMAIS = (EditText) findViewById(IDTEXT);
        final SeekBar SMAIS = (SeekBar) findViewById(IDSEEK);

        TMAIS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)  {
                try {
                    EditText TMAIS = (EditText) findViewById(IDTEXT);
                    SeekBar SMAIS = (SeekBar) findViewById(IDSEEK);
                    String varsx = TMAIS.getText().toString();
                    SMAIS.setMax(100);
                    SMAIS.setProgress(Integer.parseInt(varsx));
                    EMCalc();
                } catch (Exception e) {
                    EditText TMAIS = (EditText) findViewById(IDTEXT);
                    TMAIS.setText("0");
                }}
            int i = 0;
            @Override
            public void afterTextChanged(Editable editable) {
                if (shardemaxvalue > 100){
                    VariableAttribProp(R.id.TMAIS,R.id.SMAIS);
                    VariableAttribProp(R.id.TCMAC,R.id.SCMAC);
                    VariableAttribProp(R.id.TBLE,R.id.SBLE);
                    VariableAttribProp(R.id.TSOJA,R.id.SSOJA);
                    VariableAttribProp(R.id.TCOTON,R.id.SCOTON);
                    VariableAttribProp(R.id.TDRE,R.id.SDRE);
                    VariableAttribProp(R.id.TPAL,R.id.SPAL);
                    VariableAttribProp(R.id.TARA,R.id.SARA);
                    VariableAttribProp(R.id.TFPO,R.id.SFPO);
                    VariableAttribProp(R.id.THR,R.id.SHR);
                    VariableAttribProp(R.id.TCH,R.id.SCH);
                    VariableAttribProp(R.id.TLYS,R.id.SLYS);
                    VariableAttribProp(R.id.TMET,R.id.SMET);
                    VariableAttribProp(R.id.TPHB,R.id.SPHB);
                    VariableAttribProp(R.id.TSEL,R.id.SSEL);
                    VariableAttribProp(R.id.TPRMX,R.id.SPRMX);
                    VariableAttribProp(R.id.TSFER,R.id.SSFER);
                    VariableAttribProp(R.id.TCPONT,R.id.SCPONT);
                    VariableAttribProp(R.id.TCCHAIR,R.id.SCCHAIR);
                    VariableAttribProp(R.id.TSOJAG,R.id.SSOJAG);
                    VariableAttribProp(R.id.TSMAIS,R.id.SSMAIS);
                    VariableAttribProp(R.id.TSRIZ,R.id.SSRIZ);
                    VariableAttribProp(R.id.TMOR,R.id.MOR);
                    TMAIS.setEnabled(true);
                    SMAIS.setEnabled(true);

                    if (i < 1){
                        Toast.makeText(getBaseContext(),"Maximum atteint ", Toast.LENGTH_LONG).show();
                        i= i+1;
                    }

                }else {
                    VariableAttribNegativeProp(R.id.TMAIS,R.id.SMAIS);
                    VariableAttribNegativeProp(R.id.TCMAC,R.id.SCMAC);
                    VariableAttribNegativeProp(R.id.TBLE,R.id.SBLE);
                    VariableAttribNegativeProp(R.id.TSOJA,R.id.SSOJA);
                    VariableAttribNegativeProp(R.id.TCOTON,R.id.SCOTON);
                    VariableAttribNegativeProp(R.id.TDRE,R.id.SDRE);
                    VariableAttribNegativeProp(R.id.TPAL,R.id.SPAL);
                    VariableAttribNegativeProp(R.id.TARA,R.id.SARA);
                    VariableAttribNegativeProp(R.id.TFPO,R.id.SFPO);
                    VariableAttribNegativeProp(R.id.THR,R.id.SHR);
                    VariableAttribNegativeProp(R.id.TCH,R.id.SCH);
                    VariableAttribNegativeProp(R.id.TLYS,R.id.SLYS);
                    VariableAttribNegativeProp(R.id.TMET,R.id.SMET);
                    VariableAttribNegativeProp(R.id.TPHB,R.id.SPHB);
                    VariableAttribNegativeProp(R.id.TSEL,R.id.SSEL);
                    VariableAttribNegativeProp(R.id.TPRMX,R.id.SPRMX);
                    VariableAttribNegativeProp(R.id.TSFER,R.id.SSFER);
                    VariableAttribNegativeProp(R.id.TCPONT,R.id.SCPONT);
                    VariableAttribNegativeProp(R.id.TCCHAIR,R.id.SCCHAIR);
                    VariableAttribNegativeProp(R.id.TSOJAG,R.id.SSOJAG);
                    VariableAttribNegativeProp(R.id.TSMAIS,R.id.SSMAIS);
                    VariableAttribNegativeProp(R.id.TSRIZ,R.id.SSRIZ);
                    VariableAttribNegativeProp(R.id.TMOR,R.id.MOR);
                    i = 0;
                }
            }
        });

        SMAIS.setMax(100);
        SMAIS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                SeekBar SMAIS = (SeekBar) findViewById(IDSEEK);
                EditText TMAIS = (EditText) findViewById(IDTEXT);
                TMAIS.setText(Integer.toString(progress));
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    Integer getIntFromMyctrl(Integer VARIABLE){
        EditText TCMAC = (EditText) findViewById(VARIABLE);
        String varsx = TCMAC.getText().toString();
        int dara = Integer.parseInt(varsx);
        return dara;
    }

    public void VariableAttribProp(final Integer IDTEXT, final Integer IDSEEK){
        EditText TMAIS = (EditText) findViewById(IDTEXT);
        SeekBar SMAIS = (SeekBar) findViewById(IDSEEK);
        TMAIS.setEnabled(false);
        SMAIS.setEnabled(false);
    }
    public void VariableAttribNegativeProp(final Integer IDTEXT, final Integer IDSEEK){
        EditText TMAIS = (EditText) findViewById(IDTEXT);
        SeekBar SMAIS = (SeekBar) findViewById(IDSEEK);
        TMAIS.setEnabled(true);
        SMAIS.setEnabled(true);
    }
    public void setToNull(Integer VARIABLE){
        EditText TMAIS = (EditText) findViewById(VARIABLE);
        TMAIS.setText("0");
    }
    public void VariableAttribListeFixit(final Integer IDTEXT, final Integer IDSEEK){
        EditText TMAIS = (EditText) findViewById(IDTEXT);
        TMAIS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)  {
                EditText TMAIS = (EditText) findViewById(IDTEXT);
                if (TMAIS.getText().toString() == "")
                {

                }else
                {
                    SeekBar SMAIS = (SeekBar) findViewById(IDSEEK);
                    String varsx = TMAIS.getText().toString();
                    SMAIS.setMax(100);
                    SMAIS.setProgress(Integer.parseInt(varsx));
                }}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        SeekBar SMAIS = (SeekBar) findViewById(IDSEEK);
        SMAIS.setMax(100);
        SMAIS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                SeekBar SMAIS = (SeekBar) findViewById(IDSEEK);
                EditText TMAIS = (EditText) findViewById(IDTEXT);
                TMAIS.setText(Integer.toString(progress));
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    public void EMCalc (){
        EditText TMAIS = (EditText) findViewById(R.id.TMAIS);
        int mais = getIntFromMyctrl(R.id.TMAIS);
        int cmac = getIntFromMyctrl(R.id.TCMAC);
        int ble = getIntFromMyctrl(R.id.TBLE);
        int dre = getIntFromMyctrl(R.id.TDRE);
        int soja = getIntFromMyctrl(R.id.TSOJA);
        int coton = getIntFromMyctrl(R.id.TCOTON);
        int pal = getIntFromMyctrl(R.id.TPAL);
        int ara = getIntFromMyctrl(R.id.TARA);
        int fpo = getIntFromMyctrl(R.id.TFPO);
        int thr = getIntFromMyctrl(R.id.THR);
        int tch = getIntFromMyctrl(R.id.TCH);
        int lys = getIntFromMyctrl(R.id.TLYS);
        int met = getIntFromMyctrl(R.id.TMET);
        int phb = getIntFromMyctrl(R.id.TPHB);
        int sel = getIntFromMyctrl(R.id.TSEL);
        int pemx = getIntFromMyctrl(R.id.TPRMX);
        int sfer = getIntFromMyctrl(R.id.TSFER);
        int cpont = getIntFromMyctrl(R.id.TCPONT);
        int cchair = getIntFromMyctrl(R.id.TCCHAIR);
        int qqojag = getIntFromMyctrl(R.id.TSOJAG);
        int smais = getIntFromMyctrl(R.id.TSMAIS);
        int sriz = getIntFromMyctrl(R.id.TSRIZ);
        int mor = getIntFromMyctrl(R.id.TMOR);
        //calcul dem
        double finalEM=((mais*3300)/100) +((ble*1440)/100) +((dre*2400)/100) +
               ((cmac*2900)/100) +((soja*2420)/100) +((coton*1945)/100) +((pal*1240)/100) +
               ((ara*2825)/100) +((fpo*2200)/100) +((thr*9000)/100) +((tch*0)/100) +
               ((lys*3870)/100) +((met*4950)/100) +((phb*0)/100) +((sel*0)/100) +
               ((qqojag*3900)/100) +((smais*2228)/100) +((cpont*0)/100) +((cchair*0)/100) +
               ((sfer*0)/100) +((pemx*0)/100) +((sriz*2950)/100) +((mor*1100)/100);

        //calcul PB
        double finalPB =((mais*8.5)/100) +((ble*14)/100) +((dre*25)/100) +
                ((cmac*2.2)/100) +((soja*43)/100) +((coton*41)/100) +((pal*16)/100) +
                ((ara*49)/100) +((fpo*46)/100) +((thr*0)/100) +((tch*0)/100) +
                ((lys*95.6)/100) +((met*58.7)/100) +((phb*0)/100) +((sel*0)/100) +
                ((qqojag*37)/100) +((smais*10)/100) +((cpont*45)/100) +((cchair*0)/100) +
                ((sfer*0)/100) +((pemx*0)/100) +((sriz*13)/100) +((mor*24)/100);

        //calcul cellulose
        double finalCELL =((mais*2.2)/100) +((ble*9.6)/100) +((dre*15.3)/100) +
                ((cmac*3)/100) +((soja*7.4)/100) +((coton*13)/100) +((pal*15)/100) +
                ((ara*10)/100) +((fpo*0)/100) +((thr*0)/100) +((tch*0)/100) +
                ((lys*0)/100) +((met*0)/100) +((phb*0)/100) +((sel*0)/100) +
                ((qqojag*6)/100) +((smais*9)/100) +((cpont*0)/100) +((cchair*0)/100) +
                ((sfer*0)/100) +((pemx*0)/100) +((sriz*12)/100) +((mor*19.63)/100);

        //calcul Pho
        double finalPho =((mais*0.3)/100) +((ble*0.15)/100) +((dre*1.3)/100) +
                ((cmac*0.5)/100) +((soja*0.7)/100) +((coton*1)/100) +((pal*0.6)/100) +
                ((ara*0.6)/100) +((fpo*2.6)/100) +((thr*0)/100) +((tch*0.05)/100) +
                ((lys*0)/100) +((met*0)/100) +((phb*18)/100) +((sel*0)/100) +
                ((qqojag*6)/100) +((smais*0.23)/100) +((cpont*4.5)/100) +((cchair*0)/100) +
                ((sfer*0)/100) +((pemx*0)/100) +((sriz*1.4)/100) +((mor*0.5)/100);

        //calcul CA
        double finalCA =((mais*0.02)/100) +((ble*0.2)/100) +((dre*0.14)/100) +
                ((cmac*0.3)/100) +((soja*0.34)/100) +((coton*0.2)/100) +((pal*0.3)/100) +
                ((ara*0.16)/100) +((fpo*5)/100) +((thr*0)/100) +((tch* 38)/100) +
                ((lys*0.04)/100) +((met*0.02)/100) +((phb*18)/100) +((sel*0)/100) +
                ((qqojag*0.25)/100) +((smais*0.03)/100) +((cpont*4.5)/100) +((cchair*0)/100) +
                ((sfer*0)/100) +((pemx*0)/100) +((sriz*1.4)/100) +((mor*0.4)/100);

        //calcul price
        double finalPRICE=((mais*250)/100) +((ble*200)/100) +((dre*300)/100) +
                ((cmac*150)/100) +((soja*450)/100) +((coton*300)/100) +((pal*190)/100) +
                ((ara*170)/100) +((fpo*310)/100) +((thr*600)/100) +((tch*100)/100) +
                ((lys*2500)/100) +((met*4600)/100) +((phb*700)/100) +((sel*50)/100) +
                ((qqojag*400)/100) +((smais*180)/100) +((cpont*700)/100) +((cchair*700)/100) +
                ((sfer*700)/100) +((pemx*700)/100) +((sriz*100)/100) +((mor*170)/100);
        TextView PRESENTX = (TextView) findViewById(R.id.textView3);
        PRESENTX.setText( String.valueOf(Math.round(finalPRICE)) + "F CFA");

        //calculdu pourcentage totalattein au cour du dosage
        double finalTotalMax = (mais + cmac + ble + dre + soja + coton + pal + ara +
                fpo + thr + tch + lys + met + phb + sel + pemx + sfer + cpont + cchair +
                qqojag + smais + sriz + mor);
        shardemaxvalue = finalTotalMax;

        //attrtipbe var String[]
        foodsummary[1] = Integer.toString(mais);
        foodsummary[2] = Integer.toString(cmac);
        foodsummary[3] = Integer.toString(ble);
        foodsummary[4] = Integer.toString(dre);
        foodsummary[5] = Integer.toString(soja);
        foodsummary[6] = Integer.toString(coton);
        foodsummary[7] = Integer.toString(pal);
        foodsummary[8] = Integer.toString(ara);
        foodsummary[9] = Integer.toString(fpo);
        foodsummary[10] = Integer.toString(thr);
        foodsummary[11] = Integer.toString(tch);
        foodsummary[12] = Integer.toString(lys);
        foodsummary[13] = Integer.toString(met);
        foodsummary[14] = Integer.toString(phb);
        foodsummary[15] = Integer.toString(sel);
        foodsummary[16] = Integer.toString(pemx);
        foodsummary[17] = Integer.toString(sfer);
        foodsummary[18] = Integer.toString(cpont);
        foodsummary[19] = Integer.toString(cchair);
        foodsummary[20] = Integer.toString(qqojag);
        foodsummary[21] = Integer.toString(smais);
        foodsummary[22] = Integer.toString(sriz);
        foodsummary[23] = Integer.toString(mor);
            //add caloculated data
        foodsummary[24] = Double.toString(finalEM);
        foodsummary[25] = Double.toString(finalPB);
        foodsummary[26] = Double.toString(finalPRICE);
        foodsummary[27] = Double.toString(finalTotalMax);
        foodsummary[28] = Double.toString(finalCELL);
        foodsummary[29] = Double.toString(finalPho);
        foodsummary[30] = Double.toString(finalCA);

        TextView PRESENT = (TextView) findViewById(R.id.textView2);
        PRESENT.setText("EM : " + String.valueOf(finalEM) + " █ " + "PB : "+ String.valueOf(round2(finalPB)) + " █ Sur " + finalTotalMax + "%");
    }
     Double round2(Double val) {
        return new BigDecimal(val.toString()).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
