package fi.mongo.training;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.Convention;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.immutables.mongo.repository.RepositorySetup;

import java.util.List;

public class Main {

    public static final String CONNECTIONS_STRING = "mongodb://localhost/test";
    private final TreeFacade treeFacade = new TreeFacade(RepositorySetup.forUri(CONNECTIONS_STRING));

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        makeBirchForest();
    }

    private void makeBirchForest() {
        for (int i = 0; i < 30; i++) {
            addBirchToRepository(1 + i, i + 2);
        }
    }

    private void addBirchToRepository(int id, int height) {
        Tree tree = treeFacade.builder()
                .id(id).height(height)
                .species(TreeSpecies.BIRCH).build();
        treeFacade.addOrUpdate(tree);
    }


}
