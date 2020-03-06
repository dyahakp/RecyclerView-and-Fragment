package com.example.pahlawanku;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    //langkah 5 bikin deklarasi buttonnya
    BottomNavigationView bottomNavigationView;
    //5
    //7
    Fragment selectedFragment = new Profile(); //default home ---> new profile()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //6
        bottomNavigationView = findViewById(R.id.btn_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //7
        loadFragments(selectedFragment);
    }

    //8
    private boolean loadFragments(Fragment selectedFragment) {
        //diganti boolean biar gak error antisipasi
        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_content, selectedFragment)
                    .commit();
            return true;
        }
        return false;

    }

    @Override
    //6
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //9
        switch (menuItem.getItemId()) {
            case R.id.profile_bar:
                selectedFragment = new Profile(); //dr menu
                loadFragments(selectedFragment);
                break;

            case R.id.list_bar:
                selectedFragment = new HeroList(); //dr menu
                loadFragments(selectedFragment);
                break;
            //bikin recycler view

        }
        return true;
    }
}
