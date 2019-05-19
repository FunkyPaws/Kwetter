package domain;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.ws.rs.core.Link;
import java.io.Serializable;
import java.util.List;


import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.getAll", query = "SELECT u FROM User AS u"),
        @NamedQuery(name = "User.getFollowers", query = "SELECT u FROM User AS u WHERE :user MEMBER OF u.Followers"),
        @NamedQuery(name = "User.getFollowing", query = "SELECT u FROM User AS u WHERE :user MEMBER OF u.Following"),
        @NamedQuery(name = "User.some", query = "SELECT u from User as u WHERE u.Name like :uName"),
        @NamedQuery(name = "User.login", query = "SELECT u.UserID from User as u WHERE u.Name = :name AND u.Password = :password")

})
public class User extends ResourceSupport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserID;

    private String Name;

    @JsonbTransient
    private String Password;
    private String Biography;
    private String Location;
    private String Website;
    private boolean IsAdmin;

    @ManyToMany(mappedBy = "Following")
    @JsonbTransient
    private List<User> Followers;

    @JsonbTransient
    @ManyToMany
    private List<User> Following;

    // Constructors
    public User(String name, String password, String biography, String location, String website, Boolean isAdmin, List<User> following, List<User> follower) {
        Name = name;
        Password = password;
        Biography = biography;
        Location = location;
        Website = website;
        IsAdmin = isAdmin;
        Following = following;
        Followers = follower;
    }

    public User(String name, String biography, String location, String website, Boolean isAdmin, List<User> following, List<User> follower) {
        Name = name;
        Biography = biography;
        Location = location;
        Website = website;
        IsAdmin = isAdmin;
        Following = following;
        Followers = follower;
    }

    public User(Long userID, String name, String biography, String location, String website, Boolean isAdmin, List<User> following, List<User> follower) {
        UserID = userID;
        Name = name;
        Biography = biography;
        Location = location;
        Website = website;
        IsAdmin = isAdmin;
        Following = following;
        Followers = follower;
    }


    public User() {
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

    @JsonbTransient
    public List<User> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<User> followers) {
        Followers = followers;
    }

    @JsonbTransient
    public List<User> getFollowing() {
        return Following;
    }

    public void setFollowing(List<User> following) {
        Following = following;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Biography='" + Biography + '\'' +
                ", Location='" + Location + '\'' +
                ", Website='" + Website + '\'' +
                ", IsAdmin=" + IsAdmin +
                ", Followers=" + Followers +
                ", Following=" + Following +
                '}';
    }

    //this user goes following other user
    public void addFollowing(User user) {
        if (!this.Following.contains(user)) {
            this.Following.add(user);
        }
    }

    //this users followers
    public void addFollower(User user) {
        if (!this.Followers.contains(user)) {
            this.Followers.add(user);
        }
    }

    public void removeFollowed(User user) {
        if (this.Following.contains(user)) {
            Following.remove(user);
        }
    }

    public Link[] getUserLinks(){
        return null;
    }
}
