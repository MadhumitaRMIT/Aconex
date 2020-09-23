package main.java.com.aconex.simulator.input;
import main.java.com.aconex.simulator.commands.*;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Parser implements Function<String, Command> {

    private static final Pattern Advance_patt = Pattern.compile("(ADVANCE|A)\\s([1-9][0-9]*)");
    private static final String Left_patt = "(LEFT|L)";
    private static final String Right_patt = "(RIGHT|R)";
    @Override
    public Command apply(final String inputString){

        if (inputString.startsWith("A")){
            final Matcher matcher = Advance_patt.matcher(inputString);
        if (matcher.matches()) {
            return new Advance(Integer.parseInt(matcher.group(2)));
            }
        } else if (Pattern.matches(Left_patt, inputString)) {
            return new Left();
        } else if (Pattern.matches(Right_patt, inputString)) {
            return new Right();
        } else if (Pattern.matches("(QUIT|Q)", inputString)) {
            return new QuitCommand("The simulation has ended at your request.");
        }

        return new NoOpCommand(inputString);
    }

}
