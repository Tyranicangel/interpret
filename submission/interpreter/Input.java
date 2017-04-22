/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Input object for reading User input
 * @author Pradyumna
 */
public class Input {
    public Input(){
        
    }
    
    /**
     *Reads each line from User Input
     * @return The read Input
     */
    public int read(){
        String line="";
        try {
            System.out.println("Enter an integer");
            BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
            line = in.readLine();
        }
        catch( java.io.IOException ex ) {
            
        }
        return Integer.parseInt(line);
    }
}
