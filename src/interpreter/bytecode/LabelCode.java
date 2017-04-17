/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.bytecode.ByteCode;
import interpreter.VirtualMachine;

/**
 *
 * @author Pradyumna
 */
public class LabelCode extends ByteCode {
    String label;
    @Override
    public void addData(String[] data){
        this.label=data[1];
    }
    
    @Override
    public boolean isLabel(){
        return true;
    }
    
    @Override
    public String getLabel(){
        return label;
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.println("LABEL "+label);
        return true;
    }
}
