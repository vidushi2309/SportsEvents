package com.auth.Authentication.entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonManagedReference;
=======
>>>>>>> main
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(unique = true, nullable = false)
    private String email; // New field for email

    private String name;

    @Column(nullable = false)
=======
    private String username;

    private String email; // New field for email

>>>>>>> main
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

<<<<<<< HEAD
    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Admin admin;

    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Athlete athlete;

    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Coach coach;

=======
>>>>>>> main
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
=======
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
>>>>>>> main
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
<<<<<<< HEAD

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
=======
>>>>>>> main
}