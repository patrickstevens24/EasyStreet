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
 * Represents a Human.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class Human extends AbstractVehicle {
    /** */
    private static final int DEATH_TIME = 45;
    /** */
    private final Terrain myTerrain; 
    
    /**
     * Constructs a new Human. 
     * 
     * @param theX 
     * @param theY  
     * @param theDirection 
     * @param theTerrain 
     */
    public Human(final int theX, final int theY, 
                 final Direction theDirection, final Terrain theTerrain) {
        super(theX, theY, theDirection, DEATH_TIME);
        myTerrain = theTerrain;
    }
    
    /**
     * Humans stay on their initial terrain.
     * 
     * @param theTerrain 
     * @param theLight 
     * @return if it can pass or not
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        
        if ((myTerrain == Terrain.STREET || myTerrain == Terrain.LIGHT) 
                        && (theTerrain == Terrain.STREET || (theTerrain == Terrain.LIGHT))) {
            canPass = true;
        } else if (theTerrain == myTerrain) {
            canPass = true;
        }
        return canPass;     
    }
    /**
     * Humans moves all directions on their initial terrain. 
     * 
     * @param theNeighbors 
     * @return theDirection chosen
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final List<Direction> directionList = new ArrayList<Direction>();
        final Random random = new Random();
       
        final boolean streetLight = (myTerrain == Terrain.LIGHT) 
                        || (myTerrain == Terrain.STREET);
        
        for (final Direction dir : theNeighbors.keySet()) {
            if (streetLight && theNeighbors.get(dir) == Terrain.STREET 
                        || theNeighbors.get(dir) == Terrain.LIGHT) {
                directionList.add(dir);
            } else if (myTerrain == theNeighbors.get(dir)) {
                directionList.add(dir);
            }
        }
        final int chooseRandom = random.nextInt(directionList.size());
        return directionList.get(chooseRandom);
    }
}
