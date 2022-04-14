package com.example.androidprogrammingsemesterproject;

import android.graphics.drawable.Drawable;

public class ActivityItem {
    String name, unitType;
    int intMax, intProgress, activityPriority, resID, streak;
    float floatMax, floatProgress;

    public ActivityItem(String name,String unitType, int intMax, int intProgress, int activityPriority, float floatMax, float floatProgress, int resID, int streak){
        this.name = name;
        this.unitType = unitType;
        this.intMax = intMax;
        this.intProgress = intProgress;
        this.activityPriority = activityPriority;
        this.floatMax = floatMax;
        this.floatProgress = floatProgress;
        this.resID = resID;
        this.streak = streak;
    }

    public String getName() {
        return name;
    }

    public int getIntMax() {
        return intMax;
    }

    public int getIntProgress() {
        return intProgress;
    }

    public int getActivityPriority() {
        return activityPriority;
    }

    public float getFloatMax() {
        return floatMax;
    }

    public float getFloatProgress() {
        return floatProgress;
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

    public void setIntMax(int intMax) {
        this.intMax = intMax;
    }

    public void setIntProgress(int intProgress) {
        this.intProgress = intProgress;
    }

    public void setActivityPriority(int activityPriority) {
        this.activityPriority = activityPriority;
    }

    public void setFloatMax(float floatMax) {
        this.floatMax = floatMax;
    }

    public void setFloatProgress(float floatProgress) {
        this.floatProgress = floatProgress;
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
                ", intMax=" + intMax +
                ", intProgress=" + intProgress +
                ", activityPriority=" + activityPriority +
                ", resID=" + resID +
                ", streak=" + streak +
                ", floatMax=" + floatMax +
                ", floatProgress=" + floatProgress +
                '}';
    }
}
