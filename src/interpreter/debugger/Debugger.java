/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger;

import interpreter.ByteCodeLoader;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Pradyumna
 */
public class Debugger {
    ByteCodeLoader bCL;
    ArrayList<SourceLine> sourceCode;
    Stack<FunctionalEnvironmentRecord> environmentStack;
    
    public Debugger(String sourceFile){
        this.sourceCode=new ArrayList<>();
        this.environmentStack=new Stack<>();
        CodeTable.init();
        String codeFile = sourceFile+".x.cod";
        bCL=new ByteCodeLoader(codeFile);
    }
    
    public void run(){
        
    }
    
}
