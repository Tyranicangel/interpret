/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger;

import interpreter.Program;
import interpreter.ByteCodeLoader;
import interpreter.Reader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Pradyumna
 */
public class Debugger {
    ByteCodeLoader bCL;
    ArrayList<SourceLine> sourceCode;
    Stack<FunctionalEnvironmentRecord> environmentStack;
    VirtualMachine vM;
    
    public Debugger(String sourceFile) throws FileNotFoundException{
        this.sourceCode=new ArrayList<>();
        this.environmentStack=new Stack<>();
        CodeTable.init();
        Reader r = new Reader(sourceFile+".x");
        this.sourceCode.add(new SourceLine("Start"));
        while(true){
            try{
                this.sourceCode.add(new SourceLine(r.read()));
            }
            catch(IOException e){
                break;
            }
        }
        String codeFile = sourceFile+".x.cod";
        bCL=new ByteCodeLoader(codeFile);
    }
    
    public void showUi(){
        this.vM.showUi();
    }
    
    public int getCurrentLine(){
        if(this.environmentStack.size()>0){
            return this.getRecord().getLineNo();
        }
        return 0;
    }
    
    public void createFunctionRecord(){
        FunctionalEnvironmentRecord fenv = new FunctionalEnvironmentRecord();
        fenv.beginScope();
        this.environmentStack.add(fenv);
    }
    
    public void popFunctionRecord(){
        this.environmentStack.pop();
    }
    
    public FunctionalEnvironmentRecord getRecord(){
        if(this.environmentStack.size()>0){
            return this.environmentStack.peek();
        }
        return null;
    }
    
    public void run() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Program p=bCL.loadCodes();
        p.SetBreaks(this);
        vM=new VirtualMachine(p,this);
        vM.execute();
    }
    
    public ArrayList<SourceLine> getSourceCode(){
        return this.sourceCode;
    }
    
    public void isBreakPoint(int i){
        if(i>=0){
            this.sourceCode.get(i).isBreakPoint();
        }
    }
    
    public void setBreakPoint(int i){
        if(i>=0){
            this.sourceCode.get(i).setBreakPoint();
        }
    }
    
    public void clearBreakPoint(int i){
        if(i>=0){
            this.sourceCode.get(i).clearBreakPoint();
        }
    }
    
    public boolean hasBreakPoint(int i){
        if(i<=0){
            return false;
        }
        return this.sourceCode.get(i).hasBreakPoint();
    }
    
    public boolean canBeBreakPoint(int i){
        if(i<=0){
            return false;
        }
        return this.sourceCode.get(i).canBeBreakPoint();
    }
    
    public void quit(){
        vM.stopRunning();
    }
    
    public String getCurrentFunction(){
        if(this.getRecord()!=null){
            return this.getRecord().getFunctionName();
        }
        return null;
    }
    
    public ArrayList<Integer> getFunctionArgs(){
        return this.getRecord().getFunctionArgs();
    }
    
    public HashMap<String,Integer> getLocalVariables(){
        return this.getRecord().getVars();
    }
    
}
