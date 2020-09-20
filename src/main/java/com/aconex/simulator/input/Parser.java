package com.aconex.simulator.input;
import com.aconex.simulator.commands.*;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Parser implements Function<String, Command> {

    private static final Pattern Advance_patt = Pattern.compile("(ADVANCE|A)\\s([1-9][0-9]*)");
    private static final String Left_patt = "(LEFT|L)";
    private static final String right_patt= "(RIGHT|R)";
    @Override
    public Command apply(String inputString){

        if (inputString.startsWith("A")){
            Matcher matcher = Advance_patt.matcher(inputString);
        if (matcher.matches()) {
            return new advance(Integer.parseInt(matcher.group(2)));
            }
        } else if (Pattern.matches(Left_patt, inputString)) {
            return new LeftCommand();
        } else if (Pattern.matches(Right_patt, inputString)) {
            return new RightCommand();
        } else if (Pattern.matches("(QUIT|Q)", inputString)) {
            return new QuitCommand("The simulation has ended at your request.");
        }

        return new NoOpCommand(inputString);
    }

}
