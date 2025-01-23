package com.example.demo.service;

import java.util.Optional;


import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserrRepository;
import com.example.demo.model.Userr;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private com.example.demo.repository.UserrRepository repository;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
//    @Lazy
    private UserInfoService userInfoService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Userr> userDetail = repository.findByName(username); // Assuming 'email' is used as username
System.out.println(" name  " +userDetail.get().getName() + " "+userDetail.get().getPassword());
        // Converting UserInfo to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public String addUser(Userr userInfo) {
        // Encode password before saving the user
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User Added Successfully";
    }
}
