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
public class BS extends Command{
    public void initialize(String[] data){
        
    }
    public void execute(FunctionalEnvironmentRecord fenv){
        fenv.beginScope();
    }
}
