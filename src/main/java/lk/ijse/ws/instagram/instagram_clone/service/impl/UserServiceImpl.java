package lk.ijse.ws.instagram.instagram_clone.service.impl;

import lk.ijse.ws.instagram.instagram_clone.dto.UserDto;
import lk.ijse.ws.instagram.instagram_clone.entity.User;
import lk.ijse.ws.instagram.instagram_clone.repository.UserRepo;
import lk.ijse.ws.instagram.instagram_clone.service.UserService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public StandardResponse registerUser(UserDto userDto) throws Exception {
        if (userRepo.existsByUsername(userDto.getUsername())) {
            return new StandardResponse(500, "User Already Exists", null);
        }
        System.out.println(userDto.getProfilePicUrl().getOriginalFilename());
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setProfilePicUrl("https://myawsimagebucket.s3.us-east-2.amazonaws.com/" + userDto.getProfilePicUrl().getOriginalFilename());
        User save = userRepo.save(user);
        if (save != null) {
            return new StandardResponse(200, "Added Sucessful", save);

        }
        return new StandardResponse(415, "Not Added", null);

    }

    @Override
    public StandardResponse getUserbyId(int userId) throws Exception {
        Optional<User> user = userRepo.findById(userId);
        System.out.println("User : " + user);
        if (user != null) {
            return new StandardResponse(200, "Added Sucessful", user);

        }
        return new StandardResponse(415, "Not Added", null);
    }
}
