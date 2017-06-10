/*
 * TCSS 305 - Winter 2016
 * Assignment 3 - EasyStreet
 */

package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;


import org.junit.Before;
import org.junit.Test;

/**
 * Test class for truck.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class TruckTest {

    /**Truck to test.*/
    private Truck myTruck;
    /**Neighbor direction to test.*/
    private Map<Direction, Terrain> myNeighbors;

    /**
     * Setting up the truck. 
     */
    @Before
    public void setUp() {
        myTruck = new Truck(1, 1, Direction.NORTH);
        myNeighbors = new HashMap<Direction, Terrain>();
    }
    /** Test method for Truck constructor. */
    @Test
    public void testTruckConstructor() {
        
        assertEquals("Truck x coordinate not initialized correctly!", 1, myTruck.getX());
        assertEquals("Truck y coordinate not initialized correctly!", 1, myTruck.getY());
        assertEquals("Truck direction not initialized correctly!",
                     Direction.NORTH, myTruck.getDirection());
        assertEquals("Truck death time not initialized correctly!", 0, myTruck.getDeathTime());
        assertTrue("Truck isAlive() fails initially!", myTruck.isAlive());
    }

    /**
     * Test method for {@link model.Truck#canPass(model.Terrain, model.Light)}.
     */
    @Test
    public void testCanPassLight() {
        final boolean yellow = myTruck.canPass(Terrain.LIGHT, Light.YELLOW);
        final boolean red = myTruck.canPass(Terrain.LIGHT, Light.RED);
        final boolean green = myTruck.canPass(Terrain.LIGHT, Light.GREEN);
        assertEquals("Test failed for yellow light", true, yellow);
        assertEquals("Test failed for yellow light", true, red);
        assertEquals("Test failed for yellow light", true, green);
        
    }
    
    /**
     * Test method for {@link model.Truck#canPass(model.Terrain, model.Light)}.
     */
    @Test
    public void testCanPassStreet() {
        final boolean yellow = myTruck.canPass(Terrain.STREET, Light.YELLOW);
        final boolean red = myTruck.canPass(Terrain.STREET, Light.RED);
        final boolean green = myTruck.canPass(Terrain.STREET, Light.GREEN);
        assertEquals("Test failed for yellow light", true, yellow);
        assertEquals("Test failed for yellow light", true, red);
        assertEquals("Test failed for yellow light", true, green);
    }
    /**
     * Test method for can pass.
     */
    @Test
    public void testCanPasss() {
        final boolean wall = myTruck.canPass(Terrain.WALL, Light.YELLOW);
        assertEquals("Test", false, wall);
    }

    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionNorthStreet() {
        myNeighbors.put(Direction.NORTH, Terrain.STREET);
        myTruck.setDirection(Direction.EAST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.STREET, 
                     myNeighbors.get(Direction.NORTH));
    }
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionNorthStreetWest() {
        myNeighbors.put(Direction.NORTH, Terrain.STREET);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.STREET, 
                     myNeighbors.get(Direction.NORTH));
    }
    
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionWestStreet() {
        myNeighbors.put(Direction.WEST, Terrain.STREET);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.STREET, 
                     myNeighbors.get(Direction.WEST));
    }
    
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionEastStreet() {
        myNeighbors.put(Direction.EAST, Terrain.STREET);
        myTruck.setDirection(Direction.EAST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.STREET, 
                     myNeighbors.get(Direction.EAST));
    }
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionSouthStreet() {
        myNeighbors.put(Direction.SOUTH, Terrain.STREET);
        myTruck.setDirection(Direction.SOUTH);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.STREET, 
                     myNeighbors.get(Direction.SOUTH));
    }
    
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionNorthLight() {
        myNeighbors.put(Direction.NORTH, Terrain.LIGHT);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.LIGHT, 
                     myNeighbors.get(Direction.NORTH));
    }
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionNorthLightEast() {
        myNeighbors.put(Direction.NORTH, Terrain.LIGHT);
        myTruck.setDirection(Direction.EAST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.LIGHT, 
                     myNeighbors.get(Direction.NORTH));
    }
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionWestLight() {
        myNeighbors.put(Direction.WEST, Terrain.LIGHT);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.LIGHT, 
                     myNeighbors.get(Direction.WEST));
    }
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionEastLight() {
        myNeighbors.put(Direction.EAST, Terrain.LIGHT);
        myTruck.setDirection(Direction.EAST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.LIGHT, 
                     myNeighbors.get(Direction.EAST));
    }
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionSouthLight() {
        myNeighbors.put(Direction.SOUTH, Terrain.LIGHT);
        myTruck.setDirection(Direction.SOUTH);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Incorrect Truck Direction", Terrain.LIGHT, 
                     myNeighbors.get(Direction.SOUTH));
    }
    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testDirectionReverse() {
        myNeighbors.put(Direction.NORTH, Terrain.WALL);
        myNeighbors.put(Direction.EAST, Terrain.WALL);
        myNeighbors.put(Direction.WEST, Terrain.WALL);
        
        myNeighbors.put(Direction.SOUTH, Terrain.LIGHT);
        myTruck.setDirection(Direction.NORTH);
        myTruck.chooseDirection(myNeighbors);
        
        assertEquals("PLS", Terrain.LIGHT, myNeighbors.get(Direction.SOUTH));
        
       
    }
}
