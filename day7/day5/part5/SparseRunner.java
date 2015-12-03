//package my_grid;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
/**
* This class runs a world with additional grid choices.
*/
public class SparseRunner
{
  public static void main(String[] args)
  {
    ActorWorld world = new ActorWorld();
    world.addGridClass("my_grid.SparseBoundedGrid");
    world.addGridClass("my_grid.SparseBoundedGrid2");
    //world.addGridClass("SparseBoundedGrid3");
    world.addGridClass("my_grid.UnBoundedGrid2");
    world.add(new Location(2, 2), new Critter());
    world.show();
  }
}