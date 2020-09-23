package com.aconex.simulator.processor;

import com.aconex.simulator.entities.Square;
import com.aconex.simulator.entities.enums.Type;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Loads the sitemap information into a 2D array
 */
public class SiteMapProcessor implements Function<List<String>, Square[][]> {

    @Override
    public Square[][] apply(List<String> lines) {

        Square[][] sqr = new Square[lines.size()][lines.get(0).length()];

        lines.forEach(s -> {
            IntStream.range(0, s.length())
                    .forEach(value -> System.out.print(s.toCharArray()[value] + " "));
            System.out.println();
        });

        IntStream.range(0, lines.size())
                .mapToObj(i -> {
                    char[] temp = lines.get(i).toCharArray();
                    IntStream.range(0, temp.length)
                            .mapToObj(j -> {
                                sqr[i][j] = new Square(Type.of(temp[j]));
                                return j;
                            }).collect(Collectors.toList());
                    return i;
                }).collect(Collectors.toList());

        return sqr;
    }

}
