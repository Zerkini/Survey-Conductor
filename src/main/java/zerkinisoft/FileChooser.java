package zerkinisoft;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileChooser {

    public Survey chooseFile(){
        File file = new File("badanie-pytania.xml");
        return XMLParser.parseXML(file);
    }
}
