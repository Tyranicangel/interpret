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
public class QuitExecution extends Command{

    @Override
    public void addData(String[] data) {
        
    }

    @Override
    public boolean execute(Debugger d) {
        System.out.println("***EXIT***");
        d.quit();
        return false;
    }
    
}
