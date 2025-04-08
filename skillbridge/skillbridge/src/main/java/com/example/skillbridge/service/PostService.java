package com.example.skillbridge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.skillbridge.entity.Post;
import com.example.skillbridge.entity.Utente;
import com.example.skillbridge.repository.PostRepository;

import lombok.Data;

@Data
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    

    //AGGIUNTO 26.03
    public Post updatePost(Long id, String titolo, String descrizione, String immagine, Long id_utente) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post con id: " + id + " non trovato"));
               
        
        post.setTitolo(titolo);
        post.setDescrizione(descrizione);
        post.setImmagine(immagine);
        post.getUtente().setId(id_utente);
    
        return postRepository.saveAndFlush(post);
    }    

    //aggiunto  26-03
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }


}