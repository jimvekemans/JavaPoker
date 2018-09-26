package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;

public class PXLIO {
    //Javadoc kan worden opgevraagd via Ctrl+Q of de klasse kan worden geinspecteerd via Ctrl+shift+I
    //Een Path-Object is een pad in het bestandssysteem voorgesteld door een Object
    //Pad verkrijgen door Paths.get("filePath").desiredMethod();
    //Files is een statische klasse die Files kan op halen adhv een Pad-object
    /*
    Old-school reader en writers
    Reader:
    - int read(); // leest 1 karakter
    - int read(char[] cbuf);
    - int read(char[] cbuf, int offset, int length);
    - void close()
    Writer:
    - write(int c); // schrijft 1 karakter
    - write(char[] buf);
    - write(char[] buf, int offset, int length);
    - write(String str);
    - write(String str, int offset, int length);
    - close();
    - flush();
    */

    public static String writeToFile(Collection<String> linesOfText, String fileLocation){
        try(OutputStream fileOutputStream = Files.newOutputStream(Paths.get(fileLocation));){
            Path path = Paths.get(fileLocation);
            Files.createDirectories(path.getParent());
            if(Files.exists(path)){
                Files.createFile(path);
                System.out.println("File created.");
            }else{
                System.out.println("File already exists.");
            }

            //Write to the file
            //Files.write(path, linesOfText, Charset.defaultCharset(), StandardOpenOption.APPEND);


            //
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return "yeet";
    }
}
