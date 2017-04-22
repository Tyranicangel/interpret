/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger;

import interpreter.Program;
import interpreter.RunTimeStack;
import interpreter.bytecode.ByteCode;
import java.util.Stack;
import interpreter.debugger.ui.Ui;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pradyumna
 */
public class VirtualMachine extends interpreter.VirtualMachine {
    private Debugger debug;
    private Ui ui;
    
    public VirtualMachine(Program p,Debugger d) {
        super(p);
        this.debug = d;
    }
    
    public void execute(){
        this.rStack = new RunTimeStack();
        this.returnAddr = new Stack<>();
        this.returnAddr.push(0);
        this.isRunning = true;
        this.ui = new Ui(debug);
//        try {
//            this.sho;
//        } catch (InstantiationException ex) {
//            Logger.getLogger(VirtualMachine.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(VirtualMachine.class.getName()).log(Level.SEVERE, null, ex);
//        }
        this.showUi();
        this.debug.createFunctionRecord();
        this.debug.setBreakPoint(2);
        this.debug.setBreakPoint(3);
        this.debug.setBreakPoint(4);
        this.debug.setBreakPoint(6);
        this.debug.setBreakPoint(7);
        this.debug.setBreakPoint(9);
        this.debug.setBreakPoint(12);
        this.debug.setBreakPoint(13);
        this.debug.setBreakPoint(14);
        this.debug.setBreakPoint(15);
        this.debug.setBreakPoint(16);
        
        while(isRunning){
            ByteCode bC = program.getCode(pCounter);
            bC.execute(this);
            bC.debug(debug);
            this.dumpStack();
            pCounter++;
        }
    }
    
    public void showUi(){
        try {
            this.ui.Def();
        } catch (InstantiationException ex) {
            Logger.getLogger(VirtualMachine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(VirtualMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
