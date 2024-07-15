package org.martynas.blogapp.controller;
import java.util.logging.Logger;  // Example for java.util.logging
import org.martynas.blogapp.model.BlogUser;
import org.martynas.blogapp.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

@Controller
@SessionAttributes("blogUser")
public class SignupController {
    private static final Logger logger = Logger.getLogger(SignupController.class.getName());
    private final BlogUserService blogUserService;

    @Autowired
    public SignupController(BlogUserService blogUserService) {
        this.blogUserService = blogUserService;
    }

    @GetMapping("/signup")
    public String getRegisterForm(Model model) {
        // create new BlogUser instance and pass it to registerForm view template
        BlogUser blogUser = new BlogUser();
        model.addAttribute("blogUser", blogUser);
        return "registerForm";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute BlogUser blogUser, BindingResult bindingResult, SessionStatus sessionStatus) throws RoleNotFoundException {
        logger.info("newUser: " + blogUser);  // for testing debugging purposes
        // Check if username is available
        if (blogUserService.findByUsername(blogUser.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "error.username","Username is already registered try other one or go away");
            logger.info("Username already taken error message");
        }
        // Validate users fields
        if (bindingResult.hasErrors()) {
            logger.info("New user did not validate");
            return "registerForm";
        }
        // Persist new blog user
        this.blogUserService.saveNewBlogUser(blogUser);
        // Create Authentication token and login after registering new blog user
        Authentication auth = new UsernamePasswordAuthenticationToken(blogUser, blogUser.getPassword(), blogUser.getAuthorities());
        logger.info("AuthToken: " + auth);  // for testing debugging purposes
        SecurityContextHolder.getContext().setAuthentication(auth);
        logger.info("SecurityContext Principal: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());  // for testing debugging purposes
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
