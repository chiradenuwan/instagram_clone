package lk.ijse.ws.instagram.instagram_clone.service;

import lk.ijse.ws.instagram.instagram_clone.dto.ReactDto;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;

public interface ReactService {
    StandardResponse reactPost(ReactDto reactDto) throws Exception;
}
