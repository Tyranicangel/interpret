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
public class StoreCode extends ByteCode {
    private int offset;
    private String id;
    private int value;
    
    @Override
    public void addData(String[] data){
        this.offset=Integer.parseInt(data[1]);
        this.id=data[2];
    }
    
    @Override
    public void execute(VirtualMachine vm){
        this.value=vm.store(offset);
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.print("STORE ");
        System.out.print(offset);
        System.out.print(" "+id);
        System.out.print("\t\t");
        System.out.print(id+"=");
        System.out.println(value);
        return true;
    }
}