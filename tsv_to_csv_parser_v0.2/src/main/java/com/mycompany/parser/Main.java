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
        String pattern = "(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*)";
        Pattern titlePattern = Pattern.compile(pattern);

        try {
            File myObj = new File(fileToParse);
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    Matcher m = titlePattern.matcher(data);
                    if (m.find()) {
                        System.out.println(m.group(9));
                    }
                    else {
                        System.out.println("no match");
                    }

                    // lines.add(data);
                }
                //Path file = Paths.get(fileParsed);
                //Files.write(file, lines);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }


}
