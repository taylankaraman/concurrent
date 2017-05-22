package com.company.interfaces;

/**
 * Created by taylan.karaman on 22-May-17.
 */
public interface Bicycle {
    void changeCadence(int newValue);

    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);

    void printStates();
}
