package btreep;

/**
 *
 * @author junio
 */
public class TriePatricia {
    private No raiz;
    private int M = 26;

    public TriePatricia() {
        raiz = new No();
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
        palavra = palavra.toLowerCase();
        int indexPalavra = 0, i, j;
        boolean flagFim = false;
        No noPalavra, aux = raiz;

        while(!flagFim){
            int pos = palavra.charAt(indexPalavra) - 'a';
            if(aux.getvLig(pos) == null)
            {
                String restoPalavra = leString(palavra, indexPalavra);
                flagFim = true;
                noPalavra = new No(restoPalavra);
                aux.setvLig(noPalavra, pos);
                aux.setTL(aux.getTL()+1);
            }
            else
            {
                No pai = aux;
                aux = aux.getvLig(pos);
                i = 0;
                while(aux.getvLig(pos).getPalavra().charAt(i) == palavra.charAt(indexPalavra)){
                    indexPalavra++;
                    i++;
                }

                if(i < aux.getPalavra().length()){

                }else{

                }

            }
        }

    }

    public void exibir(){
        System.out.println("raiz");
    }

    public String leString(String palavra, int pos){
        String palavraAux = "";
        for(int i = pos; i < palavra.length(); i++ ){
            palavraAux += palavra.charAt(i);
        }

        return palavraAux;
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
