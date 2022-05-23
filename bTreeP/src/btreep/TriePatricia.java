package btreep;

/**
 *
 * @author junio
 */
public class TriePatricia {
    private No raiz;
    private int M = 26;

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
            No noPalavra = new No(palavra);

            while(indexPalavra < palavra.length() ){
                buscaMelhorPos(palavra.charAt(indexPalavra));
                
                if(palavra.charAt(indexPalavra)){
                    
                }
                indexPalavra++;
            }
        }
    }
    
    public No localizarNo(String info)
    {
        No no = raiz;
        int pos;
        boolean flag = false;

        while(no != null && !flag){
            pos = no.procurarPosicao(info);
            if(pos < no.getTL() && no.getPalavra().eq == info)
                flag = true;
            else
                no = no.getvLig(pos);
        }

        return no;
    }
    
}
