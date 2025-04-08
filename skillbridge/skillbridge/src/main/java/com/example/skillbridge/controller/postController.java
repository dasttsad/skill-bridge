package com.example.skillbridge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.skillbridge.entity.Post;
import com.example.skillbridge.service.PostService;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Data
@Controller
public class postController {

    private final PostService postservice;

    
    @GetMapping("/post")
    public String showRegularPosts(Model model) {
        List<Post> lista = postservice.getAllPosts();
        List<Post> listavuota = new ArrayList<>();
        for (Post post : lista) {
            if (post.getUtente().getRuolo().getTipo().equalsIgnoreCase("freelancer")) {
                listavuota.add(post);
            }
        }
        model.addAttribute("posts", listavuota);
        return "post";
    }
    
    @GetMapping("/offerta")
    public String showOfferPosts(Model model) {
        List<Post> lista = postservice.getAllPosts();
        List<Post> listavuota = new ArrayList<>();
        for (Post post : lista) {
            if (post.getUtente().getRuolo().getTipo().equalsIgnoreCase("cliente")) {
                listavuota.add(post);
            }
        }
        model.addAttribute("posts", listavuota);
        return "post";
    }

    @GetMapping("/utentipost")
    public String utentipost(Model model) {

        model.addAttribute("posts", postservice.getAllPosts());

        return "utentipost";
    }

   
    


}
