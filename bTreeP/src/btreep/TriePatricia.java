package btreep;

/**
 *
 * @author junio
 */
public class TriePatricia {
    private No raiz;
    private int alphabet = 26;

    public TriePatricia() {
        raiz = new No();
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public int getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(int M) {
        this.alphabet = alphabet;
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

                if(i < aux.getPalavra().length()){ //second case
                    No noRamificacao = new No(aux.getPalavra().substring(0,i));
                    aux.setPalavra(aux.getPalavra().substring(i));
                    aux.setFlag(flagFim);
                    int novaPosAux = aux.getPalavra().charAt(0) - 'a';
                    
                    noRamificacao.setvLig(noPalavra, novaPosP);
                    noRamificacao.setvLig(aux, novaPosAux);
                    pai.setvLig(noRamificacao, pos);
                }else{         
                    if(aux.getvLig(pos) == null){ //third case
                        aux.setvLig(noPalavra, pos);
                        aux.setFlag(flagFim);
                    }
                    
                    if(palavra.length() == indexPalavra && aux.getPalavra().length() == i){ //fourth case
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
    public void exibeArvoreNivelANivel()
    {
        No aux;
        int i;
        String palavra = "";
        Stack stack = new Stack(); 
        stack.push(raiz);
        
        System.out.println("====== Palavras Cadastradas ======");
        System.out.println("Raiz");

        while(!stack.isEmpty())
        {
            i = 0;
            aux = stack.pop();
            
            while(i < this.alphabet){
                if(aux.getvLig(i) != null)
                    stack.push(aux.getvLig(i));
                i++;
            }
            
        }
    }
    
    public void exibePalavras(No raiz, String palavra)
    {
       if (raiz!=null){
            for(int i=0; i < alphabet; i++){
                if(raiz.getFlag())
                    System.out.println(palavra);         
                exibePalavras(raiz.getvLig(i), (palavra+raiz.getPalavra()));
            }
       }
    }
    
    public void exibePalavras(){
        System.out.println("--- Palavras ---");
        exibePalavras(raiz, "");
    }

}
