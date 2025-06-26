package example.collection;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class QuickStart {
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://danieljrodcoding:Goofy77871998@collection.zuevfjb.mongodb.net/?retryWrites=true&w=majority&appName=Collection";

        String connectionString = uri; 

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Ping the database to test the connection
            MongoDatabase database = mongoClient.getDatabase("collection"); // You can use any database
            Document pingCommand = new Document("ping", 1);
            database.runCommand(pingCommand);
            
            System.out.println("Successfully connected to MongoDB!");

            // Optional: List database names to further confirm connectivity
            System.out.println("Available databases:");
            for (String dbName : mongoClient.listDatabaseNames()) {
                System.out.println("- " + dbName);
            }

        } catch (Exception e) {
            System.err.println("Failed to connect to MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }
}