/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.bytecode.ByteCode;
import interpreter.Output;
import interpreter.VirtualMachine;

/**
 *
 * @author Pradyumna
 */
public class WriteCode extends ByteCode {
    @Override
    public void addData(String[] data){
        
    }
    
    @Override
    public void execute(VirtualMachine vm){
        int i=vm.peek();
        Output out = new Output();
        out.write(i);
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.println("WRITE");
        return true;
    }
}