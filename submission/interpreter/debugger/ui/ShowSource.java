/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger.ui;

import interpreter.debugger.Debugger;
import interpreter.debugger.SourceLine;
import java.util.ArrayList;

/**
 *
 * @author Pradyumna
 */
public class ShowSource extends Command{

    @Override
    public void addData(String[] data) {
        
    }

    @Override
    public boolean execute(Debugger d) {
        ArrayList<SourceLine> sourceCode = d.getSourceCode();
        int cLineNo=d.getCurrentLine();
        for(int counter=1;counter<sourceCode.size();counter++){
            if(sourceCode.get(counter).hasBreakPoint()){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
            System.out.print(String.format("%-3s", counter));
            System.out.print('.'+sourceCode.get(counter).getLine());
            if(counter==cLineNo){
                System.out.print("<--------");
            }
            System.out.println("");
        }
        return true;
    }
}
