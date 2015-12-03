/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
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
 * @author Alyce Brady
 * @author APCS Development Committee
 * @author Cay Horstmann
 */

//package my_grid;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.*;

/**
 * An <code>UnboundedGrid</code> is a rectangular grid with an unbounded number of rows and
 * columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class UnBoundedGrid2<E> extends AbstractGrid<E>
{
    private Object[][] my_arr;
    private int cur_row = 16;
    private int cur_col = 16;
    /**
     * Constructs an empty unbounded grid.
     */
    public UnBoundedGrid2()
    {
        my_arr = new Object[cur_row][cur_col];
    }

    public int getNumRows()
    {
        return -1;
    }

    public int getNumCols()
    {
        return -1;
    }

    public boolean isValid(Location loc)
    {
        return (loc.getCol() >= 0 && loc.getRow() >= 0);
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> a = new ArrayList<Location>();
        for (int i = 0; i < cur_row; i++) {
        	for (int j = 0; j < cur_col; j++) {
        		if (get(new Location(i, j)) != null) {
        			a.add(new Location(i, j));
        		}
        	}
        }
        return a;
    }

    public E get(Location loc)
    {
        if (loc == null) {
            throw new NullPointerException("loc == null");
}
        else if (!isValid(loc)) {
        	throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
        }
        if (loc.getRow() < cur_row && loc.getCol() < cur_col) {
        return (E) my_arr[loc.getRow()][loc.getCol()];
        } else {
        	return null;
        }
    }

    public E put(Location loc, E obj)
    {
    	if (loc == null) {
            throw new NullPointerException("loc == null");
}
        else if (!isValid(loc)) {
        	throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
}
        if (loc.getRow() < cur_row && loc.getCol() < cur_col) {
        Object old = my_arr[loc.getRow()][loc.getCol()];
        my_arr[loc.getRow()][loc.getCol()] = obj;
        return (E) old;
        } else {
        	Object [][]new_arr = new Object[cur_row][cur_col];
        	for (int i = 0; i < cur_row; i++) {
        		for (int j = 0; j < cur_col; j++) {
        			new_arr[i][j] = my_arr[i][j];
        		}
        	}
        	my_arr = new Object[cur_row*2][cur_col*2];
        	for (int i = 0; i < cur_row; i++) {
        		for (int j = 0; j < cur_col; j++) {
        			my_arr[i][j] = new_arr[i][j];
        		}
        	}
        	my_arr[loc.getRow()][loc.getCol()] = obj;
        	cur_row *= 2;
        	cur_col *= 2;
        	return null;
        }
    }

    public E remove(Location loc)
    {
    	if (loc == null) {
            throw new NullPointerException("loc == null");
}
        else if (!isValid(loc)) {
        	throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
        }
    	if (loc.getRow() < cur_row && loc.getCol() < cur_col) {
    	Object old = my_arr[loc.getRow()][loc.getCol()];
    	my_arr[loc.getRow()][loc.getCol()] = null;
    	return (E)old;
    	} else {
    		return null;
    	}
    	
    }
}
