package ik.ijse.ws.instagram_clone.service;

import ik.ijse.ws.instagram_clone.dto.UserDto;
import ik.ijse.ws.instagram_clone.util.StandardResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    StandardResponse registerUser(UserDto userDto) throws Exception;

//    boolean loginUser(UserDto userDto) throws Exception;
}
