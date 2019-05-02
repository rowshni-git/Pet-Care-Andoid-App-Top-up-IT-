package bracu.topup.petcareapp.mainactivity_grid_package;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import bracu.topup.petcareapp.AccountActivity_firebase.Login_Activity;
import bracu.topup.petcareapp.AccountActivity_firebase.SignUp_Activity;
import bracu.topup.petcareapp.R;

public class AccountMain_Activity extends AppCompatActivity {

    private Button  btnRemoveUser, signOut;
    private TextView email;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountmain);
//get firebase auth instance
        auth = FirebaseAuth.getInstance();
        email = (TextView) findViewById(R.id.useremail);

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        setDataToView(user);

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(AccountMain_Activity.this, Login_Activity.class));
                    finish();
                }
            }
        };


    //    btnChangePassword = (Button) findViewById(R.id.change_password_button);

        btnRemoveUser = (Button) findViewById(R.id.remove_user_button);

     //   changePassword = (Button) findViewById(R.id.changePass);

    //    remove = (Button) findViewById(R.id.remove);
        signOut = (Button) findViewById(R.id.sign_out);


     //   remove.setVisibility(View.GONE);




       btnRemoveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AccountMain_Activity.this, "Your profile is deleted:( Create a account now!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(AccountMain_Activity.this, SignUp_Activity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(AccountMain_Activity.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
                finish();
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void setDataToView(FirebaseUser user) {

        email.setText("User Email: " + user.getEmail());


    }

    // this listener will be called when there is change in firebase user session
    FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user == null) {
                // user auth state is changed - user is null
                // launch login activity
                startActivity(new Intent(AccountMain_Activity.this, Login_Activity.class));
                finish();
            } else {
                setDataToView(user);

            }
        }


    };

    //sign out method
    public void signOut() {
        auth.signOut();


// this listener will be called when there is change in firebase user session
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(AccountMain_Activity.this, Login_Activity.class));
                    finish();
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }
}
