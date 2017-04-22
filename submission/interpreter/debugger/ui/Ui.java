/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger.ui;

import interpreter.debugger.Debugger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Pradyumna
 */
public class Ui {
    private HashMap<String,String> CommandList;
    private final Debugger d;
    
    public Ui(Debugger d){
        this.CommandList=new HashMap<>();
        this.d = d;
        this.CommandList.put("?", "ShowHelp");
        this.CommandList.put("setbreakpoint","SetBreakPoint");
        this.CommandList.put("clearbreakpoint", "ClearBreakPoint");
        this.CommandList.put("displaycurrent","DisplayCurrentFunction");
        this.CommandList.put("displayvariables","DisplayVariables");
        this.CommandList.put("continue","ContinueExecution");
        this.CommandList.put("quit", "QuitExecution");
        this.CommandList.put("showsource", "ShowSource");
    }
    
    public void Def() throws InstantiationException, IllegalAccessException{
        System.out.println("Type '?' for help");
        this.read();
    }
    
    public void read() throws InstantiationException, IllegalAccessException{
        String line="";
        while(true){
            try {
            BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
            line = in.readLine();
                try {
                    String [] input = line.split(" ");
                    Command c = (Command)(Class.forName("interpreter.debugger.ui."+this.CommandList.get(input[0])).newInstance());
                    c.addData(input);
                    if(!c.execute(d)){
                        break;
                    }
                } catch (ClassNotFoundException ex) {
                    System.out.println("Please enter a valid command");
                }
        }
        catch( java.io.IOException ex ) {
            
        }
        }
    }
}
