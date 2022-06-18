package ru.pdasilem.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pdasilem.spring.security.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUserLogin(String userLogin);
}