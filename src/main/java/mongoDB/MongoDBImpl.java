package mongoDB;

import Resource.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
@Slf4j
public class MongoDBImpl {

    public Document getPerson(String personName, String databaseName){
        MongoDatabase database = MongoDBClient.getMongoDB(databaseName);
        log.info("got the database finally");
        BasicDBObject dbObject = new BasicDBObject("name", personName);
        FindIterable<Document> person = database.getCollection("personDetails").find(dbObject);
        return person.first();
    }

    public void savePerson(Person person, String databaseName){
        MongoDatabase database = MongoDBClient.getMongoDB(databaseName);
        log.info("got the database finally");
        Document doc = new Document("name",person.getName());
        doc.append("age",person.getAge());
        doc.append("address",person.getAddress());
        database.getCollection("personDetails").insertOne(doc);
    }
}
