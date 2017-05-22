package com.company.classes;

import com.company.interfaces.Bicycle;

/**
 * Created by taylan.karaman on 22-May-17.
 */
public class MountainBicycle implements Bicycle{
    private int cadence = 0;
    private int gear = 1;
    private int speed = 0;

    public void speedUp(int amount){
        speed += amount;
    }

    public void changeGear(int newGear){
        gear = newGear;
    }

    public void applyBrakes(int amount){
        speed -= amount;
    }

    public void changeCadence(int newValue){
        cadence = newValue;
    }

    public void printStates(){
        System.out.println("cadence:" +
                cadence + " speed:" +
                speed + " gear:" + gear);
    }

}
