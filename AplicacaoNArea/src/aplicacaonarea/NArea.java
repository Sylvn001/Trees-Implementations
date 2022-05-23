/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaonarea;

/**
 *
 * @author Aluno
 */
public class NArea implements Definicoes{
    private No raiz;
    
    public NArea(){
        raiz = null;
    }
    
    public void inserir(int info){
       No aux;
       int pos;
       boolean flag = false; 
       
       if(raiz == null)
           raiz = new No(info);
       else
       {
           aux = raiz;
           while(!flag){
               pos = aux.buscarPos(info);
               if(aux.getTL() < N-1){
                   aux.remanejar(pos);
                   aux.setvInfo(pos, info);
                   aux.setTL(aux.getTL()+1);
                   flag = true;
               }else{
                   if(aux.getvLig(pos) == null){
                       aux.setvLig(pos, new No(info));
                       flag = true;
                   }
                   else
                    aux = aux.getvLig(pos);                      
               }
           }
       }
    }
    
    public void inOrdem(No raiz){
        if(raiz != null){
            for(int i=0; i < raiz.getTL(); i++){
                inOrdem(raiz.getvLig(i));
                System.out.println(raiz.getvInfo(i));
            }
            inOrdem(raiz.getvLig(raiz.getTL()));
        }
    }
    
    public void inOrdem(){
        inOrdem(raiz);
    }
}
