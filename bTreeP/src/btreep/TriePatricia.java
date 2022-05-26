package btreep;

/**
 *
 * @author junio
 */
public class TriePatricia {
    private No raiz;
    private int M = 26;

    public TriePatricia() {
        raiz = new No();
    }

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
        int indexPalavra = 0, i, j;
        boolean flagFim = false;
        No noPalavra, aux = raiz;

        while(!flagFim){
            int pos = palavra.toLowerCase().charAt(indexPalavra) - 'a';
            if(aux.getvLig(pos) == null)
            {
                String restoPalavra = leString(palavra, indexPalavra);

                flagFim = true;
                noPalavra = new No(restoPalavra);
                aux.setvLig(noPalavra, pos);
//                System.out.println("Adicionado: " + restoPalavra + " PosgetVLig: " + pos );;
                aux.setTL(aux.getTL()+1);
            }
            else
            {
                No paiDiv =  new No (""+palavra.toLowerCase().charAt(indexPalavra));
                No auxFilho = aux.getvLig(pos);
                String palavraAux = leString(aux.getvLig(pos).getPalavra(), 1); 
                System.out.println(palavraAux + " - " + paiDiv.getPalavra());
                aux.setvLig(paiDiv, pos);
                aux.getvLig(pos).setvLig(auxFilho, pos);
//                String letraAnterior="";;
//                i = 0;
//                while(aux.getvLig(pos).getPalavra().toLowerCase().charAt(i) == palavra.toLowerCase().charAt(indexPalavra)){
//                    letraAnterior = "" + aux.getvLig(pos).getPalavra().toLowerCase().charAt(i);
//                    System.out.println(aux.getvLig(pos).getPalavra().charAt(i) + " igual " + palavra.charAt(indexPalavra));;;
//                    indexPalavra++;
//                    i++;
//                }
//                
//                if(letraAnterior != aux.getvLig(pos).getPalavra()){
//                    System.out.println(aux.getvLig(pos).getPalavra().charAt(i) + " - " + palavra.charAt(indexPalavra));
//                    System.out.println(i);
//                }
//                aux = aux.getvLig(pos);
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
    public void in_ordem(No raiz)
    {
       if (raiz!=null)
       {
           for(int i=0; i<raiz.getTL(); i++)
           {
               in_ordem(raiz.getvLig(i));
               System.out.println(raiz.getPalavra());
           }
           in_ordem(raiz.getvLig(raiz.getTL()));
       }
    }

    public void in_ordem()
    {
        in_ordem(raiz);
    }

}
