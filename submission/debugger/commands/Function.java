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
public class Function extends Command{
    private String name;
    private int sLineNo;
    private int eLineNo;
    public void initialize(String[] data){
        name=data[1];
        sLineNo=Integer.parseInt(data[2]);
        eLineNo=Integer.parseInt(data[3]);
    }
    public void execute(FunctionalEnvironmentRecord fenv){
       fenv.setFunctionInfo(name, sLineNo, eLineNo);
    }
}
