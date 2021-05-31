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


class Lista {

  private Celula primeiro;
  private Celula ultimo;


  public Lista(){
    primeiro=new Celula();
    ultimo=primeiro;
  }

  public void inserirInicio(int x){

    Celula temporaria= new Celula(x); // criar uma nova celula temporaria
    temporaria.proximoElemento=primeiro.proximoElemento; // alocar essa celula apos a celula cabeca
    primeiro.proximoElemento=temporaria; //fazer com que o ponteiro.proximo aponte para a nova celula
    if(primeiro==ultimo){ // teste para verificar se sera preciso fazer mais uma corelacao
      ultimo=temporaria;
    }
    temporaria= null; // tirar a referencia
  }

  public void inserirFim(int x){
    ultimo.proximoElemento=new Celula(x); // fazer com que o ultimo aponte para o novo elemento
    ultimo = ultimo.proximoElemento; // mudar o local do apontador
  }

  public int removerInicio(){
    if(primeiro== ultimo){System.out.print("Nao existe elementos na fila ");} // ver se existe elemento no array
    Celula temporaria= primeiro;//criar uma celula temporaria
    primeiro=primeiro.proximoElemento; // fazer com que aponte para o primeiro elemento
    int pegar = primeiro.elemento; //pegar o valor presente na referencia
    temporaria.proximoElemento=null; // apontar para null
    temporaria=null; // apontar para nulll
    return pegar; // retornar o valor
  }

  public int removerFim(){
  if(primeiro== ultimo){System.out.print("Nao existe elementos na fila ");}
  Celula i;
   for(i = primeiro; i.proximoElemento != ultimo; i = i.proximoElemento);
   int pegar= ultimo.elemento;
   ultimo=i;
   i=null;
   ultimo.proximoElemento=null;
   return pegar;
  }

  public void inserir(int x,int posicao){
    int tamanho=saberTamanho();
    if(posicao<0||posicao>tamanho){
      System.out.println("posicao nao existe");
    }
    else if(posicao==0){
      inserirInicio(x);
    }
    else if(posicao==tamanho){
      inserirFim(x);
    }
    else{
      Celula i =primeiro;
      for(int j = 0; j < posicao; j++, i = i.proximoElemento);

      Celula temporaria = new Celula(x);

      temporaria.proximoElemento=i.proximoElemento;
      i.proximoElemento=temporaria;
      i=null;
      temporaria=null;

    }

  }

  public int remover(int posicao){
    int tamanho=saberTamanho();
    int pegar=0;
    if(posicao<0||posicao>tamanho){
      System.out.println("posicao nao existe");
    }
    else if(posicao==0){
      pegar=removerInicio();
    }
    else if(posicao==tamanho){
      pegar=removerFim();
    }
    else{
      Celula i = primeiro;
      for(int j = 0; j < posicao; j++, i = i.proximoElemento);

      Celula temporaria = i.proximoElemento;
      pegar = temporaria.elemento;
      i.proximoElemento = temporaria.proximoElemento;
      temporaria.proximoElemento = null;
      i = temporaria = null;
    }
    return pegar;
  }

  public int saberTamanho(){
      int t =0;
      for(Celula i = primeiro; i != ultimo; i = i.proximoElemento, t++);
      return t;
  }

  public void mostrar(){
    //  System.out.print("[Cabeca] --> ");
    for (Celula i=primeiro.proximoElemento;i!=null ;i=i.proximoElemento ) {
        System.out.print(i.elemento+" ");
    }
    System.out.println("");
  }


  public void inverterLista(){
    int []tmp=new int[ saberTamanho()+1];
    int x=0;
    for (Celula i=primeiro.proximoElemento;i!=null && x<saberTamanho();i=i.proximoElemento,x++) {
        tmp[x]=i.elemento;
    }
    for(Celula i=primeiro;i!=null||x>0;i=i.proximoElemento,x--){
    i.elemento=tmp[x];
    }

  }

	public void RemovePos(int n){
		if(n>0){
			Celula i = primeiro.proximoElemento;
			if(n==1){
				primeiro.proximoElemento=primeiro.proximoElemento.proximoElemento;
			}
			else{
				for(int saber=0;saber<n&&i.proximoElemento!=null;saber++,i=i.proximoElemento);
				i.proximoElemento=i.proximoElemento.proximoElemento;
			}
		}
	}

}


public class main {
	public static void main(String[] args) {
		try {
			//System.out.println("=== LISTA FLEXIVEL SIMPLESMENTE ENCADEADA ===");
			Lista lista = new Lista();

			lista.inserirInicio(1);
			lista.inserirInicio(0);
			lista.inserirFim(4);
			lista.inserirFim(5);
			lista.inserir(2, 2);
			lista.inserir(3, 3);
			lista.inserir(6, 6);
			lista.inserir(30, 0);
			lista.inserirFim(7);
			lista.inserirFim(8);
      lista.mostrar();
      lista.RemovePos(3);
			lista.mostrar();



		//	System.out.print("Apos remocoes (" +x1+ ", " +x2+ ", " +x3+ ", " +x4+ ", " +x5+ ", " +x6+ "): ");
			//lista.mostrar();
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
