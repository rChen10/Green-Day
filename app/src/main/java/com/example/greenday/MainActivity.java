package com.example.greenday;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obtain saved info
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        // find date
        Calendar currentDate = Calendar.getInstance();

        // prompt update if date is new
        float defaultDriving = Float.parseFloat(getResources().getString(R.string.minutes_driving_default));
        float minutesDriving = sharedPref.getFloat(getString(R.string.minutes_driving), defaultDriving);

        // read from info otherwise


        Fragment = new ManagerFragment();
        Fragment.setObject(mainManager);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, collectionsFragment);
        fragmentTransaction.commit();
    }
}
