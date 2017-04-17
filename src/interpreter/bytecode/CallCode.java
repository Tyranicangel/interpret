/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Pradyumna
 */
public class CallCode extends ByteCode {
    private String label;
    @Override
    public void addData(String[] data){
        this.label=data[1];
    }
    
    @Override
    public boolean isRedirect(){
        return true;
    }
    
    @Override
    public String getLabel(){
        return label;
    }
    
    @Override
    public void execute(VirtualMachine vm){
        vm.pushAddr();
        vm.setCounter(this.nextAddress);
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        ByteCode b = vm.getCode(vm.getPrevious());
        if(b instanceof ReturnCode){
            return false;
        }
        b=vm.getCode(vm.getCounter()-1);
        System.out.print("CALL "+this.label+"\t\t");
        System.out.print(getFunctionName());
        System.out.print("(");
        if(b instanceof ArgsCode){
            ArrayList<Integer> topStack = vm.peekStack();
            for(int i=0;i<topStack.size();i++){
                if(i!=0){
                    System.out.print(",");
                }
                System.out.print(topStack.get(i));
            }
        }
        System.out.println(")");
        return true;
    }
    
    private String getFunctionName(){
        return this.label.split("<")[0];
    }
}
