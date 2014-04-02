package uk.ac.ebi.enzyme.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import uk.ac.ebi.enzyme.parser.EcFlatFileParser;

import java.io.IOException;
import java.util.Map;

/**
 * Created by diego on 26/02/14.
 */
public class EcResource {
    private static Logger log = LogManager.getRootLogger();

    private static volatile Map<String, Ec> instance = null;

    private EcResource() {
    }

    public static Map<String, Ec> getInstance() {
        if (instance == null) {
            synchronized (EcResource.class) {

                if (instance == null) {
                    EcFlatFileParser ecParser = new EcFlatFileParser();
                    try {
                        instance = ecParser.parseEcFile();
                        log.info("EC file parsed correctly");
                    } catch (IOException e) {
                        log.error("Unable to parse the EC file");
                    }
                }
            }
        }
        return instance;
    }

}
