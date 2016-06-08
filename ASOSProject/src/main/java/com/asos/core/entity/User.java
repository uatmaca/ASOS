package com.asos.core.entity;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by Umut on 20.11.2015.
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "SURNAME", length = 20)
    private String surname;

    @Column(name = "USER_NAME", nullable = false, length = 20)
    private String userName;

    @Column(name = "USER_PASSWORD", nullable = false, length = 20)
    private String password;

    @Column(name = "CREATED_BY", length = 20)
    private String createdBy;

    @Column(name = "USER_TYPE")
    private int userType;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<GreenHouse> greenHouses;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Set<GreenHouse> getGreenHouses() {
        return greenHouses;
    }

    public void setGreenHouses(Set<GreenHouse> greenHouses) {
        this.greenHouses = greenHouses;
    }
}
