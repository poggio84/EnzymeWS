package uk.ac.ebi.enzyme;

import com.sun.jersey.spi.resource.Singleton;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import uk.ac.ebi.enzyme.model.EcResource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/ecnumber")
@Singleton
public class EcNumberRestService {
    private static Logger log = LogManager.getRootLogger();
    //http://examples.javacodegeeks.com/enterprise-java/rest/jersey/jersey-hello-world-example/
    //http://examples.javacodegeeks.com/enterprise-java/rest/jersey/json-example-with-jersey-jackson/
    //http://localhost:8080/rest/helloWorldREST/JavaCodeGeeks?value=enjoy-REST
    //http://localhost:8080/rest/jsonServices/print/carlos

    //http://localhost:8080/rest/ecnumber/description?EC=1.1.1.1
    @GET
   	@Path("description")
   	public Response responseDescription(@DefaultValue("Nothing to say") @QueryParam("EC") String value) {

        String output = EcResource.getInstance().get(value).getDe();
        log.info("Query: " + value + output);

   		return Response.status(200).entity(output).build();
   	}

    //http://localhost:8080/rest/ecnumber/alternateName?EC=1.1.1.1
    @GET
   	@Path("alternateName")
   	public Response responseAlternateName(@DefaultValue("Nothing to say") @QueryParam("EC") String value) {

        String output = EcResource.getInstance().get(value).getAn();
        log.info("Query: " + value + " " + output);

   		return Response.status(200).entity(output).build();
   	}

    //http://localhost:8080/rest/ecnumber/catalyticActivity?EC=1.1.1.2
    @GET
   	@Path("catalyticActivity")
   	public Response responseCatalyticActivity(@DefaultValue("Nothing to say") @QueryParam("EC") String value) {

        String output = EcResource.getInstance().get(value).getCa();
        log.info("Query:" + value + " " + output);

   		return Response.status(200).entity(output).build();
   	}


}
