package daraunited.com.fisherinnovapps;

import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class MainAnalyse extends AppCompatActivity {
    String[] foodsummary = new String[50];
    CardView toolbacr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_analyse);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final CardView toolbacr = (CardView) findViewById(R.id.nescar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);
        Bundle p = getIntent().getExtras();
        foodsummary = p.getStringArray("FOODSUMMARY");
        try {
            AttribeVarListe(R.id.TMAIS,R.id.SMAIS,foodsummary[1]);
            AttribeVarListe(R.id.TCMAC,R.id.SCMAC,foodsummary[2]);
            AttribeVarListe(R.id.TBLE,R.id.SBLE,foodsummary[3]);
            AttribeVarListe(R.id.TSOJA,R.id.SSOJA,foodsummary[4]);
            AttribeVarListe(R.id.TCOTON,R.id.SCOTON,foodsummary[5]);
            AttribeVarListe(R.id.TDRE,R.id.SDRE,foodsummary[6]);
            AttribeVarListe(R.id.TPAL,R.id.SPAL,foodsummary[7]);
            AttribeVarListe(R.id.TARA,R.id.SARA,foodsummary[8]);
            AttribeVarListe(R.id.TFPO,R.id.SFPO,foodsummary[9]);
            AttribeVarListe(R.id.THR,R.id.SHR,foodsummary[10]);
            AttribeVarListe(R.id.TCH,R.id.SCH,foodsummary[11]);
            AttribeVarListe(R.id.TLYS,R.id.SLYS,foodsummary[12]);
            AttribeVarListe(R.id.TMET,R.id.SMET,foodsummary[13]);
            AttribeVarListe(R.id.TPHB,R.id.SPHB,foodsummary[14]);
            AttribeVarListe(R.id.TSEL,R.id.SSEL,foodsummary[15]);
            AttribeVarListe(R.id.TPRMX,R.id.SPRMX,foodsummary[16]);
            AttribeVarListe(R.id.TSFER,R.id.SSFER,foodsummary[17]);
            AttribeVarListe(R.id.TCPONT,R.id.SCPONT,foodsummary[18]);
            AttribeVarListe(R.id.TCCHAIR,R.id.SCCHAIR,foodsummary[19]);
            AttribeVarListe(R.id.TSOJAG,R.id.SSOJAG,foodsummary[20]);
            AttribeVarListe(R.id.TSMAIS,R.id.SSMAIS,foodsummary[21]);
            AttribeVarListe(R.id.TSRIZ,R.id.SSRIZ,foodsummary[22]);
            AttribeVarListe(R.id.TMOR,R.id.MOR,foodsummary[23]);

        /*AttribeVarBool(R.id.TMAIS,R.id.SMAIS);
        AttribeVarBool(R.id.TCMAC,R.id.SCMAC);
        AttribeVarBool(R.id.TBLE,R.id.SBLE);
        AttribeVarBool(R.id.TSOJA,R.id.SSOJA);
        AttribeVarBool(R.id.TCOTON,R.id.SCOTON);
        AttribeVarBool(R.id.TDRE,R.id.SDRE);
        AttribeVarBool(R.id.TPAL,R.id.SPAL);
        AttribeVarBool(R.id.TARA,R.id.SARA);
        AttribeVarBool(R.id.TFPO,R.id.SFPO);
        AttribeVarBool(R.id.THR,R.id.SHR);
        AttribeVarBool(R.id.TCH,R.id.SCH);
        AttribeVarBool(R.id.TLYS,R.id.SLYS);
        AttribeVarBool(R.id.TMET,R.id.SMET);
        AttribeVarBool(R.id.TPHB,R.id.SPHB);
        AttribeVarBool(R.id.TSEL,R.id.SSEL);
        AttribeVarBool(R.id.TPRMX,R.id.SPRMX);
        AttribeVarBool(R.id.TSFER,R.id.SSFER);
        AttribeVarBool(R.id.TCPONT,R.id.SCPONT);
        AttribeVarBool(R.id.TCCHAIR,R.id.SCCHAIR);
        AttribeVarBool(R.id.TSOJAG,R.id.SSOJAG);
        AttribeVarBool(R.id.TSMAIS,R.id.SSMAIS);
        AttribeVarBool(R.id.TSRIZ,R.id.SSRIZ);
        AttribeVarBool(R.id.TMOR,R.id.MOR);*/

            AttribeVarBool(R.id.LTxMAIS,R.id.TMAIS,R.id.SMAIS);
            AttribeVarBool(R.id.LTxCMAC,R.id.TCMAC,R.id.SCMAC);
            AttribeVarBool(R.id.LTxBLE,R.id.TBLE,R.id.SBLE);
            AttribeVarBool(R.id.LTxSOJA,R.id.TSOJA,R.id.SSOJA);
            AttribeVarBool(R.id.LTxCOTON,R.id.TCOTON,R.id.SCOTON);
            AttribeVarBool(R.id.LTxDRE,R.id.TDRE,R.id.SDRE);
            AttribeVarBool(R.id.LTxPAL,R.id.TPAL,R.id.SPAL);
            AttribeVarBool(R.id.LTxARA,R.id.TARA,R.id.SARA);
            AttribeVarBool(R.id.LTxFPO,R.id.TFPO,R.id.SFPO);
            AttribeVarBool(R.id.LTxHR,R.id.THR,R.id.SHR);
            AttribeVarBool(R.id.LTxCH,R.id.TCH,R.id.SCH);
            AttribeVarBool(R.id.LTxLYS,R.id.TLYS,R.id.SLYS);
            AttribeVarBool(R.id.LTxMET,R.id.TMET,R.id.SMET);
            AttribeVarBool(R.id.LTxPHB,R.id.TPHB,R.id.SPHB);
            AttribeVarBool(R.id.LTxSEL,R.id.TSEL,R.id.SSEL);
            AttribeVarBool(R.id.LTxPRMX,R.id.TPRMX,R.id.SPRMX);
            AttribeVarBool(R.id.LTxSFER,R.id.TSFER,R.id.SSFER);
            AttribeVarBool(R.id.LTxCPONT,R.id.TCPONT,R.id.SCPONT);
            AttribeVarBool(R.id.LTxCCHAIR,R.id.TCCHAIR,R.id.SCCHAIR);
            AttribeVarBool(R.id.LTxSOJAG,R.id.TSOJAG,R.id.SSOJAG);
            AttribeVarBool(R.id.LTxSMAIS,R.id.TSMAIS,R.id.SSMAIS);
            AttribeVarBool(R.id.LTxSRIZ,R.id.TSRIZ,R.id.SSRIZ);
            AttribeVarBool(R.id.LTxMOR,R.id.TMOR,R.id.MOR);

            AttribeResume(R.id.TEMET,foodsummary[24]);
            AttribeResume(R.id.TPRO,foodsummary[25]);
            AttribeResume(R.id.TPRIX,foodsummary[26]);
            AttribeResume(R.id.TCELL,foodsummary[28]);
            AttribeResume(R.id.TPHO,foodsummary[29]);
            AttribeResume(R.id.TCA,foodsummary[30]);
            AttribeGMQ(R.id.SGMQ, R.id.TGMQ,foodsummary[24],foodsummary[25]);
        } catch (Exception e) {
            Snackbar.make(findViewById(android.R.id.content), "Aucune donnée introduite.", Snackbar.LENGTH_LONG).show();
        }

    }
    public void AttribeVarool(final Integer IDTEXT, final Integer IDSEEK){
        final EditText TMAIS = (EditText) findViewById(IDTEXT);
        final ProgressBar SMAIS = (ProgressBar) findViewById(IDSEEK);

         if (TMAIS.toString() =="") {
             TMAIS.setVisibility(View.INVISIBLE);
             SMAIS.setVisibility(View.INVISIBLE);
         } else if (TMAIS.toString() =="0"){
             SMAIS.setVisibility(View.INVISIBLE);
             TMAIS.setVisibility(View.INVISIBLE);
         } else {
             TMAIS.setVisibility(View.VISIBLE);
             SMAIS.setVisibility(View.VISIBLE);
         }

    }

    public void AttribeVarBool(final Integer IDTITLE, final Integer IDTEXT, final Integer IDSEEK){
        final EditText TMAIS = (EditText) findViewById(IDTEXT);
        final LinearLayout XTITLE = (LinearLayout) findViewById(IDTITLE);
        final ProgressBar SMAIS = (ProgressBar) findViewById(IDSEEK);
        String varcc = TMAIS.getText().toString();
        int huy;
        try {
            huy = Integer.parseInt(varcc);
        } catch (Exception e) {
            huy = 0;
        }

        if (huy > 0) {
            //TMAIS.setVisibility(View.VISIBLE);
            //SMAIS.setVisibility(View.VISIBLE);
            XTITLE.setVisibility(View.VISIBLE);
            //toolbacr.refreshDrawableState();

        } else {
            //TMAIS.setVisibility(View.INVISIBLE);
            //SMAIS.setVisibility(View.GONE);
            XTITLE.setVisibility(View.GONE);

            SMAIS.setVisibility(View.GONE);

        }

    }

    public void AttribeVarListe(final Integer IDTEXT, final Integer IDSEEK, final String vartxt){
        final EditText TMAIS = (EditText) findViewById(IDTEXT);
        final ProgressBar SMAIS = (ProgressBar) findViewById(IDSEEK);
        int huy;
        try {
            huy = Integer.parseInt(vartxt);
        } catch (Exception e) {
            huy = 0;
        }

        TMAIS.setText(vartxt);
        SMAIS.setMax(100);
        SMAIS.setProgress(huy);
    }

    public void AttribeResume(final Integer IDTEXT, final String vartxt){
        final EditText TMAIS = (EditText) findViewById(IDTEXT);

        Math.pow(Double.parseDouble(vartxt),2);
        TMAIS.setText(vartxt);
    }
    public void AttribeGMQ(final Integer IDR,final Integer IDTEXT, final String emtxt, final String pbtxt){
        final EditText TMAIS = (EditText) findViewById(IDTEXT);
        final ProgressBar SMAIS = (ProgressBar) findViewById(IDR);
        double gmq =  (Double.parseDouble(pbtxt) *5.5)/40;
        double gmql =  (Double.parseDouble(emtxt) *5.5)/2100;
        double fiin = (gmq + gmql)/2;
        TMAIS.setText(Long.toString(Math.round(fiin)));
        SMAIS.setMax(7);
        SMAIS.setProgress(Integer.valueOf((int) (Math.round(fiin))));
    }
}
