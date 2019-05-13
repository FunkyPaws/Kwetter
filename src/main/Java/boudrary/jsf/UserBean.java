package boudrary.jsf;


import boudrary.rest.UserRescource;
import domain.User;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean implements Serializable {

    @Inject
    private UserService userService;

    private List<User> allUsers;

    @PostConstruct
    public void init() {
        allUsers = userService.getAllUsers();
    }

    public void deleteUser(Long userID) {
        this.userService.deleteUser(userID);
        refresh();
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    private void refresh(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/kwetter/faces/home.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
