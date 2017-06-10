/*
 * TCSS 305 - Winter 2016
 * Assignment 3 - EasyStreet
 */

package model;

/**
 * General vehicle behavior parent class.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public abstract class AbstractVehicle implements Vehicle {
    /**The death time of vehicle. */
    private final int myDeathTime;
    /**The x of a vehicle.*/
    private int myX;
    /**The y of a vehicle. */
    private int myY;
    /**The initial direction. */
    private final Direction myInitialDirection;
    /**The initial X value. */
    private final int myInitialX;
    /**the initial Y value. */
    private final int myInitialY;
    /**The current direction. */
    private Direction myCurrentDirection;
    /**The poke count. */
    private int myPokeCount;
    /**The alive status. */
    private boolean myAlive;
    
    /**
     * Constructs a vehicle with given parameters.
     * 
     * @param theX 
     * @param theY 
     * @param theDirection 
     * @param theDeathTime 
     */
    protected AbstractVehicle(final int theX, final int theY,
                              final Direction theDirection, final int theDeathTime) {
        myInitialY = theY;
        myInitialX = theX;
        myInitialDirection = theDirection;
        myX = theX;
        myY = theY;
        myDeathTime = theDeathTime;
        myCurrentDirection = theDirection;
        myAlive = true;
        myPokeCount = 0;
    }
    /**
     * When vehicles pass by each other this method decides what happens. 
     * 
     * @param theOther
     */
    @Override
    public void collide(final Vehicle theOther) {
        if (isAlive() && theOther.isAlive()) {
            if (getDeathTime() > theOther.getDeathTime()) {
                myAlive = false;
            }
        }
    }
    /**
     * Method that returns the file name if dead or alive.
     * 
     * @return the file name
     */
    @Override
    public String getImageFileName() {
        String fileName = null;
        if (myAlive) {
            fileName = getClass().getSimpleName().toLowerCase() + ".gif";
        } else {
            fileName = getClass().getSimpleName().toLowerCase() + "_dead.gif";
        }
        return fileName;
    }
    
    /**
     * Method that returns the number of pokes until the vehicle is revived.
     * 
     * @return myDeathTime
     */
    @Override
    public int getDeathTime() {
        return myDeathTime;
    }
    
    /**
     * Method that returns the direction of the vehicle.
     * 
     * @return the current direction
     */
    @Override
    public Direction getDirection() {
        return myCurrentDirection;
    }
    /**
     * Method that returns the x coordinate. 
     * 
     * @return myX
     */
    @Override
    public int getX() {
        return myX;
    }
    /**
     * Method that returns the y coordinate.
     * 
     * @return myY
     */
    @Override
    public int getY() {
        return myY;
    }
    /**
     * Method that returns if the vehicle is alive or not.
     * 
     * @return myAlive
     */
    @Override
    public boolean isAlive() {
        return myAlive;
    }
    /**
     * Method that adds up pokes to get to the death time number
     * to revive the vehicle.
     */
    @Override
    public void poke() {
        myPokeCount++;
        if (myPokeCount == getDeathTime()) {
            myPokeCount = 0;
            myAlive = true;
            setDirection(Direction.random());
        }
    }
    /**
     * Method that moves the vehicle back to the starting position. 
     */
    @Override
    public void reset() {
        setX(myInitialX);
        setY(myInitialY);
        setDirection(myInitialDirection); 
        myPokeCount = 0;
        myAlive = true;
    }
    /**
     * Sets the direction as myCurrentDirection.
     * 
     * @param theDirection
     */
    @Override
    public void setDirection(final Direction theDirection) {
        myCurrentDirection = theDirection;
    }
    
    /**
     * Sets the x.
     * 
     * @param theX
     */
    @Override
    public void setX(final int theX) {
        myX = theX;
    }
    /**
     * Sets the Y.
     * 
     * @param theY
     */
    @Override
    public void setY(final int theY) {
        myY = theY;
    }
    /**
     * ToSting to represent the vehicle.
     * 
     * @param the toString
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        if (myAlive) {
            builder.append(getClass().getSimpleName());
        } else {
            builder.append("Pokes: ");
            builder.append(myPokeCount);
        }
        return builder.toString();
    }

}
