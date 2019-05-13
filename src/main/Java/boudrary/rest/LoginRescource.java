package boudrary.rest;


import domain.GlobalKey;
import io.jsonwebtoken.Jwts;
import javafx.application.Application;
import org.primefaces.json.JSONObject;
import service.UserService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.security.Key;

@Path("login")
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class LoginRescource {

    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(JsonObject object) {
        String loginName = object.getString("name");
        String password = object.getString("password");

        Long ID = userService.loginUser(loginName, password);
        if (ID != null) {
            String token = issueToken(loginName);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("access_token", "Bearer" + token);
            jsonObject.put("userID", ID);
            return Response.ok(jsonObject.toString()).header(HttpHeaders.AUTHORIZATION, "Bearer" + token).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    private String issueToken(String loginname) {
        Key key = GlobalKey.getKey();
        String jwToken = Jwts.builder().setSubject(loginname).signWith(key).compact();
        return jwToken;
    }
}
