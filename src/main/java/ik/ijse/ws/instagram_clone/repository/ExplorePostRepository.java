package ik.ijse.ws.instagram_clone.repository;

import ik.ijse.ws.instagram_clone.entity.ExplorePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExplorePostRepository extends JpaRepository<ExplorePost, Integer> {

    @Autowired
    ExplorePost explorepost = null;



    @Query(value = "  SELECT * FROM exploreposts ep WHERE NOT u_id =:u_id ", nativeQuery = true)
    List<ExplorePost> getAllPosts(int offset, int limit,@Param("u_id")int userId);

}
