/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Object which holds all the code to Object mapping
 * @author Pradyumna
 */
public class CodeTable {
    private static HashMap<String,String> codeList;
    private static String fileName = "codeList.txt";
    
    /**
     * Creates a hash map of all bytecodes from the default file
     */
    public static void init(){
        CodeTable.codeList=new HashMap<>();
        try {
            Reader fileRead = new Reader(fileName);
            while(true){
                try {
                    String[] line=fileRead.read().split(" ");
                    CodeTable.codeList.put(line[0], line[1]);
                } catch (IOException ex) {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Please provide the file codeList.txt for loading the Codes");
        }
    }
    
    /**
     * Get the actual class name of a bytecode from the hashmap
     * @param key the bytecode name
     * @return the actual ByteCode class name
     */
    public static String get(String key){
        return CodeTable.codeList.get(key);
    }
}
