/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import interpreter.debugger.Debugger;

/**
 *
 * @author Pradyumna
 */
public class Interpreter {
    ByteCodeLoader bCL;

    /**
     *
     * @param codeFile
     */
    public Interpreter(String codeFile){
        CodeTable.init();
        bCL=new ByteCodeLoader(codeFile);
    }
    
    void run() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Program p=bCL.loadCodes();
        VirtualMachine vM=new VirtualMachine(p);
        vM.execute();
    }
    
    

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(args.length==0){
            System.out.println("Please provide  the file to run as parameter");
        }
        else if(args[0].equals("-d")){
            (new Debugger(args[1])).run();
        }
        else{
            (new Interpreter(args[0])).run();
        }
    }
    
}
