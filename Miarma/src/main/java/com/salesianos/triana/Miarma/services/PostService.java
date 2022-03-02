package com.salesianos.triana.Miarma.services;


import com.salesianos.triana.Miarma.dto.CreatePostDto;

import com.salesianos.triana.Miarma.dto.GetPostDto;
import com.salesianos.triana.Miarma.models.Post;

import com.salesianos.triana.Miarma.users.dto.CreateUserDto;
import com.salesianos.triana.Miarma.users.model.User;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostService {

    List<GetPostDto> findAllPublicPosts();
    Optional<Post> findOne(Long id);
    Post savePost(CreatePostDto createPostDto, MultipartFile file, User user);
    Post edit(Long id, CreatePostDto createPostDto, MultipartFile file, CreateUserDto createUserDto);
    void removePostById(Long id, User user) throws IOException;

}
