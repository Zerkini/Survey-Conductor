package com.psychosurvey;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

@Component
public class FileChooser {

    public Survey chooseFile(){
        System.out.println("Enter the name of the file: ");
        File file = new File(readInput());
        return XMLParser.parseXML(file);
    }

    private String readInput(){
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        return fileName;
    }
}
