/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author darkblade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        List<String> lines = new ArrayList<>();
        String fileToParse = "resources/new.tsv";
        String fileParsed = "resources/dataParsed.csv";
        String pattern = "(.*)";
        String delimiter = "|";
        int groupCount = 1;

        try {
            File myObj = new File(fileToParse);
            try (Scanner myReader = new Scanner(myObj)) {
                String firstLine = myReader.nextLine();
                for(int i = 0; i < firstLine.length(); i++){
                    if(firstLine.charAt(i) == '\t'){
                        groupCount++;
                    }
                }
                for(int j = 1; j < groupCount; j++){
                    pattern = "(.*?)\t" + pattern;
                }
                Pattern titlePattern = Pattern.compile(pattern);

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String line = "";
                    Matcher m = titlePattern.matcher(data);
                    if (m.find()) {
                        for(int i = 1; i < m.groupCount(); i++){
                            line = line + m.group(i) + delimiter;
                        }
                        line = line + m.group(m.groupCount());
                    }
                    else {
                        System.out.println("no match");
                    }

                    lines.add(line);
                }
                Path file = Paths.get(fileParsed);
                Files.write(file, lines);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }


}
