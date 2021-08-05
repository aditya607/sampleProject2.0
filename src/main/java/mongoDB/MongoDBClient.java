package mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MongoDBClient {

    public static MongoDatabase getMongoDB(String database){
        log.info("trying to get mongo client");
        MongoClient mongoClient = new MongoClient("192.168.101.4",27017); // get this to your id address
        log.info("successfully got the mongo client");
        log.info("Now trying getting the data base from mongo 2");
        MongoDatabase db = mongoClient.getDatabase(database);

        log.info("got the database finally whose name is :: " + db.getName());


        return db;
    }
}
