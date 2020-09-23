package com.aconex.simulator.input;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandReaderTest {

    private CommandReader commandReader = new CommandReader();

    @Test
    public void test() {
        InputStream in = new ByteArrayInputStream("foo\r\nbar\r\nq".getBytes());
        System.setIn(in);
        Stream<String> stringStream = commandReader.readCommand();
        assertEquals("FOOBARQUIT", stringStream.collect(Collectors.joining()));
    }

}