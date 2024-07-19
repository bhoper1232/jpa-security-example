package com.bhoper.jpasecurity;

import com.bhoper.jpasecurity.model.Post;
import com.bhoper.jpasecurity.model.UserEntity;
import com.bhoper.jpasecurity.repository.PostRepository;
import com.bhoper.jpasecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JpaSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PostRepository postRepository, UserRepository userRepository,
                                               PasswordEncoder passwordEncoder) {
        return args -> {
            userRepository.save(new UserEntity(
                    "user",
                    passwordEncoder.encode("password"),
                    "ROLE_USER"));
            userRepository.save(new UserEntity(
                    "admin",
                    passwordEncoder.encode("password"),
                    "ROLE_USER,ROLE_ADMIN"));
            postRepository.save(new Post("Title", "Test Content", "bhoper"));
        };
    }
}
