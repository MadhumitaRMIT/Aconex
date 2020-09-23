package main.java.com.aconex.simulator.input;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Reader {

    private static final Pattern QUIT_REGEX = Pattern.compile("(Quit|quit|q|Q)");

    public Stream<String> readCommand() {
        System.out.println("\nThe bulldozer is currently located at the Northern edge of the site, " +
                "immediately to the West of the site, and facing East.\n");

        Scanner scanner = new Scanner(System.in);

        List<String> result = new ArrayList<>();
        System.out.print("(l)eft, (r)ight, (a)dvance <n>, (q)uit:");

        while (!scanner.hasNext(QUIT_REGEX)) {
            System.out.print("(l)eft, (r)ight, (a)dvance <n>, (q)uit:");
            result.add(scanner.nextLine().toUpperCase());
        }

        result.add("QUIT");
        return result.stream();
    }

}

