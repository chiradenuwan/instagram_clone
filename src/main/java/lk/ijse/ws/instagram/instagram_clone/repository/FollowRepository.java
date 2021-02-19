package lk.ijse.ws.instagram.instagram_clone.repository;

import lk.ijse.ws.instagram.instagram_clone.entity.Follow;
import lk.ijse.ws.instagram.instagram_clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Integer> {

    //Followings
//    public List<Follow> getAllFollowsByProfileId(User profileId);

    @Query("SELECT f.followingUserId from Follow f where f.userId.userId= ?1")
    public List<User> getProfileWhichFollowedByMe(int profileId);


    //Followers
//    public List<Follow> getAllFollowsByFollowingProfileId(User profileId);

    @Query("SELECT f.userId from Follow f where f.followingUserId.userId= ?1")
    public List<User> getProfileWhichFollowMe(int profileId);
}
