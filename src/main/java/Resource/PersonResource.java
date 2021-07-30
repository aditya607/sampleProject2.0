package Resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    @GET
    @Path("raja")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getRaja(){
        Person person = new Person("raja",21,"hajipur");
        return person;
    }

}
