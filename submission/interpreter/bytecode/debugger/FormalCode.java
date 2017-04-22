/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode.debugger;

import interpreter.VirtualMachine;
import interpreter.debugger.Debugger;

/**
 *
 * @author Pradyumna
 */
public class FormalCode extends interpreter.bytecode.ByteCode{
    private String varName;
    private int value;
    private int offset;
    
    @Override
    public void addData(String[] data) {
        this.varName=data[1];
        this.offset=Integer.parseInt(data[2]);
    }
    
    @Override
    public void execute(VirtualMachine vm){
        this.value=vm.getOffset(offset);
    }
    
    public void debug(Debugger d){
        d.getRecord().setVarVal(varName, value);
    }
}
