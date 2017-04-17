/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import interpreter.bytecode.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Pradyumna
 */
public class ByteCodeLoader {
    private Reader source;
    
    /**
     * Loads the file into the source
     * @param codeFile program file to execute
     */
    public ByteCodeLoader(String codeFile){
        try {
            this.source = new Reader(codeFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    /**
     * Reads all the bytecodes from the source into the Program object.
     * Resolves the addresses for each bytecode and attaches next address the vm must point to
     * @return Program for the virtual Machine to execute
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Program loadCodes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Program p = new Program();
        HashMap<String,Integer> address=new HashMap<>();
        int i=0;
        while(true){
            try {
                String[] line=this.source.read().split(" ");
                ByteCode bC = (ByteCode)(Class.forName("interpreter.bytecode."+CodeTable.get(line[0])).newInstance());
                bC.addData(line);
                if(bC.isLabel()){
                    address.put(bC.getLabel(), i);
                }
                if(!bC.isRedirect()){
                    bC.setAddress(i+1);
                }
                p.addCode(bC);
                i++;
            } catch (IOException ex) {
                break;
            }
        }
        p.resolveAddress(address);
        return p;
    }
}
