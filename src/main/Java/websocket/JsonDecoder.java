package websocket;

import com.google.gson.Gson;
import domain.Post;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * Decodes {@link Message}s from JSON
 *
 * @author jgeenen
 */
public class JsonDecoder implements Decoder.Text<Post> {

    private final Gson gson = new Gson();

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public Post decode(String arg0) throws DecodeException {
        return gson.fromJson(arg0, Post.class);
    }

    @Override
    public boolean willDecode(String arg0) {
        return true;
    }


    @Override
    public void destroy() {

    }
}
