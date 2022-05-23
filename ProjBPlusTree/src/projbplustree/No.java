package projbplustree;

public class No 
{
    private final int n = 4;
    private int vInfo[];
    private No vLig[];
    private int tl;
    private No ant;
    private No prox;
    
    public No()
    {
        vInfo = new int[n];
        vLig = new No[n+1];
        tl = 0;
        ant = null;
        prox = null; 
    }
    
    public No(int info)
    {
        this();
        vInfo[0] = info;
        tl = 1;
    }
    
    public No(int info, No ant, No prox)
    {
        this();
        vInfo[0] = info;
        tl = 1;
        ant = ant;
        prox = prox;
    }


    public int procurarPosicao(int info)
    {
        int pos=0;
        while(pos<tl && info>vInfo[pos])
            pos++;
        return pos;
    }
    
    public void remanejar(int pos)
    {
        vLig[tl+1] = vLig[tl];
        for(int i=tl; i>pos; i--)
        {
            vInfo[i] = vInfo[i-1];
            vLig[i] = vLig[i-1];
        }
    }
    
    public int getvInfo(int p) {
        return vInfo[p];
    }

    public void setvInfo(int p, int info) {
        vInfo[p] = info;
    }

    public No getvLig(int p) {
        return vLig[p];
    }

    public void setvLig(int p, No lig) {
        vLig[p] = lig;
    }

    public int getTl() {
        return tl;
    }

    public void setTl(int tl) {
        this.tl = tl;
    }
}
