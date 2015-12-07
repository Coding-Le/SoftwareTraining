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
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;
 import java.util.*;
/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
    private int steps;
    private int sideLength;
    private int []my_arr;
    private int num;
    private int cur_num;
    private int flag;
    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug(int length)
    {
        steps = 0;
        sideLength = length;
        cur_num = 0;
        flag = 0;
        num = new Random().nextInt(10)+1;
        my_arr = new int[num];
        for (int i = 0; i < num; i++) {
            my_arr[i] = new Random().nextInt(8)+1;
        }
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (flag == 0 && cur_num < my_arr[steps]) {
            turn();
            cur_num++;
        } else if (flag == 0) {
            flag = 1;
            cur_num = 0;
            steps++;
            steps %= num;
        }
        if (flag == 1 && canMove()) {
            move();
            flag = 0;
        }
        else if (flag == 1)
        {
            turn();
        }
    }
}
