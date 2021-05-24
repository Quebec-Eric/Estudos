#include <stdio.h>
#include <stdlib.h>

typedef struct Celula {
	int elemento;        // Elemento inserido na celula.
	struct Celula* proximoElemento; // Aponta a celula prox.
} Celula;

Celula* novaCelula(int elementoNovo) {
   Celula* nova = (Celula*) malloc(sizeof(Celula)); // alocar espaco na memoria
   nova->elemento = elementoNovo; // apontar para um novo elemento
   nova->proximoElemento = NULL;
   return nova;
}
Celula* topo;
/* criar uma pilha sem elementos*/
void start () {
   topo = NULL;
}

void inserir(int elemento) {
   Celula* temporaria = novaCelula(elemento); // Criar um ponteiro temporario
   temporaria->proximoElemento = topo;
   topo = temporaria;
   temporaria = NULL;
   free(temporaria); // lixo
}

int remover(){

  if(topo==NULL){
  printf("erro ao remover\n");
  }
  int valor = topo->elemento;
  Celula *temporaria = topo;
  topo=topo->proximoElemento;
  temporaria->proximoElemento = NULL;
  temporaria=NULL;
  free(temporaria);
  return valor;

}
void mostrar (){
  Celula * i;
  printf("Topo\n");
  printf(" | \n");
  printf(" V \n");
  for(i= topo ; i!=NULL; i=i->proximoElemento){
    printf("[%d]\n",i->elemento);
    printf(" | \n");
    printf(" V \n");
  }
  printf(" NULL \n");
}

int main (){
  start();
  for(int i =0;i<10;i++){
    inserir(i);
  }

  printf("Apos insercoes: \n");
    mostrar();
   int x1 = remover();
   int x2 = remover();
   int x3 = remover();
   printf("\n");
   printf("\n");
    printf("Apos as remocoes (%d, %d, %d) \n ", x1, x2, x3);
    printf("\n");
    printf("\n");
    mostrar();
}
