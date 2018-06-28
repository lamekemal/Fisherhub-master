    package daraunited.com.fisherinnovapps;

    import android.os.Build;
    import android.os.Bundle;
    import android.support.design.widget.TabLayout;
    import android.support.v4.app.Fragment;
    import android.support.v4.app.FragmentManager;
    import android.support.v4.app.FragmentPagerAdapter;
    import android.support.v4.view.ViewPager;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.widget.Toast;

    import com.google.android.gms.common.ConnectionResult;
    import com.google.android.gms.common.GoogleApiAvailability;
    import com.google.firebase.auth.FirebaseAuth;
    import com.google.firebase.auth.FirebaseUser;
    import com.microsoft.windowsazure.notifications.NotificationsManager;
    import android.content.Intent;
    import android.util.Log;
    import android.widget.TextView;
    import android.widget.Toast;
    import java.util.ArrayList;
    import java.util.List;

    import daraunited.com.fisherinnovapps.Notification.MyHandler;
    import daraunited.com.fisherinnovapps.Notification.NotificationSettings;
    import daraunited.com.fisherinnovapps.Notification.RegistrationIntentService;

    public class fingerprint extends AppCompatActivity {
        public static fingerprint mainActivity;
        public static Boolean isVisible = false;
        private static final String TAG = "MainActivity";
        private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
        private FirebaseAuth mAuth;
        FirebaseUser currentUser;
        private Toolbar toolbar;
        private TabLayout tabLayout;
        private ViewPager viewPager;
        private int[] tabIcons = {
                R.drawable.ic_trending_up_white_48dp,
                R.drawable.ic_forum_white_48dp,
                R.drawable.ic_shopping_cart_white_48dp,
                R.drawable.ic_library_books_white_24dp
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_icon_text_tabs);

            toolbar = (Toolbar) findViewById(R.id.toolbars);
            setSupportActionBar(toolbar);
            //getSupportActionBar().setDisplayUseLogoEnabled(true);
            //getSupportActionBar().setLogo(R.drawable.ic_person_white_24dp);
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(viewPager);

            tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);
            setupTabIcons();

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setNavigationBarColor(getResources().getColor(R.color.primary));
            }
            mAuth = FirebaseAuth.getInstance();
            mainActivity = this;
            //NotificationsManager.handleNotifications(this, NotificationSettings.SenderId, MyHandler.class);
            //registerWithNotificationHubs();
        }

        private void setupTabIcons() {
            tabLayout.getTabAt(0).setIcon(tabIcons[3]);
            tabLayout.getTabAt(1).setIcon(tabIcons[0]);
            tabLayout.getTabAt(1).select();
            tabLayout.getTabAt(2);
            tabLayout.getTabAt(3).setIcon(tabIcons[1]);
        }

        private boolean checkPlayServices() {
            GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
            int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
            if (resultCode != ConnectionResult.SUCCESS) {
                if (apiAvailability.isUserResolvableError(resultCode)) {
                    apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                            .show();
                } else {
                    Log.i(TAG, "This device is not supported by Google Play Services.");
                    ToastNotify("This device is not supported by Google Play Services.");
                    finish();
                }
                return false;
            }
            return true;
        }
        public void registerWithNotificationHubs()
        {
            if (checkPlayServices()) {
                // Start IntentService to register this application with FCM.
                Intent intent = new Intent(this, RegistrationIntentService.class);
                startService(intent);
            }
        }

        public void ToastNotify(final String notificationMessage) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(fingerprint.this, notificationMessage, Toast.LENGTH_LONG).show();
                    //TextView helloText = (TextView) findViewById(R.id.text_hello);
                    //helloText.setText(notificationMessage);
                }
            });
        }

        @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            currentUser = mAuth.getCurrentUser();

        }

        private void setupViewPager(ViewPager viewPager) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

            adapter.addFrag(new FourFragment(), "");
            adapter.addFrag(new OneFragment(), "");
            adapter.addFrag(new ThreeFragment(), "MA FERME");
            adapter.addFrag(new TwoFragment(), "");
            viewPager.setAdapter(adapter);
        }
        /*
        @Override
        public void onBackPressed() {
            if (viewPager.getCurrentItem() == 2){
                if (ThreeFragment.cangobackforwbrowser() ==true){
                    Toast.makeText(getBaseContext(), "Opération en cour....", Toast.LENGTH_LONG).show();
                    ThreeFragment.gobackforwbrowser();
                }else {
                    finish();
                }
            } else {
                finish();
            }
        }*/

        class ViewPagerAdapter extends FragmentPagerAdapter {
            private final List<Fragment> mFragmentList = new ArrayList<>();
            private final List<String> mFragmentTitleList = new ArrayList<>();

            public ViewPagerAdapter(FragmentManager manager) {
                super(manager);
            }

            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            public void addFrag(Fragment fragment, String title) {
                mFragmentList.add(fragment);
                mFragmentTitleList.add(title);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentTitleList.get(position);
            }

        }
    }