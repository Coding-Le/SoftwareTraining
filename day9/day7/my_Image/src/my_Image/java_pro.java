package my_Image;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

    

  public class java_pro
    {
        public Image showChanelR(Image sourceImage)
        {
            RedFilter filter = new RedFilter();
            Toolkit kit = Toolkit.getDefaultToolkit();
    Image newimg = kit.createImage(new FilteredImageSource(sourceImage.getSource(), filter));
            return newimg;
        }
        public Image showChanelG(Image sourceImage)
        {
            GreenFilter filter = new GreenFilter();
            Toolkit kit = Toolkit.getDefaultToolkit();
    Image newimg = kit.createImage(new FilteredImageSource(sourceImage.getSource(), filter));
            return newimg;
        }
        public Image showChanelB(Image sourceImage)
        {
            BlueFilter filter = new BlueFilter();
            Toolkit kit = Toolkit.getDefaultToolkit();
    Image newimg = kit.createImage(new FilteredImageSource(sourceImage.getSource(), filter));
            return newimg;
        }
        public Image showGray(Image sourceImage)
        {
            GrayFilter filter = new GrayFilter();
            Toolkit kit = Toolkit.getDefaultToolkit();
    Image newimg = kit.createImage(new FilteredImageSource(sourceImage.getSource(), filter));
            return newimg;
        }
        class RedFilter extends RGBImageFilter
        {
            public RedFilter()
            {
                canFilterIndexColorModel = true;
            }
            public int filterRGB(int x, int y, int rgb)
            {
                return (rgb & 0xffff0000);
            }
        }
        class GreenFilter extends RGBImageFilter
        {
            public GreenFilter()
            {
                canFilterIndexColorModel = true;
            }
            public int filterRGB(int x, int y, int rgb)
            {
                return (rgb & 0xff00ff00);
            }
        }
        class BlueFilter extends RGBImageFilter
        {
            public BlueFilter()
            {
                canFilterIndexColorModel = true;
            }
            public int filterRGB(int x, int y, int rgb)
            {
                return (rgb & 0xff0000ff);
            }
        }
        class GrayFilter extends RGBImageFilter
        {
            public GrayFilter()
            {
                canFilterIndexColorModel = true;
            }
            public int filterRGB(int x, int y, int rgb)
            {
                int gray = (int)(((rgb & 0x00ff0000)>>16)*0.3 + ((rgb & 0x0000ff00)>>8)*0.59 + (rgb & 0x000000ff)*0.11);
                return (rgb & 0xff000000)+(gray<<16)+(gray<<8)+gray;
            } 
        }
    }