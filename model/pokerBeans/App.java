package pokerBeans;

import IO.PXLIO;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        List<String> sacredTexts = new ArrayList<>();
        sacredTexts.add("Howdy ho motherfuckers");
        sacredTexts.add("You gonna do fine");
        PXLIO.writeToFile(sacredTexts, "./inputfile");
    }

}
