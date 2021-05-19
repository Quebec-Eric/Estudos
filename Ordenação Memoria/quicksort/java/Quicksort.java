import java.util.Random;
public class Quicksort{
  public static void main(String[] args) {
    int [] arrayDesordenado={10,40,1,74,31,100,30,50,70,20,12,13}; // array desordenado
    int []arrayOrdenado=quicksort(arrayDesordenado,0, arrayDesordenado.length-1); // chamamento da funcao
    for(int i =0;i<arrayOrdenado.length;i++){ //mostrar
     System.out.print(arrayOrdenado[i]+" ");
    }
  }
 /* na minha funcao so quicksort consegui melhorar as chanches de cair no caso medio do quicksort  */
  private static int [] quicksort(int array[],int esq, int dir) {
      Random gerador = new Random();
      int numero1=gerador.nextInt(dir+1);
      int numeor2=gerador.nextInt(dir+1);
      int numero3=gerador.nextInt(dir+1);
      int i = esq, j = dir;
      int pivo = array[(numero1+numeor2+numero3)/3];
      while (i <= j) {
          while (array[i] < pivo) i++;
          while (array[j] > pivo) j--;
          if (i <= j) {
              swap(i, j,array);
              i++;
              j--;
          }
      }
      if (esq < j){
          quicksort(array,esq, j);
        }
      if (i < dir){
          quicksort(array,i, dir);
        }
      return array;
  }

  public static void swap(int primeiraP , int segundaP, int []arrayParaserTrocado){
    int receber=0;
    receber=arrayParaserTrocado[primeiraP];
    arrayParaserTrocado[primeiraP]=arrayParaserTrocado[segundaP];
    arrayParaserTrocado[segundaP]=receber;
  }


}
