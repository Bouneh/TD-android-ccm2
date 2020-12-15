package com.lamoureux.ccm2_td_android_insset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAfficherMaps(View view){
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void btnQuote(View view){
        startActivity(new Intent(this, Retrofit.class));
    }

    public void btnRecyclerView(View view){
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}