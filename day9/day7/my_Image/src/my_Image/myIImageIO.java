package my_Image;
import imagereader.IImageIO;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class myIImageIO implements IImageIO
    {
	private int my_height;
	private int my_width;
	private int my_size;
	private int head = 14;
	private int information = 40;
	public Image myRead(String filePath) throws IOException
    {
		FileInputStream my_stream = new FileInputStream(filePath);
		Image my_image;
		//0 ~ 13
		byte []my_head = new byte[head];
		my_stream.read(my_head, 0, head);
		// 14~53
		byte []my_info = new byte[information];
		my_stream.read(my_info, 0, information);
		my_width = (((int)my_info[7] & 0xff) << 24) | (((int)my_info[6]  & 0xff) << 16) | (((int)my_info[5] &0xff) << 8) | (((int)my_info[4]&0xff));
		my_height = (((int)my_info[11] & 0xff) << 24) | (((int)my_info[10]  & 0xff) << 16) | (((int)my_info[9] &0xff) << 8) | (((int)my_info[8]&0xff));
		my_size = (((int)my_info[23] & 0xff) << 24) | (((int)my_info[22]  & 0xff) << 16) | (((int)my_info[21] &0xff) << 8) | (((int)my_info[20]&0xff));
        int my_empty = my_size/my_height - my_width*(24/8);
        byte []my_data = new byte[my_size];
        int []data = new int[my_height*my_width];
        my_stream.read(my_data, 0, my_size);
        int cur = 0;
        for (int row = my_height-1; row >= 0; row--) {
        	for (int col = 0; col < my_width; col++) {
        		int temp = ((255 & 0xff) << 24) | ((int)my_data[cur] & 0xff) | (((int)my_data[cur+1] & 0xff) << 8) | (((int)my_data[cur+2] & 0xff) << 16);
        		data[row*my_width+col] = temp;
        		cur += 3;
        	}
        	cur += my_empty;
        }
        Toolkit my_kit = Toolkit.getDefaultToolkit();
        my_image = my_kit.createImage(new MemoryImageSource(my_width, my_height, data, 0, my_width));
               return my_image;
    }
	
	public Image myWrite(Image image, String filePath) throws IOException
    {
		File my_file = new File(filePath + ".bmp");
        BufferedImage my_image = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D my_graph = my_image.createGraphics();
        my_graph.drawImage(image, 0, 0, null);
        my_graph.dispose();
        ImageIO.write(my_image, "bmp", my_file);
        return my_image;
    }
    }
	
	
 
