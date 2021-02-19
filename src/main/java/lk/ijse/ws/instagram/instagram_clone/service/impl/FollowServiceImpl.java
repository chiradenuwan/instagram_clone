package lk.ijse.ws.instagram.instagram_clone.service.impl;

import lk.ijse.ws.instagram.instagram_clone.dto.UserDetailsDto;
import lk.ijse.ws.instagram.instagram_clone.entity.Follow;
import lk.ijse.ws.instagram.instagram_clone.entity.User;
import lk.ijse.ws.instagram.instagram_clone.repository.FollowRepository;
import lk.ijse.ws.instagram.instagram_clone.repository.UserRepository;
import lk.ijse.ws.instagram.instagram_clone.service.FollowService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository profileDetailRepository;

    @Override
    @Transactional
    public StandardResponse followProfile(int profile, int followProfileId) throws Exception {

        User followProfile = profileDetailRepository.getUserByUserId(followProfileId);
        User user = new User();
        user.setUserId(profile);
        if (followProfile != null) {
            Follow follow = new Follow();
            follow.setUserId(user);
            follow.setFollowingUserId(followProfile);
            follow.setFollowedDate(new Timestamp(System.currentTimeMillis()));
            follow.setUnfollowedDate(null);
            follow.setStatus("ACT");

            follow = followRepository.save(follow);

            if (follow != null) {
                return new StandardResponse(200, "Added Sucessful", follow);
            }
            return new StandardResponse(415, "Not Added", null);

        } else {
            return new StandardResponse(415, "No Profile found to the Profile Id - " + followProfileId, null);
        }

    }

    @Override
    public StandardResponse getFollowers(int userProfile) {
        List<UserDetailsDto> followerList = new ArrayList<>();

        List<User> followers = followRepository.getProfileWhichFollowMe(userProfile);

        for (User profileId : followers) {
            UserDetailsDto details = new UserDetailsDto();
            details.setName(profileId.getName());
            details.setId(profileId.getUserId());
            details.setUsername(profileId.getUsername());
            details.setProfilePicUrl(profileId.getProfilePicUrl());
            followerList.add(details);
        }
        if (followerList.size() > 0) {
            return new StandardResponse(200, "Ok", followerList);
        } else {
            return new StandardResponse(200, "No Followers", null);
        }

    }

    @Override
    public StandardResponse getFollowings(int profile) throws Exception {
        List<UserDetailsDto> followingList = new ArrayList<>();
        List<User> followings = followRepository.getProfileWhichFollowedByMe(profile);
        System.out.println(followings);
        for (User profileId : followings) {
            UserDetailsDto details = new UserDetailsDto();
            details.setName(profileId.getName());
            details.setId(profileId.getUserId());
            details.setUsername(profileId.getUsername());
            details.setProfilePicUrl(profileId.getProfilePicUrl());
            followingList.add(details);
        }
        if (followingList.size() > 0) {
            return new StandardResponse(200, "Ok", followingList);
        } else {
            return new StandardResponse(200, "No Followers", null);
        }
    }
}