package example.collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findByUser(String user);
}
