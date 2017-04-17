/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger.commands;

import interpreter.debugger.FunctionalEnvironmentRecord;

/**
 *
 * @author Pradyumna
 */
public class Line extends Command{
    private int cLineNo;
    public void initialize(String[] data){
        cLineNo=Integer.parseInt(data[1]);
    }
    public void execute(FunctionalEnvironmentRecord fenv){
        fenv.setCurrentLineNumber(cLineNo);
    }
}
