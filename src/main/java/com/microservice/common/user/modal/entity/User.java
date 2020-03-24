package com.microservice.common.user.modal.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -7970748246782251934L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;
    @Column(length = 60)
    private String password;
    private Boolean enable;
    private String name;
    private String lastname;
    @Column(unique = true, length = 100)
    private String email;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})})
    private List<Role> roles;
    private Integer tries;

    public Integer getTries() {
        return tries;
    }

    public void setTries(Integer tries) {
        this.tries = tries;
    }

}
