package org.martynas.blogapp.controller;

import org.martynas.blogapp.model.BlogUser;
import org.martynas.blogapp.model.Post;
import org.martynas.blogapp.service.BlogUserService;
import org.martynas.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.logging.Logger;  // Example for java.util.logging

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@SessionAttributes("post")
public class PostController {
    private final String a = "anonymousUser";
    private final String f = "postForm";
    private final String er = "error";
    private final PostService postService;
    private final BlogUserService blogUserService;
    private static final Logger logger = Logger.getLogger(PostController.class.getName());
    @Autowired
    public PostController(PostService postService, BlogUserService blogUserService) {
        this.postService = postService;
        this.blogUserService = blogUserService;
    }

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model, Principal principal) {

        // Just curious  what if we get username from Principal instead of SecurityContext
        String authUsername = a;
        if (principal != null) {
            authUsername = principal.getName();
        }
        // the end of curiosity //

//        // get username of current logged in session user

        // find post by id
        Optional<Post> optionalPost = this.postService.getById(id);
        // if post exist put it in model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            // Check if current logged in user is owner and let view template know to take according actions
            if (authUsername.equals(post.getUser().getUsername())) {
                model.addAttribute("isOwner", true);
            }
            return "post";
        } else {
            return "404";
        }
    }

    @Secured("ROLE_USER")
    @GetMapping("/createNewPost")
    public String createNewPost(Model model, Principal principal) {

        // Just curious  what if we get username from Principal instead of SecurityContext
        String authUsername = a;
        if (principal != null) {
            authUsername = principal.getName();
        }
        // the end of curiosity //

//        // get username of current logged in session user

        // find user by username
        Optional<BlogUser> optionalBlogUser = this.blogUserService.findByUsername(authUsername);
        // set user to post and put former in model
        if (optionalBlogUser.isPresent()) {
            Post post = new Post();
            post.setUser(optionalBlogUser.get());
            model.addAttribute("post", post);
            return f;
        } else {
            return er;
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("/createNewPost")
    public String createNewPost(@Valid @ModelAttribute Post post, BindingResult bindingResult, SessionStatus sessionStatus) {
        logger.info("POST post: " + post); // for testing debugging purposes
        if (bindingResult.hasErrors()) {
            logger.info("Post did not validate");
            return f;
        }
        // Save post if all good
        this.postService.save(post);
        logger.info("SAVE post: " + post); // for testing debugging purposes
        sessionStatus.setComplete();
        return "redirect:/post/" + post.getId();
    }

    @Secured("ROLE_USER")
    @GetMapping("editPost/{id}")
    public String editPost(@PathVariable Long id, Model model, Principal principal) {
        // Just curious  what if we get username from Principal instead of SecurityContext
        String authUsername = a;
        if (principal != null) {
            authUsername = principal.getName();
        }
        // the end of curiosity //

//        // get username of current logged in session user

        // find post by id
        Optional<Post> optionalPost = this.postService.getById(id);
        // Check if current logged in user is an owner and so has the right for modifications to happen
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            // Check if current logged in user is owner
            if (authUsername.equals(post.getUser().getUsername())) {
                model.addAttribute("post", post);
                logger.info("EDIT post: " + post); // for testing debugging purposes
                return f;
            } else {
                logger.info("Current User has no permissions to edit anything on post by id: " + id); // for testing debugging purposes
                return "403";
            }
        } else {
            logger.info("Could not find a post by id: " + id); // for testing debugging purposes
            return er;
        }
    }

    @Secured("ROLE_USER")
    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable Long id, Principal principal) {

        // Just curious  what if we get username from Principal instead of SecurityContext
        String authUsername = a;
        if (principal != null) {
            authUsername = principal.getName();
        }
        // the end of curiosity //

//        // get username of current logged in session user

        // find post by id
        Optional<Post> optionalPost = this.postService.getById(id);
        // Check if current logged in user is an owner and so has the right for modifications to happen
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            // Check if current logged in user is owner
            if (authUsername.equals(post.getUser().getUsername())) {
                // if so then it is safe to remove post from database
                this.postService.delete(post);
                logger.info("DELETED post: " + post); // for testing debugging purposes
                return "redirect:/";
            } else {
                logger.info("Current User has no permissions to edit anything on post by id: " + id); // for testing debugging purposes
                return "403";
            }
        } else {
            logger.info("Could not find a post by id: " + id); // for testing debugging purposes
            return er;
        }
    }

}
