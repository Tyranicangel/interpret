/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

/**
 *
 * @author Pradyumna
 */
public class BopCode extends ByteCode {
    private String operator;
    @Override
    public void addData(String[] data){
        operator=data[1];
    }
    
    @Override
    public boolean dump(VirtualMachine vm){
        System.out.print("BOP ");
        System.out.println(operator);
        return true;
    }
    
    @Override
    public void execute(VirtualMachine vm){
        int second = vm.pop();
        int first = vm.pop();
        switch (operator) {
            case "+":
                vm.push(first+second);
                break;
            case "-":
                vm.push(first-second);
                break;
            case "*":
                vm.push(first*second);
                break;
            case "/":
                vm.push(first/second);
                break;
            case "==":
                if(first==second){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "!=":
                if(first!=second){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "<=":
                if(first<=second){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "<":
                if(first<second){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case ">":
                if(first>second){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case ">=":
                if(first>=second){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "|":
                if(first!=0 || second!=0){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "&":
                if(first==0 || second==0){
                    vm.push(0);
                }
                else{
                    vm.push(1);
                }
                break;
            default:
                break;
        }
    }
}
