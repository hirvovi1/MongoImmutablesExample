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

    private MongoClient getMongoClient(String uri) {
        return MongoClients.create(uri);
    }

    private void ping(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("admin");
        try {
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = database.runCommand(command);
            System.out.println("Connected successfully to server: " +commandResult);
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
        }
    }

    public void pojoTraining(){
//        try (MongoClient mongoClient = getMongoClient(CONNECTIONS_STRING)) {
//            CodecProvider pojoCodecProvider = getCodecProvider(Collections.EMPTY_LIST);
//            CodecRegistry pojoCodecRegistry =
//                    fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
//            String databaseName = "sample_pojos";
//            MongoDatabase database = getDatabase(mongoClient, pojoCodecRegistry, databaseName);
//
//            MongoCollection<Flower> collection = database.getCollection("flowers", FlowerImpl.class);
//            Flower flower =
//                    new FlowerImpl("rose", false, 25.4f, Arrays.asList(new String[] {"red", "green"}));
//
//            collection.insertOne(flower);
//
//            List<Flower> flowers = new ArrayList<>();
//            collection.find().into(flowers);
//            System.out.println(flowers);
//        }
    }

    private MongoDatabase getDatabase(MongoClient mongoClient, CodecRegistry pojoCodecRegistry, String databaseName) {
        return mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
    }


    private CodecProvider getCodecProvider(List<Convention> conventions) {
        return PojoCodecProvider.builder().conventions(conventions).automatic(true).build();
    }

}
