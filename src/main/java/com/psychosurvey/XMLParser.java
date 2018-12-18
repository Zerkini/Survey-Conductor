package com.psychosurvey;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@Component
public class XMLParser {

    public static void parseXML(File file) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("SUCKS");
        }

        System.out.println("Root element :" + document.getDocumentElement().getNodeName());
        NodeList nList = document.getElementsByTagName("survey");
        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                NodeList childNodes = eElement.getChildNodes();

                System.out.println("Question : "
                        + eElement.getAttribute("question"));
//                System.out.println("First Name : "
//                        + eElement
//                        .getElementsByTagName("firstname")
//                        .item(0)
//                        .getTextContent());
//                System.out.println("Marks : "
//                        + eElement
//                        .getElementsByTagName("marks")
//                        .item(0)
//                        .getTextContent());
            }
        }
    }
}