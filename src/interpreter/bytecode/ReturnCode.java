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
public class ReturnCode extends ByteCode {
    String label;
    @Override
    public void addData(String[] data){
        if(data.length>1){
            this.label=data[1];
        }
        else{
            this.label=null;
        }
    }
    
    @Override
    public String getLabel(){
        return label;
    }
    
    public void execute(VirtualMachine vm){
        int i = vm.pop();
        vm.popFrame();
        vm.push(i);
        vm.popAddr();
    }
}
