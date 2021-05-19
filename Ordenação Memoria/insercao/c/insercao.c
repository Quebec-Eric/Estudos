#include <stdio.h>

int *insercao(int  arrayDesordenado[] , int tamanho);
int main (){
   int arrayDesordenado[11]={5,10,40,100,1,3,14,20,30,41,29};
   int *arrayOrdenado=insercao(arrayDesordenado,11);
   for(int i =0; i<11;i++){
     printf("%d ",arrayOrdenado[i]);
   }
  return 0;
 }

int *insercao(int  arrayDesordenado[] , int tamanho){
  for(int i=1;i<tamanho;i++){ // iniciar em 1 pelo fato de achar que o primeiro ja esta Ordenado
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
