package ik.ijse.ws.instagram_clone.service.impl;

import ik.ijse.ws.instagram_clone.dto.UserDto;
import ik.ijse.ws.instagram_clone.entity.User;
import ik.ijse.ws.instagram_clone.repository.UserRepository;
import ik.ijse.ws.instagram_clone.service.UserService;
import ik.ijse.ws.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public StandardResponse registerUser(UserDto userDto) throws Exception {
        if (userRepository.existsByUsername(userDto.getusername())) {
            return new StandardResponse(500, "User Already Exists", null);
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getusername());
        user.setPassword(userDto.getPassword());
        user.setPro_pic("https://myawsimagebucket.s3.us-east-2.amazonaws.com/" + userDto.getPro_pic().getOriginalFilename());
        User save = userRepository.save(user);
        System.out.println(save);

        return null;
    }

    @Override
    public boolean loginUser(UserDto userDto) throws Exception {
        User user = new User();
        user.setUsername(userDto.getusername());
        user.setPassword(userDto.getPassword());
        User set =  userRepository.findUserByUsername(user.getUsername());
        if (set !=null) {
            return true;
        }
        return false;
    }
}
