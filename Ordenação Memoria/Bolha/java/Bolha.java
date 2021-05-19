public class Bolha{

  public static void main (String [] agrs){
    int [] arrayDesordenado={10,40,1,74,31,100,30,50,70,20,12,13}; // array desordenado
    int []arrayOrdenado=bolhaShort(arrayDesordenado); // chamamento da funcao
    for(int i =0;i<arrayOrdenado.length;i++){ //mostrar
     System.out.print(arrayOrdenado[i]+"");
    }
  }


/* Algoritimo bolha */
  public static int [] bolhaShort(int []arrayDesordenado){
    for(int i =(arrayDesordenado.length-1);i>0;i--){
      for (int z=0;z<i ;z++ ) {
        if(arrayDesordenado[z]>arrayDesordenado[z+1])
        swap(z,z+1,arrayDesordenado);
      }
    }
    return arrayDesordenado ;
  }


/* metodo swap  */
  public static void swap(int primeiraP , int segundaP, int []arrayParaserTrocado){
    int receber=0;
    receber=arrayParaserTrocado[primeiraP];
    arrayParaserTrocado[primeiraP]=arrayParaserTrocado[segundaP];
    arrayParaserTrocado[segundaP]=receber;
  }

}
