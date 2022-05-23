package projbplustree;

public class Aplicacao {

    public static void main(String[] args) {
       BPlusTree b = new BPlusTree();
       
      for(int i=1; i<1000000; i++)
          b.inserir(i, i);

      b.in_ordem();
    
    }
    
}
