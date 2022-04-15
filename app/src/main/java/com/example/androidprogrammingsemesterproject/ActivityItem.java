package com.example.androidprogrammingsemesterproject;

import android.graphics.drawable.Drawable;

public class ActivityItem {
    String name, unitType;
    int activityPriority, resID, streak;
    double doubleMax, doubleProgress;

    public ActivityItem(String name,String unitType, int activityPriority, double doubleMax, double doubleProgress, int resID, int streak){
        this.name = name;
        this.unitType = unitType;
        this.activityPriority = activityPriority;
        this.doubleMax = doubleMax;
        this.doubleProgress = doubleProgress;
        this.resID = resID;
        this.streak = streak;
    }

    public String getName() {
        return name;
    }

    public String getActivityPriority() {
        String priority;
        if (activityPriority == 1){
            priority = "High";
        }
        else if (activityPriority == 2){
            priority = "Med.";
        }
        else {
            priority = "Low";
        }
        return priority;
    }

    public double getdoubleMax() {
        return doubleMax;
    }

    public double getdoubleProgress() {
        return doubleProgress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResID() {
        return resID;
    }

    public String getUnitType() {
        return unitType;
    }

    public int getStreak() {
        return streak;
    }

    public void setActivityPriority(int activityPriority) {
        this.activityPriority = activityPriority;
    }

    public void setdoubleMax(double floatMax) {
        this.doubleMax = doubleMax;
    }

    public void setdoubleProgress(double doubleProgress) {
        this.doubleProgress = doubleProgress;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    @Override
    public String toString() {
        return "ActivityItem{" +
                "name='" + name + '\'' +
                ", unitType='" + unitType + '\'' +
                ", activityPriority=" + activityPriority +
                ", resID=" + resID +
                ", streak=" + streak +
                ", floatMax=" + doubleMax +
                ", floatProgress=" + doubleProgress +
                '}';
    }
}
