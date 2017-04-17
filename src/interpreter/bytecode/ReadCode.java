/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.bytecode.ByteCode;
import interpreter.Input;
import interpreter.VirtualMachine;

/**
 *
 * @author Pradyumna
 */
public class ReadCode extends ByteCode {
    @Override
    public void addData(String[] data){
        
    }
    
    public void execute(VirtualMachine vm){
        Input in = new Input();
        int i = in.read();
        vm.push(i);
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.println("READ");
        return true;
    }
}
