package mongoDB;

import Resource.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

@Slf4j
public class MongoDBImpl {


    private static MongoDatabase database = MongoDBClient.getMongoDB("person");

    public Document getPerson(String personName, String databaseName){
        BasicDBObject dbObject = new BasicDBObject("name", personName);
        FindIterable<Document> person = database.getCollection("personDetails").find(dbObject);
        return person.first();
    }

    public void savePerson(Person person, String databaseName){

        Document doc = new Document("name",person.getName());
        doc.append("age",person.getAge());
        doc.append("address",person.getAddress());
        log.info("trying to get the collection");
        MongoCollection<Document> coll = database.getCollection("personDetails");
        log.info("got the collection :: " + coll.count());
        coll.insertOne(doc);
    }
}
