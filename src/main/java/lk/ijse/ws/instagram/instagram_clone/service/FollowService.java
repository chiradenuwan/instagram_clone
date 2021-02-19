package lk.ijse.ws.instagram.instagram_clone.service;

import lk.ijse.ws.instagram.instagram_clone.entity.User;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;

public interface FollowService {
    public StandardResponse followProfile(int profile, int followProfile) throws Exception;

    StandardResponse getFollowers(int userProfile) throws Exception;

    StandardResponse getFollowings(int userProfile) throws Exception;
}
