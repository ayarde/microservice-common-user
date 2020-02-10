package com.microservice.common.user.modal.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="role")
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 2812411316245065300L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;
}
