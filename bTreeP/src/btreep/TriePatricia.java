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
        int indexPalavra = 0, i;
        boolean flagFim = false;
        No noPalavra, aux = raiz;
        String restoPalavra;

        while(!flagFim){
            int pos = palavra.charAt(indexPalavra) - 'a';
            if(aux.getvLig(pos) == null)
            {
                restoPalavra = leString(palavra, indexPalavra);
                flagFim = true;
                noPalavra = new No(restoPalavra);
                aux.setvLig(noPalavra, pos);
                aux.setTL(aux.getTL()+1);
            }
            else
            {
                int novaPosP;
                No pai = aux;
                aux = aux.getvLig(pos);
                
                i = 1;
                indexPalavra++;
                while(aux.getPalavra().charAt(i) == palavra.charAt(indexPalavra)){
                    indexPalavra++;
                    i++;
                }
                flagFim = true;
                restoPalavra = palavra.substring(i);
                noPalavra = new No(restoPalavra, flagFim);
                novaPosP = restoPalavra.charAt(0) - 'a';

                if(i < aux.getPalavra().length()){
                    No noRamificacao = new No(aux.getPalavra().substring(0,i));
                    aux.setPalavra(aux.getPalavra().substring(i));
                    int novaPosAux = aux.getPalavra().charAt(0) - 'a';
                    
                    noRamificacao.setvLig(noPalavra, pos);
                    noRamificacao.setvLig(aux, novaPosAux);
                    System.out.println(aux.getPalavra());
                    pai.setvLig(noRamificacao, pos);
                }else{                    
                    if(aux.getvLig(pos) == null){
                        aux.setvLig(noPalavra, pos);
                        aux.setFlag(flagFim);
                    }
                    
                    if(palavra.length() == indexPalavra && aux.getPalavra().length() == i){
                        aux.setFlag(flagFim);
                    }
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
    public void exibe_elementos(No raiz)
    {
       if (raiz!=null)
       {
           for(int i=0; i<raiz.getTL(); i++)
           {
               exibe_elementos(raiz.getvLig(i));
               System.out.println(raiz.getPalavra());
           }
           exibe_elementos(raiz.getvLig(raiz.getTL()));
       }
    }

    public void in_ordem()
    {
        exibe_elementos(raiz);
    }

}
