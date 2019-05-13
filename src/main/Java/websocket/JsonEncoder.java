package websocket;

import com.google.gson.Gson;
import domain.Post;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Encodes {@link Message}s to JSON
 * @author jgeenen
 */
public class JsonEncoder implements Encoder.Text<Post> {
    
    private final Gson gson = new Gson();

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public String encode(Post arg0) throws EncodeException {
        return gson.toJson(arg0);
    }

    @Override
    public void destroy() {
    }
}
