package com.myblog11.myblog11.serviceImpl;

import com.myblog11.myblog11.entity.Post;
import com.myblog11.myblog11.payload.PostDto;
import com.myblog11.myblog11.repository.PostRepository;
import com.myblog11.myblog11.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTittle(postDto.getTittle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost = postRepository.save(post);
        PostDto dto = new PostDto();
        dto.setTittle(savedPost.getTittle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
        return dto;
    }
}
