package xml.java;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class Doms {

    @Test
    public void run() throws DocumentException {
        SAXReader reader = new SAXReader();

        InputStream in = getClass().getClassLoader().getResourceAsStream("first.xml");
        Document document = reader.read(in); // doc
        System.out.println(document);
        Element rootElement = document.getRootElement();

        Node node = rootElement.selectSingleNode("//name");
        System.out.println(node);
    }
}
