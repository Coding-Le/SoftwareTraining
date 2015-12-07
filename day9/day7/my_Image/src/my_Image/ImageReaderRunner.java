package my_Image;
//ImagaReaderRunner.java
import imagereader.Runner;

public class ImageReaderRunner {
 public static void main(String[] args) {
     myIImageIO imageioer = new myIImageIO();
     myIImageProcessor processor = new myIImageProcessor();
     Runner.run(imageioer, processor);
 }
}
