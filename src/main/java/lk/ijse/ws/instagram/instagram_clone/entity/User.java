package lk.ijse.ws.instagram.instagram_clone.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    private String profilePicUrl;

    @OneToMany
    @MapKey(name = "post")
    private List<Post> allPosts;

    @OneToMany
    @MapKey(name = "share")
    private List<Share> allShares;

    @OneToMany
    @MapKey(name = "react")
    private List<React> allReacts;

    @OneToMany
    @MapKey(name = "comment")
    private List<Comment> allComments;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }
}
