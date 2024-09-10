package com.gilandrey.workshopmongo.services;

import com.gilandrey.workshopmongo.domain.Post;
import com.gilandrey.workshopmongo.repository.PostRepository;
import com.gilandrey.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object don't found"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }
}
