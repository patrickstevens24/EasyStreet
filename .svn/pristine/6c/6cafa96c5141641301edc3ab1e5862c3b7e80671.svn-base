/*
 * TCSS 305 - Winter 2016
 * Assignment 3 - EasyStreet
 */

package model;

import java.util.Map;

/**
 * Represents a ATV.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class Atv extends AbstractVehicle {
    /**Death time for ATV. */
    private static final int DEATH_TIME = 15;
    /**
     * Constructs a new ATV.
     * 
     * @param theX 
     * @param theY 
     * @param theDirection 
     */
    public Atv(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, DEATH_TIME);
    }
    /**
     * ATVs can travel on any terrain except for walls.
     * 
     * @param theLight 
     * @param theTerrain 
     * @return everything but the wall
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return !(theTerrain == Terrain.WALL);
    }
    /**
     * ATVs randomly select which direction to go. And they also never reverse.
     * 
     * @param theNeighbors 
     * @return theDirection chosen
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction atvDirection  = this.getDirection();
        Direction changeAtv;
        Direction currentDirection = null;
        boolean tru = true;
        while (tru) {
            changeAtv = Direction.random();
            if (theNeighbors.get(changeAtv) == Terrain.WALL) {
                tru = true;
            } else if (changeAtv == atvDirection.reverse()) {
                tru = true;
            } else {
                tru = false;
                this.setDirection(changeAtv);
                currentDirection = changeAtv;
            }
        }
        return currentDirection;
    }
}
