package com.psychosurvey;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

@Component
public class FileChooser {

    public Survey chooseFile(){
        File file = new File("badanie-pytania.xml");
        return XMLParser.parseXML(file);
    }
}
