package mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MongoDBClient {

    public static MongoDatabase getMongoDB(String database){
        log.info("trying to get mongo client");
        MongoClient mongoClient = new MongoClient("localhost",27017);
        log.info("successfully got the mongo client");
        log.info("Now trying getting the data base from mongo 2");
        return mongoClient.getDatabase(database);
    }
}
