/*
 * TCSS 305 - Winter 2016
 * Assignment 3 - EasyStreet
 */

package model;

/**
 * Represents a Taxi.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class Taxi extends Car {
    /**Counter for traffic light. */
    private int myCounter;
    
    /**
     * Constructs a Taxi. 
     * 
     * @param theX 
     * @param theY 
     * @param theDirection 
     */
    public Taxi(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection);
    }
    /**
     * Taxis move the same as cars except they wait 3 turns to go on a red light. 
     * 
     * @param theLight 
     * @param theTerrain 
     * @return everything but the wall
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean pass = false;
        final int taxiCanPass = 4;

        if ((theTerrain == Terrain.STREET) || ((theTerrain == Terrain.LIGHT 
                        && (theLight == Light.GREEN || (theLight == Light.YELLOW))))) {
            pass = true;
        } else if ((theTerrain == Terrain.LIGHT) && (theLight == Light.RED)) {
            pass = false;
            myCounter++;
            if (myCounter == taxiCanPass) {
                myCounter = 0;
                pass = true;
            }
        }
        return pass;
    }
}
