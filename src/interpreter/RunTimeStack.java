/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.util.ArrayList;
import java.util.Stack;

/**
 * The stack maintained during execution
 * @author Pradyumna
 */
public class RunTimeStack {
    Stack<Integer> framePointer;
    ArrayList<Integer> runStack;
    
    public RunTimeStack(){
        this.runStack=new ArrayList<>();
        this.framePointer = new Stack<>();
    }
    
    /**
     * Dumps the current stack to the Output
     */
    public void dump(){
        System.out.print("[");
        boolean flag=false;
        for(int i=0;i<runStack.size();i++){
            if(framePointer.contains(i)){
                System.out.print("] [");
                flag=false;
            }
            if(flag){
                System.out.print(",");
            }
            System.out.print(runStack.get(i));
            flag=true;
        }
        System.out.println("]");
    }
    
    /**
     * View the top frame
     * @return
     */
    public ArrayList peekStack(){
        ArrayList<Integer> topStack = new ArrayList<>();
        for(int i=this.framePointer.peek();i<this.runStack.size();i++){
            topStack.add(this.runStack.get(i));
        }

        return topStack;
    }
    
    /**
     * View the top item of the stack
     * @return
     */
    public int peek(){
        return this.runStack.get(this.runStack.size()-1);
    }
    
    /**
     * Pops the top item of the stack and returns it
     * @return integer
     */
    public int pop(){
        int i = this.runStack.get(this.runStack.size()-1);
        this.runStack.remove(this.runStack.size()-1);
        return i;
    }
    
    /**
     * Push an element to the top of the stack and returns the value that is pushed
     * @param i
     * @return integer being pushed
     */
    public int push(int i){
        this.runStack.add(i);
        return this.runStack.get(this.runStack.size()-1);
    }
    
    /**
     * Create a new frame from the top of the stack
     * @param offset
     */
    public void newFrame(int offset){
        this.framePointer.push(this.runStack.size()-offset);
    }
    
    /**
     * Pop out the top frame
     */
    public void popFrame(){
        int i = this.framePointer.pop();
        this.runStack=new ArrayList<>(this.runStack.subList(0, i));
    }
    
    /**
     * The execution for the store ByteCode
     * @param offset
     * @return
     */
    public int store(int offset){
        int i = this.pop();
        int off=0;
        if(this.framePointer.size()>0){
            off = offset+this.framePointer.peek();  
        }
        this.runStack.set(off, i);
        return this.runStack.get(off);
    }
    
    /**
     * The execution for the Load ByteCode
     * @param offset
     * @return
     */
    public int load(int offset){
        int off=0;
        if(this.framePointer.size()>0){
            off = offset+this.framePointer.peek();  
        }
        int i = this.runStack.get(off);
        return this.push(i);
    }
    
    /**
     * Push an element to the top of the stack
     * @param i
     * @return
     */
    public Integer push(Integer i){
        this.runStack.add(i);
        return this.runStack.get(this.runStack.size()-1);
    }
}