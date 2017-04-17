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
public class Enter extends Command{
    private String name;
    private int value;
    public void initialize(String[] data){
        name=data[1];
        value=Integer.parseInt(data[2]);
    }
    public void execute(FunctionalEnvironmentRecord fenv){
        fenv.setVarVal(name, value);
    }
}
