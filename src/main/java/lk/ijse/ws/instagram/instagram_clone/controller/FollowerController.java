package lk.ijse.ws.instagram.instagram_clone.controller;

import lk.ijse.ws.instagram.instagram_clone.service.FollowService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/follow")
public class FollowerController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private FollowService followService;

    @PostMapping("/{followProfileId}")
    public ResponseEntity<StandardResponse> followProfile(@PathVariable("followProfileId") int followProfileId) {
        try {
            System.out.println("follow call call : ");

            int userProfile = (int) httpServletRequest.getAttribute("user");
            System.out.println(userProfile);
            StandardResponse standardResponse = followService.followProfile(userProfile, followProfileId);
            return new ResponseEntity<>(standardResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/followers")
    public ResponseEntity<StandardResponse> getFollowers() {
        try {

            int userProfile = (int) httpServletRequest.getAttribute("user");
            StandardResponse standardResponse = followService.getFollowers(userProfile);
            return new ResponseEntity<>(standardResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/followings")
    public ResponseEntity<StandardResponse> getFollowings() {
        try {

            int userProfile = (int) httpServletRequest.getAttribute("user");
            StandardResponse standardResponse = followService.getFollowings(userProfile);
            return new ResponseEntity<>(standardResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}