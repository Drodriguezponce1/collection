package example.collection;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Add these imports if User and UserRepository are in the same package
import example.collection.User;
import example.collection.UserRepository;

@RestController
@RequestMapping("/users")
public class CollectionController {

    @Autowired
    private UserRepository userRepository; // Assuming you're using a MongoRepository

    @GetMapping("/hello")
    public String getTester(@RequestParam(defaultValue = "NSKONDKLSNDLK") String param) {
        return param;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = userRepository.findAll(); // Use MongoDB repository to fetch all users
        return ResponseEntity.ok(users); // Return users in the response
    }

    @PostMapping
    public ResponseEntity<?>  createUser(@RequestBody User user) {
        try {
            User savedUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }

}
