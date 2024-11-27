package Book8.Chapter_5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.NumberFormat;

public class ListMoviesXML2
{
    private static NumberFormat cf = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        Document doc = getDocument("C:\\Bootcamp\\Java Bootcamp\\Java\\Advanced\\DummiesBook\\src\\Book8\\Chapter_5\\movies.xml");

        Element root = doc.getDocumentElement();
        Element movieElement = (Element) root.getFirstChild();

        Movie m;
        while (movieElement != null)
        {
            m = getMovie(movieElement);
            String msg = Integer.toString(m.year);
            msg += ": " + m.title;
            msg += " (" + cf.format(m.price) + " )";
            System.out.println(msg);
            movieElement = (Element) movieElement.getNextSibling();
        }
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
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Movie getMovie(Element e)
    {
        // get the year attribute
        String yearstring = e.getAttribute("year");
        int year = Integer.parseInt(yearstring);

        // get the title Element
        Element tElement = (Element)e.getFirstChild();
        String title = getTextValue(tElement).trim();

        // get the Price element
        Element pElement = (Element) tElement.getNextSibling();

        String pString = getTextValue(pElement).trim();
        double price  = Double.parseDouble(pString);
        return new Movie(title, year, price);
    }

    private static String getTextValue(Node n)
    {
        return n.getFirstChild().getNodeValue();
    }

    private static class Movie
    {
        public String title;
        public int year;
        public double price;
        public Movie(String title, int year, double price)
        {
            this.title = title;
            this.year = year;
            this.price = price;
        }
    }
}
