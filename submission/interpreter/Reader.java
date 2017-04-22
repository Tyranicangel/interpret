/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pradyumna
 */
public class Reader {
    private Scanner source;
    public Reader(String fileName) throws FileNotFoundException{
        source = new Scanner(new File(fileName));
    }
    
    public String read() throws IOException{
        if(!this.source.hasNextLine()){
            throw new IOException();
        }
        return this.source.nextLine();
    }
}
