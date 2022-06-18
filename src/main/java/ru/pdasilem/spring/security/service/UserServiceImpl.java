package ru.pdasilem.spring.security.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.pdasilem.spring.security.model.UserModel;
import ru.pdasilem.spring.security.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserById(long id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.get();
    }

    @Override
    @Transactional
    public void save(UserModel userModel) {
        userModel.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        userRepository.save(userModel);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(UserModel newUser, long id) {
        Optional<UserModel> userModelOpt = userRepository.findById(id);
        UserModel userModel = userModelOpt.get();
        userModel.setRoles(newUser.getRoles());
        userModel.setEmail(newUser.getEmail());
        userModel.setAge(newUser.getAge());
        userModel.setName(newUser.getName());
        userModel.setSurName(newUser.getSurName());
        userModel.setUserLogin(newUser.getUsername());
        userModel.setPassword(newUser.getPassword());
        userRepository.save(userModel);
    }

    @Override
    public UserModel getUserByLogin(String login) {
        return userRepository.findByUserLogin(login);
    }
}
