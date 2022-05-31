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
                restoPalavra = palavra.substring(indexPalavra);// leString(palavra, indexPalavra);
                flagFim = true;
                noPalavra = new No(restoPalavra, flagFim);
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
                while(i < aux.getPalavra().length() && indexPalavra < palavra.length() && aux.getPalavra().charAt(i) == palavra.charAt(indexPalavra)){
                    indexPalavra++;
                    i++;
                }
                
                flagFim = true;
                restoPalavra = palavra.substring(indexPalavra);
                noPalavra = new No(restoPalavra, true);
                novaPosP = restoPalavra.charAt(0) - 'a';

                if(i < aux.getPalavra().length()){ 
                    No noRamificacao = new No(aux.getPalavra().substring(0,i));
                    aux.setPalavra(aux.getPalavra().substring(i));
                    int novaPosAux = aux.getPalavra().charAt(0) - 'a';                    
                    noRamificacao.setvLig(noPalavra, novaPosP);
                    noRamificacao.setvLig(aux, novaPosAux);
                    pai.setvLig(noRamificacao, pos);
                }else{         
                    if(aux.getvLig(novaPosP) == null){ 
                        aux.setvLig(noPalavra, novaPosP);
                    }else{
                        if(indexPalavra < palavra.length()){
                            flagFim = false;
                        }
                        if(palavra.length() == indexPalavra && aux.getPalavra().length() == i){ //fourth case
                            aux.setFlag(flagFim);
                            System.out.println("palavra do 4 caso: " + palavra);
                        }                        
                    }
                }

            }
        }

    }

    //.....................
    public void exibeArvoreNivelANivel()
    {
        No aux;
        int i;
        String palavra = "";
        StackControl stack = new StackControl();
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
            palavra += raiz.getPalavra();
            if(raiz.getFlag())
                System.out.println(palavra);         
            for(int i=0; i < alphabet; i++){
                exibePalavras(raiz.getvLig(i), palavra);
            }
       }
    }
    
    public void exibePalavras(){
        System.out.println("--- Palavras ---");
        exibePalavras(raiz, "");
        System.out.println("----------------");
    }

}
