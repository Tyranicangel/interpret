/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;
import interpreter.debugger.Debugger;

/**
 *
 * @author Pradyumna
 */
public abstract class ByteCode {
    protected int nextAddress;
    
    public abstract void addData(String[] data);
    
    public boolean isLabel(){
        return false;
    }
    
    public boolean isRedirect(){
        return false;
    }
    
    public void setAddress(int i){
        this.nextAddress=i;
    }
    
    public String getLabel(){
        return null;
    }
    
    public void execute(VirtualMachine vm){
        
    }
    
    public boolean dump(VirtualMachine vm){
        return true;
    }
    
    public void debug(Debugger d){
        
    }

    public int getLineNo() {
        return 0;
    }
}
