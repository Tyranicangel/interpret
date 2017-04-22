/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger.ui;

import interpreter.debugger.Debugger;
import java.util.ArrayList;

/**
 *
 * @author Pradyumna
 */
public class DisplayCurrentFunction extends Command{

    @Override
    public void addData(String[] data) {
        
    }

    @Override
    public boolean execute(Debugger d) {
        String func=d.getCurrentFunction();
        System.out.print(func);
        if(func!=null){
            ArrayList<Integer> args=d.getFunctionArgs();
            System.out.print("(");
            for(int i=0;i<args.size();i++){
                if(i!=0){
                    System.out.print(",");
                }
                System.out.print(args.get(i));
            }
            System.out.print(")");
        }
        System.out.println("");
        return true;
    }
    
}
