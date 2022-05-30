package btreep;

/**
 *
 * @author Junior
 */
public class BTreeP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int TL = 4;
        String arrString[] = {"bear", "Bell", "bid", "Bull", "Bully", "buy", "sell", "stock", "stop", "stoped", "beared"};
        TriePatricia trie = new TriePatricia();

        for(int i=0; i< TL; i++){
            trie.inserir(arrString[i]);
        };

        trie.exibePalavras();
    }

}
