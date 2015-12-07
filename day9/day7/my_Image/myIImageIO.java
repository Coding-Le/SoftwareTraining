
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
        // some basic information about the image
	
	public Image myRead(String filePath) throws IOException
    {
                 int myheight;
	 int mywidth;
	 int mysize;
	int head = 14;
	 int information = 40;
        int num = 8;
         int num2 = 16;
        int num3 = 24;
        int m = 0xff;
                // get the stream by java's FileInputStream function
		FileInputStream mystream = new FileInputStream(filePath);
		Image myimage;
		//0 ~ 13
		byte []myhead = new byte[head];
		my_stream.read(myhead, 0, head);
		// 14~53
		byte []myinfo = new byte[information];
		my_stream.read(myinfo, 0, information);
               // use the information provided by the wiki to extract the byte information about width, height and then transform them to int
		mywidth = (((int)myinfo[7] & m) << num3) | (((int)myinfo[6]  & m) << num2) | (((int)myinfo[5] &m) << num) | (((int)myinfo[4]&m));
		myheight = (((int)myinfo[11] & m) << num3) | (((int)myinfo[10]  & m) << num2) | (((int)myinfo[9] & m) << num) | (((int)myinfo[8]&m));
		mysize = (((int)myinfo[23] & m) << num3) | (((int)myinfo[22]  & m) << num2) | (((int)myinfo[21] &m) << num) | (((int)myinfo[20]&m));
        //calculate the padding added by the system and disgrad them in suitable time
        int myempty = mysize/myheight - mywidth*(num3/num);
        byte []mydata = new byte[mysize];
        int []data = new int[myheight*mywidth];
        mystream.read(mydata, 0, mysize);
        int cur = 0;
        for (int row = my_height-1; row >= 0; row--) {
        	for (int col = 0; col < mywidth; col++) {
                         // the image pixel is consist of 24 bit(3 byte), so you need to change it to int
        		int temp = ((255 & m) << num3) | ((int)mydata[cur] & m) | (((int)mydata[cur+1] & m) << num) | (((int)mydata[cur+2] & m) << num2);
        		data[row*mywidth+col] = temp;
        		cur += 3;
        	}
        	cur += myempty;
        }
          // use the system function to construct your image 
        Toolkit mykit = Toolkit.getDefaultToolkit();
        myimage = mykit.createImage(new MemoryImageSource(mywidth, myheight, data, 0, mywidth));
               return myimage;
    }
	
	public Image myWrite(Image image, String filePath) throws IOException
    {
        // the usage of api
		File myfile = new File(filePath + ".bmp");
        BufferedImage myimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D mygraph = myimage.createGraphics();
        mygraph.drawImage(image, 0, 0, null);
        mygraph.dispose();
        // use the function 'write' to get the correct image
        ImageIO.write(myimage, "bmp", myfile);
        return myimage;
    }
    }
	
	
 
