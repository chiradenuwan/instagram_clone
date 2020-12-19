package ik.ijse.ws.instagram_clone.service.impl;

import ik.ijse.ws.instagram_clone.entity.ExplorePost;
import ik.ijse.ws.instagram_clone.repository.ExplorePostRepository;
import ik.ijse.ws.instagram_clone.service.ExplorePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExplorePostServiceImpl implements ExplorePostService {
    @Autowired
    private ExplorePostRepository explorePostRepository;
    @Override
    public List<ExplorePost> loadAllPosts(int offset, int limit,int userId) {
        explorePostRepository.getAllPosts(offset,limit,userId);
        return null;
    }
}
