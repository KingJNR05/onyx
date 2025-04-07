package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.service;

import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.model.User;
import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.model.UserPrincipal;
import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username Not Found"));
        return new UserPrincipal(user);
    }
}
