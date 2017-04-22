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
public class LineCode extends interpreter.bytecode.ByteCode{
    private int lineNo;
    
    @Override
    public void addData(String[] data) {
        this.lineNo=Integer.parseInt(data[1]);
    }
    
    public int getLineNo(){
        return this.lineNo;
    }
    
    public void debug(Debugger d){
        d.getRecord().setCurrentLineNumber(lineNo);
        if(d.hasBreakPoint(lineNo)){
            d.showUi();
        }
    }
}
