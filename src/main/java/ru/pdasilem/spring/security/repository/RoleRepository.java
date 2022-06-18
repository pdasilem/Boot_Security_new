package ru.pdasilem.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pdasilem.spring.security.model.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
}
