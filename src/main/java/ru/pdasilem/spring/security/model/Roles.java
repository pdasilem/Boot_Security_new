package ru.pdasilem.spring.security.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Roles implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roles")
   private Set<UserModel> userModelSet;

    public Roles(String role, Set<UserModel> userModelSet) {
        this.role = role;
        this.userModelSet = userModelSet;
    }
    public Roles(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Roles() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserModel> getUserModelSet() {
        return userModelSet;
    }

    public void setUserModelSet(Set<UserModel> userModelSet) {
        this.userModelSet = userModelSet;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
