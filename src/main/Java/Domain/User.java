package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserID;

    private String Name;
    private String Password;
    private String Biography;
    private String Location;
    private String Website;
    private Boolean IsAdmin;

    private List<User> Followers;
    private List<User> Following;

    // Constructors
    public User(String name, String password, String biography, String location, String website, Boolean isAdmin, List<User> followers, List<User> following) {
        Name = name;
        Password = password;
        Biography = biography;
        Location = location;
        Website = website;
        IsAdmin = isAdmin;
        Followers = followers;
        Following = following;
    }

    // Getters and Setters
    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        Biography = biography;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public Boolean getAdmin() {
        return IsAdmin;
    }

    public void setAdmin(Boolean admin) {
        IsAdmin = admin;
    }

    public List<User> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<User> followers) {
        Followers = followers;
    }

    public List<User> getFollowing() {
        return Following;
    }

    public void setFollowing(List<User> following) {
        Following = following;
    }

    // Methods

}