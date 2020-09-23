package com.aconex.simulator.input;


import com.aconex.simulator.commands.*;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser implements Function<String, Command> {

    private static final Pattern ADVANCE_REGEX = Pattern.compile("(ADVANCE|A)\\s([1-9][0-9]*)");
    private static final String LEFT_REGEX = "(LEFT|L)";
    private static final String RIGHT_REGEX = "(RIGHT|R)";

    @Override
    public Command apply(String inputString){

        if (inputString.startsWith("A")){
            Matcher matcher = ADVANCE_REGEX.matcher(inputString);
        if (matcher.matches()) {
            return new AdvanceCommand(Integer.parseInt(matcher.group(2)));
            }
        } else if (Pattern.matches(LEFT_REGEX, inputString)) {
            return new LeftCommand();
        } else if (Pattern.matches(RIGHT_REGEX, inputString)) {
            return new RightCommand();
        } else if (Pattern.matches("(QUIT|Q)", inputString)) {
            return new QuitCommand("The simulation has ended at your request.");
        }

        return new NoOpCommand(inputString);
    }

}
