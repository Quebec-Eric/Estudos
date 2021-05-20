public class Heapsort{



  public static void main(String[] args) {
    int [] arrayDesordenado={10,40,1,74,31,100,30,50,70,20,12,13,1000000,100002}; // array desordenado
    int []arrayOrdenado=heapsort(arrayDesordenado,arrayDesordenado.length); // chamamento da funcao
    for(int i =0;i<arrayOrdenado.length;i++){ //mostrar
     System.out.print(arrayOrdenado[i]+" ");
    }
  }


  public static int [] heapsort(int [] array, int n ) {
    //Alterar o vetor ignorando a posicao zero
    int[] tmp = new int[n+1];
    for(int i = 0; i < n; i++){
       tmp[i+1] = array[i];
    }
    array = tmp;

    //Contrucao do heap
    for(int tamHeap = 2; tamHeap <= n; tamHeap++){
       construir(array,tamHeap);
    }

    //Ordenacao propriamente dita
    int tamHeap = n;
    while(tamHeap > 1){
       swap(array,1, tamHeap--);
       reconstruir(array,tamHeap);
    }

    //Alterar o vetor para voltar a posicao zero
    tmp = array;
    array = new int[n];
    for(int i = 0; i < n; i++){
       array[i] = tmp[i+1];
    }

    return array;
 }

 public static void construir(int []array,int tamHeap){
     for(int i = tamHeap; i > 1 && array[i] > array[i/2]; i /= 2){
        swap(array,i, i/2);
     }
  }

  public static void reconstruir(int []array,int tamHeap){
     int i = 1;
     while(i <= (tamHeap/2)){
        int filho = getMaiorFilho(array,i, tamHeap);
        if(array[i] < array[filho]){
           swap(array,i, filho);
           i = filho;
        }else{
           i = tamHeap;
        }
     }
  }

  public static int getMaiorFilho(int []array,int i, int tamHeap){
     int filho;
     if (2*i == tamHeap || array[2*i] > array[2*i+1]){
        filho = 2*i;
     } else {
        filho = 2*i + 1;
     }
     return filho;
  }

  public static void swap(int []arrayParaserTrocado,int primeiraP , int segundaP){
    int receber=0;
    receber=arrayParaserTrocado[primeiraP];
    arrayParaserTrocado[primeiraP]=arrayParaserTrocado[segundaP];
    arrayParaserTrocado[segundaP]=receber;
  }


}
