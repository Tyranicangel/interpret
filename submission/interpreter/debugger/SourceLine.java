/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger;

/**
 *
 * @author Pradyumna
 */
public class SourceLine {
    private String line;
    private boolean isBreakPoint = false;
    private boolean isBreakPointSet = false;
    
    public SourceLine(String line){
        this.line=line;
    }
    
    public String getLine(){
        return this.line;
    }
    
    public void isBreakPoint(){
        this.isBreakPoint=true;
    }
    
    public void setBreakPoint(){
        if(!this.canBeBreakPoint()){
            System.out.println("Break point cannot be set here");
        }
        else{
            this.isBreakPointSet=true;
        }
    }
    
    public void clearBreakPoint(){
        this.isBreakPointSet=false;
    }
    
    public boolean hasBreakPoint(){
        return this.isBreakPointSet;
    }
    
    public boolean canBeBreakPoint(){
        return this.isBreakPoint;
    }
}
