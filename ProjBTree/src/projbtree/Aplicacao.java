package projbtree;

public class Aplicacao {

    public static void main(String[] args) {
       BTree b = new BTree();
       int i;
       
      for(i=1; i<=10000; i++)
          b.inserir(i, i);

      for(i=1; i<=9990; i++)
          b.excluir(i);      
      
      b.in_ordem();
    }
    
}
