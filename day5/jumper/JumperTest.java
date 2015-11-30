package info.gridworld.actor;
import static org.junit.Assert.*;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import org.junit.Before;
import org.junit.Test;

public class JumperTest {
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testAct() {
		ActorWorld world =  new ActorWorld();
		Jumper alice = new Jumper();
	    world.add(new Location(1, 1), alice);
	    alice.act();
	    assertEquals(alice.getLocation(), new Location(1,1));
	    assertEquals(alice.getDirection(), 45);
	    
	    alice.moveTo(new Location(0,0));
	    alice.setDirection(0);
	    alice.act();
	    alice.act();
	    assertEquals(alice.getLocation(), new Location(0,0));
	    assertEquals(alice.getDirection(), 90);
	    
	    alice.moveTo(new Location(3,3));
	    Jumper Bob = new Jumper();
	    world.add(new Location(5, 3), Bob);
	    Bob.act();
	    assertEquals(Bob.getLocation(), new Location(5,3));
	    assertEquals(Bob.getDirection(), 45);
	}

	@Test
	public void testJumper() {
		
	}

	@Test
	public void testJumperColor() {
		
	}

	@Test
	public void testTurn() {
		ActorWorld world =  new ActorWorld();
		Jumper alice = new Jumper();
	    world.add(new Location(5, 5), alice);
	    alice.setDirection(45);
	    alice.turn();
	    assertEquals(alice.getDirection(), 90);
	}

	@Test
	public void testMove() {
		ActorWorld world =  new ActorWorld();
		Jumper alice = new Jumper();
	    world.add(new Location(5, 5), alice);
	    alice.move();
	    assertEquals(alice.getLocation(), new Location(3,5));
	    alice.setDirection(90);
	    alice.move();
	    assertEquals(alice.getLocation(), new Location(3,7));
	    alice.setDirection(180);
	    alice.move();
	    assertEquals(alice.getLocation(), new Location(5,7));
	    alice.setDirection(270);
	    alice.move();
	    assertEquals(alice.getLocation(), new Location(5,5));
	    
	    
	    
	}

	@Test
	public void testCanMove() {
		ActorWorld world =  new ActorWorld();
		Jumper alice = new Jumper();
		Flower fl = new Flower();
	    world.add(new Location(5, 5), alice);
	    world.add(new Location(3,5), fl);
	    assertEquals(alice.canMove(), true);
	    Rock ro = new Rock();
	    world.add(new Location(3,5), ro);
	    assertEquals(alice.canMove(), false);
	    
	}

}

