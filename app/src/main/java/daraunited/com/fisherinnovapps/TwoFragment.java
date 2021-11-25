package daraunited.com.fisherinnovapps;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.clover_studio.spikachatmodule.ChatActivity;
import com.clover_studio.spikachatmodule.models.Config;
import com.clover_studio.spikachatmodule.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class TwoFragment extends Fragment{
    private PrefManager prefManager;
    private String Userdata[] = new String[10];
    private String rawpopom;
    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //GET SETTINGS
        prefManager = new PrefManager(getActivity().getApplicationContext());
        //APPLY SETTINGD
        getUserSettingBystring();
        //INFLATE VIEW
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        //ASSIGN IMAGE VIEW FONCTION
        ImageView Oneacard = (ImageView) v.findViewById(R.id.thumbnailtwo);
        CardView OneacardV = (CardView) v.findViewById(R.id.card_view_two_a);
        Oneacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spikahelp();
                //StartActivityForResult(myIntent, 0);
            }
        });
        OneacardV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spikahelp();
                //StartActivityForResult(myIntent, 0);
            }
        });
        //ASSIGN IMAGE VIEW FONCTION
        final EditText SharedBoxl = (EditText) v.findViewById(R.id.TxMOR);

        ImageView Oneacardb = (ImageView) v.findViewById(R.id.thumbnailb);
        Oneacardb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //spikahelppersonnal(SharedBoxl.getText().toString());
                //StartActivityForResult(myIntent, 0);
            }
        });
        //ASSIGN GROUP NAME VAR
        if (Userdata[9] == "_"){
            final EditText SharedBoxlx = (EditText) v.findViewById(R.id.TxMOR);
            SharedBoxlx.setText("Entrez le nom de votre groupe.");
        } else {
            final EditText SharedBoxlx = (EditText) v.findViewById(R.id.TxMOR);
            SharedBoxlx.setText(Userdata[9]);
        }
        return v;
    }

    public void getUserSettingBystring(){
        Userdata[0] = prefManager.pref.getString(Constants.EMAIL, "EMAIL_INVALID");
        Userdata[1] = prefManager.pref.getString(Constants.NAME, "NAME_INVALID");
        Userdata[2] = prefManager.pref.getString(Constants.ADRESS, "ADRESS_INVALID");
        Userdata[3] = prefManager.pref.getString(Constants.MNUM, "MNUM_INVALID");
        Userdata[4] = prefManager.pref.getString(Constants.AGE, "AGE_INVALID");
        Userdata[5] = prefManager.pref.getString(Constants.ALIAS, "ALIAS_INVALID");
        Userdata[6] = prefManager.pref.getString(Constants.CITY, "CITY_INVALID");
        Userdata[7] = prefManager.pref.getString(Constants.UNIQUE_ID, "UNIQUE_ID_INVALID");
        //Userdata[8] = "Agro-forum";
        Userdata[8] = "Forum-Pisciculteurs";
        Userdata[9] = prefManager.pref.getString(Constants.PGroupeN, "_");
    }

    public void spikahelp (){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        User user = new User();
        user.roomID = Userdata[8];
        user.userID = Userdata[5];
        user.name = Userdata[1];
        user.avatarURL = currentUser.getPhotoUrl().toString();
        Config config = new Config();
        config.apiBaseUrl = "http://archeos.ovh:3320/spika/v1/";
        config.socketUrl = "http://archeos.ovh:3320/spika";
        ChatActivity.startChatActivityWithConfig(getContext(), user, config);
    }
public void spikahelppersonnal (final String PrivateGroupeName){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Demande de confirmation");
        builder.setMessage("Etes vous bien sur que [" + PrivateGroupeName + "] vous convient?");

        builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                User user = new User();
                user.roomID = PrivateGroupeName;
                user.userID = Userdata[5];
                user.name = Userdata[1];
                Userdata[9] = PrivateGroupeName;
                SharedPreferences.Editor editor = prefManager.MyPrefEditor();
                editor.putString(Constants.PGroupeN,PrivateGroupeName);
                editor.apply();
                user.avatarURL = "http://52.32.105.30:880/img/avatar.jpg";
                Config config = new Config();
                config.apiBaseUrl = "http://52.32.105.30:880/spika/v1/";
                config.socketUrl = "http://52.32.105.30:880/spika";
                ChatActivity.startChatActivityWithConfig(getActivity().getApplicationContext(), user, config);

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NON", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getActivity().getApplicationContext(), "Opération annulé...", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
