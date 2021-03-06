package com.blog.blog.controllers.models;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, length = 100, unique = true)
    @NotBlank(message = "Cannot be blank")
    @Pattern(regexp = "(?=^.{1,26}$)^[a-zA-Z][a-zA-Z0-9 ]*[._-]?[a-zA-Z0-9 ]+$", message = "Username must be alphanumeric only.")
    private String username;
    @Column(nullable = false, length = 100, unique = true)
    @NotBlank(message="Cannot be blank")
    @Email(message="Not valid")
    private String email;
    private String password;

    private String ranking = "junior";

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Score> scores;



    public User() {
    }

    public User(String username, String email, String password, String rank, List<Score> scores) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.ranking = rank;
        this.scores = scores;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRank() {
        return ranking;
    }

    public void setRank(String rank) {
        this.ranking = rank;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
