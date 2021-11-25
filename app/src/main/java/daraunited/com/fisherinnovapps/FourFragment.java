package daraunited.com.fisherinnovapps;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.clover_studio.spikachatmodule.ChatActivity;
import com.clover_studio.spikachatmodule.models.Config;
import com.clover_studio.spikachatmodule.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FourFragment extends Fragment{
    private PrefManager prefManager;
    private String Userdata[] = new String[10];
    public FourFragment() {
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
        //getUserSettingBystring();
        //StartNews();
        View v = inflater.inflate(R.layout.fragment_one_tips, container, false);
       ImageView img = (ImageView) v.findViewById(R.id.imageView);
        //ASSIGN IMAGE VIEW FONCTION
        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            TabLayout myHost = (TabLayout) getActivity().findViewById(R.id.tabs);
            myHost.setScrollPosition(1,0f,true);
            myHost.getTabAt(1).select();
            spikahelp ();
        }
    }

   /* @Override
    public void onPause(){
        super.onPause();
        TabLayout myHost = (TabLayout) getActivity().findViewById(R.id.tabs);
        myHost.getTabAt(1).select();
    }*/

    public void StartNewsTo(){
        Intent myIntent = new Intent(getContext(), Evaluateff.class);
        startActivity(myIntent);
        TabLayout myHost = (TabLayout) getActivity().findViewById(R.id.tabs);
        myHost.setScrollPosition(1,0f,true);
        myHost.getTabAt(1).select();
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
        Userdata[8] = "Actualités-Annonces";
        Userdata[9] = prefManager.pref.getString(Constants.PGroupeN, "_");
    }

        public void spikahelp (){
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            getUserSettingBystring();
            User user = new User();
            user.roomID = Userdata[8];
            user.userID = Userdata[5];
            user.name = Userdata[1];
            user.avatarURL = currentUser.getPhotoUrl().toString();
            Config config = new Config();
            config.apiBaseUrl = "http://archeos.ovh:3320/spika/v1/";
            config.socketUrl = "http://archeos.ovh:3320/spika";
            Bundle bundle = ActivityOptions.makeCustomAnimation(getContext(),R.anim.push_left_in, R.anim.push_left_out).toBundle();
            ChatActivity.startChatActivityWithConfigAndAnim(getContext(), user, config, bundle);
            TabLayout myHost = (TabLayout) fingerprint.mainActivity.findViewById(R.id.tabs);
            myHost.setScrollPosition(1,0f,true);
            myHost.getTabAt(1).select();

        }
    public static void startCh() {

    }
}
