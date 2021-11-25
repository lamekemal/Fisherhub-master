package daraunited.com.fisherinnovapps;

import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainCommande extends AppCompatActivity {
    boolean acccomand = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_commande);

        Button PRESENTX = (Button) findViewById(R.id.button5);
        PRESENTX.setOnClickListener(new View.OnClickListener() {
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
        EditText MAIS = (EditText) findViewById(R.id.cqte_a);
        MAIS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)  {
                try {
                    EditText TMAIS = (EditText) findViewById(R.id.cqte_a);
                    String varsx = TMAIS.getText().toString();
                    double filnalcr = Integer.parseInt(varsx) + 30;
                    if (filnalcr > 1){
                        acccomand = true;
                    }
                } catch (Exception e) {
                    acccomand = false;
                }}
            @Override
            public void afterTextChanged(Editable editable) {}
        });

    }
}
