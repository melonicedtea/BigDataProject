/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author darkblade
 */
public class Main {

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
}
