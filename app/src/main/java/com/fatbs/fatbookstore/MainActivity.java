package com.fatbs.fatbookstore;

import android.net.Uri;
import android.os.Bundle;

import com.fatbs.fatbookstore.fragment.BlankFragment;
import com.fatbs.fatbookstore.fragment.BlankFragment2;
import com.fatbs.fatbookstore.fragment.BlankFragment3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener, BlankFragment2.OnFragmentInteractionListener, BlankFragment3.OnFragmentInteractionListener {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    addFragment(new BlankFragment(), true, "Satu");
                    return true;
                case R.id.navigation_dashboard:
                    addFragment(new BlankFragment2(), true, "Dua");
                    return true;
                case R.id.navigation_notifications:
                    addFragment(new BlankFragment3(), true, "Tiga");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if(addToBackStack) {
            ft.addToBackStack(tag);
        }

        ft.replace(R.id.message, fragment, tag);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
