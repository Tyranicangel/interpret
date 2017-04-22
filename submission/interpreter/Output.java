/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

/**
 * The Output object for user interface
 * @author Pradyumna
 */
public class Output {
    public Output(){
        
    }
    
    /**
     * Writes the object to output
     * @param s
     */
    public void write(Object s){
        System.out.print("Output:");
        System.out.println(s);
    }
}