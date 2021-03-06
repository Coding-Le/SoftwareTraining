
import imagereader.IImageProcessor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;


  public class myIImageProcessor implements IImageProcessor
    {
        public Image showChanelR(Image sourceImage)
        {
            // the usage of toolkit to create the image
        	Toolkit mykit = Toolkit.getDefaultToolkit();
            // invoke the function to change the value of rgb, thus the image turns red
            myred myfilter = new myred();
            return mykit.createImage(new FilteredImageSource(sourceImage.getSource(), myfilter));
           
        }
        public Image showChanelG(Image sourceImage)
        {
            // the usage of toolkit to create the image
        	Toolkit mykit = Toolkit.getDefaultToolkit();
            // invoke the function to change the value of rgb, thus the image turns green
            mygreen myfilter = new mygreen();
            return  mykit.createImage(new FilteredImageSource(sourceImage.getSource(), myfilter));
            
        }
        public Image showChanelB(Image sourceImage)
        {
            // the usage of toolkit to create the image
        	Toolkit mykit = Toolkit.getDefaultToolkit();
            // invoke the function to change the value of rgb, thus the image turns blue
            myblue myfilter = new myblue();
            return mykit.createImage(new FilteredImageSource(sourceImage.getSource(), myfilter));
            
        }
        public Image showGray(Image sourceImage)
        {
           // the usage of toolkit to create the image
        	Toolkit mykit = Toolkit.getDefaultToolkit();
           // invoke the function to change the value of rgb, thus the image turns gray
            mygray myfilter = new mygray();
            return mykit.createImage(new FilteredImageSource(sourceImage.getSource(), myfilter));
         
        }
        
        class myred extends RGBImageFilter
        {
            public myred()
            {
                canFilterIndexColorModel = true;
            }
            public int filterRGB(int x, int y, int rgb)
            {
                return (rgb & 0xffff0000);
            }
        }
        class mygreen extends myred
        {
            public int filterRGB(int x, int y, int rgb)
            {
                return (rgb & 0xff00ff00);
            }
        }
        class myblue extends myred
        {
            public int filterRGB(int x, int y, int rgb)
            {
                return (rgb & 0xff0000ff);
            }
        }
        class mygray extends myred
        {
            public int filterRGB(int x, int y, int rgb)
            {
                int gray = (int)(0.3*((rgb & 0x00ff0000)>>16) + 0.59*((rgb & 0x0000ff00)>>8) + 0.11*(rgb & 0x000000ff));
                return (rgb & 0xff000000)+(gray<<16)+(gray<<8)+gray;
            }
        }
    }
