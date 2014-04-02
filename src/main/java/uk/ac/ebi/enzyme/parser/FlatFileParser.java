package uk.ac.ebi.enzyme.parser;

import java.io.BufferedReader;

/**
 * @author Diego Poggioli
 *
 */
public interface FlatFileParser {
    void parse(BufferedReader bufferedReader);
}
