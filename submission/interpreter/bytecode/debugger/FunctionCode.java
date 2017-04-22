/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode.debugger;

import interpreter.VirtualMachine;
import interpreter.debugger.Debugger;
import java.util.ArrayList;
        

/**
 *
 * @author Pradyumna
 */
public class FunctionCode extends interpreter.bytecode.ByteCode{
    private String name;
    private int sLineNo;
    private int eLineNo;
    private ArrayList<Integer> args;
    
    @Override
    public void execute(VirtualMachine vm){
        this.args=vm.getFrameData();
    }
    
          
    @Override
    public void addData(String[] data) {
        this.name=data[1];
        this.sLineNo=Integer.parseInt(data[2]);
        this.eLineNo=Integer.parseInt(data[3]);
    }
    
    public void debug(Debugger d){
        d.getRecord().setFunctionInfo(name, sLineNo, eLineNo);
        d.getRecord().setFunctionArgs(args);
    }
    
}
