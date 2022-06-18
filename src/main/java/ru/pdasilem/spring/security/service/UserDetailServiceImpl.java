package ru.pdasilem.spring.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.pdasilem.spring.security.repository.UserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByUserLogin(login);
    }
}
