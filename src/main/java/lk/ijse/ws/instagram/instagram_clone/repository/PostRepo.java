package lk.ijse.ws.instagram.instagram_clone.repository;

import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Long> {
}
