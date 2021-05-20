#include <stdio.h>

void swap(int *i, int *j);
void construir(int array[], int tamHeap);
int getMaiorFilho(int array[], int i, int tamHeap);
void reconstruir(int array[], int tamHeap);
int * heapsort(int array[], int n);
int main (){
   int arrayDesordenado[14]={5,10,15,60,100000,40,100,1,3,14,20,30,41,29};
   int *arrayOrdenado=heapsort(arrayDesordenado,14);
   for(int i =0; i<14;i++){
     printf("%d ",arrayOrdenado[i]);
   }
  return 0;
 }


 void construir(int array[], int tamHeap){
     for(int i = tamHeap; i > 1 && array[i] > array[i/2]; i /= 2){
         swap(array + i, array + i/2);
     }
 }

 int getMaiorFilho(int array[], int i, int tamHeap){
     int filho;
     if (2*i == tamHeap || array[2*i] > array[2*i+1]){
         filho = 2*i;
     } else {
         filho = 2*i + 1;
     }
     return filho;
 }

 void reconstruir(int array[], int tamHeap){
     int i = 1;
     while(i <= (tamHeap/2)){
         int filho = getMaiorFilho(array, i, tamHeap);
         if(array[i] < array[filho]){
             swap(array + i, array + filho);
             i = filho;
         }else{
             i = tamHeap;
         }
     }
 }

 int* heapsort(int array[], int n) {
     //Alterar o vetor ignorando a posicao zero
     int arrayTmp[n+1];
     for(int i = 0; i < n; i++){
         arrayTmp[i+1] = array[i];
     }

     //Contrucao do heap
     for(int tamHeap = 2; tamHeap <= n; tamHeap++){
         construir(arrayTmp, tamHeap);
     }

     //Ordenacao propriamente dita
     int tamHeap = n;
     while(tamHeap > 1){
         swap(arrayTmp + 1, arrayTmp + tamHeap--);
         reconstruir(arrayTmp, tamHeap);
     }

     //Alterar o vetor para voltar a posicao zero
     for(int i = 0; i < n; i++){
         array[i] = arrayTmp[i+1];
     }
     return array;
 }


 void swap(int *i, int *j) {
    int temp = *i;
    *i = *j;
    *j = temp;
 }
