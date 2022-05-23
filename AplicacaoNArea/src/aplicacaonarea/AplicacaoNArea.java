package aplicacaonarea;
public class AplicacaoNArea {

    public static void main(String[] args) {
        NArea narea = new NArea();
        narea.inserir(100);
        narea.inserir(80);
        narea.inserir(120);
        narea.inserir(40);
        narea.inserir(30);
        narea.inserir(38);
        narea.inserir(98);
        narea.inserir(85);
        narea.inserir(19);
        
        narea.inOrdem();
    }
    
}
