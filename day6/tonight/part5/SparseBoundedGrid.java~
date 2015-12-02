//package my_grid;

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

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A <code>BoundedGrid</code> is a rectangular grid with a finite number of rows
 * and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundedGrid<E> extends AbstractGrid<E> {
	private ArrayList<LinkedList<OccupantInCol>> sparseArray;
	private int my_col;
	private int my_row;

	/**
	 * Constructs an empty bounded grid with the given dimensions.
	 * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
	 * 
	 * @param rows
	 *            number of rows in BoundedGrid
	 * @param cols
	 *            number of columns in BoundedGrid
	 */
	public SparseBoundedGrid(int rows, int cols) {
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
}
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
}
		my_col = cols;
		my_row = rows;
		sparseArray = new ArrayList<LinkedList<OccupantInCol>>(rows);
	
	    for (int i = 0; i < rows; i++) {
        	sparseArray.add(new LinkedList<OccupantInCol>());
        }
		
        for (int i = 0; i < rows; i++) {
        	if (!sparseArray.get(i).isEmpty()) {
             sparseArray.get(i).clear();
        	}
        }
	}

	public int getNumRows() {
		return my_row;
	}

	public int getNumCols() {
		// Note: according to the constructor precondition, numRows() > 0, so
		// theGrid[0] is non-null.
		return my_col;
	}

	public boolean isValid(Location loc) {
		return (0 <= loc.getRow() && loc.getRow() < getNumRows()
				&& 0 <= loc.getCol() && loc.getCol() < getNumCols());
	}

	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> theLocations = new ArrayList<Location>();
		// Look at all grid locations.
		for (int r = 0; r < getNumRows(); r++) {
			if (!sparseArray.get(r).isEmpty()) {
			for (OccupantInCol o : sparseArray.get(r)) {
				theLocations.add(new Location(r, o.getc()));
			}
			}
		}

		return theLocations;
	}

	public E get(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
}
		int co = loc.getCol();
		int ro = loc.getRow();
		if (!sparseArray.get(ro).isEmpty()) {
		for (OccupantInCol o : sparseArray.get(ro)) {
			if (o.getc() == co) {
				return (E) o.getObject();
			}
		}
		}
		return null;
		// unavoidable warning
	}

	public E put(Location loc, E obj) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
}
		if (obj == null) {
			throw new NullPointerException("obj == null");
}

		// Add the object to the grid.
		E oldOccupant = remove(loc);
		sparseArray.get(loc.getRow()).add(new OccupantInCol(obj, loc.getCol()));
		return oldOccupant;
	}

	public E remove(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
}

		// Remove the object from the grid.
		int co = loc.getCol();
		int ro = loc.getRow();
		E r = get(loc);
		if (r != null) {
			for (OccupantInCol o : sparseArray.get(ro)) {
				if (o.getc() == co) {
					sparseArray.get(ro).remove(o);
				}
			}
		}
		return r;
	}
}
