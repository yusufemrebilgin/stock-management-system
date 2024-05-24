package com.example.stockmanagement.service;

import com.example.stockmanagement.exception.UserNotFoundException;
import com.example.stockmanagement.repository.user.RoleRepository;
import com.example.stockmanagement.repository.user.UserRepository;
import com.example.stockmanagement.entity.user.Role;
import com.example.stockmanagement.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean changePassword(String username, String currentPassword, String newPassword) {
        User user = findByUsername(username);
        if (user != null && passwordEncoder.matches(currentPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Transactional
    public void save(User formUser) {
        User user = User.builder()
                .username(formUser.getUsername())
                .password(passwordEncoder.encode(formUser.getPassword()))
                .enabled(true)
                .firstName(formUser.getFirstName())
                .lastName(formUser.getLastName())
                .email(formUser.getEmail())
                .roles(Collections.singletonList(roleRepository.findRoleByName("ROLE_USER")))
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }

    public void deleteById(Long id) {
        User user = findById(id);
        user.setRoles(null);
        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
