package triePatricia;

/**
 *
 * @author Junior
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int TL = 13;
        String arrString[] = {"bear", "Bell", "bid", "bull", "bully", "bullyed", "buy", "sell", "stock", "stop", "stoped", "beared", "stocked"};
        TriePatricia trie = new TriePatricia();

        for(int i=0; i< TL; i++){
            trie.inserir(arrString[i]); // 1
        };
        
        trie.exibeArvoreNivelANivel();
        trie.exibePalavras(); // 3
        
    }

}
