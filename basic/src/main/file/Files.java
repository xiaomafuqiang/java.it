package main.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Files {
    @Test
    public void api() throws IOException, InterruptedException, URISyntaxException {
        File f = new File("/home/mark/test/777.txt");
        // f.delete();

        // f.getParentFile().delete();
        // System.out.println("del");
        // Thread.sleep(10000);
        // System.out.println("mk");
        // f.getParentFile().mkdirs();
       // boolean b = f.createNewFile();
       //  System.out.println(b);
       //  b = f.renameTo(new File(f.getParent() + "/y.txt"));
       //  System.out.println(b);
       //  // System.out.println(f.getParentFile());
       //  System.out.println(f);
        // System.out.println(b);
        // // b = f.delete();
        // System.out.println(b);

        // new File("/home/mark", "sss.tt").createNewFile();

        // URI uri = new URI("file:///home/mark/Git/server-tpl/public/index.html");
        // File ff = new File(uri);
    }
}
