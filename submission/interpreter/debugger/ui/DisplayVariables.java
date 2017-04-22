/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger.ui;

import interpreter.debugger.Debugger;
import java.util.HashMap;

/**
 *
 * @author Pradyumna
 */
public class DisplayVariables extends Command{

    @Override
    public void addData(String[] data) {
        
    }

    @Override
    public boolean execute(Debugger d) {
        HashMap<String,Integer> vars=d.getLocalVariables();
        for(String key: vars.keySet()){
            System.out.print(key+" : ");
            System.out.print(vars.get(key));
            System.out.print(",");
        }
        System.out.println("");
        return true;
    }
    
}
