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
public class Pop extends Command{
    private int noPop;
    public void initialize(String[] data){
        noPop=Integer.parseInt(data[1]);
    }
    public void execute(FunctionalEnvironmentRecord fenv){
        fenv.doPop(noPop);
    }
}
