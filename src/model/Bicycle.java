/*
 * TCSS 305 - Winter 2016
 * Assignment 3 - EasyStreet
 */

package model;

import java.util.Map;

/**
 * Represents a Bicycle.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class Bicycle extends AbstractVehicle {
    
    /**Death time for Bicycle. */
    private static final int DEATH_TIME = 25; 
    
    /**
     * Constructs a new Bicycle.
     * 
     * @param theX  
     * @param theY  
     * @param theDirection  
     */
    public Bicycle(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, DEATH_TIME);
    }
    /**
     * Bicycles travels on streets, trails, and lights and only go on green lights. 
     * 
     * @param theLight 
     * @param theTerrain 
     * @return canPass
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        if (theTerrain == Terrain.TRAIL) {
            canPass = true;
        } else if ((theTerrain == Terrain.STREET) || (theTerrain == Terrain.LIGHT)) {
            canPass = true;
        } else if (theTerrain == Terrain.LIGHT 
                        && ((theLight == Light.YELLOW) || (theLight == Light.RED))) {
            canPass = false;
        }
        return canPass;
    }
    
    /**
     * Bicycles prefer trails, if not it continues on the street.
     * 
     * @param theNeighbors 
     * @return theDirection chosen
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction bikeDirection  = this.getDirection();
        Direction currentDirection = null;
        
        if (theNeighbors.get(bikeDirection) == Terrain.TRAIL) {
            currentDirection = bikeDirection;
        } else if (theNeighbors.get(bikeDirection.left()) == Terrain.TRAIL) {
            currentDirection = bikeDirection;
        } else if (theNeighbors.get(bikeDirection.right()) == Terrain.TRAIL) {
            currentDirection = bikeDirection.right();
        } else if ((theNeighbors.get(bikeDirection) == Terrain.STREET) 
                        || (theNeighbors.get(bikeDirection) == Terrain.LIGHT)) {
            currentDirection = bikeDirection;
        } else if ((theNeighbors.get(bikeDirection.left()) == Terrain.STREET) 
                        || (theNeighbors.get(bikeDirection.left()) == Terrain.LIGHT)) {
            currentDirection = bikeDirection.left();
        } else if ((theNeighbors.get(bikeDirection.right()) == Terrain.STREET) 
                        || (theNeighbors.get(bikeDirection.right()) == Terrain.LIGHT)) {
            currentDirection = bikeDirection.right();
        } else {
            currentDirection = bikeDirection.reverse();
        }
        return currentDirection;
    }
}
