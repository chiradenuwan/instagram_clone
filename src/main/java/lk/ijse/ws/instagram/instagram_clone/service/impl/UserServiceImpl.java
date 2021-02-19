package lk.ijse.ws.instagram.instagram_clone.service.impl;

import lk.ijse.ws.instagram.instagram_clone.dto.UserDto;
import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import lk.ijse.ws.instagram.instagram_clone.entity.User;
import lk.ijse.ws.instagram.instagram_clone.repository.UserRepository;
import lk.ijse.ws.instagram.instagram_clone.service.UserService;
import lk.ijse.ws.instagram.instagram_clone.util.S3FileUploader;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private S3FileUploader fileUploader;

    @Override
    public StandardResponse registerUser(UserDto userDto) throws Exception {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            return new StandardResponse(500, "User Already Exists", null);
        }
        System.out.println(userDto.getProfilePicUrl().getOriginalFilename());
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setProfilePicUrl(this.fileUploader.uploadFile(userDto.getProfilePicUrl()));
        User save = userRepository.save(user);
        if (save != null) {
            return new StandardResponse(200, "Added Successful", save);

        }
        return new StandardResponse(415, "Not Added", null);

    }

    @Override
    public StandardResponse getUserbyId(int userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        System.out.println("User : " + user);
        if (user.isPresent()) {
            return new StandardResponse(200, "", user);

        }
        return new StandardResponse(415, "No User Found", null);
    }

    @Override
    public StandardResponse updateUserDetails(UserDto userDto, int userId) throws Exception {
        Optional<User> userById = userRepository.findById(userId);
        User user = new User();
        user.setUserId(userId);
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setProfilePicUrl(this.fileUploader.uploadFile(userDto.getProfilePicUrl()));
        User update = userRepository.save(user);
        System.out.println(update);
        if (update != null) {
            return new StandardResponse(200, "Added Successful", update);

        }
        return new StandardResponse(415, "Not Added", null);
    }

    @Override
    public User loadUsernameAndPassword(String username) throws Exception {

        return userRepository.getUserByUsername(username);
    }

    @Override
    public StandardResponse getAllUsers() throws Exception {
        List<User> all = (List<User>) userRepository.findAll();
        if (all.size() > 0) {
            return new StandardResponse(200, "", all);
        } else {
            return new StandardResponse(200, "", null);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        User apiUser = userRepository.getUserByUsername(username);

        if (apiUser != null) {
            return new org.springframework.security.core.userdetails.User(apiUser.getUsername(),
                    apiUser.getPassword(), Collections.singleton(authority));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
