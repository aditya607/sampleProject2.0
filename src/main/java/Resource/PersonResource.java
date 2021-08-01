package Resource;

import mongoDB.MongoDBImpl;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    String databaseName = "person";
    MongoDBImpl mongoDBImpl = new MongoDBImpl();

    @GET
    @Path("/getPerson/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Document getRaja(@PathParam("name") String name){
        return mongoDBImpl.getPerson(name,databaseName);
    }

    @POST
    @Path("/savePerson")
    public void savePerson(Person person){
        mongoDBImpl.savePerson(person, databaseName);
    }

}
