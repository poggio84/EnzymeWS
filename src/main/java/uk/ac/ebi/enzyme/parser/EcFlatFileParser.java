package uk.ac.ebi.enzyme.parser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import uk.ac.ebi.enzyme.model.Ec;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Diego Poggioli
 *
 * Enzyme file documentation here:
 * ftp://ftp.expasy.org/databases/enzyme/enzuser.txt
 *
 */
public class EcFlatFileParser {
    private static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) throws IOException {
        EcFlatFileParser EcFlatFileParser = new EcFlatFileParser();
        try {
            //EcFlatFileParser.parseEcFile(System.getProperty("user.dir") + File.separator + "data" + File.separator + "Enzyme.dat");
            EcFlatFileParser.parseEcFile("data" + File.separator + "Enzyme.dat");

        } catch (IOException e) {
            throw new IOException("Unable to parse the EC file");
        }
    }

    public Map<String, Ec> parseEcFile() throws IOException {
        //TODO move file path in a configuration file
        return getStringFromInputStream("enzyme.dat");
    }

    private Map<String, Ec> getStringFromInputStream(String file) {
        Map<String, Ec> ecs = new HashMap<>();

       InputStream stream = this.getClass().getClassLoader().getResourceAsStream(file);

        BufferedReader br = null;

        String id="";
        String de="";
        String an="";
        String ca="";
        String inputLine;
        try {

            //br = new BufferedReader(new FileReader(file));
            br = new BufferedReader(new InputStreamReader(stream));
            while ((inputLine = br.readLine()) != null) {

                if(inputLine.startsWith("ID")){
                    id=inputLine.substring(5);
                }

                else if(inputLine.startsWith("DE")){
                    de+=removeLastDot(inputLine.substring(5));
                }

                else if(inputLine.startsWith("AN")){
                    an+=removeLastDot(inputLine.substring(5));
                }

                //TODO to split multiple CA activity
                else if(inputLine.startsWith("CA")){
                    ca+=(removeLastDot(inputLine.substring(5)));
                }

                else if (inputLine.startsWith("//")){
                    Ec ec = new Ec();
                    ec.setDe(de);
                    ec.setId(id);
                    ec.setAn(an);
                    ec.setCa(ca);
                    ecs.put(id,ec);

                    log.info(id + " " + de);
                    de=""; an=""; ca = "";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }

        return ecs;

    }

    public Map<String, Ec> parseEcFile(String file) throws IOException {
        Map<String, Ec> ecs = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))) {

            String inputLine;
            String id="";
            String de="";
            String an="";
            String ca="";

            while ( (inputLine = br.readLine()) != null) {

                if(inputLine.startsWith("ID")){
                    id=inputLine.substring(5);
                }

                else if(inputLine.startsWith("DE")){
                    de+=removeLastDot(inputLine.substring(5));
                }

                else if(inputLine.startsWith("AN")){
                    an+=removeLastDot(inputLine.substring(5));
                }

                //TODO to split multiple CA activity
                else if(inputLine.startsWith("CA")){
                    ca+=(removeLastDot(inputLine.substring(5)));
                }

                else if (inputLine.startsWith("//")){
                    Ec ec = new Ec();
                    ec.setDe(de);
                    ec.setId(id);
                    ec.setAn(an);
                    ec.setCa(ca);
                    ecs.put(id,ec);

                    log.debug(id + " " + de);
                    de=""; an=""; ca = "";
                }
            }
        }

        return ecs;
    }

    private String removeLastDot(String str){
        String strWithoutDot=str;
        if(str.charAt(str.length() - 1) == '.')
            strWithoutDot = str.substring(0, str.length() - 1);
        return strWithoutDot;
    }

}