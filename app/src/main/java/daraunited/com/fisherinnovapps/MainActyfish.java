package daraunited.com.fisherinnovapps;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActyfish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actyfish);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Bouton3 Configuration; Pour pisciculteur pro
        Button next = (Button) findViewById(R.id.button3);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Calkpage.class);
                startActivityForResult(myIntent, 0);
            }
        });

        //Bouton Configuration; Pour pisciculteur debutant
        Button starterp = (Button) findViewById(R.id.button);
        starterp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), MainStarter.class);
                startActivityForResult(myIntent, 0);
            }
        });

        //Bouton2 Configuration; Pour pisciculteur aide
        Button tiwahelp = (Button) findViewById(R.id.button2);
        tiwahelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });

    }
}
