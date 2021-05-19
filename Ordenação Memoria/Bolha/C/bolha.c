
#include <stdio.h>
void swap(int *i, int *j);
int *bolha(int  arrayDesordenado[] , int tamanho);
int main (){
   int arrayDesordenado[11]={5,10,40,100,1,3,14,20,30,41,29};
   int *arrayOrdenado=bolha(arrayDesordenado,11);
   for(int i =0; i<11;i++){
     printf("%d ",arrayOrdenado[i]);
   }
  return 0;
 }

/* algoritimo de ordenacao*/
int *bolha(int *arrayDesordenado, int tamanho){
  for(int i = (tamanho-1); i>0 ; i--){
    for(int z =0; z<i;z++){
      if(arrayDesordenado[z]>arrayDesordenado[z+1]){
        swap(&arrayDesordenado[z],&arrayDesordenado[z+1]);
      }
    }
  }
  return arrayDesordenado;
}


/* trocar valores no vetor */
void swap(int *i, int *j) {
   int temp = *i;
   *i = *j;
   *j = temp;
}
