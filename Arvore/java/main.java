import java.io.IOException;

/* Criando a class no*/
class No {
  int elemento // elemento
  No esq; // referencias para a esquerda
  No dir; // referencia para a direita

/* contrutor quando nao for informado as referencias*/
  No(int elemento){
    this(elemento,null,null);
  }

 /* contrutor  com as passagem das referencias */
  No(int elemento, No esq,No dir){
    this.elemento=elemento;
    this.esq=esq;
    this.dir=dir
  }
}

class ArvoreBinaria{

  /* Criando a raiz*/
  No raiz;

/* fazendo com que a raiz aponte para null
mema ideia da Pilha*/
  ArvoreBinaria(){
    raiz = null;
  }
  /* chamamento para a funcao recursiva*/
  void inserir(int elemento){
    raiz=inserir(elemento,raiz);
  }

 /* funcao recursiva*/
  No inserir(int elemento,No i){
    if(i==null){
      i=new No(elemento); // se nao existir elemento na raiz , colocar o elemento com
    }
    /* se o elemeto for menor que a raiz colocar ele na esquerda da
    raiz ,  */
    else if(elemento<i.elemento){
      i.esq=inserir(x,i.esq);
    }
    else{
      /* Se o elemento foi maior que a raiz colocar ele na direita da raiz*/
      i.dir-inserir(elemento,i.dir);
    }
    return i

  }
}
