package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String role;
<<<<<<< HEAD

=======
>>>>>>> da3fa85312d503526c757fe3b6723406cfe55f38
     @OneToOne
    private User user;

    public Account() {
    }

    public Account(String userName, String password, User user) {
        this.userName = userName;
        this.password = password;
        this.user = user;
        this.role = "customer";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public User getUser() {
        return user;
    }

}
