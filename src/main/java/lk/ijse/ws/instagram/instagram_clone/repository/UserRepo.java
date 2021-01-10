package lk.ijse.ws.instagram.instagram_clone.repository;

import lk.ijse.ws.instagram.instagram_clone.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    boolean existsByUsername(String username) throws Exception;

//    User merge(int userId, User user) throws Exception;
}
