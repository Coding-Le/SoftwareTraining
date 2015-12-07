package my_Image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;

  
public class my_java
    {
        private static int bfhead = 14;
        private static int bfinfo = 40;
        public class ImageHead
        {
            private int width;
            private int height;
            private int bitcount;
            private int size;
            public ImageHead(FileInputStream stream)
            {
                try
                {
     
                    // 0~13
                    byte bh[] = new byte[bfhead];
                    // 14~53
                    byte bi[] = new byte[bfinfo];
                    // buffer offset count
                    stream.read(bh, 0, bfhead);
                    stream.read(bi, 0, bfinfo);
                    width = ( ( (int) bi[7] & 0xff) << 24) //width of source file
                    | ( ( (int) bi[6] & 0xff) << 16)
                    | ( ( (int) bi[5] & 0xff) << 8)
                    | (int) bi[4] & 0xff;
                    height = ( ( (int) bi[11] & 0xff) << 24) //heigth of source file
                    | ( ( (int) bi[10] & 0xff) << 16)
                    | ( ( (int) bi[9] & 0xff) << 8)
                    | (int) bi[8] & 0xff;
                    bitcount = ( ( (int) bi[15] & 0xff) << 8) | (int) bi[14] & 0xff;
                    size = ( ( (int) bi[23] & 0xff) << 24)
                    | ( ( (int) bi[22] & 0xff) << 16)
                    | ( ( (int) bi[21] & 0xff) << 8)
                    | (int) bi[20] & 0xff;
                }
                catch (Exception e)
                {
                    e.printStackTrace(System.out);
                }
            }
        }
        public Image myRead(String filePath)
        {
            try
            {
                Image image;
                FileInputStream stream = new FileInputStream(filePath);
         ImageHead img = new ImageHead(stream);
                int blank = ((img.size / img.height) - img.width * 3)/(3 * img.width);
         int data[] = new int[img.height * img.width];
                byte brgb[] = new byte[ (img.width + blank) * 3 * img.height];
         if (img.bitcount == 24)
         {
             stream.read(brgb, 0, (img.width + blank) * 3 * img.height);
             int nindex = 0;
             for (int j = 0; j < img.height; j++)
             {
                 for (int i = 0; i < img.width; i++)
                 {
              data[img.width * (img.height - j - 1) + i] =
                  (255 & 0xff) << 24
                  | ( ( (int) brgb[nindex + 2] & 0xff) << 16)
                  | ( ( (int) brgb[nindex + 1] & 0xff) << 8)
                  | (int) brgb[nindex] & 0xff;
              nindex += 3;
                 }
                 nindex += blank;
             }
         }
                Toolkit kit = Toolkit.getDefaultToolkit();
         image = kit.createImage(new MemoryImageSource(img.width, img.height, data, 0, img.width));
                return image;
            }
            catch (Exception e)
            {
                e.printStackTrace(System.out);
            }
            return (Image)null;
        }

        public Image myWrite(Image image, String filePath)
        {
            try
            {
                File imgFile = new File(filePath + ".jpg");
                BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2 = bi.createGraphics();
                g2.drawImage(image, 0, 0, null);
                g2.dispose();
                ImageIO.write(bi, "jpg", imgFile); 
                return image;
            }
            catch (Exception e)
            {
                e.printStackTrace(System.out);
            }
            return image;
        }
    }