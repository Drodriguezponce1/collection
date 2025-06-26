package example.collection;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class CollectionController {

    @Autowired
    //private UserRepository userRepository;  // Assuming you're using a MongoRepository
    
    @GetMapping("/hello")
    public String getTester(@RequestParam(defaultValue = "NSKONDKLSNDLK") String param) {
        return new String(param);
    }
    
}
