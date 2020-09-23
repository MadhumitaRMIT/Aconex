package main.java.com.aconex.simulator.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SiteMap implements Function<String, List<String>> {

    /**
     * Read input from a file
     * @param inputFileName
     * @return
     */
    @Override
    public List<String> apply(String inputFileName) {
        try{

           return Files.lines(Paths.get(inputFileName)).collect(Collectors.toList());

        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException(ioe.getMessage());
        }
    }

}
