package com.example.greenday;

public class Info{
    public float minutesDriving;
    public int recycledBottles;
    public int recycledBags;
    public boolean usesRenewableEnergy;
    public float ouncesOfMeatEaten;
    public int appReferrals;
    public float volunteerHours;
    public int[] date;

    public Info(float newDriving, int newBottles, int newBags, boolean newEnergy, float newMeat,
                int newReferrals, float newVolunteer, int[] newDate){
        minutesDriving = newDriving;
        recycledBottles = newBottles;
        recycledBags = newBags;
        usesRenewableEnergy = newEnergy;
        ouncesOfMeatEaten = newMeat;
        appReferrals = newReferrals;
        volunteerHours = newVolunteer;
        date = newDate;
    }

    public String[] getVar(int pos){
        String[] ret = new String[2];
        switch(pos){
            case 0:
                ret[0] = "Minutes Driven:";
                ret[1] = Float.toString(minutesDriving);
                return ret;
            case 1:
                ret[0] = "Bottles Recycled:";
                ret[1] = Integer.toString(recycledBottles);
                return ret;
            case 2:
                ret[0] = "Uses Renewable Energy:";
                ret[1] = (usesRenewableEnergy ? "True" : "False");
                return ret;
            case 3:
                ret[0] = "Ounces of Meat Eaten:";
                ret[1] = Float.toString(ouncesOfMeatEaten);
                return ret;
            case 4:
                ret[0] = "App Referrals:";
                ret[1] = Integer.toString(appReferrals);
                return ret;
            default:
                ret[0] = "Volunteer Hours:";
                ret[1] = Float.toString(volunteerHours);
                return ret;

        }
    }
}