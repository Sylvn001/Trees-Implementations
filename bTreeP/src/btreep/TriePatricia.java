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
                No pai = aux;
                aux = aux.getvLig(pos);
                
                i = 1;
                indexPalavra++;
                System.out.println("indexPalavra: " + indexPalavra);
                System.out.println("i: " + i);
                System.out.println("Aux: " + aux.getPalavra());
                System.out.println(palavra + " Indice: "+ i  +  " - PLength: " + palavra.length() + " auxL " + aux.getPalavra().length());
                while(aux.getPalavra().charAt(i) == palavra.charAt(indexPalavra)){
                    System.out.println(i);
                    System.out.println(palavra);
                    System.out.println("quantas vezes ");
                    indexPalavra++;
                    i++;
                }
                
                flagFim = true;
                restoPalavra = palavra.substring(i);
                noPalavra = new No(restoPalavra, flagFim);
                pos = restoPalavra.charAt(0) - 'a';

                if(i < aux.getPalavra().length()){
                    No noRamificacao = new No(aux.getPalavra().substring(0,i));
                    aux.setPalavra(aux.getPalavra().substring(i));
                    int novaPosAux = aux.getPalavra().charAt(0) - 'a';
                    
                    noRamificacao.setvLig(noPalavra, pos);
                    noRamificacao.setvLig(aux, novaPosAux);
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
