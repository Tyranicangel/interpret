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
public class LoadCode extends ByteCode {
    private int offset;
    private String id;
    
    @Override
    public void addData(String[] data){
        this.offset=Integer.parseInt(data[1]);
        this.id=data[2];
    }
    
    @Override
    public void execute(VirtualMachine vm){
        vm.load(offset);
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.print("LOAD ");
        System.out.print(offset);
        System.out.println(" "+id+"\t\t<load "+id+">");
        return true;
    }
}
