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
public abstract class Command {
    public abstract void addData(String[] data);
    public abstract boolean execute(Debugger d);
}
