
/* Criar uma Celula para referenciar elemento*/
class Celula{

  public int elemento; // elemento
  public Celula proximoElemento; // referencia do proximo elemento

      /*contrutorsem passagem de paramentro*/
      public Celula(){
          this(0);
        }

        /* contrutor com a passagem de elemento*/
      public Celula(int novoElemento){
          this.elemento = novoElemento;
          this.proximoElemento = null;
        }
}
/* fim class celula*/

/* Inicio class Pilha*/
 class Pilha{

  private Celula topo; // celula primordial da pilha

  public Pilha(){
    this.topo=null;
  }

  public void inserir(int elemento){
    Celula temporaria = new Celula(elemento);// referenciar um novo elemento
    temporaria.proximoElemento=topo; // fazer com que a nova celula aponte para NULL
    topo=temporaria; // fazer com que o topo aponte para a nova celula;
    temporaria=null; // coletar o lixo fazendo assim o programa nao gastar tante memopria ran
  }

  public int remover(){

    if(topo==null){
      System.out.println("Sua pilha esta vazia"); // verificar se a pilha contem elementos
    }
      int pegarValor=topo.elemento; // pegar o novo elemento;
      Celula temporaria = topo; // criar uma nova celula temporaria
      topo = topo.proximoElemento; // fazerr com que o topo para de apontar para a celula retirada
      temporaria.proximoElemento=null; // fazer com que a celula apknte para null
      temporaria=null; // coletar o lixo
      return pegarValor; // retornar o valor
      }


      public void mostrar(){
        int z=0;
        System.out.println("Topo");
        System.out.println(" | ");
        System.out.println(" V ");
        for (Celula i= topo;i!=null;z++,i=i.proximoElemento ) {
          System.out.println("["+i.elemento+"]");
          System.out.println(" | ");
          System.out.println(" V ");
        }
          System.out.println("NULL ");
      }

      public int somaValores(){
        int total=0;
        if(topo==null){
          return 0;
        }
        for (Celula i= topo;i!=null;total+=i.elemento,i=i.proximoElemento);
        return total;
      }
      void imprimeBinario(int n) {
   // Declaração da estrutura de dados X
   while (n > 0) {
      i.insere(n % 2);
      n /= 2;
   }
   while(!.vazia())
      System.out.print(X.retira());
}

}
public class main {
	public static void main(String[] args) {
		try {

			Pilha pilha = new Pilha();
        for(int i =0;i<10;i++){
          pilha.inserir(i);
        }

	      System.out.println("Valores inseridos===");
			  pilha.mostrar();

	      int		x1 = pilha.remover();
	      int		x2 = pilha.remover();
	      int		x3 = pilha.remover();
          System.out.println();
          System.out.println();
			  System.out.println("Removidos== (" + x1 + "," + x2 + "," + x3 + ")");
          System.out.println();
          System.out.println();
        System.out.println("Pilha sem os valores removidos");
        pilha.imprimeBinario(4);

        System.out.println("Soma dos valores ="+ pilha.somaValores());

		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
