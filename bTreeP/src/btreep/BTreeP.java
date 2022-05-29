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

//        int TL = 10;
        int TL = 2;
//        String arrString[] = {"bear", "Bell", "bid", "Bull", "buy", "sell", "stock", "stop", "stoped", "beared"};
        String arrString[] = {"bear", "Bell"};
        TriePatricia trie = new TriePatricia();

        for(int i=0; i< TL; i++){
            trie.inserir(arrString[i]);
        };

        trie.in_ordem();
    }

}
