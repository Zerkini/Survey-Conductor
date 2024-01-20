package zerkinisoft;

import zerkinisoft.questions.ChoiceQuestion;
import zerkinisoft.questions.Question;
import zerkinisoft.questions.ScaleQuestion;
import zerkinisoft.questions.TextQuestion;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

@Component
public class XMLParser {

    public static Survey parseXML(File file) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }

        NodeList nodeList = document.getElementsByTagName("question");
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                questions.add(createQuestion(element));
            }
        }
        return new Survey(questions);
    }

    private static Question createQuestion(Element element){
        String questionType = element.getElementsByTagName("questionType").item(0).getTextContent();
        switch (questionType) {
            case "scale":
                return createScaleQuestion(element);
            case "text":
                return createTextQuestion(element);
            case "choice":
                return createChoiceQuestion(element);
        }
        return null;
    }

    private static Question createScaleQuestion(Element element) {
        return new ScaleQuestion(parseInt(element.getAttribute("id")), element.getElementsByTagName("questionText").item(0).getTextContent(), parseInt(element.getElementsByTagName("maxScale").item(0).getTextContent()));
    }

    private static Question createChoiceQuestion(Element element) {
        String[] answers = element.getElementsByTagName("answers").item(0).getTextContent().split("/");
        return new ChoiceQuestion(parseInt(element.getAttribute("id")), element.getElementsByTagName("questionText").item(0).getTextContent(), Arrays.asList(answers));
    }

    private static Question createTextQuestion(Element element) {
        return new TextQuestion(parseInt(element.getAttribute("id")), element.getElementsByTagName("questionText").item(0).getTextContent());
    }


}