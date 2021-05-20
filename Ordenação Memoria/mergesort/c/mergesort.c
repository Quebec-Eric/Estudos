#include <stdio.h>

int *mergesort(int array[],int esq, int dir);
void intercalar(int array[],int esq, int meio, int dir);
int main (){
  int arrayDesordenado[11]={5,10,40,100,1,3,14,20,30,41,29};
   int *arrayOrdenado=mergesort(arrayDesordenado,0,11);
   for(int i =0; i<11;i++){
     printf("%d\n",arrayOrdenado[i]);
   }
  return 0;
 }

/* funcao recursiva*/
 int * mergesort(int array[],int esq, int dir) {
      if (esq < dir){
         int meio = (array,esq + dir) / 2;
         mergesort(array,esq, meio);
         mergesort(array,meio + 1, dir);
         intercalar(array,esq, meio, dir);
      }
      return array;
   }


   void intercalar(int array[],int esq, int meio, int dir){
      int n1, n2, i, j, k;

      //Definir tamanho dos dois subarrays
      n1 = meio-esq+1;
      n2 = dir - meio;

      int a1[n1+1];
      int a2[n2+1];

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
