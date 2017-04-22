/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode.debugger;

import interpreter.debugger.Debugger;

/**
 *
 * @author Pradyumna
 */
public class CallCode extends interpreter.bytecode.CallCode{
    public void debug(Debugger d){
        d.createFunctionRecord();
    }
}
