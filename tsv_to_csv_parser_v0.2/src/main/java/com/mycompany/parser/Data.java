/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author darkblade
 */

package com.mycompany.parser;


public class Data{
    
    String line;
    public Data(String line){
        this.line = line;
    }
    
    //replaces , with ","
    void replaceCommas() {
        line = line.replaceAll(",", "\",\"");
        
    }
    
    //replaces (tab)    with ,
    void replaceTabs() {
        line = line.replaceAll("\\t", ",");
    }
    
    //get line
    String getLineString(){
        return line;
    }
    
}
