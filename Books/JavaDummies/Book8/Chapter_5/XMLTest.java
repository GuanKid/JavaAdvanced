package Book8.Chapter_5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.NumberFormat;


public class XMLTest
{
    private static NumberFormat cf = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        Document doc = getDocument("C:\\Bootcamp\\Java Bootcamp\\Java\\Advanced\\DummiesBook\\src\\Book8\\Chapter_5\\movies.xml");
        System.out.println("DOM Loaded");

        int count = 0;
        Element root = doc.getDocumentElement();

        Node movie1 = root.getFirstChild();
        while (movie1 != null) {
            count ++;
            movie1 = movie1.getNextSibling();
        }

        System.out.println(count);

        NodeList movies = root.getChildNodes();
        for (int i = 0; i < movies.getLength(); i++)
        {
//            Node movie = movies.item(i);
//            System.out.print(movie.getFirstChild().getTextContent() + "\t");
//            System.out.print(movie.getFirstChild().getNextSibling().getTextContent() + "\t");
//            System.out.println(movie.getAttributes().getNamedItem("year").getTextContent() );
            Element movie = (Element) movies.item(i);
            Node title = movie.getFirstChild();
            System.out.println(getTextValue(title));
            System.out.println(movie.getAttribute("year"));
            Node price = movie.getFirstChild().getNextSibling();
            System.out.println(cf.format( Double.parseDouble(getTextValue(price)) ));
        }



        Element movie = (Element) root.getFirstChild();
        int oldest = 9999;
        while (movie != null)
        {
            String s = movie.getAttribute("year");
            int year = Integer.parseInt(s);
            if (year < oldest)
                oldest = year;
            movie = (Element) movie.getNextSibling();
        }
        System.out.println("The oldest movie in the file is from " + oldest);
        

//        System.out.println("There are " + count + " movies.");
    }

    private static String getTextValue(Node n) {
        return n.getFirstChild().getNodeValue();
    }

    private static Document getDocument(String name)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(name));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
