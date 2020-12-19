package ik.ijse.ws.instagram_clone.service;

import ik.ijse.ws.instagram_clone.entity.ExplorePost;

import java.util.List;

public interface ExplorePostService {
    List<ExplorePost> loadAllPosts(int offset, int limit,int userId);
}
