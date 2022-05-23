package projbtree;

public class BTree
{
    private final int m = 2;
    private No raiz;

    public BTree()
    {
        raiz = null;
    }

    public No navegarAteFolha(int info)
    {
        No folha=raiz;
        int pos;
        while (folha.getvLig(0)!=null)
        {
            pos=folha.procurarPosicao(info);
            folha=folha.getvLig(pos);
        }
        return folha;
    }

    public No localizarPai(No folha, int info)
    {
        int pos;
        No no=raiz, pai=raiz;
        while (no!=folha)
        {
            pai=no;
            pos=no.procurarPosicao(info);
            no=no.getvLig(pos);
        }
        return pai;
    }

    public void split(No folha, No pai)
    {
        int pos;
    	No cx1 = new No();
        No cx2 = new No();
        for(int i = 0; i<m; i++)
        {
            cx1.setvInfo(i, folha.getvInfo(i));
            cx1.setvPos(i, folha.getvPos(i));
            cx1.setvLig(i, folha.getvLig(i));
        }
        cx1.setvLig(m, folha.getvLig(m));
        cx1.setTl(m);
        for(int i = m+1; i<2*m+1; i++)
        {
            cx2.setvInfo(i - (m+1), folha.getvInfo(i));
            cx2.setvPos(i - (m+1), folha.getvPos(i));
            cx2.setvLig(i - (m+1), folha.getvLig(i));
        }
        cx2.setvLig(m, folha.getvLig(2*m+1));
        cx2.setTl(m);
        if(folha == pai)
        {
            folha.setvInfo(0, folha.getvInfo(m));
            folha.setvPos(0, folha.getvPos(m));
            folha.setTl(1);
            folha.setvLig(0, cx1);
            folha.setvLig(1, cx2);
        }
        else
        {
            pos = pai.procurarPosicao(folha.getvInfo(m));
            pai.remanejar(pos);
            pai.setvInfo(pos, folha.getvInfo(m));
            pai.setvPos(pos, folha.getvPos(m));
            pai.setTl(pai.getTl()+1);
            pai.setvLig(pos, cx1);
            pai.setvLig(pos+1, cx2);
            if (pai.getTl()>2*m)
            {
                folha = pai;
                pai = localizarPai(folha, folha.getvInfo(0));
                split(folha, pai);
            }
        }
    }

    public void inserir(int info, int posArq)
    {
        No folha,pai;
        int pos;
        if (raiz==null)
            raiz = new No(info, posArq);
        else
        {
            folha = navegarAteFolha(info);
            pos = folha.procurarPosicao(info);
            folha.remanejar(pos);
            folha.setvInfo(pos, info);
            folha.setvPos(pos, posArq);
            folha.setTl(folha.getTl()+1);
            if (folha.getTl() > 2*m)
            {
                pai = localizarPai(folha, info);
                split(folha, pai);
            }
        }
    }

    //Exclusao ............

    public No localizarNo(int info)
    {
        No no = raiz;
        int pos;
        boolean flag = false;

        while(no != null && !flag){
            pos = no.procurarPosicao(info);
            if(pos < no.getTl() && no.getvInfo(pos) == info)
                flag = true;
            else
                no = no.getvLig(pos);
        }

        return no;
    }

    public No localizarSubE(No no, int pos)
    {
        no = no.getvLig(pos);
        while(no.getvLig(no.getTl()) != null)
            no = no.getvLig(no.getTl());
        return no;
    }

    public No localizarSubD(No no, int pos)
    {
        no = no.getvLig(pos);
        while(no.getvLig(0) != null)
            no = no.getvLig(0);
        return no;
    }


    public void excluir(int info)
    {
        int pos;
        No subE, subD, folha;
        No no = localizarNo(info);

        if (no!=null) //achou
        {
            pos = no.procurarPosicao(info);
            if (no.getvLig(0)!=null) //nao esta na folha
            {
                subE = localizarSubE(no, pos);
                subD = localizarSubD(no, pos+1);
                if (subD.getTl()>subE.getTl())//pega da direita
                {
                    no.setvInfo(pos, subD.getvInfo(0));
                    no.setvPos(pos, subD.getvPos(0));
                    folha=subD;
                    pos=0;
                }
                else//pega da esquerda
                {
                    no.setvInfo(pos, subE.getvInfo(subE.getTl()-1));
                    no.setvPos(pos, subE.getvPos(subE.getTl()-1));
                    folha=subE;
                    pos=subE.getTl()-1;
                }
            }
            else
                folha=no;

            //excluir da folha
            folha.remanejarEx(pos);
            folha.setTl(folha.getTl()-1);

            if (folha.getTl()<m && folha!=raiz)
                concatena_redistribui(folha);
            else
            if (folha==raiz && folha.getTl()==0)
                raiz=null;
        }
    }

    public void concatena_redistribui(No folha)
    {
        No irmaE = null, irmaD = null;
        No pai = localizarPai(folha, folha.getvInfo(0));
        int posP = pai.procurarPosicao(folha.getvInfo(0));


        if(posP > 0)
            irmaE = pai.getvLig(posP-1);
        if(posP < pai.getTl())
            irmaD = pai.getvLig(posP+1);
        if(irmaE != null && irmaE.getTl() > m){
            folha.setvInfo(folha.getTl(), pai.getvInfo(posP-1));
            folha.setvPos(folha.getTl(), pai.getvPos(posP-1));
            folha.setTl(folha.getTl()+1);
            folha.setvLig(folha.getTl(), irmaE.getvLig(irmaE.getTl()));

            pai.setvInfo(posP-1, irmaE.getvInfo(irmaE.getTl()-1));
            pai.setvPos(posP-1, irmaE.getvInfo(irmaE.getTl()-1));

            irmaE.setTl(irmaE.getTl()-1);
        }
        else{
            if(irmaD != null && irmaD.getTl() > m)
            {
                folha.setvInfo(folha.getTl(), pai.getvInfo(posP));
                folha.setvPos(folha.getTl(), pai.getvPos(posP));
                folha.setTl(folha.getTl()+1);
                folha.setvLig(folha.getTl(), irmaD.getvLig(0));

                pai.setvInfo(posP, irmaD.getvInfo(0));
                pai.setvPos(posP, irmaD.getvPos(0));

                irmaD.remanejarEx(0);
                irmaD.setTl(irmaD.getTl()-1);
            }
            else
            {
                //concatenação
                if(irmaE != null)
                {
                    irmaE.setvInfo(irmaE.getTl(), pai.getvInfo(posP-1));
                    irmaE.setvPos(irmaE.getTl(), pai.getvPos(posP-1));
                    irmaE.setTl(irmaE.getTl()+1);

                    pai.remanejarEx(posP-1);
                    pai.setTl(pai.getTl()-1);
                    pai.setvLig(posP-1, irmaE);

                    for(int i=0; i < folha.getTl(); i++){
                        irmaE.setvInfo(irmaE.getTl(), folha.getvInfo(i));
                        irmaE.setvPos(irmaE.getTl(), folha.getvPos(i));
                        irmaE.setvLig(irmaE.getTl(), folha.getvLig(i));
                        irmaE.setTl(irmaE.getTl()+1);
                    }
                    irmaE.setvLig(irmaE.getTl(), folha.getvLig(folha.getTl()));
                }
                else
                {
                    irmaD.remanejar(0);
                    irmaD.setvInfo(0, pai.getvInfo(posP));
                    irmaD.setvPos(0, pai.getvPos(posP));
                    irmaD.setTl(irmaD.getTl()+1);

                    pai.remanejarEx(posP);
                    pai.setTl(pai.getTl()-1);
                    pai.setvLig(posP, irmaD);

                    irmaD.setvLig(0, folha.getvLig(folha.getTl()));
                    for(int i=0; i < folha.getTl(); i++){               
                        irmaD.remanejar(i);
                        irmaD.setvInfo(0, folha.getvInfo(i));
                        irmaD.setvPos(0, folha.getvPos(i));
                        irmaD.setvLig(0, folha.getvLig(i));
                        irmaD.setTl(irmaD.getTl()+1);
                    }
                }
                
              folha = pai;
              
              if(pai.getTl() == 0 && pai == raiz){
                  if(irmaE != null)
                    raiz = irmaE;
                  else
                    raiz = irmaD;
              }
              else{
                  if(pai != raiz && pai.getTl() < m){
                      concatena_redistribui(folha);
                  }
              }

            }
        }
    }

    //.....................
    public void in_ordem(No raiz)
    {
       if (raiz!=null)
       {
           for(int i=0; i<raiz.getTl(); i++)
           {
               in_ordem(raiz.getvLig(i));
               System.out.println(raiz.getvInfo(i));
           }
           in_ordem(raiz.getvLig(raiz.getTl()));
       }
    }

    public void in_ordem()
    {
        in_ordem(raiz);
    }
}
