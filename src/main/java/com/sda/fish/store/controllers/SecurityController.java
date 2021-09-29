package com.sda.fish.store.controllers;

import com.sda.fish.store.entities.AuthorityEntity;
import com.sda.fish.store.entities.UserEntity;
import com.sda.fish.store.models.RegisterModel;
import com.sda.fish.store.repositories.AuthorityRepository;
import com.sda.fish.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ModelAndView showLogin(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegister() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("registerContainer", new RegisterModel());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute ("registerContainer") RegisterModel registerModel){
        ModelAndView modelAndView = new ModelAndView("redirect:/frontpage");
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerModel.getUsername());
        userEntity.setPassword(passwordEncoder.encode(registerModel.getPassword()));
        userEntity.setEnabled(true);
        userRepository.save(userEntity);

        AuthorityEntity authorityEntity = new AuthorityEntity();
        authorityEntity.setUsername(registerModel.getUsername());
        authorityEntity.setAuthority("USER");
        authorityRepository.save(authorityEntity);

        return modelAndView;
    }
}
