package lk.ijse.ws.instagram.instagram_clone.service;

import lk.ijse.ws.instagram.instagram_clone.dto.PostDto;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;

public interface PostService {
    StandardResponse createPost(PostDto postDto) throws Exception;
}
