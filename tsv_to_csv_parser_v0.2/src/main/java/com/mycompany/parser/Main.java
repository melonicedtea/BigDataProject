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
        String fileToParse = "resources/new.tsv";
        String fileParsed = "resources/dataParsed.csv";

        try {
            File myObj = new File(fileToParse);
            try (Scanner myReader = new Scanner(myObj)) {
                String firstLine = myReader.nextLine();
                String pattern = createPattern(firstLine);
                Pattern titlePattern = Pattern.compile(pattern);
                List<String> lines = getLines(myReader, titlePattern);
                Path file = Paths.get(fileParsed);
                Files.write(file, lines);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public static String createPattern(String firstLine) {
        String pattern = "(.*)";
        int groupCount = 1;
        for (int i = 0; i < firstLine.length(); i++) {
            if (firstLine.charAt(i) == '\t') {
                groupCount++;
            }
        }
        for (int j = 1; j < groupCount; j++) {
            pattern = "(.*?)\t" + pattern;
        }
        return pattern;
    }

    public static List<String> getLines(Scanner myReader, Pattern titlePattern) {
        String delimiter = "|";
        List<String> lines = new ArrayList<>();

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String line = "";
            Matcher m = titlePattern.matcher(data);
            if (m.find()) {
                for (int i = 1; i < m.groupCount(); i++) {
                    line = line + m.group(i) + delimiter;
                }
                line = line + m.group(m.groupCount());
            } else {
                System.out.println("no match");
            }

            lines.add(line);
        }
        return lines;
    }

}
