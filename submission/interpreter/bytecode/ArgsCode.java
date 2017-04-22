/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

/**
 *
 * @author Pradyumna
 */
public class ArgsCode extends ByteCode {
    private int Args;
    
    @Override
    public void addData(String[] data){
        this.Args=Integer.parseInt(data[1]);
    }
    
    @Override
    public void execute(VirtualMachine vm){
        vm.newFrame(Args);
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.print("ARGS ");
        System.out.println(Args);
        return true;
    }
    
}
