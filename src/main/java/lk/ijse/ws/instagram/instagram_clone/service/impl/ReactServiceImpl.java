package lk.ijse.ws.instagram.instagram_clone.service.impl;


import lk.ijse.ws.instagram.instagram_clone.dto.ReactDto;
import lk.ijse.ws.instagram.instagram_clone.entity.React;
import lk.ijse.ws.instagram.instagram_clone.entity.Share;
import lk.ijse.ws.instagram.instagram_clone.repository.ReactRepo;
import lk.ijse.ws.instagram.instagram_clone.service.ReactService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ReactServiceImpl implements ReactService {

    @Autowired
    ReactRepo reactRepo;

    @Override
    public StandardResponse reactPost(ReactDto reactDto) throws Exception {
        System.out.println(reactDto);
        React react = new React();
        react.setReactor(reactDto.getReactor());
        react.setPost(reactDto.getPost());
        react.setReaction(reactDto.getReaction());
        react.setTime(new Date());
        React save = reactRepo.save(react);
        System.out.println(react);
        if (save != null) {
            return new StandardResponse(200, "Added Sucessful", save);

        }
        return new StandardResponse(415, "Not Added", null);
    }
}
