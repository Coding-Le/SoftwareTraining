package my_Image;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class IImage {

	public IImage() {
		// TODO Auto-generated constructor stub
	}
	void myRead(String path) {
		FileInputStream fis = null ;  
        ImageInputStream iis =null ;
        fis = new FileInputStream(path);   
        Iterator it = ImageIO.getImageReadersByFormatName(".bmp");   
        ImageReader reader = (ImageReader) it.next();   
        //获取图片流    
        iis = ImageIO.createImageInputStream(fis);    
        reader.setInput(iis,true) ;  
        ImageReadParam param = reader.getDefaultReadParam();   
        //定义一个矩形   
        Rectangle rect = new Rectangle(x, y, width, height);   
        //提供一个 BufferedImage，将其用作解码像素数据的目标。    
        param.setSourceRegion(rect);  
        BufferedImage bi = reader.read(0,param);                  
        //保存新图片    
        ImageIO.write(bi, writeImageFormat, new File(toPath)); 
	}
    void myWrite(Image my_image, String path) {
    	
    }
}
