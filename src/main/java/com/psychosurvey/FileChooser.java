package com.psychosurvey;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

@Component
public class FileChooser {

    public void chooseFile(){
        System.out.println("Enter the name of the file: ");
        File file = new File(readInput());
//        readFile(file);
        XMLParser.parseXML(file);
    }

    private String readInput(){
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        return fileName;
    }

    private void readFile(File file){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null){
                System.out.println(text);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }






}
