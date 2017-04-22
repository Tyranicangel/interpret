/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger.ui;

import interpreter.debugger.Debugger;

/**
 *
 * @author Pradyumna
 */
public class ClearBreakPoint extends Command{
    private int lineNo;

    @Override
    public void addData(String[] data) {
        this.lineNo=Integer.parseInt(data[1]);
    }

    @Override
    public boolean execute(Debugger d) {
        d.clearBreakPoint(lineNo);
        return true;
    }
    
}
