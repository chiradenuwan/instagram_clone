package lk.ijse.ws.instagram.instagram_clone.service.impl;


import lk.ijse.ws.instagram.instagram_clone.repository.ReactRepo;
import lk.ijse.ws.instagram.instagram_clone.service.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReactServiceImpl implements ReactService {

    @Autowired
    ReactRepo reactRepo;
}
