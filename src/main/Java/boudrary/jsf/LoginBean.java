package boudrary.jsf;

import boudrary.rest.UserRescource;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @Inject
    private UserRescource userRescource;

    private String username;
    private String password;

    public void loginUser(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            context.getExternalContext().redirect("faces/home.xhtml");
        } catch (IOException e){}
    }

    //TODO: implement methode
    public void logoutUser(){

    }
}
