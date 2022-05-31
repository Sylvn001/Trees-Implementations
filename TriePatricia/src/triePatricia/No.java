package triePatricia;

/**
 *
 * @author Junior
 */
public class No {
    private int TL;
    private String palavra;
    private boolean flag;
    private No vLig[];

    public No(){
        this.TL = 0;
        this.flag = false;
        this.palavra = "";
        this.vLig = new No[26];
    }
    
    public No(String palavra){
        this();
        this.palavra = palavra;
        this.TL = 1;
    }
    
    public No(String palavra, boolean flag){
        this();
        this.palavra = palavra;
        this.TL = 1;
        this.flag = flag;
    }

    public int getTL() {
        return TL;
    }

    public void setTL(int TL) {
        this.TL = TL;
    }

    public No getvLig(int pos) {
        return vLig[pos];
    }

    public void setvLig(No no, int pos) {
        this.vLig[pos] = no;
    }
    
    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
}
