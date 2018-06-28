package daraunited.com.fisherinnovapps;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class selectSpec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_spec);

        //poulet caire
        AppCompatImageView presspchair = (AppCompatImageView) findViewById(R.id.pchair);
        AppCompatImageView checkpchair = (AppCompatImageView) findViewById(R.id.pchair_chek);
        presspchair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Action
                Intent intent = new Intent(getApplicationContext(), matSelect.class);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                startActivity(intent);
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);
        //pondeuse
        AppCompatImageView presspondeuse = (AppCompatImageView) findViewById(R.id.pondeuse);
        AppCompatImageView checkpondeuse = (AppCompatImageView) findViewById(R.id.pondeuse_chek);
        presspondeuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Action
            }
        });


        //porc
        AppCompatImageView pressporc = (AppCompatImageView) findViewById(R.id.porc);
        AppCompatImageView checkporc = (AppCompatImageView) findViewById(R.id.porc_chek);
        pressporc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Action
            }
        });


        //catfish
        AppCompatImageView presscatfish = (AppCompatImageView) findViewById(R.id.catfish);
        AppCompatImageView checkcatfish = (AppCompatImageView) findViewById(R.id.catfish_chek);
        presscatfish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                Intent intent = new Intent(getApplicationContext(), fingerprint.class);
                startActivity(intent);
            }
        });


        //tilapia
        AppCompatImageView presstilapia = (AppCompatImageView) findViewById(R.id.tilapia);
        AppCompatImageView checktilapia = (AppCompatImageView) findViewById(R.id.tilapia_chek);
        presstilapia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Action
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                Intent intent = new Intent(getApplicationContext(), fingerprint.class);
                startActivity(intent);
            }
        });


        //tilapia
        AppCompatImageView presssnail = (AppCompatImageView) findViewById(R.id.snail);
        AppCompatImageView checksnail = (AppCompatImageView) findViewById(R.id.snail_chek);
        presssnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Action
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ImageView dy_bacground = (ImageView) findViewById(R.id.iron_background_img);

            //layout
            RelativeLayout RelAlimL = (RelativeLayout) findViewById(R.id.formlite);
            RelativeLayout RelAlimP = (RelativeLayout) findViewById(R.id.formpro);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //define bacgroung
                    dy_bacground.setImageResource(R.drawable.alim_l);

                    RelAlimL.setVisibility(View.VISIBLE);
                    RelAlimP.setVisibility(View.INVISIBLE);
                return true;
                case R.id.navigation_dashboard:
                    //define bacgroung
                    dy_bacground.setImageResource(R.drawable.alim_p);

                    RelAlimP.setVisibility(View.VISIBLE);
                    RelAlimL.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_farm:
                    //define bacgroung
                    dy_bacground.setImageResource(R.drawable.pelets);

                    return true;
                case R.id.navigation_notifications:
                    //define bacgroung
                    dy_bacground.setImageResource(R.drawable.bale);

                    return true;
                case R.id.navigation_adico:
                    //define bacgroung
                    dy_bacground.setImageResource(R.drawable.cidicooic);

                    return true;
            }
            return false;
        }
    };
}
