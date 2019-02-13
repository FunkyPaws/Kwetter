package main.Java.domain;


import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Post{
    //Properties
    //@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long PostID;

    private String Text;
    private Date DateTime;
    private Boolean IsReaction;
    private User User;

    private Long OriginalPostID;

    // Constructors


    public Post(Long postID, String text, Date dateTime, Boolean isReaction, User user, Long originalPostID) {
        PostID = postID;
        Text = text;
        DateTime = dateTime;
        IsReaction = isReaction;
        User = user;
        OriginalPostID = originalPostID;
    }

    public Post(String text, Date dateTime, Boolean isReaction, User user, Long originalPostID) {
        Text = text;
        DateTime = dateTime;
        IsReaction = isReaction;
        User = user;
        OriginalPostID = originalPostID;
    }

    // Getters and Setters
    public Long getPostID() {
        return PostID;
    }

    public void setPostID(Long postID) {
        PostID = postID;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public Boolean getReaction() {
        return IsReaction;
    }

    public void setReaction(Boolean reaction) {
        IsReaction = reaction;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public Long getOriginalPostID() {
        return OriginalPostID;
    }

    public void setOriginalPostID(Long originalPostID) {
        OriginalPostID = originalPostID;
    }

}
