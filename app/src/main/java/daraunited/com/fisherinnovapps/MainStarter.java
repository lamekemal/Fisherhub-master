package daraunited.com.fisherinnovapps;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainStarter extends AppCompatActivity {
    boolean acccomand = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_starter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(acccomand == true){
                    Snackbar.make(view, R.string.cinfotrue, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else {
                    Snackbar.make(view, R.string.cinfofalse, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

       EditText TMAIS = (EditText) findViewById(R.id.cqte);
        EditText MAIS = (EditText) findViewById(R.id.calu);
        TMAIS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)  {
                try {
                    EditText TMAIS = (EditText) findViewById(R.id.cqte);
                    String varsx = TMAIS.getText().toString();

                    EditText MAIS = (EditText) findViewById(R.id.calu);
                    String vars = MAIS.getText().toString();
                    if (Integer.parseInt(vars)< 500){
                        vars = "500";
                    }

                    double filnalcr = Integer.parseInt(vars) * Integer.parseInt(varsx) + 30;

                    TextView PRESENTX = (TextView) findViewById(R.id.textto);
                    PRESENTX.setText( String.valueOf(Math.round(filnalcr)) + "F CFA");
                    if (filnalcr > 1000){
                        acccomand = true;
                    }
                } catch (Exception e) {
                    EditText TMAIS = (EditText) findViewById(R.id.cqte);
                    TMAIS.setText("0");
                    acccomand = false;
                }}
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        MAIS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)  {
                try {
                    EditText MAIS = (EditText) findViewById(R.id.calu);
                    String varsx = MAIS.getText().toString();
                    EditText TMAIS = (EditText) findViewById(R.id.cqte);
                    String vars = TMAIS.getText().toString();
                    if (Integer.parseInt(varsx)< 500){
                        varsx = "500";
                    }
                    double finaleData = Integer.parseInt(vars) * Integer.parseInt(varsx) + 30;

                    TextView PRESENTX = (TextView) findViewById(R.id.textto);
                    PRESENTX.setText( String.valueOf(Math.round(finaleData)) + "F CFA");
                    if (finaleData > 1000){
                        acccomand = true;
                    }
                } catch (Exception e) {
                    EditText MAIS = (EditText) findViewById(R.id.calu);
                    MAIS.setText("0");
                    acccomand = false;
                }}
            @Override
            public void afterTextChanged(Editable editable) {}
        });

    }

}
