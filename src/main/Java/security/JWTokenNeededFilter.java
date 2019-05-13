package security;

import domain.GlobalKey;
import io.jsonwebtoken.Jwts;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Key;

@Provider
@JWToken
@Priority(Priorities.AUTHENTICATION)
public class JWTokenNeededFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        try {
            String Authorisasion = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            String token = Authorisasion.substring("Bearer".length()).trim();

            Key key = GlobalKey.getKey();
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);

        } catch (Exception e) {
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
