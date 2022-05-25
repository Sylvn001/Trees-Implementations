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
                    for(int i=indexPalavra, j=0; i < palavra.length(); i++){
                        restoPalavra += palavra.charAt(indexPalavra);
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

}
