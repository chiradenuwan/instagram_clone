package lk.ijse.ws.instagram.instagram_clone.dto;

import java.util.List;

public class FollowerDto {
    private int followerId;
    private List<UserDto> followersList;
    private List<UserDto> followingList;

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public List<UserDto> getFollowersList() {
        return followersList;
    }

    public void setFollowersList(List<UserDto> followersList) {
        this.followersList = followersList;
    }

    public List<UserDto> getFollowingList() {
        return followingList;
    }

    public void setFollowingList(List<UserDto> followingList) {
        this.followingList = followingList;
    }

    @Override
    public String toString() {
        return "FollowerDto{" +
                "followerId=" + followerId +
                ", followersList=" + followersList +
                ", followingList=" + followingList +
                '}';
    }
}
