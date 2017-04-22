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
public class PopCode extends ByteCode {
    protected int popLevels;
    
    @Override
    public void addData(String[] data){
        this.popLevels=Integer.parseInt(data[1]);
    }
    
    @Override
    public void execute(VirtualMachine vm){
        for(int i=0;i<popLevels;i++){
            vm.pop();
        }
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.print("POP ");
        System.out.println(popLevels);
        return true;
    }
}
