/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btreep;

/**
 *
 * @author junio
 */
public class StackControl {
    Stack top;
    int size;

    public StackControl() {
        this.size = 0;
    }
    
    public void push(No element){
        Stack NH = new Stack(element, top);
        top = NH;
    }
    
    public No pop(){
        No head = null;
        if(size != 0){
            head = top.value;
            top = top.prox;
            size--;
        }
        return head;
    }
    
    public int length(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
}
