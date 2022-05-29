/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btreep;

/**
 *
 * @author junio
 */
public class Stack {
    No stack[];
    int TL;
    
    Stack(){
        this.stack = new No[100];
        this.TL = 0;
    }
    
    public void push(No element){
        
        if(TL < 100){
            this.stack[TL++] = element;
        }
    }
    
    public No pop(){
        if(TL > 0){
            return this.stack[TL--]; 
        }else
            return null;
    }
    
    public int length(){
        return TL;
    }
    
    public boolean isEmpty(){
        return TL == 0;
    }
    
}            
