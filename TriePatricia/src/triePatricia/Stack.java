/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triePatricia;

/**
 *
 * @author junio
 */
public class Stack {
    No value;
    Stack prox; 

    public Stack(No value, Stack prox) {
        this.value = value;
        this.prox = prox;
    }

    public No getValue() {
        return value;
    }

    public void setValue(No value) {
        this.value = value;
    }

    public Stack getProx() {
        return prox;
    }

    public void setProx(Stack prox) {
        this.prox = prox;
    }
    
    
}            
