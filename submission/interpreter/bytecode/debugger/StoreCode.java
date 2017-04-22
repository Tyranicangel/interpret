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
public class StoreCode extends interpreter.bytecode.StoreCode{
    public void debug(Debugger d){
        d.getRecord().setVarVal(id, value);
    }
}
