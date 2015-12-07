package my_Image;
import imagereader.IImageProcessor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;


  public class myIImageProcessor implements IImageProcessor
    {
        public Image showChanelR(Image sourceImage)
        {
        	Toolkit my_kit = Toolkit.getDefaultToolkit();
            my_red my_filter = new my_red();
            Image my_image = my_kit.createImage(new FilteredImageSource(sourceImage.getSource(), my_filter));
            return my_image;
        }
        public Image showChanelG(Image sourceImage)
        {
        	Toolkit my_kit = Toolkit.getDefaultToolkit();
            my_green my_filter = new my_green();
            Image my_image = my_kit.createImage(new FilteredImageSource(sourceImage.getSource(), my_filter));
            return my_image;
        }
        public Image showChanelB(Image sourceImage)
        {
        	Toolkit my_kit = Toolkit.getDefaultToolkit();
            my_blue my_filter = new my_blue();
            Image my_image = my_kit.createImage(new FilteredImageSource(sourceImage.getSource(), my_filter));
            return my_image;
        }
        public Image showGray(Image sourceImage)
        {
        	Toolkit my_kit = Toolkit.getDefaultToolkit();
            my_gray my_filter = new my_gray();
            Image my_image = my_kit.createImage(new FilteredImageSource(sourceImage.getSource(), my_filter));
            return my_image;
        }
        
        class my_red extends RGBImageFilter
        {
            public my_red()
            {
                canFilterIndexColorModel = true;
            }
            public int filterRGB(int x, int y, int rgb)
            {
                return (rgb & 0xffff0000);
            }
        }
        class my_green extends my_red
        {
            public int filterRGB(int x, int y, int rgb)
            {
                return (rgb & 0xff00ff00);
            }
        }
        class my_blue extends my_red
        {
            public int filterRGB(int x, int y, int rgb)
            {
                return (rgb & 0xff0000ff);
            }
        }
        class my_gray extends my_red
        {
            public int filterRGB(int x, int y, int rgb)
            {
                int gray = (int)(0.3*((rgb & 0x00ff0000)>>16) + 0.59*((rgb & 0x0000ff00)>>8) + 0.11*(rgb & 0x000000ff));
                return (rgb & 0xff000000)+(gray<<16)+(gray<<8)+gray;
            }
        }
    }