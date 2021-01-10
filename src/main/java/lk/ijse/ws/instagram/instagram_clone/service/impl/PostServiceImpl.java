package lk.ijse.ws.instagram.instagram_clone.service.impl;

import lk.ijse.ws.instagram.instagram_clone.dto.PostDto;
import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import lk.ijse.ws.instagram.instagram_clone.repository.PostRepo;
import lk.ijse.ws.instagram.instagram_clone.service.PostService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;


@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Override
    public StandardResponse createPost(PostDto postDto) throws Exception {
        System.out.println(postDto);
        Post post = new Post();
        post.setImageUrl("https://myawsimagebucket.s3.us-east-2.amazonaws.com/" + postDto.getImageUrl().getOriginalFilename());
        post.setPostTime(new Date());
        post.setText(postDto.getText());
        post.setUser(postDto.getUser());
        Post save = postRepo.save(post);
        System.out.println(post);
        if (save != null) {
            return new StandardResponse(200, "Added Sucessful", save);

        }
        return new StandardResponse(415, "Not Added", null);

    }
}
