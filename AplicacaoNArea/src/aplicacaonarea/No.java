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
public class No implements Definicoes{
    private int vInfo[];
    private No vLig[];
    private int TL;
    
    public No(){
        vInfo = new int[N-1];
        vLig = new No[N];
        TL = 0;
    }

    public No(int info) {
        this();
        vInfo[0] = info;
        TL = 1;
    }

    public int getvInfo(int p) {
        return vInfo[p];
    }

    public void setvInfo(int p, int info) {
        this.vInfo[p] = info;
    }

    public int getTL() {
        return TL;
    }

    public void setTL(int TL) {
        this.TL = TL;
    }
    
    

    public No getvLig(int p) {
        return vLig[p];
    }

    public void setvLig(int p,No lig) {
        this.vLig[p] = lig;
    }
    
    public int buscarPos(int chave){
        int pos=0;
        while(pos < TL && chave > vInfo[pos])
            pos++;
        
        return pos;
    }
    
    public void remanejar(int pos){
        for (int i = TL; i > pos; i-- )
            vInfo[i] = vInfo[i-1];    
                                                                                                
    }
    
}
