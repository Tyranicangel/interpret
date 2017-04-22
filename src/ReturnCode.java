
import interpreter.debugger.Debugger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pradyumna
 */
public class ReturnCode extends interpreter.bytecode.ReturnCode{
    public void debug(Debugger d){
        d.popFunctionRecord();
    }
}
