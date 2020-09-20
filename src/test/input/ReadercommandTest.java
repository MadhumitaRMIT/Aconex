package simulator.input;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReaderTest {

    private Reader Reader = new Reader();

    @Test
    public void test() {
        InputStream in = new ByteArrayInputStream("foo\r\nbar\r\nq".getBytes());
        System.setIn(in);
        Stream<String> stringStream = Reader.readCommand();
        assertEquals("FOOBARQUIT", stringStream.collect(Collectors.joining()));
    }

}