/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger;

import java.util.ArrayList;
import interpreter.debugger.commands.*;
import java.util.HashMap;

/**
 *
 * @author Pradyumna
 */
public class FunctionalEnvironmentRecord {
    private SymbolTable symbolTable;
    private String functionName;
    private int startingLineNo;
    private int endingLineNo;
    private int curentLineNo;
    private ArrayList<Integer> args;
    
    public void beginScope(){
        this.symbolTable=new SymbolTable();
        this.symbolTable.beginScope();
    }
    
    public void setFunctionInfo(String functionName,int sLineNo, int eLineNo){
        this.functionName=functionName;
        this.startingLineNo=sLineNo;
        this.endingLineNo=eLineNo;
    }
    
    public void setFunctionArgs(ArrayList<Integer> args){
        this.args=args;
    }
    
    public ArrayList<Integer> getFunctionArgs(){
        return this.args;
    }
    
    public void setCurrentLineNumber(int cLineNo){
        this.curentLineNo=cLineNo;
    }
    
    public void setVarVal(String var, int val){
        this.symbolTable.put(var, val);
    }
    
    public void doPop(int number){
        this.symbolTable.pop(number);
    }
    
    public String getFunctionName(){
        return this.functionName;
    }
    
    public HashMap<String,Integer> getVars(){
        return this.symbolTable.getVars();
    }
    
    public int getLineNo(){
        return this.curentLineNo;
    }
    
    public String dump(){
       String out="(<";
       out+=this.symbolTable.dump();
       out+=">,";
       if(this.functionName!=null){
           out+=this.functionName+','+this.startingLineNo+","+this.endingLineNo+",";
       }
       else{
           out+="-,-,-";
       }
       if(this.curentLineNo!=0){
           out+=this.curentLineNo;
       }
       else{
           out+="-";
       }
       out+=")";
       return out;
    }
    
    /*public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        ArrayList<String> CommandList=new ArrayList<>();
        CommandList.add("BS");
        CommandList.add("Function g 1 20");
        CommandList.add("Line 5");
        CommandList.add("Enter a 4");
        CommandList.add("Enter b 2");
        CommandList.add("Enter c 7");
        CommandList.add("Enter a 1");
        CommandList.add("Pop 2");
        CommandList.add("Pop 1");
        FunctionalEnvironmentRecord fenv;
        fenv = new FunctionalEnvironmentRecord();
        for (String string : CommandList) {
            String[] command=string.split(" ");
            Command com = (Command)(Class.forName("interpreter.debugger.commands."+command[0]).newInstance());
            com.initialize(command);
            com.execute(fenv);
            System.out.println(fenv.dump());
        }
    }*/
}
