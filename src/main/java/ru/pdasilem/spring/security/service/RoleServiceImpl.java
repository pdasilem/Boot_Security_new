package ru.pdasilem.spring.security.service;

import org.springframework.stereotype.Service;
import ru.pdasilem.spring.security.model.Roles;
import ru.pdasilem.spring.security.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Roles> rolesList() {
        return roleRepository.findAll();
    }

    @Override
    public Roles findRoleById(long id) {
        Optional<Roles> userRoles = roleRepository.findById(id);
        return userRoles.get();
    }

}
