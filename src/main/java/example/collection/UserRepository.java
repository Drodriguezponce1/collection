package example.collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import example.collection.User;

public interface UserRepository extends MongoRepository<User, String>{
    
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
}
