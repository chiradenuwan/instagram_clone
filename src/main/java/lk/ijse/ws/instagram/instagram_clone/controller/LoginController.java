package lk.ijse.ws.instagram.instagram_clone.controller;

import lk.ijse.ws.instagram.instagram_clone.dto.ReactDto;
import lk.ijse.ws.instagram.instagram_clone.dto.UserDto;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping(value = "/login", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        UserDetails user = userDetailsService.loadUserByUsername(userDto.getUsername());
        System.out.println(user);
        System.out.println(user.getAuthorities());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
