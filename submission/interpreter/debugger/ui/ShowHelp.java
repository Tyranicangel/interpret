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
public class ShowHelp extends Command{

    @Override
    public void addData(String[] data) {
        
    }

    @Override
    public boolean execute(Debugger d) {
        System.out.println("setbreakpoint <line no> - Set a break point at line no");
        System.out.println("clearbreakpoint <line no> - Clear the break point set at line no");
        System.out.println("displaycurrent - Display the current function being executed");
        System.out.println("displayvariables - Display the values of variables for the current function");
        System.out.println("continue - Continue execution");
        System.out.println("quit - Stop execution");
        System.out.println("showsource - Show the source code");
        System.out.println("? - Help");
        return true;
    }
    
}
