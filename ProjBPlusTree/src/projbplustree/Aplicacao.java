package projbplustree;

public class Aplicacao {

    public static void main(String[] args) {
        BPlusTree b = new BPlusTree();
        int[] info = {1, 4, 7, 10, 17, 21, 31, 25, 19, 20, 28, 42};
        
        //for(int i=0; i < 10000; i++)//Second Way to insert
            //b.inserir(i);
            
        for(int i=0; i<info.length; i++) // Class example
            b.inserir(info[i]);

        b.in_ordem();
    }
}
