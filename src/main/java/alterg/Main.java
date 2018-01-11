package alterg;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    public static URI getResource(String filename) throws URISyntaxException {
        Class<Main> cl = Main.class;
        return cl.getResource(filename).toURI();
    }
}
