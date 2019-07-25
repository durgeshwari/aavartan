package com.aavartan.aavartan2k19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.aavartan.aavartan2k19.fragments.AttractionFragment;
import com.aavartan.aavartan2k19.fragments.EventFragment;
import com.aavartan.aavartan2k19.fragments.FaceFragment;
import com.aavartan.aavartan2k19.fragments.HomeFragment;
import com.aavartan.aavartan2k19.fragments.sponsorFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(BottomNavActivity.this);


    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment=null;
        switch ((menuItem.getItemId())){
            case R.id.navigation_home:
                fragment=new HomeFragment();
                break;
            case R.id.navigation_event:
                fragment=new EventFragment();
                break;

            case R.id.navigation_attraction:
                fragment=new AttractionFragment();
                break;
            case R.id.navigation_face:
                fragment=new FaceFragment();
                break;
            case R.id.navigation_tshirt:
                fragment=new sponsorFragment();
                break;
        }
        return loadFragment(fragment);
    }
}

