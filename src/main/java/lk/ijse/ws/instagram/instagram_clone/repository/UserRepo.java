package lk.ijse.ws.instagram.instagram_clone.repository;

import lk.ijse.ws.instagram.instagram_clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username) throws Exception;
}
