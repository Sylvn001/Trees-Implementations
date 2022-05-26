package btreep;

/**
 *
 * @author junio
 */
public class TriePatricia {
    private No raiz;
    private int M = 26;

    public TriePatricia() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public int getM() {
        return M;
    }

    public void setM(int M) {
        this.M = M;
    }

    public void inserir(String palavra){
        if(raiz == null){
            raiz = new No();
        }
        else
        {
            int indexPalavra = 0;
            boolean flagFim = false;
            No noPalavra, aux = raiz;

            while(!flagFim){
                int pos = palavra.toLowerCase().charAt(indexPalavra) - 'a';

                if(aux.getvLig(pos) == null)
                {
                    String restoPalavra="";
                    for(int i=indexPalavra; i < palavra.length(); i++){
                        restoPalavra += palavra.charAt(i);
                    }

                    flagFim = true;
                    noPalavra = new No(restoPalavra);
                    noPalavra.setFlag(flagFim);
                    aux.setvLig(noPalavra, pos);
                    aux.setTL(aux.getTL()+1);
                }
                else
                {
                    aux = aux.getvLig(pos);
                    indexPalavra++;
                }
            }
        }
    }

    public void exibir(){
        System.out.println("raiz");
    }

    //.....................
    public void in_ordem(No raiz)
    {
       if (raiz!=null)
       {
           for(int i=0; i<raiz.getTL(); i++)
           {
               in_ordem(raiz.getvLig(i));
               System.out.println(raiz.getPalavra());
           }
           in_ordem(raiz.getvLig(raiz.getTL()));
       }
    }

    public void in_ordem()
    {
        in_ordem(raiz);
    }

}
