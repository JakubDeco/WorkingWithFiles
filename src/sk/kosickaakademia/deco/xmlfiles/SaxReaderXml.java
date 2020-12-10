package sk.kosickaakademia.deco.xmlfiles;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SaxReaderXml {
    public static void main(String[] args) {
        printMatchReport();
        /*
    2020-12-10
    FC Kosice - Zemplin Michalovce 1:2
    goly: 64 Jan Kollar - 5 Richard Kovac , 57 Emil Novak
    */

    }

    private static void printMatchReport() {
        try {
        File file=new File("resource/futbal.xml");
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();

        DocumentBuilder db=db = dbf.newDocumentBuilder();
        Document doc=db.parse(file);
        doc.getDocumentElement().normalize();

        System.out.println(doc.getElementsByTagName("datum").item(0).getTextContent());
        System.out.print(doc.getElementsByTagName("domaci").item(0).getTextContent()+" - ");
        System.out.print(doc.getElementsByTagName("hostia").item(0).getTextContent()+" ");
        System.out.println(doc.getElementsByTagName("vysledok").item(0).getTextContent());


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
