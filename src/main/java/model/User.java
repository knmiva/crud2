package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "country")
    private String country;
    @Column(name = "mobile")
    private String mobile;

    public User() {
    }

    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;


    }

    public User(String name, String email, String country, String mobile) {

        this.name = name;
        this.email = email;
        this.country = country;
        this.mobile = mobile;
    }

    public User(Long id, String name, String email, String country, String mobile) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}


