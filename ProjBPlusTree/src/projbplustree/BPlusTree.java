package projbplustree;

public class BPlusTree 
{
    private final int n = 4;
    private No raiz;
    
    public BPlusTree()
    {
        raiz = null;
    }
    
    public No navegarAteFolha(int info)
    {
        No folha=raiz;
        int pos;
        while (folha.getvLig(0)!=null)
        {
            pos=folha.procurarPosicao(info);
            folha=folha.getvLig(pos);
        }
        return folha;
    }
    
    public No localizarPai(No folha, int info)
    {
        int pos;
        No no=raiz, pai=raiz;
        while (no!=folha)
        {
            pai=no;
            pos=no.procurarPosicao(info);
            no=no.getvLig(pos);
        }
        return pai;
    }
    
    public void split(No folha, No pai)
    {    
        boolean flagFolha = false;
        int tamanho, inicio;
        int pos;
    	No cx1 = new No();
        No cx2 = new No();
        No irmaE = null, irmaD = null;
        
        if(folha.getvLig(0) == null)
            flagFolha = true;          
        
        tamanho = flagFolha ? Math.round((float) (n-1)/2) : Math.round((float)n/2)-1;
        inicio = tamanho; 
                
        for(int i = 0; i<tamanho; i++)
        {
            cx1.setvInfo(i, folha.getvInfo(i));
            cx1.setvLig(i, folha.getvLig(i));
        }

        cx1.setvLig(tamanho, folha.getvLig(tamanho));
        cx1.setTl(tamanho);
        
        if (!flagFolha)
            inicio++;
        
        for(int i = inicio; i < folha.getTl(); i++)
        {
            cx2.setvInfo(i - (inicio), folha.getvInfo(i));
            cx2.setvLig(i - (inicio), folha.getvLig(i));
            cx2.setTl(cx2.getTl()+1);
        }

        cx2.setvLig(cx2.getTl(), folha.getvLig(n));      

        if(folha == pai)
        {
            cx1.setProx(cx2);
            cx2.setAnt(cx1);
            folha.setvInfo(0, folha.getvInfo(tamanho));        
            folha.setTl(1);
            folha.setvLig(0, cx1);
            folha.setvLig(1, cx2);
        }
        else
        {

            pos = pai.procurarPosicao(folha.getvInfo(tamanho));

            if(pos > 0)
                irmaE = pai.getvLig(pos-1);
            if(pos < pai.getTl())
                irmaD = pai.getvLig(pos+1);

            if(irmaE != null){
                irmaE.setProx(cx1);
                cx1.setAnt(irmaE);
            }
            if(irmaD != null){
                irmaD.setAnt(cx2);
                cx2.setProx(irmaD);
            }
            
            pai.remanejar(pos);
            pai.setvInfo(pos, folha.getvInfo(tamanho));
            pai.setTl(pai.getTl()+1);
            pai.setvLig(pos, cx1);
            pai.setvLig(pos+1, cx2);
            if (pai.getTl() > n+1)
            {
                folha = pai;
                pai = localizarPai(folha, folha.getvInfo(0));
                split(folha, pai);
            }
        }
    }
    
    public void inserir(int info)
    {
        No folha,pai;
        int pos;
        if (raiz==null)
            raiz = new No(info);
        else
        {
            folha = navegarAteFolha(info);
            pos = folha.procurarPosicao(info);
            folha.remanejar(pos);        
            folha.setvInfo(pos, info);
            folha.setTl(folha.getTl()+1);
            if (folha.getTl() > n-1)
            {   
                pai = localizarPai(folha, info);
                split(folha, pai);
            }
        }
    }
    
    public void in_ordem(No raiz)
    {
       if (raiz!=null)
       {
           for(int i=0; i<raiz.getTl(); i++)
           {
               in_ordem(raiz.getvLig(i));
               System.out.println(raiz.getvInfo(i));
           }
           in_ordem(raiz.getvLig(raiz.getTl()));
       }
    }
    
    public void in_ordem()
    {
        in_ordem(raiz);
    }
}
