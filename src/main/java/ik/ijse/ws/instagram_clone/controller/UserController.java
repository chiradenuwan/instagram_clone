package ik.ijse.ws.instagram_clone.controller;

import ik.ijse.ws.instagram_clone.dto.UserDto;
import ik.ijse.ws.instagram_clone.service.UserService;
import ik.ijse.ws.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<StandardResponse> register(@RequestBody UserDto userDto) {
        try {
            StandardResponse responseResponse = userService.registerUser(userDto);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

//    @GetMapping("/login")
//    public ResponseEntity<StandardResponse> login(@RequestBody UserDto userDto) {
//        try {
//            boolean islogged = userService.loginUser(userDto);
//            return new ResponseEntity<>(new StandardResponse(200, "true", null), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }


}
