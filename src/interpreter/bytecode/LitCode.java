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
public class LitCode extends ByteCode {
    private String varName;
    private int value;
    
    public LitCode(){
        this.value=0;
        this.varName=null;
    }
    
    @Override
    public void addData(String[] data){
        if(data.length>2){
            varName=data[2];
        }
        value=Integer.parseInt(data[1]);
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.print("LIT ");
        System.out.print(value);
        if(this.varName!=null){
            System.out.print(" "+varName);
            System.out.print("\t\t");
            System.out.print("int "+varName);
        }
        System.out.println("");
        return true;
    }
    
    /**
     *
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm){
        if(this.varName!=null){
            vm.push(value);
        }
        else{
            vm.push(Integer.valueOf(value));
        }
    }
}
