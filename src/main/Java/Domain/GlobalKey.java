package domain;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class GlobalKey {
    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public static Key getKey() {
        return key;
    }
}
