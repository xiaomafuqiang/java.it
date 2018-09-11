import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Play {

    @Test
    public void run() throws UnsupportedEncodingException {
        String e = URLEncoder.encode("好女kk", "utf-8");
        System.out.println(e);
        String ee = URLDecoder.decode(e, "utf-8");
        System.out.println(ee);
    }
}
