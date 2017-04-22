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
public class DumpCode extends ByteCode{
    private boolean dumpFlag;
    
    public DumpCode(){
        this.dumpFlag=false;
    }
    
    @Override
    public void addData(String[] data){
        if("ON".equals(data[1])){
            this.dumpFlag=true;
        }
        else{
            this.dumpFlag=false;
        }
    }
    
    @Override
    public void execute(VirtualMachine vm){
        vm.changeDump(dumpFlag);
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.print("DUMP ");
        if(this.dumpFlag){
            System.out.println("ON");
        }
        else{
            System.out.println("OFF");
        }
        return true;
    }
}
