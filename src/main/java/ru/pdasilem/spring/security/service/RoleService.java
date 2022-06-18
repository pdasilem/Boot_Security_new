package ru.pdasilem.spring.security.service;


import ru.pdasilem.spring.security.model.Roles;

import java.util.List;

public interface RoleService  {
    List<Roles> rolesList();
    Roles findRoleById(long id);
}
