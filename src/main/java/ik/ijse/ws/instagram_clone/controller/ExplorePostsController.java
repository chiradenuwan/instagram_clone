package ik.ijse.ws.instagram_clone.controller;

import ik.ijse.ws.instagram_clone.entity.ExplorePost;
import ik.ijse.ws.instagram_clone.service.ExplorePostService;
import ik.ijse.ws.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/other-post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExplorePostsController {

    @Autowired
    private ExplorePostService explorePostService;

    @GetMapping("/getpost")
    public ResponseEntity<StandardResponse> getAllPosts(int offset,int limit,int userId){
       List<ExplorePost> list = explorePostService.loadAllPosts(offset,limit,userId);
        System.out.println(list);
        return new ResponseEntity<>(new StandardResponse(200, "true", list), HttpStatus.OK);
    }
}
