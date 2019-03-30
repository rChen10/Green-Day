package com.example.greenday;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obtain saved info
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedEditor = sharedPref.edit();

        // find date
        Calendar date = Calendar.getInstance();
        int lastDate[] = new int[3]; // month, date, year
        int currentDate[] = new int[3]; // month, date, year

        int defaultMonth = 0;
        lastDate[0] = sharedPref.getInt(getString(R.string.month), defaultMonth);
        int defaultDate = 0;
        lastDate[1] = sharedPref.getInt(getString(R.string.date), defaultDate);
        int defaultYear = 0;
        lastDate[2] = sharedPref.getInt(getString(R.string.year), defaultYear);

        currentDate[0] = date.get(date.MONTH)+1;
        currentDate[1] = date.get(date.DATE);
        currentDate[2] = date.get(date.YEAR);

        Info info;

        if(lastDate[0] != currentDate[0]
            || lastDate[1] != currentDate[1]
            || lastDate[2] != currentDate[2]) {
            // prompt update if date is new

        }
        sharedEditor.putInt(getString(R.string.month), currentDate[0]);
        sharedEditor.putInt(getString(R.string.date), currentDate[1]);
        sharedEditor.putInt(getString(R.string.year), currentDate[2]);
        sharedEditor.apply();
        //else {
            // read from info otherwise
            float defaultDriving = Float.parseFloat(getResources().getString(R.string.minutes_driving_default));
            float minutesDriving = sharedPref.getFloat(getString(R.string.minutes_driving), defaultDriving);
            int defaultBottles = Integer.parseInt(getResources().getString(R.string.recycle_bottles_default));
            int recycledBottles = sharedPref.getInt(getString(R.string.recycle_bottles), defaultBottles);
            int defaultBags = Integer.parseInt(getResources().getString(R.string.recycle_bags_default));
            int recycledBags = sharedPref.getInt(getString(R.string.recycle_bags), defaultBags);
            int defaultEnergy = Integer.parseInt(getResources().getString(R.string.use_renewable_energy_default));
            boolean usesRenewable = sharedPref.getInt(getString(R.string.use_renewable_energy), defaultEnergy) > 0;
            float defaultMeat = Float.parseFloat(getResources().getString(R.string.ounces_of_meat_eaten_default));
            float ouncesMeatEaten = sharedPref.getFloat(getString(R.string.ounces_of_meat_eaten), defaultMeat);
            int defaultReferrals = Integer.parseInt(getResources().getString(R.string.app_referrals_default));
            int appReferrals = sharedPref.getInt(getString(R.string.app_referrals), defaultReferrals);
            float defaultVolunteer = Float.parseFloat(getResources().getString(R.string.volunteer_hours_default));
            float volunteerHours = sharedPref.getFloat(getString(R.string.volunteer_hours), defaultVolunteer);

            info = new Info(minutesDriving, recycledBottles, recycledBags, usesRenewable, ouncesMeatEaten, appReferrals, volunteerHours, lastDate);
        //}

        String textDate = info.date[0] + " / " + info.date[1] + " / " + info.date[2];
        ((TextView) findViewById(R.id.date)).setText(textDate);
        InfoFragment currentStats = new InfoFragment();
        currentStats.setObject(info);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, currentStats);
        fragmentTransaction.commit();
    }
}
