package daraunited.com.fisherinnovapps;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sourcey.materiallogindemo.LoginActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Array;

import mehdi.sakout.fancybuttons.FancyButton;

public class matSelect extends AppCompatActivity {

    //region DEFINE VAR
    CheckBox chk_mais ;
    CheckBox chk_cmac ;
    CheckBox chk_hr ;
    CheckBox chk_smais ;
    CheckBox chk_sriz ;

    CheckBox chk_sble  ;
    CheckBox chk_dre  ;
    CheckBox chk_tsoja ;
    CheckBox chk_tcoton ;
    CheckBox chk_tpalm ;
    CheckBox chk_tara ;
    CheckBox chk_fpoi ;
    CheckBox chk_soja ;

    CheckBox chk_coq ;
    CheckBox chk_phbic ;
    CheckBox chk_ly ;
    CheckBox chk_met ;

    CheckBox chk_sel ;
    CheckBox chk_fer;
    CheckBox chk_premix ;
    CheckBox chk_ctr_c;
    CheckBox chk_ctr_p;

    EditText pmais;

    EditText pcmac;
    EditText phr;
    EditText psmais;
    EditText psriz;

    EditText psble;
    EditText pdre;
    EditText ptsoja;
    EditText ptcoton;
    EditText ptpalm ;
    EditText ptara;
    EditText pfpoi ;
    EditText psoja;

    EditText coq ;
    EditText phbic;
    EditText ly ;
    EditText met;

    EditText sel ;
    EditText fer;
    EditText premix ;
    EditText ctr_c;
    EditText ctr_p;

     double qteTAlimGen;
     double prixTAlimGen;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_select);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorAccent));
        }

        //region DEVIFNE OOOFF
        //energy
        chk_mais = (CheckBox) findViewById(R.id.chek_mais);
        chk_cmac = (CheckBox) findViewById(R.id.chek_cmac);
        chk_hr = (CheckBox) findViewById(R.id.chek_hr);
        chk_smais = (CheckBox) findViewById(R.id.chek_smais);
        chk_sriz = (CheckBox) findViewById(R.id.chek_sriz);

         pmais =(EditText) findViewById(R.id.prix_mais);
         pcmac =(EditText) findViewById(R.id.prix_cmac);
         phr =(EditText) findViewById(R.id.prix_hr);
         psmais= (EditText) findViewById(R.id.prix_smais);
         psriz= (EditText) findViewById(R.id.prix_sriz);

        //proto
         chk_sble = (CheckBox) findViewById(R.id.chek_sble);
         chk_dre = (CheckBox) findViewById(R.id.chek_dre);
         chk_tsoja = (CheckBox) findViewById(R.id.chek_tsoja);
         chk_tcoton= (CheckBox) findViewById(R.id.chek_tcoton);
         chk_tpalm= (CheckBox) findViewById(R.id.chek_tpalm);
         chk_tara= (CheckBox) findViewById(R.id.chek_tara);
         chk_fpoi = (CheckBox) findViewById(R.id.chek_fpoi);
         chk_soja = (CheckBox) findViewById(R.id.chek_soja);

         psble =(EditText) findViewById(R.id.prix_sble);
         pdre =(EditText) findViewById(R.id.prix_dre);
         ptsoja =(EditText) findViewById(R.id.prix_tsoja);
         ptcoton =(EditText) findViewById(R.id.prix_tcoton);
         ptpalm =(EditText) findViewById(R.id.prix_tpalm);
         ptara =(EditText) findViewById(R.id.prix_tara);
         pfpoi =(EditText) findViewById(R.id.prix_fpoi);
         psoja =(EditText) findViewById(R.id.prix_soja);

        chk_coq = (CheckBox) findViewById(R.id.chek_coq);
        chk_phbic = (CheckBox) findViewById(R.id.chek_phbic);
        coq = (EditText) findViewById(R.id.prix_coq);
        phbic = (EditText) findViewById(R.id.prix_phbic);

        chk_ly = (CheckBox) findViewById(R.id.chek_lys);
        chk_met = (CheckBox) findViewById(R.id.chek_met);
        ly = (EditText) findViewById(R.id.prix_lys);
        met = (EditText) findViewById(R.id.prix_met);

        sel = (EditText) findViewById(R.id.prix_sel);
        fer = (EditText) findViewById(R.id.prix_fer);
        premix = (EditText) findViewById(R.id.prix_premix);
        ctr_c = (EditText) findViewById(R.id.prix_ctr_c);
        ctr_p = (EditText) findViewById(R.id.prix_ctr_p);

        chk_sel = (CheckBox) findViewById(R.id.chek_sel);

        final RadioButton pirate = (RadioButton) findViewById(R.id.radio_pirates);
        final RadioButton ninjas = (RadioButton) findViewById(R.id.radio_ninjas);

        final RadioButton tempere_ = (RadioButton) findViewById(R.id.radio_tempere);
        final RadioButton tropical_ = (RadioButton) findViewById(R.id.radio_tropic);

        chk_fer = (CheckBox) findViewById(R.id.chek_fer);
        chk_premix = (CheckBox) findViewById(R.id.chek_premix);
        chk_ctr_c = (CheckBox) findViewById(R.id.chek_ctr_c);
        chk_ctr_p = (CheckBox) findViewById(R.id.chek_ctr_p);
        //endregion

        chk_premix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (chk_premix.isChecked()){
                   chk_ctr_c.setChecked(false);
                   chk_ctr_p.setChecked(false);
               }
            }
        });
        chk_ctr_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chk_ctr_c.isChecked()){
                    chk_premix.setChecked(false);
                    chk_ctr_p.setChecked(false);
                }
            }
        });
        chk_ctr_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chk_ctr_p.isChecked()){
                    chk_ctr_c.setChecked(false);
                    chk_premix.setChecked(false);
                }
            }
        });
        FancyButton fancy_act = (FancyButton) findViewById(R.id.btn_android_prefix);
        fancy_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NestedScrollView new_int = (NestedScrollView) findViewById(R.id.sec_layout);
                NestedScrollView pim_int = (NestedScrollView) findViewById(R.id.pim_lay);
                final ProgressDialog progressDialog = new ProgressDialog(matSelect.this,
                        R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Calcul...");
                progressDialog.show();
                new_int.setVisibility(View.INVISIBLE);
                pim_int.setVisibility(View.INVISIBLE);
                try {
                    if(ninjas.isChecked()){
                        if(tropical_.isChecked()){
                            //croissance et finition en milieu tropical
                            autoChoice(3100, 19);
                        }else if(tempere_.isChecked()){
                            //croissance et finition en milieu tempéré
                            autoChoice(2900, 18);
                        }
                    }

                    if(pirate.isChecked()){
                        if(tropical_.isChecked()){
                            //Demarrage en milieu tropical
                            autoChoice(3200, 24);
                        }
                        if(tempere_.isChecked()){
                            //Demarrage en milieu tempéré
                            autoChoice(2900, 22);
                        }
                    }
                }catch (Exception es ){
                    es.printStackTrace();
                    Toast.makeText(matSelect.this, "Most error detected",
                            Toast.LENGTH_SHORT).show();
                }
                new_int.setVisibility(View.VISIBLE);
                progressDialog.dismiss();
            }
        });

        FancyButton fancy_bact = (FancyButton) findViewById(R.id.btn_android_back);
        fancy_bact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NestedScrollView new_int = (NestedScrollView) findViewById(R.id.sec_layout);
                NestedScrollView pim_int = (NestedScrollView) findViewById(R.id.pim_lay);
                new_int.setVisibility(View.INVISIBLE);
                pim_int.setVisibility(View.VISIBLE);
            }
        });
    }

    public void autoChoice(int emReference, int matReference)
    {
        qteTAlimGen=0;
        prixTAlimGen=0;

        //region CALCUL DES EM DIFFERE
        //start for calculate ref value
        double b_total = 0;
        double b_mais;
        double b_cmac;
        double b_hr;
        double b_smais;
        double b_sriz;

        //mais
        if (chk_mais.isChecked()){
            b_mais =  a__mais_r_EM(3300,97.8,Integer.parseInt(pmais.getText().toString()),Integer.parseInt(pmais.getText().toString()),1);
            b_total = b_mais + b_total;
        }else {
            b_mais=0;
        }

        //mais
        if (chk_cmac.isChecked()){
            b_cmac = a__mais_r_EM(2900,97.0,Integer.parseInt(pcmac.getText().toString()),Integer.parseInt(pmais.getText().toString()),1);
            b_total = b_cmac + b_total;
        }else {
            b_cmac=0;
        }

        //cmac
        if (chk_hr.isChecked()){
            b_hr= a__mais_r_EM(9000,50.0,Integer.parseInt(phr.getText().toString()),Integer.parseInt(pmais.getText().toString()),1);
            b_total = b_hr + b_total;
        }else {
            b_hr=0;
        }

        //mais
        if (chk_smais.isChecked()){
            b_smais = a__mais_r_EM(2228,91.1,Integer.parseInt(psmais.getText().toString()),Integer.parseInt(pmais.getText().toString()),1);
            b_total = b_smais + b_total;
        }else {
            b_smais=0;
        }

        //mais
        if (chk_sriz.isChecked()){
            b_sriz = a__mais_r_EM(2950,88.0,Integer.parseInt(psriz.getText().toString()),Integer.parseInt(pmais.getText().toString()),1);
            b_total = b_sriz + b_total;
        }else {
            b_sriz=0;
        }

        Log.i("NEW PROCESSS", "b tot "+ b_total);

        //calcule des valeurs Z pourcentage
        double Zmais =nul_NAN(b_mais,(b_mais*100/b_total));
        double Zcmac = nul_NAN(b_cmac,(b_cmac*100/b_total));
        double Zhr = nul_NAN(b_hr,(b_hr*100/b_total));
        double Zsmais = nul_NAN(b_smais,(b_smais*100/b_total));
        double Zsriz = nul_NAN(b_sriz,(b_sriz*100/b_total));

        Log.i("TOW PROCESS", "b_mais "+ b_mais + "b_smais "+ b_smais + "b_sriz "+ b_sriz);

        //calcul des valeurs EM et Mat des sous aliment ==composant
        double em_mais= nul_NAN(Zmais,(3300*Zmais)/(double)100);
        double em_cmac = nul_NAN(Zcmac,(2900*Zcmac)/(double)100);
        double em_hr=nul_NAN(Zhr,(9000*Zhr)/(double)100);
        double em_smais=nul_NAN(Zsmais,(2228*Zsmais)/(double)100);
        double em_sriz=nul_NAN(Zsriz,(2950*Zsriz)/(double)100);

        //calcul des valeurs Mat des sous aliment ==composant
        double ma_mais= nul_NAN(Zmais,(8.5*Zmais)/(double)100);
        double ma_cmac = nul_NAN(Zcmac,(2.2*Zcmac)/(double)100);
        double ma_hr=nul_NAN(Zhr,(0*Zhr)/(double)100);
        double ma_smais=nul_NAN(Zsmais,(10.1*Zsmais)/(double)100);
        double ma_sriz=nul_NAN(Zsriz,(12.8*Zsriz)/(double)100);

        //em total aliment et mat
        double Vt_em = em_mais+em_cmac+em_hr+em_smais+em_sriz;
        double Vt_ma = ma_mais+ma_cmac+ma_hr+ma_smais+ma_sriz;
        //endregion

        //region CALCUL DES MAT DIFFERE
        double b_m_total=0;
        double b_sble;
        double b_dre;
        double b_tsoja;
        double b_tcoton;
        double b_tpalm;
        double b_tara;
        double b_fp;
        double b_sojag;

        if (chk_sble.isChecked()){
            b_sble =  a__tsoja_r_AM(14,85,Integer.parseInt(psble.getText().toString()),Integer.parseInt(ptsoja.getText().toString()));
            b_m_total =b_sble+b_m_total;
        }else {
            b_sble=0;
        }

        if (chk_tsoja.isChecked()){
            b_tsoja =  a__tsoja_r_AM(43,100,Integer.parseInt(ptsoja.getText().toString()),Integer.parseInt(ptsoja.getText().toString()));
            b_m_total =b_tsoja+b_m_total;
        }else {
            b_tsoja=0;
        }

        if (chk_dre.isChecked()){
            b_dre =  a__tsoja_r_AM(25,85,Integer.parseInt(pdre.getText().toString()),Integer.parseInt(ptsoja.getText().toString()));
            b_m_total =b_dre+b_m_total;
        }else {
            b_dre=0;
        }

        if (chk_tcoton.isChecked()){
            b_tcoton =  a__tsoja_r_AM(41,82,Integer.parseInt(ptcoton.getText().toString()),Integer.parseInt(ptsoja.getText().toString()));
            b_m_total =b_tcoton+b_m_total;
        }else {
            b_tcoton=0;
        }

        if (chk_tpalm.isChecked()){
            b_tpalm =  a__tsoja_r_AM(16,85,Integer.parseInt(ptpalm.getText().toString()),Integer.parseInt(ptsoja.getText().toString()));
            b_m_total =b_tpalm +b_m_total;
        }else {
            b_tpalm=0;
        }

        if (chk_tara.isChecked()){
            b_tara =  a__tsoja_r_AM(49,90,Integer.parseInt(ptara.getText().toString()),Integer.parseInt(ptsoja.getText().toString()));
            b_m_total =b_tara +b_m_total;
        }else {
            b_tara=0;
        }

        if (chk_fpoi.isChecked()){
            b_fp =  a__tsoja_r_AM(46,100,Integer.parseInt(pfpoi.getText().toString()),Integer.parseInt(ptsoja.getText().toString()));
            b_m_total =b_fp +b_m_total;
        }else {
            b_fp=0;
        }

        if (chk_soja.isChecked()){
            b_sojag =  a__tsoja_r_AM(37,93,Integer.parseInt(psoja.getText().toString()),Integer.parseInt(ptsoja.getText().toString()));
            b_m_total =b_sojag +b_m_total;
        }else {
            b_sojag=0;
        }

        //calcule des valeurs Z pourcentage de mat
        double Zmsble =nul_NAN(b_sble,(b_sble/b_m_total)*100);
        double Zmtsoja =nul_NAN(b_tsoja,(b_tsoja/b_m_total)*100);
        double Zmdre =nul_NAN(b_dre,(b_dre/b_m_total)*100);
        double Zmtcoton =nul_NAN(b_tcoton,(b_tcoton/b_m_total)*100);
        double Zmtpalm =nul_NAN(b_tpalm,(b_tpalm/b_m_total)*100);
        double Zmtara =nul_NAN(b_tara,(b_tara/b_m_total)*100);
        double Zmfp =nul_NAN(b_fp,(b_fp/b_m_total)*100);
        double Zmsojag =nul_NAN(b_sojag,(b_sojag/b_m_total)*100);

        //calcul des valeurs EM et Mat des sous aliment ==composant2
        double em_msble= nul_NAN(Zmsble,(1440*Zmsble)/(double)100);
        double em_mtsoja= nul_NAN(Zmtsoja,(2420*Zmtsoja)/(double)100);
        double em_mdre= nul_NAN(Zmdre,(2400*Zmdre)/(double)100);
        double em_mtcoton= nul_NAN(Zmtcoton,(1945*Zmtcoton)/(double)100);
        double em_mtpalm= nul_NAN(Zmtpalm,(1240*Zmtpalm)/(double)100);
        double em_mtara= nul_NAN(Zmtara,(2825*Zmtara)/(double)100);
        double em_mfp= nul_NAN(Zmfp,(2200*Zmfp)/(double)100);
        double em_msojag= nul_NAN(Zmsojag,(3700*Zmsojag)/(double)100);

        //calcul des valeurs mat et Mat des sous aliment ==composant2
        double m_msble= nul_NAN(Zmsble,(14*Zmsble)/(double)100);
        double m_mtsoja= nul_NAN(Zmtsoja,(43*Zmtsoja)/(double)100);
        double m_mdre= nul_NAN(Zmdre,(25*Zmdre)/(double)100);
        double m_mtcoton= nul_NAN(Zmtcoton,(41*Zmtcoton)/(double)100);
        double m_mtpalm= nul_NAN(Zmtpalm,(16*Zmtpalm)/(double)100);
        double m_mtara= nul_NAN(Zmtara,(49*Zmtara)/(double)100);
        double m_mfp= nul_NAN(Zmfp,(46*Zmfp)/(double)100);
        double m_msojag= nul_NAN(Zmsojag,(37*Zmsojag)/(double)100);

        //em total aliment et mat pour compos_ali1
        double vb_em = em_msble+em_mtsoja+em_mdre+em_mtcoton+em_mtpalm+em_mtara+em_mfp+em_msojag;
        double vb_ma = m_msble+m_mtsoja+m_mdre+m_mtcoton+m_mtpalm+m_mtara+m_mfp+m_msojag;
        //endregion

        double x = Vt_em;
        double y = vb_em;
        double z = emReference;

        double a = Vt_ma;
        double b = vb_ma;
        double c = matReference;

        double beta = (double)((a * z) - (x * c)) / (double)((a * y) - (x*b));
        double alpha = ((double)z / (double)x) - (double)((a * y * z) - (y * x * c)) / (double)(x * ((a * y) - (x*b)));
        double totSAS = beta + alpha;
        double beta_percent = (double)(beta *100)/totSAS;
        double alpha_percent = (double) (alpha * 100)/ totSAS;

        Log.i("beta_percent",String.valueOf(beta_percent));
        Log.i("alpha_percent",String.valueOf(alpha_percent));
        Log.i("Calcul","Valeur ALFA " + alpha + " VALEUR BETA " + beta + "alpa+bata " + (alpha+beta));

        //region DIFFERE MARS
        double betaM = beta_percent/100;
        double alphaE = alpha_percent/100;

        //suite
        double ffmais =nul_NAN(Zmais,(Zmais * (alphaE *100))/(double)100);
        double ffcmac =nul_NAN(Zcmac,(Zcmac * (alphaE *100))/(double)100);
        double ffhr =nul_NAN(Zhr,(Zhr * (alphaE *100))/(double)100);
        double ffsmais =nul_NAN(Zsmais,(Zsmais * (alphaE *100))/(double)100);
        double ffsriz =nul_NAN(Zsriz,(Zsriz * (alphaE *100))/(double)100);

        double ffmsble =nul_NAN(Zmsble,(Zmsble  * (betaM *100))/(double)100);
        double ffmtsoja =nul_NAN(Zmtsoja,(Zmtsoja * (betaM *100))/(double)100);
        double ffmdre =nul_NAN(Zmdre,(Zmdre * (betaM *100))/(double)100);
        double ffmtcoton =nul_NAN(Zmtcoton,(Zmtcoton * (betaM *100))/(double)100);
        double ffmtpalm =nul_NAN(Zmtpalm,(Zmtpalm * (betaM *100))/(double)100);
        double ffmtara =nul_NAN(Zmtara,(Zmtara * (betaM *100))/(double)100);
        double ffmfp =nul_NAN(Zmfp,(Zmfp * (betaM *100))/(double)100);
        double ffmsojag =nul_NAN(Zmsojag,(Zmsojag * (betaM *100))/(double)100);

        //suitede
        double fpmais = a__rec(pmais,ffmais);
        double fpcmac = a__rec(pcmac,ffcmac);
        double fphr = a__rec(phr,ffhr);
        double fpsmais = a__rec(psmais,ffsmais);
        double fpsriz = a__rec(psriz,ffsriz);

        double fpmsble = a__rec(psble,ffmsble);
        double fpmtsoja = a__rec(ptsoja,ffmtsoja);
        double fpmdre = a__rec(pdre,ffmdre);
        double fpmtcoton = a__rec(ptcoton,ffmtcoton);
        double fpmtpalm = a__rec(ptpalm,ffmtpalm);
        double fpmtara = a__rec(ptara,ffmtara);
        double fpmfp = a__rec(pfpoi,ffmfp);
        double fpmsojag = a__rec(psoja,ffmsojag);

        //invisibility of dock
        set_inv(R.id.ll_mais);
        set_inv(R.id.ll_cmac);
        set_inv(R.id.ll_hr);
        set_inv(R.id.ll_smais);
        set_inv(R.id.ll_sriz);
        set_inv(R.id.ll_sble);
        set_inv(R.id.ll_tsoja);
        set_inv(R.id.ll_dre);
        set_inv(R.id.ll_tcoton);
        set_inv(R.id.ll_tpalm);
        set_inv(R.id.ll_tara);
        set_inv(R.id.ll_fpoi);
        set_inv(R.id.ll_soja);
        set_inv(R.id.ll_coq);
        set_inv(R.id.ll_phbic);
        //endregion

        //region DRAFT CODE
        /*
        define_data(R.id.qte_mais,R.id.fprix_mais,ffmais,fpmais);
        define_data(R.id.qté_cmac,R.id.fprix_cmac,ffcmac,fpcmac);
        define_data(R.id.qte_hr,R.id.fprix_hr,ffhr,fphr);
        define_data(R.id.qte_smais,R.id.fprix_smais,ffsmais,fpsmais);
        define_data(R.id.qte_sriz,R.id.fprix_sriz,ffsriz,fpsriz);
        define_data(R.id.qte_sble,R.id.fprix_sble,ffmsble,fpmsble);
        define_data(R.id.qte_tsoja,R.id.fprix_tsoja,ffmtsoja,fpmtsoja);
        define_data(R.id.qte_dre,R.id.fprix_dre,ffmdre,fpmdre);
        define_data(R.id.qte_tcoton,R.id.fprix_tcoton,ffmtcoton,fpmtcoton);
        define_data(R.id.qte_tpalm,R.id.fprix_tpalm,ffmtpalm,fpmtpalm);
        define_data(R.id.qte_tara,R.id.fprix_tara,ffmtara,fpmtara);
        define_data(R.id.qte_fpoi,R.id.fprix_fpoi,ffmfp,fpmfp);
        define_data(R.id.qte_soja,R.id.fprix_soja,ffmsojag,fpmsojag);*/
        //endregion

        //mais
        define_data(R.id.qte_mais, R.id.fprix_mais, ffmais, fpmais,R.id.ll_mais);
        define_data(R.id.qté_cmac, R.id.fprix_cmac, ffcmac, fpcmac,R.id.ll_cmac);
        define_data(R.id.qte_hr, R.id.fprix_hr, ffhr, fphr,R.id.ll_hr);
        define_data(R.id.qte_smais, R.id.fprix_smais, ffsmais, fpsmais,R.id.ll_smais);
        define_data(R.id.qte_sriz, R.id.fprix_sriz, ffsriz, fpsriz,R.id.ll_sriz);
        define_data(R.id.qte_sble, R.id.fprix_sble, ffmsble, fpmsble,R.id.ll_sble);
        define_data(R.id.qte_tsoja, R.id.fprix_tsoja, ffmtsoja, fpmtsoja,R.id.ll_tsoja);
        define_data(R.id.qte_dre, R.id.fprix_dre, ffmdre, fpmdre,R.id.ll_dre);
        define_data(R.id.qte_tcoton, R.id.fprix_tcoton, ffmtcoton, fpmtcoton,R.id.ll_tcoton);
        define_data(R.id.qte_tpalm, R.id.fprix_tpalm, ffmtpalm, fpmtpalm,R.id.ll_tpalm);
        define_data(R.id.qte_tara, R.id.fprix_tara, ffmtara, fpmtara,R.id.ll_tara);
        define_data(R.id.qte_fpoi, R.id.fprix_fpoi, ffmfp, fpmfp,R.id.ll_fpoi);
        define_data(R.id.qte_soja, R.id.fprix_soja, ffmsojag, fpmsojag,R.id.ll_soja);

        //region CALCIUM & OLIGO ELEMENT
        /*concernant le ca et p*/
        if (chk_coq.isChecked()){
            double ca_value =1;
            double pca_value =(double)(1 * Integer.parseInt(coq.getText().toString()))/(double)100;
            define_data(R.id.qte_coq, R.id.fprix_coq, ca_value, pca_value,R.id.ll_coq);
        }else {
            set_inv(R.id.ll_coq);
        }

        if (chk_phbic.isChecked()){
            double ca_value =0.7;
            double pca_value =(double)(0.7 * Integer.parseInt(phbic.getText().toString()))/(double)100;
            define_data(R.id.qte_phbic, R.id.fprix_phbic, ca_value, pca_value,R.id.ll_phbic);
        }else {
            set_inv(R.id.ll_phbic);
        }

        //lys met
        if (chk_ly.isChecked()){
            double ca_value =0.66;
            double pca_value =(double)(0.66 * Integer.parseInt(ly.getText().toString()))/(double)100;
            define_data(R.id.qte_lys, R.id.fprix_lys, ca_value, pca_value,R.id.ll_lys);
        }else {
            set_inv(R.id.ll_lys);
        }

        if (chk_met.isChecked()){
            double ca_value =0.34;
            double pca_value =(double)(0.34 * Integer.parseInt(met.getText().toString()))/(double)100;
            define_data(R.id.qte_met, R.id.fprix_met, ca_value, pca_value,R.id.ll_met);
        }else {
            set_inv(R.id.ll_met);
        }

        // sel
        if (chk_sel.isChecked()){
            double ca_value =0.14;
            double pca_value =(double)(0.14 * Integer.parseInt(sel.getText().toString()))/(double)100;
            define_data(R.id.qte_sel, R.id.fprix_sel, ca_value, pca_value,R.id.ll_sel);
        }else {
            set_inv(R.id.ll_sel);
        }

        //FER
        if (chk_fer.isChecked()){
            double ca_value =0.004;
            double pca_value =(double)(0.004 * Integer.parseInt(fer.getText().toString()))/(double)100;
            define_data(R.id.qte_fer, R.id.fprix_fer, ca_value, pca_value,R.id.ll_fer);
        }else {
            set_inv(R.id.ll_fer);
        }
        //endregion oligo_element

        //region PRMX
        if (chk_premix.isChecked()){
            qteTAlimGen=0;
            prixTAlimGen=0;
            define_data(R.id.qte_mais, R.id.fprix_mais, ffmais*0.95, fpmais*0.95,R.id.ll_mais);
            define_data(R.id.qté_cmac, R.id.fprix_cmac, ffcmac*0.95, fpcmac*0.95,R.id.ll_cmac);
            define_data(R.id.qte_hr, R.id.fprix_hr, ffhr*0.95, fphr*0.95,R.id.ll_hr);
            define_data(R.id.qte_smais, R.id.fprix_smais, ffsmais*0.95, fpsmais*0.95,R.id.ll_smais);
            define_data(R.id.qte_sriz, R.id.fprix_sriz, ffsriz*0.95, fpsriz*0.95,R.id.ll_sriz);
            define_data(R.id.qte_sble, R.id.fprix_sble, ffmsble*0.95, fpmsble*0.95,R.id.ll_sble);
            define_data(R.id.qte_tsoja, R.id.fprix_tsoja, ffmtsoja*0.95, fpmtsoja*0.95,R.id.ll_tsoja);
            define_data(R.id.qte_dre, R.id.fprix_dre, ffmdre*0.95, fpmdre*0.95,R.id.ll_dre);
            define_data(R.id.qte_tcoton, R.id.fprix_tcoton, ffmtcoton*0.95, fpmtcoton*0.95,R.id.ll_tcoton);
            define_data(R.id.qte_tpalm, R.id.fprix_tpalm, ffmtpalm*0.95, fpmtpalm*0.95,R.id.ll_tpalm);
            define_data(R.id.qte_tara, R.id.fprix_tara, ffmtara*0.95, fpmtara*0.95,R.id.ll_tara);
            define_data(R.id.qte_fpoi, R.id.fprix_fpoi, ffmfp*0.95, fpmfp*0.95,R.id.ll_fpoi);
            define_data(R.id.qte_soja, R.id.fprix_soja, ffmsojag*0.95, fpmsojag*0.95,R.id.ll_soja);

            if (chk_coq.isChecked()){
                double ca_value =1;
                double pca_value =(double)(1 * Integer.parseInt(coq.getText().toString()))/(double)100;
                define_data(R.id.qte_coq, R.id.fprix_coq, ca_value, pca_value,R.id.ll_coq);
            }else {
                set_inv(R.id.ll_coq);
            }

            if (chk_phbic.isChecked()){
                double ca_value =0.7;
                double pca_value =(double)(0.7 * Integer.parseInt(phbic.getText().toString()))/(double)100;
                define_data(R.id.qte_phbic, R.id.fprix_phbic, ca_value, pca_value,R.id.ll_phbic);
            }else {
                set_inv(R.id.ll_phbic);
            }

            //lys met
            if (chk_ly.isChecked()){
                double ca_value =0.66;
                double pca_value =(double)(0.66 * Integer.parseInt(ly.getText().toString()))/(double)100;
                define_data(R.id.qte_lys, R.id.fprix_lys, ca_value, pca_value,R.id.ll_lys);
            }else {
                set_inv(R.id.ll_lys);
            }

            if (chk_met.isChecked()){
                double ca_value =0.34;
                double pca_value =(double)(0.34 * Integer.parseInt(met.getText().toString()))/(double)100;
                define_data(R.id.qte_met, R.id.fprix_met, ca_value, pca_value,R.id.ll_met);
            }else {
                set_inv(R.id.ll_met);
            }

            if (chk_sel.isChecked()){
                double ca_value =0.14;
                double pca_value =(double)(0.14 * Integer.parseInt(sel.getText().toString()))/(double)100;
                define_data(R.id.qte_sel, R.id.fprix_sel, ca_value, pca_value,R.id.ll_sel);
            }else {
                set_inv(R.id.ll_sel);
            }

            //FER
            if (chk_fer.isChecked()){
                double ca_value =0.004;
                double pca_value =(double)(0.004 * Integer.parseInt(fer.getText().toString()))/(double)100;
                define_data(R.id.qte_fer, R.id.fprix_fer, ca_value, pca_value,R.id.ll_fer);
            }else {
                set_inv(R.id.ll_fer);
            }

                double ca_value =5;
                double pca_value =(double)(5 * Integer.parseInt(premix.getText().toString()))/(double)100;
                define_data(R.id.qte_premix, R.id.fprix_premix, ca_value, pca_value,R.id.ll_premix);
            }else {
                set_inv(R.id.ll_premix);
            }
            //endregion

        //CC
        if (chk_ctr_c.isChecked()){
            qteTAlimGen=0;
            prixTAlimGen=0;
            define_data(R.id.qte_mais, R.id.fprix_mais, (ffmais*0.95), (fpmais*0.95),R.id.ll_mais);
            define_data(R.id.qté_cmac, R.id.fprix_cmac, (ffcmac*0.95), (fpcmac*0.95),R.id.ll_cmac);
            define_data(R.id.qte_hr, R.id.fprix_hr, (ffhr*0.95), (fphr*0.95),R.id.ll_hr);
            define_data(R.id.qte_smais, R.id.fprix_smais, (ffsmais*0.95), (fpsmais*0.95),R.id.ll_smais);
            define_data(R.id.qte_sriz, R.id.fprix_sriz, (ffsriz*0.95), (fpsriz*0.95),R.id.ll_sriz);
            define_data(R.id.qte_sble, R.id.fprix_sble, (ffmsble*0.95), (fpmsble*0.95),R.id.ll_sble);
            define_data(R.id.qte_tsoja, R.id.fprix_tsoja, (ffmtsoja*0.95), (fpmtsoja*0.95),R.id.ll_tsoja);
            define_data(R.id.qte_dre, R.id.fprix_dre, (ffmdre*0.95), (fpmdre*0.95),R.id.ll_dre);
            define_data(R.id.qte_tcoton, R.id.fprix_tcoton, (ffmtcoton*0.95), (fpmtcoton*0.95),R.id.ll_tcoton);
            define_data(R.id.qte_tpalm, R.id.fprix_tpalm, (ffmtpalm*0.95), (fpmtpalm*0.95),R.id.ll_tpalm);
            define_data(R.id.qte_tara, R.id.fprix_tara, (ffmtara*0.95), (fpmtara*0.95),R.id.ll_tara);
            define_data(R.id.qte_fpoi, R.id.fprix_fpoi, (ffmfp*0.95), (fpmfp*0.95),R.id.ll_fpoi);
            define_data(R.id.qte_soja, R.id.fprix_soja, (ffmsojag*0.95),(fpmsojag*0.95),R.id.ll_soja);

            if (chk_coq.isChecked()){
                double ca_value =1;
                double pca_value =(double)(1 * Integer.parseInt(coq.getText().toString()))/(double)100;
                define_data(R.id.qte_coq, R.id.fprix_coq, ca_value, pca_value,R.id.ll_coq);
            }else {
                set_inv(R.id.ll_coq);
            }

            if (chk_phbic.isChecked()){
                double ca_value =0.7;
                double pca_value =(double)(0.7 * Integer.parseInt(phbic.getText().toString()))/(double)100;
                define_data(R.id.qte_phbic, R.id.fprix_phbic, ca_value, pca_value,R.id.ll_phbic);
            }else {
                set_inv(R.id.ll_phbic);
            }

            //lys met
            if (chk_ly.isChecked()){
                double ca_value =0.66;
                double pca_value =(double)(0.66 * Integer.parseInt(ly.getText().toString()))/(double)100;
                define_data(R.id.qte_lys, R.id.fprix_lys, ca_value, pca_value,R.id.ll_lys);
            }else {
                set_inv(R.id.ll_lys);
            }

            if (chk_met.isChecked()){
                double ca_value =0.34;
                double pca_value =(double)(0.34 * Integer.parseInt(met.getText().toString()))/(double)100;
                define_data(R.id.qte_met, R.id.fprix_met, ca_value, pca_value,R.id.ll_met);
            }else {
                set_inv(R.id.ll_met);
            }

            if (chk_sel.isChecked()){
                double ca_value =0.14;
                double pca_value =(double)(0.14 * Integer.parseInt(sel.getText().toString()))/(double)100;
                define_data(R.id.qte_sel, R.id.fprix_sel, ca_value, pca_value,R.id.ll_sel);
            }else {
                set_inv(R.id.ll_sel);
            }

            //FER
            if (chk_fer.isChecked()){
                double ca_value =0.004;
                double pca_value =(double)(0.004 * Integer.parseInt(fer.getText().toString()))/(double)100;
                define_data(R.id.qte_fer, R.id.fprix_fer, ca_value, pca_value,R.id.ll_fer);
            }else {
                set_inv(R.id.ll_fer);
            }
            double ca_value =5;
            double pca_value =(double)(5 * Integer.parseInt(ctr_c.getText().toString()))/(double)100;
            define_data(R.id.qte_ctr_c, R.id.fprix_ctr_c, ca_value, pca_value,R.id.ll_ctr_c);
        }else {
            set_inv(R.id.ll_ctr_c);
        }
        Log.i("samais","ffsmais= " + ffsmais);
        //CCpp
        if (chk_ctr_p.isChecked()){
            qteTAlimGen=0;
            prixTAlimGen=0;
            define_data(R.id.qte_mais, R.id.fprix_mais, ffmais*0.95, fpmais*0.95,R.id.ll_mais);
            define_data(R.id.qté_cmac, R.id.fprix_cmac, ffcmac*0.95, fpcmac*0.95,R.id.ll_cmac);
            define_data(R.id.qte_hr, R.id.fprix_hr, ffhr*0.95, fphr*0.95,R.id.ll_hr);
            define_data(R.id.qte_smais, R.id.fprix_smais, ffsmais*0.95, fpsmais*0.95,R.id.ll_smais);
            define_data(R.id.qte_sriz, R.id.fprix_sriz, ffsriz*0.95, fpsriz*0.95,R.id.ll_sriz);
            define_data(R.id.qte_sble, R.id.fprix_sble, ffmsble*0.95, fpmsble*0.95,R.id.ll_sble);
            define_data(R.id.qte_tsoja, R.id.fprix_tsoja, ffmtsoja*0.95, fpmtsoja*0.95,R.id.ll_tsoja);
            define_data(R.id.qte_dre, R.id.fprix_dre, ffmdre*0.95, fpmdre*0.95,R.id.ll_dre);
            define_data(R.id.qte_tcoton, R.id.fprix_tcoton, ffmtcoton*0.95, fpmtcoton*0.95,R.id.ll_tcoton);
            define_data(R.id.qte_tpalm, R.id.fprix_tpalm, ffmtpalm*0.95, fpmtpalm*0.95,R.id.ll_tpalm);
            define_data(R.id.qte_tara, R.id.fprix_tara, ffmtara*0.95, fpmtara*0.95,R.id.ll_tara);
            define_data(R.id.qte_fpoi, R.id.fprix_fpoi, ffmfp*0.95, fpmfp*0.95,R.id.ll_fpoi);
            define_data(R.id.qte_soja, R.id.fprix_soja, ffmsojag*0.95, fpmsojag*0.95,R.id.ll_soja);
            if (chk_coq.isChecked()){
                double ca_value =1;
                double pca_value =(double)(1 * Integer.parseInt(coq.getText().toString()))/(double)100;
                define_data(R.id.qte_coq, R.id.fprix_coq, ca_value, pca_value,R.id.ll_coq);
            }else {
                set_inv(R.id.ll_coq);
            }

            if (chk_phbic.isChecked()){
                double ca_value =0.7;
                double pca_value =(double)(0.7 * Integer.parseInt(phbic.getText().toString()))/(double)100;
                define_data(R.id.qte_phbic, R.id.fprix_phbic, ca_value, pca_value,R.id.ll_phbic);
            }else {
                set_inv(R.id.ll_phbic);
            }

            //lys met
            if (chk_ly.isChecked()){
                double ca_value =0.66;
                double pca_value =(double)(0.66 * Integer.parseInt(ly.getText().toString()))/(double)100;
                define_data(R.id.qte_lys, R.id.fprix_lys, ca_value, pca_value,R.id.ll_lys);
            }else {
                set_inv(R.id.ll_lys);
            }

            if (chk_met.isChecked()){
                double ca_value =0.34;
                double pca_value =(double)(0.34 * Integer.parseInt(met.getText().toString()))/(double)100;
                define_data(R.id.qte_met, R.id.fprix_met, ca_value, pca_value,R.id.ll_met);
            }else {
                set_inv(R.id.ll_met);
            }

            if (chk_sel.isChecked()){
                double ca_value =0.14;
                double pca_value =(double)(0.14 * Integer.parseInt(sel.getText().toString()))/(double)100;
                define_data(R.id.qte_sel, R.id.fprix_sel, ca_value, pca_value,R.id.ll_sel);
            }else {
                set_inv(R.id.ll_sel);
            }

            //FER
            if (chk_fer.isChecked()){
                double ca_value =0.004;
                double pca_value =(double)(0.004 * Integer.parseInt(fer.getText().toString()))/(double)100;
                define_data(R.id.qte_fer, R.id.fprix_fer, ca_value, pca_value,R.id.ll_fer);
            }else {
                set_inv(R.id.ll_fer);
            }


            double ca_value =5;
            double pca_value =(double)(5 * Integer.parseInt(ctr_p.getText().toString()))/(double)100;
            define_data(R.id.qte_ctr_p, R.id.fprix_ctr_p, ca_value, pca_value,R.id.ll_ctr_p);
        }else {
            set_inv(R.id.ll_ctr_p);
        }

        //endregion

        Log.i("Calcul"," Vt_ma= " + Vt_ma+" vb_em= " + vb_em+" vb_ma = " +vb_ma+" alphaE/betaM = "+alphaE+" / "+betaM );
    }

    double a__mais_r_EM(int Em, double Cr, int P,int Pr, double AlimentationFactor){
        double r = (((double) Em/(double)3300)*((double)1/(double)3))+(((double)Cr/(double) 100)*((double)2/(double)3));
        double ff = (((double)P/(double)Pr)*((double)1/(double)2))  + (r *((double)1/(double)2));
        return ff *AlimentationFactor;
    }

    double a__tsoja_r_AM(int MAT, double Sr, int P,int Pr){
        double r = (((double)MAT/(double)43)*((double)1/(double)2))+(((double)Sr/(double)100)*((double)1/(double)2));
        double ff = (((double)P/(double)Pr)*((double)1/(double)2))  + (r *((double)1/(double)2));
        return ff;
    }

    double a__rec(EditText PrixMp, double ff_TypeMP){
        return nul_NAN(Integer.parseInt(PrixMp.getText().toString())*ff_TypeMP,(double)Integer.parseInt(PrixMp.getText().toString())*ff_TypeMP)/(double)100; }

    double  nul_NAN(double nullable_value,double operatio_nvalue){
        if(nullable_value >0){
            return operatio_nvalue;
        }
            return 0;
    }

    void set_inv(int MylLayout){
        LinearLayout llorig = (LinearLayout) findViewById(MylLayout);
        llorig.setVisibility(View.GONE);
    }

    void define_data(int IdOfQte, int IdOfPrrix, double Qte, double Prixx, int SetVis){
        EditText qte = (EditText) findViewById(IdOfQte);
        qte.setText(String.valueOf(round(Qte,2)));
        EditText prx = (EditText) findViewById(IdOfPrrix);
        prx.setText(String.valueOf(round(Prixx,2)));
        if (Qte>0){
            LinearLayout llorig = (LinearLayout) findViewById(SetVis);
            llorig.setVisibility(View.VISIBLE);

            qteTAlimGen = Qte + qteTAlimGen;
            prixTAlimGen =   prixTAlimGen +Prixx;
            EditText i_qte = (EditText) findViewById(R.id.qte_tot);
            EditText n_qte = (EditText) findViewById(R.id.prix__tot);
            i_qte.setText(String.valueOf(round(qteTAlimGen,2)));
            n_qte.setText(String.valueOf(round(prixTAlimGen,1)));
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
