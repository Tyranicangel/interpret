/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * This executes the program and maintains the runstack
 * @author Pradyumna
 */
public class VirtualMachine {
    private final Program program;
    private boolean isRunning;
    private Stack<Integer> returnAddr;
    private int pCounter;
    private RunTimeStack rStack;
    private boolean dumpFlag;
    private int previousCounter;
    
    public VirtualMachine(Program p){
        this.program=p;
        this.pCounter=0;
        this.dumpFlag=false;
        this.previousCounter=0;
    }
    
    /**
     * The execution of the Program
     */
    public void execute(){
        this.rStack = new RunTimeStack();
        this.returnAddr = new Stack<>();
        this.returnAddr.push(0);
        this.isRunning = true;
        while(isRunning){
            ByteCode bC = program.getCode(pCounter);
            bC.execute(this);
            this.dumpStack();
            pCounter++;
        }
    }
    
    public ByteCode getCode(int i){
        return this.program.getCode(i);
    }
    
    public void pushAddr(){
        this.returnAddr.push(this.pCounter);
    }
    
    public void popAddr(){
        this.previousCounter=this.pCounter;
        this.pCounter=this.returnAddr.pop();
    }
    
    public int getCounter(){
        return this.pCounter;
    }
    
    public int getPrevious(){
        return this.previousCounter;
    }
    
    public void setCounter(int i){
        this.dumpStack();
        this.previousCounter=this.pCounter;
        this.pCounter=i;
    }
    
    public void changeDump(boolean flag){
        this.dumpFlag=flag;
    }
    
    public void stopRunning(){
        this.isRunning=false;
    }
    
    public void dumpStack(){
        if(this.dumpFlag){
            ByteCode bC=this.program.getCode(pCounter);
            if(bC.dump(this)){
                this.rStack.dump();
            }
        }
    }
    
    public ArrayList peekStack(){
        return this.rStack.peekStack();
    }
    
    public int peek(){
        return this.rStack.peek();
    }
    
    public int pop(){
        return this.rStack.pop();
    }
    
    public int push(int i){
        return this.rStack.push(i);
    }
    
    public void newFrame(int offset){
        this.rStack.newFrame(offset);
    }
    
    public void popFrame(){
        this.rStack.popFrame();
    }
    
    public int store(int offset){
        return this.rStack.store(offset);
    }
    
    public int load(int offset){
        return this.rStack.load(offset);
    }
    
    public Integer push(Integer i){
        return this.rStack.push(i);
    }
}