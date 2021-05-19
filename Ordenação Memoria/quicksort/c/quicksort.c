#include <stdio.h>
#include <stdlib.h>
#include<time.h>
void swap(int *i, int *j);
int *quicksort(int array[],int esq, int dir);
int main (){
  srand(time(NULL));
   int arrayDesordenado[11]={5,10,40,100,1,3,14,20,30,41,29};
   int *arrayOrdenado=quicksort(arrayDesordenado,0,11);
   for(int i =0; i<11;i++){
     printf("%d ",arrayOrdenado[i]);
   }
  return 0;
 }
  /* na minha funcao so quicksort consegui melhorar as chanches de cair no caso medio do quicksort  */
  int * quicksort(int array[],int esq, int dir) {

     int numero1=(rand() % (dir+1));
     int numeor2=(rand() % (dir+1));
     int numero3=(rand() % (dir+1));
     int i = esq, j = dir;
     int pivo = array[(numero1+numeor2+numero3)/3];
     while (i <= j) {
         while (array[i] < pivo) i++;
         while (array[j] > pivo) j--;
         if (i <= j) {
             swap(array+ i, array + j);
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

 void swap(int *i, int *j) {
    int temp = *i;
    *i = *j;
    *j = temp;
 }
