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
    

    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public BlusterCritter() {
       courage = 2;
      
    }
    
    public void processActors(ArrayList<Actor> actors)
    {
        int col = getLocation().getCol();
        int row = getLocation().getRow();
        int n = 0;
        for (Actor a : actors)
        {
            if (!(a instanceof Rock) && !(a instanceof Critter))
                a.removeSelfFromGrid();
        }
        
        Grid gr = getGrid();
        for (int i = row-2; i <= row+2; i++) {
            for (int j = col-2; j <= col+2; j++) {
                Location loc = new Location(i, j);
                if (gr.isValid(loc) && (gr.get(loc) instanceof Critter)) {
                     n++;
                 }
            }
        }
            n--;
        if (n < courage) {
           Color c = getColor();
           int red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
           if (red > 255) {
               red = 255;
           }
           int green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
           if (green > 255) {
              green = 255;
           }
           int blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
           if (blue > 255) {
              blue = 255;
           }
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
