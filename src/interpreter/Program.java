/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains all the ByteCodes of the program and the execution order
 * @author Pradyumna
 */
public class Program {
    private ArrayList<ByteCode> byteCodes;
    public Program(){
        this.byteCodes = new ArrayList<>();
    }
    
    public void addCode(ByteCode bC){
        this.byteCodes.add(bC);
    }
    
    /**
     * Resolves the addresses for ByteCode which involve redirect like CALL or GOTO
     * @param address
     */
    public void resolveAddress(HashMap<String,Integer> address){
        for (ByteCode byteCode : this.byteCodes) {
            if(byteCode.isRedirect()){
                   byteCode.setAddress(address.get(byteCode.getLabel()));
            }
        }
    }
    
    public ByteCode getCode(int counter){
        return this.byteCodes.get(counter);
    }
}