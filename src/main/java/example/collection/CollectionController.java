package example.collection;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Add these imports if User and UserRepository are in the same package
import example.collection.User;
import example.collection.UserRepository;
import example.collection.Items.Books;
import example.collection.Items.Item;
import example.collection.Items.Music;
import example.collection.Items.Media;


@RestController
@RequestMapping("/users")
public class CollectionController {

    @Autowired
    private UserRepository userRepository; // Assuming you're using a MongoRepository

    @GetMapping("/hello")
    public String getTester(@RequestParam(defaultValue = "NSKONDKLSNDLK") String param) {
        return new String(param);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = userRepository.findAll(); // Use MongoDB repository to fetch all users
        return ResponseEntity.ok(users); // Return users in the response
    }

    // this creates a new user
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User savedUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user fgdsfgs");
        }
    }

    @PostMapping("/{userId}/addItem")
    public ResponseEntity<?> addItemToUser(@PathVariable String userId, @RequestBody Item item) {
        try {
            // Find the user by ID
            Optional<User> optionalUser = userRepository.findById(userId);

            if (!optionalUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }

            User user = optionalUser.get();

            // Check the type of item and add to the correct list
            if (item instanceof Music) {
                user.getMusic().add((Music) item);
            } else if (item instanceof Books) {
                user.getBooks().add((Books) item);
            } else if (item instanceof Media) {
                user.getMedia().add((Media) item);
            }

            // Save the updated user
            userRepository.save(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding item to user");
        }

    }
}