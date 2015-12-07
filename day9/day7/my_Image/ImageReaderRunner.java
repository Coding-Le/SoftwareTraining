
//ImagaReaderRunner.java
import imagereader.Runner;

public class ImageReaderRunner {
 public static void main(String[] args) {
     // create a new myIImageIO class
     myIImageIO imageioer = new myIImageIO();
     // create a new myIImageProcessor class
     myIImageProcessor processor = new myIImageProcessor();
     // invoke the java's runner to call your functions automatically
     Runner.run(imageioer, processor);
 }
}
