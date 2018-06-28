package com.sourcey.materiallogindemo;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import daraunited.com.fisherinnovapps.Constants;
import daraunited.com.fisherinnovapps.PrefManager;
import daraunited.com.fisherinnovapps.R;
import daraunited.com.fisherinnovapps.fingerprint;

import daraunited.com.fisherinnovapps.RequestInterface;
import daraunited.com.fisherinnovapps.models.ServerRequest;
import daraunited.com.fisherinnovapps.models.ServerResponse;
import daraunited.com.fisherinnovapps.models.User;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int RC_SIGN_IN = 9001;
    private static final int REQUEST_SIGNUP = 0;
    private PrefManager prefManager;
    GoogleApiClient mGoogleApiClient;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) Button _loginButton;
    @BindView(R.id.link) TextView _signupLink;
    @BindView(R.id.lingoogle) ImageView _googleLink;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        prefManager = new PrefManager(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.primaryrt));
        }

        setContentView(R.layout.activity_login);
        //demarrage de l'activity

        ButterKnife.bind(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,null)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mAuth = FirebaseAuth.getInstance();

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });


        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        _googleLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                signIn();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        if (!prefManager.isFirstTimeLaunchconnecte()) {
            Intent intent = new Intent(getApplicationContext(), fingerprint.class);
            startActivity(intent);
            finish();
        }

    }
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            Toast.makeText(LoginActivity.this, "Authentication come-" + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                            String Userdata[] = new String[10];
                            Userdata[0] = user.getEmail();
                            Userdata[1] = user.getDisplayName();
                            Userdata[2] = user.getProviderId() + " //Google User, refer to complete Data of Adress, This is user.getProviderId()";
                            Userdata[3] = user.getPhoneNumber();
                            Userdata[4] = "00  //Google User, refer to complete Data of AGE";
                            Userdata[5] = user.getDisplayName();
                            Userdata[6] = user.getEmail() + " //Google User, refer to complete Data of CITY";
                            Userdata[7] = user.getUid();
                            SharedPreferences.Editor editor = prefManager.MyPrefEditor();
                            editor.putBoolean(Constants.IS_LOGGED_IN,true);
                            editor.putString(Constants.EMAIL,Userdata[0]);
                            editor.putString(Constants.NAME,Userdata[1]);
                            editor.putString(Constants.ADRESS,Userdata[2]);
                            editor.putString(Constants.MNUM,Userdata[3]);
                            editor.putString(Constants.AGE,Userdata[4]);
                            editor.putString(Constants.ALIAS,Userdata[5]);
                            editor.putString(Constants.CITY,Userdata[6]);
                            editor.putString(Constants.UNIQUE_ID,Userdata[7]);
                            editor.apply();
                            prefManager.setFirstTimeLaunchconnecte(false);

                            Intent intent = new Intent(getApplicationContext(), fingerprint.class);
                            startActivityForResult(intent, REQUEST_SIGNUP);
                            finish();
                            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // [END_EXCLUDE]
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    public void login() {
        Log.d(TAG, "Login");
        if (!validate()) {
            onLoginFailed();
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Connexion...");
        progressDialog.show();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        // TODO: Implement your own authentication logic here.
        if(!email.isEmpty() && !password.isEmpty()) {
            _loginButton.setEnabled(false);
            loginProcess(email,password);
        } else {
            Snackbar.make(findViewById(android.R.id.content), "Des champs sont vides... !", Snackbar.LENGTH_LONG).show();
        }
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        //onLoginSuccess();
                         //onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    private void loginProcess(final String email, final String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        ServerRequest request = new ServerRequest();
        request.setOperation(Constants.LOGIN_OPERATION);
        request.setUser(user);
        Call<ServerResponse> response = requestInterface.operation(request);

        response.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, retrofit2.Response<ServerResponse> response) {

                ServerResponse resp = response.body();
                Snackbar.make(findViewById(android.R.id.content), resp.getMessage(), Snackbar.LENGTH_LONG).show();
                if(resp.getResult().equals("success")){
                    Log.d(Constants.TAG,"login reussit");
                    String Userdata[] = new String[10];
                    Userdata[0] = resp.getUser().getEmail();
                    Userdata[1] = resp.getUser().getName();
                    Userdata[2] = resp.getUser().getAdress();
                    Userdata[3] = resp.getUser().getMnum();
                    Userdata[4] = resp.getUser().getAge();
                    Userdata[5] = resp.getUser().getAlias();
                    Userdata[6] = resp.getUser().getCity();
                    Userdata[7] = resp.getUser().getUnique_id();
                    SharedPreferences.Editor editor = prefManager.MyPrefEditor();
                    editor.putBoolean(Constants.IS_LOGGED_IN,true);
                    editor.putString(Constants.EMAIL,resp.getUser().getEmail());
                    editor.putString(Constants.NAME,resp.getUser().getName());
                    editor.putString(Constants.ADRESS,resp.getUser().getName());
                    editor.putString(Constants.MNUM,resp.getUser().getName());
                    editor.putString(Constants.AGE,resp.getUser().getName());
                    editor.putString(Constants.ALIAS,resp.getUser().getName());
                    editor.putString(Constants.CITY,resp.getUser().getName());
                    editor.putString(Constants.UNIQUE_ID,resp.getUser().getUnique_id());
                    editor.apply();
                    prefManager.setFirstTimeLaunchconnecte(false);
                    Intent intent = new Intent(getApplicationContext(), fingerprint.class);
                    startActivity(intent);
                    Toast.makeText(getBaseContext(), resp.getMessage(), Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    _loginButton.setEnabled(true);
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.d(Constants.TAG,"failed");
                Log.d(Constants.TAG,t.getLocalizedMessage());
                //Toast.makeText(getBaseContext(), "Connecté", Toast.LENGTH_LONG).show();
                //Toast.makeText(getBaseContext(), "Echec", Toast.LENGTH_LONG).show();
                Snackbar.make(findViewById(android.R.id.content), t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
                _loginButton.setEnabled(true);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                Snackbar.make(findViewById(android.R.id.content), "ERREUR INCONU", Snackbar.LENGTH_LONG).show();
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "bad run", Toast.LENGTH_LONG).show();
        //finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Echec d'enregistrement", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("Entrer une adresse mail valide");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        /*if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("Carachtères alpha numérique entre 4 et 10");
            valid = false;
        } else {
            _passwordText.setError(null);
        }*/

        return valid;
    }
}
