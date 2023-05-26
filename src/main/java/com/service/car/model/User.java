package com.service.car.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity{

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    private Status status;

//    @Override
//    public int hashCode(){
//        return this.username.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj){
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof User)) {
//            return false;
//        }
//        return this.username.equals(((User) obj).username);
//    }
}
