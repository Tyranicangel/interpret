/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.debugger;

import java.util.HashMap;
import java.util.Iterator;


class Mapper{
    private Object value;
    private String prev;
    private Mapper tail;
    
    Mapper(Object v,String p,Mapper t){
        this.value=v;
        this.prev=p;
        this.tail=t;
    }
    
    Object getValue(){
        return this.value;
    }
    
    String getPrev(){
        return this.prev;
    }
    
    Mapper getTail(){
        return this.tail;
    }
}
/**
 *
 * @author Pradyumna
 */
public class SymbolTable {
    private HashMap<String,Mapper> values;
    private String top;

    public SymbolTable() {
        this.values=new HashMap<>();
    }
    
    public void beginScope(){
        this.top=null;
    }
    
    public void put(String key, Object val){
        this.values.put(key, new Mapper(val, this.top, this.values.get(key)));
        this.top=key;
    }
    
    public void pop(int number){
        int i=0;
        while(i<number){
            Mapper current=this.values.get(top);
            if(current==null){
                this.values.remove(top);
            }
            else{
                this.values.put(top, current.getTail());
            }
            top=current.getPrev();
            i++;
        }
    }
    
    public String dump(){
        String out="";
        Iterator it = this.values.entrySet().iterator();
        while(it.hasNext()){
           HashMap.Entry<String,Mapper> pair = (HashMap.Entry)it.next();
           if(pair.getValue()!=null){
               out=" "+pair.getKey()+"/"+pair.getValue().getValue()+" "+out;
           }
        }
        return out;
    }
}
