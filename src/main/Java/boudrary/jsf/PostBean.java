package boudrary.jsf;

import domain.Post;
import service.PostService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "postBean")
@SessionScoped
public class PostBean implements Serializable {

    @Inject
    private PostService postService;

    private List<Post> userPosts;

    @PostConstruct
    public void init() {

    }

    public void getUserPosts(Long userID) {
        this.userPosts = this.postService.getLatestsTenPosts(userID);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/kwetter/faces/post.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(Post post) {
        this.postService.deletePost(post);
        refresh();
    }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }

    private void refresh() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/kwetter/faces/post.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
