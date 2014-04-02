package uk.ac.ebi.enzyme;

import com.sun.jersey.spi.resource.Singleton;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import uk.ac.ebi.enzyme.model.Ec;
import uk.ac.ebi.enzyme.model.EcResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/ecnumberjson")
@Singleton
public class EcNumberRestServiceJson {
    private static Logger log = LogManager.getRootLogger();

    //http://localhost:8080/rest/jsonServices/printtwo/carlos
//    @GET
//    @Path("/description/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Ec descriptionJson( @PathParam("name") String name ) {
//
//        Ec ec = EcResource.getInstance().get(name);
//
//        log.info("Hello Logentries 2, I'm from AppFog");
//        return ec;
//
//    }

    //http://localhost:8080/rest/ecnumberjson/all?EC=1.1.1.3
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Ec descriptionJson( @DefaultValue("Nothing to say") @QueryParam("EC") String value) {

        Ec ec = EcResource.getInstance().get(value);


        log.info("Query: " + value + " " + ec);

        return ec;
    }

}