/*
 * TCSS 305 - Winter 2016
 * Assignment 3 - EasyStreet
 */

package model;

import java.util.Map;

/**
 * Represents a car. 
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class Car extends AbstractVehicle {
    /**Death time for car. */
    private static final int DEATH_TIME = 5;
    
    /**
     * Constructs a car. 
     * 
     * @param theX 
     * @param theY 
     * @param theDirection 
     */
    public Car(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, DEATH_TIME);
    }
    
    /**
     * Cars can only travel through streets and lights. Stops for red lights. 
     * 
     * @param theLight 
     * @param theTerrain 
     * @return if it can pass or not
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean pass = false;
        if ((theTerrain == Terrain.STREET) || (theTerrain == Terrain.LIGHT)) {
            pass = true;
        }
        if ((theTerrain == Terrain.LIGHT) && (theLight == Light.RED)) {
            pass = false;
        }
        return pass;
    }

    /**
     * Cars travel on streets and lights and turns around if last possible move.
     * 
     * @param theNeighbors 
     * @return theDirection chosen
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction carDirection  = this.getDirection();
        Direction currentDirection = null;
        if ((theNeighbors.get(carDirection) == Terrain.STREET) 
                        || (theNeighbors.get(carDirection) == Terrain.LIGHT)) {
            currentDirection = carDirection;
        } else if ((theNeighbors.get(carDirection.left()) == Terrain.STREET)
                        || (theNeighbors.get(carDirection.left()) == Terrain.LIGHT)) {
            currentDirection = carDirection.left();
        } else if ((theNeighbors.get(carDirection.right()) == Terrain.STREET)
                        || (theNeighbors.get(carDirection.right()) == Terrain.LIGHT)) {
            currentDirection = carDirection.right();
        } else {
            currentDirection = carDirection.reverse();
        }
        return currentDirection;
    }

}
