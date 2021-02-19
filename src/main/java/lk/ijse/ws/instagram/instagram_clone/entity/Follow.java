package lk.ijse.ws.instagram.instagram_clone.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Follow {
    private int followId;
    private User userId;
    private User followingUserId;
    private Timestamp followedDate;
    private Timestamp unfollowedDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "following_user_id", referencedColumnName = "userId")
    public User getFollowingUserId() {
        return followingUserId;
    }

    public void setFollowingUserId(User followingUserId) {
        this.followingUserId = followingUserId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    @Basic
    @Column(name = "followed_date")
    public Timestamp getFollowedDate() {
        return followedDate;
    }

    public void setFollowedDate(Timestamp followedDate) {
        this.followedDate = followedDate;
    }

    @Basic
    @Column(name = "unfollowed_date")
    public Timestamp getUnfollowedDate() {
        return unfollowedDate;
    }

    public void setUnfollowedDate(Timestamp unfollowedDate) {
        this.unfollowedDate = unfollowedDate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return followId == follow.followId &&
                Objects.equals(followedDate, follow.followedDate) &&
                Objects.equals(unfollowedDate, follow.unfollowedDate) &&
                Objects.equals(status, follow.status);
    }
}
