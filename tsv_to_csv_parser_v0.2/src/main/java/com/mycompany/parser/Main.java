/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parser;

import java.io.File;
<<<<<<< 08b1f1c8caeb884156b6f6f3f261bee10824f23b:Parser/src/main/java/com/mycompany/parser/Main.java
import java.io.FileNotFoundException;
=======
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
>>>>>>> data class implemented:tsv_to_csv_parser_v0.2/src/main/java/com/mycompany/parser/Main.java
import java.util.Scanner;
import java.util.regex.Pattern;



/**
 *
 * @author darkblade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
<<<<<<< 08b1f1c8caeb884156b6f6f3f261bee10824f23b:Parser/src/main/java/com/mycompany/parser/Main.java
    public static void main(String[] args) {
        // TODO code application logic here
        try {
      File myObj = new File("resources/text.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
 
        String result = data.replaceAll("[\"]", ";");
        System.out.println(result);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
    
=======
    public static void main(String[] args) throws IOException {
        // TODO IOException
        // TODO more commenting
        List<String> lines = new ArrayList<>();
        String fileToParse = "resources/data.tsv"; // replace with to be parsed file path
        String fileParsed = "resources/dataParsed.csv"; // replace with output path

        File myObj = new File(fileToParse);
        Scanner myReader = new Scanner(myObj);
        
        while (myReader.hasNextLine()) {
            Data data = new Data(myReader.nextLine());
            data.replaceCommas();
            data.replaceTabs();

            //print to console
            System.out.println(data.getLineString());
            //add parsed lines to array
            lines.add(data.getLineString());
        }
        Path file = Paths.get(fileParsed);
        Files.write(file, lines);
    }
>>>>>>> data class implemented:tsv_to_csv_parser_v0.2/src/main/java/com/mycompany/parser/Main.java
}
