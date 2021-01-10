package lk.ijse.ws.instagram.instagram_clone.controller;


import lk.ijse.ws.instagram.instagram_clone.service.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/react")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReactController {

    @Autowired
    ReactService reactService;
}
