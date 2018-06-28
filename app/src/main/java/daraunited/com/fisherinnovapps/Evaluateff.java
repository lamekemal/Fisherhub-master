package daraunited.com.fisherinnovapps;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Evaluateff extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluateff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryReds));
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText TMAIS = (EditText) findViewById(R.id.TGMQ);
                final EditText TMAISU = (EditText) findViewById(R.id.TUJR);
                final EditText TMAISE = (EditText) findViewById(R.id.input_em);
                final EditText TMAISM = (EditText) findViewById(R.id.input_pb);
                // final ProgressBar SMAIS = (ProgressBar) findViewById(IDR);
                double gmq = 0;
                try {
                    gmq = (Double.parseDouble(TMAISM.getText().toString()) *5.5)/40;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                double gmql = 0;
                try {
                    gmql = (Double.parseDouble(TMAISE.getText().toString()) *5.5)/2100;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                double fiin = 0;
                try {
                    fiin = (gmq + gmql)/2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    TMAIS.setText(Long.toString(Math.round(fiin)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    TMAISU.setText(Long.toString(Math.round((1000/fiin))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
