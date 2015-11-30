/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
    private static final double DARKENING_FACTOR = 0.1;
    private int courage;
    private int row;
    private int col;
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public BlusterCritter() {
       courage = 3;
    }
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        // Look at all grid locations.
        for (int r = 0; r < getNumRows(); r++)
        {
            for (int c = 0; c < getNumCols(); c++)
            {
                // If there's an object at this location, put it in the array.
                Location loc = new Location(r, c);
                if (get(loc) != null)
                    theLocations.add(loc);
            }
        }

        return theLocations;
    }
    public void processActors(ArrayList<Actor> actors)
    {
        col = getLocation().getCol();
        row = getLocation().getRow();
        int n = 0;
        for (Actor a : actors)
        {
            if (!(a instanceof Rock) && !(a instanceof Critter))
                a.removeSelfFromGrid();
            else if (a instanceof Critter) {
                n++;
            }
        }
        
        Grid gr = getGrid();
        for (int i = row-1; i <= row+1; row++) {
            for (int j = col-1; j <= col+1; col++) {
                Location loc = new Location(i, j);
                if (gr.isValid(loc) && (gr.get(loc) instanceof Critter))
                     n++;
            }
        }
            n--;
        if (n < courage) {
           Color c = getColor();
           int red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
           if (red > 255)
               red = 255;
           int green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
           if (green > 255)
              green = 255;
           int blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
           if (blue > 255)
              blue = 255;
           setColor(new Color(red, green, blue));
           return;
        } else {
           Color c = getColor();
           int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
           int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
           int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
           setColor(new Color(red, green, blue));
        }
    }

    /**
     * Turns towards the new location as it moves.
     */
   
}
