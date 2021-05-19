public class Insercao{

  public static void main(String[] args) {
    int [] arrayDesordenado={10,40,1,74,31,100,30,50,70,20,12,13}; // array desordenado
    int []arrayOrdenado=insercao(arrayDesordenado); // chamamento da funcao
    for(int i =0;i<arrayOrdenado.length;i++){ //mostrar
     System.out.print(arrayOrdenado[i]+" ");
    }
  }

/* algoritomo de ordenacao*/
  public static int [] insercao(int []arrayDesordenado){
    for(int i=1;i<arrayDesordenado.length;i++){ // iniciar em 1 pelo fato de achar que o primeiro ja esta Ordenado
      int tmp = arrayDesordenado[i]; // variavel temporaria
      int j=i-1;
      while((j>=0)&&(arrayDesordenado[j]>tmp)){
        arrayDesordenado[j+1]=arrayDesordenado[j]; // colocar o valor que e maior no ligar do menor
        j--;// voltar na posicao do maior elemnto
      }
      arrayDesordenado[j+1]=tmp;
    }
    return arrayDesordenado;
  }
}
