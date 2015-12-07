package my_Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
public class myIImageIOTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testMyRead() throws IOException {
		myIImageIO temp = new myIImageIO();
		Image my_image =  temp.myRead("/home/Administrator/Desktop/day7/bmptest/1.bmp");
		BufferedImage my_bufferedimage = new BufferedImage( my_image.getWidth(null), my_image.getHeight(null),BufferedImage.TYPE_INT_RGB);
		Graphics g = my_bufferedimage.createGraphics();
	    // Paint the image onto the buffered image
	     g.drawImage(my_image, 0, 0, null);
	     g.dispose();
		//File my_file = new File("/home/Administrator/Desktop/day7/bmptest/1.bmp");
		BufferedImage his_image = ImageIO.read(new FileInputStream("/home/Administrator/Desktop/day7/bmptest/1.bmp"));
		assertEquals(my_bufferedimage.getHeight(null), his_image.getHeight(null));
	    assertEquals(my_bufferedimage.getWidth(null), his_image.getWidth(null));
	    assertEquals(my_bufferedimage.getMinX(), his_image.getMinX());
	    assertEquals(my_bufferedimage.getMinY(), his_image.getMinY());
	    int my_height = my_image.getHeight(null);
	    int my_width = my_image.getWidth(null);
	    int count = 0;
	    for (int i = 0; i < my_height; i++) {
	    	for (int j = 0; j < my_width; j++) {
	    			assertEquals(my_bufferedimage.getRGB(i, j), his_image.getRGB(i, j));
	    	}
	    }
	    System.out.print(count);
	}

	@Test
	public void testMyWrite() throws IOException {
		File my_file = new File("/home/Administrator/Desktop/day7/bmptest/1.bmp");
		BufferedImage his_image = ImageIO.read(my_file);
		myIImageIO temp = new myIImageIO();
		BufferedImage my_image =  (BufferedImage) temp.myWrite(his_image, "/home/Administrator/Desktop/pic");
		assertEquals(my_image.getHeight(null), his_image.getHeight(null));
	    assertEquals(my_image.getWidth(null), his_image.getWidth(null));
	    assertEquals(my_image.getMinX(), his_image.getMinX());
	    assertEquals(my_image.getMinY(), his_image.getMinY());
	    int my_height = my_image.getHeight(null);
	    int my_width = my_image.getWidth(null);
	    for (int i = my_image.getMinX(); i < my_height; i++) {
	    	for (int j = my_image.getMinY(); j < my_width; j++) {
	    		assertEquals(my_image.getRGB(i, j), his_image.getRGB(i, j));
	    	}
	    }
	}

}
