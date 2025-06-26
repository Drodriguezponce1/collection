package example.collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    // Optional<User> findByUser(String user);
    // Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
}
