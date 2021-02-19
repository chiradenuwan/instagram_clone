package lk.ijse.ws.instagram.instagram_clone.repository;

import lk.ijse.ws.instagram.instagram_clone.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends CrudRepository<User, Integer> {

    boolean existsByUsername(String username) throws Exception;

    User getUserByUsername(String username);

    User getUserByUserId(int followProfileId);


//    User merge(int userId, User user) throws Exception;
}
