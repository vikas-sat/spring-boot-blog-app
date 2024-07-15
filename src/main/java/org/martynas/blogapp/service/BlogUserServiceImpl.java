package org.martynas.blogapp.service;

import org.martynas.blogapp.model.Authority;
import org.martynas.blogapp.model.BlogUser;
import org.martynas.blogapp.repository.AuthorityRepository;
import org.martynas.blogapp.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;  // Example for java.util.logging
import javax.management.relation.RoleNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class BlogUserServiceImpl implements BlogUserService {
    private static final Logger logger = Logger.getLogger(BlogUserServiceImpl.class.getName());
    private static final String DEFAULT_ROLE = "ROLE_USER";
    private final BCryptPasswordEncoder bcryptEncoder;
    private final BlogUserRepository blogUserRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public BlogUserServiceImpl(BCryptPasswordEncoder bcryptEncoder, BlogUserRepository blogUserRepository, AuthorityRepository authorityRepository) {
        this.bcryptEncoder = bcryptEncoder;
        this.blogUserRepository = blogUserRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<BlogUser> blogUser = blogUserRepository.findByUsername(username);
        if (blogUser.isPresent()) {
            return blogUser.get();
        } else {
            throw new UsernameNotFoundException("No user found with username " + username);
        }
    }

    @Override
    public Optional<BlogUser> findByUsername(String username) {
        return blogUserRepository.findByUsername(username);
    }

    @Override
    public BlogUser saveNewBlogUser(BlogUser blogUser) throws RoleNotFoundException {
        logger.info("saveNewBlogUser: " + blogUser);  // for testing debugging purposes
        // Encode plaintext password with password encoder
        blogUser.setPassword(this.bcryptEncoder.encode(blogUser.getPassword())); // explicit bcrypt encoder so better approach ?
        // set account to enabled by default
        blogUser.setEnabled(true);
        // Set default Authority/Role to new blog user
        Optional<Authority> optionalAuthority = this.authorityRepository.findByAuthority(DEFAULT_ROLE);
        logger.info("optionalAuthority: " + optionalAuthority);  // for testing debugging purposes
        if (optionalAuthority.isPresent()) {
            Authority authority = optionalAuthority.get();
            Collection<Authority> authorities = Collections.singletonList(authority);
            blogUser.setAuthorities(authorities);
            logger.info("blogUser after Roles: " + blogUser);  // for testing debugging purposes
            return this.blogUserRepository.saveAndFlush(blogUser);
        } else {
            throw new RoleNotFoundException("Default role not found for blog user with username " + blogUser.getUsername());
        }
    }
}
