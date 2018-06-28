package daraunited.com.fisherinnovapps;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lincoln on 05/05/16.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "ArcheosSet";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_FIRST_TIME_LAUNCH_CC = "IsFirstTimeLaunchCC";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public void setFirstTimeLaunchconnecte(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH_CC, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public boolean isFirstTimeLaunchconnecte() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH_CC, true);
    }

    public boolean isFirstTimeLaunchs() {
        return pref.getBoolean(Constants.IS_LOGGED_IN,false );
    }

    public SharedPreferences.Editor MyPrefEditor() {
        return pref.edit();
    }
}
