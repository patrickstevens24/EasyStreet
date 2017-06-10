/*
 * TCSS 305 - Winter 2016
 * Assignment 3 - EasyStreet
 */

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents a truck. 
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class Truck extends AbstractVehicle {
    /**Death time for a truck. */
    private static final int DEATH_TIME = 0;
    
    /**
     * Constructs a new Truck.
     * 
     * @param theX 
     * @param theY 
     * @param theDirection 
     */
    public Truck(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, DEATH_TIME);
    }
    /**
     * Trucks can go only go on streets and lights and doesn't care about light color. 
     * 
     * @param theTerrain 
     * @param theLight 
     * @return if the truck can pass or not
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        return theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT;
    }
    

    /**
     * Trucks last resort move is reverse. They can travel on streets and lights. 
     * 
     * @param theNeighbors 
     * @return the trucks direction
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction truckDirection  = this.getDirection();
        Direction changeTruck = null;
        Direction currentDirection = null; 
        final Random random = new Random();
        final List<Direction> directionList = new ArrayList<>();
        
        if (theNeighbors.get(truckDirection) == Terrain.STREET 
                        || theNeighbors.get(truckDirection) == Terrain.LIGHT) {
            currentDirection = truckDirection;
            directionList.add(currentDirection);
        } 
        if (theNeighbors.get(truckDirection.left()) == Terrain.STREET 
                        || theNeighbors.get(truckDirection.left()) == Terrain.LIGHT) {
            currentDirection = truckDirection;
            directionList.add(currentDirection.left());
        } 
        if (theNeighbors.get(truckDirection.right()) == Terrain.STREET 
                        || theNeighbors.get(truckDirection.right()) == Terrain.LIGHT) {
            currentDirection = truckDirection;
            directionList.add(currentDirection.right()); 
        } 
        if (directionList.isEmpty()) {
            changeTruck = truckDirection.reverse();
        } else {
            final int chooseRandom = random.nextInt(directionList.size());
            changeTruck = directionList.get(chooseRandom);
        }
        return changeTruck;

    }

}
