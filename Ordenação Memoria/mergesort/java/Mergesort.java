public class Mergesort{

  public static void main(String[] args) {
    int [] arrayDesordenado={10,40,1,74,31,100,30,50,70,20,12,13}; // array desordenado
    int []arrayOrdenado=mergesort(arrayDesordenado,0, arrayDesordenado.length-1); // chamamento da funcao
    for(int i =0;i<arrayOrdenado.length;i++){ //mostrar
     System.out.print(arrayOrdenado[i]+" ");
    }
  }

/* funcao recursiva*/
  public static int [] mergesort(int []array,int esq, int dir) {
     if (esq < dir){
        int meio = (esq + dir) / 2;
        mergesort(array,esq, meio);
        mergesort(array,meio + 1, dir);
        intercalar(array,esq, meio, dir);
     }
     return array;
  }
  public static void intercalar(int array[],int esq, int meio, int dir){
        int n1, n2, i, j, k;

        //Definir tamanho dos dois subarrays
        n1 = meio-esq+1;
        n2 = dir - meio;

        int[] a1 = new int[n1+1];
        int[] a2 = new int[n2+1];

        //Inicializar primeiro subarray
        for(i = 0; i < n1; i++){
           a1[i] = array[esq+i];
        }

        //Inicializar segundo subarray
        for(j = 0; j < n2; j++){
           a2[j] = array[meio+j+1];
        }

        //Sentinela no final dos dois arrays
        a1[i] = a2[j] = 0x7FFFFFFF;

        //Intercalacao propriamente dita
        for(i = j = 0, k = esq; k <= dir; k++){
           array[k] = (a1[i] <= a2[j]) ? a1[i++] : a2[j++];
        }


     }


}
