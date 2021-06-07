#include <stdio.h>
#include <stdlib.h>
#define true   1
#define false  0
#define bool   short
typedef struct Celula {
	int elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

 // nova Celula com  passagem de elemento
Celula* novaCelula(int elemento){
  Celula* nova =(Celula*)malloc(sizeof(Celula));// criar uma alocacar dinamica para a nova Celula
  nova->elemento=elemento;
  nova->prox=NULL;
  return nova;
}

Celula* primeiro;
Celula* ultimo;

//criar uma nova lista sem elementos
void start(){
  primeiro=novaCelula(0);
  ultimo=primeiro;
}

void inserirInicio(int x) {
   Celula* tmp = novaCelula(x);
   tmp->prox = primeiro->prox;
   primeiro->prox = tmp;
   if (primeiro == ultimo) {
      ultimo = tmp;
   }
   tmp = NULL;
}

void inserirFim(int x) {
   ultimo->prox = novaCelula(x);
   ultimo = ultimo->prox;
}

int removerInicio() {
   if (primeiro == ultimo) {
      printf("Erro ao remover!");
   }
   Celula* tmp = primeiro;
   primeiro = primeiro->prox;
   int resp = primeiro->elemento;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}

int removerFim() {
   if (primeiro == ultimo) {
    printf("Erro ao remover!");
   }
   Celula* i;
   for(i = primeiro; i->prox != ultimo; i = i->prox);
   int resp = ultimo->elemento;
   ultimo = i;
   free(ultimo->prox);
   i = ultimo->prox = NULL;

   return resp;
}

int tamanho() {
   int tamanho = 0;
   for( Celula* i = primeiro; i != ultimo; i = i->prox, tamanho++);
   return tamanho;
}

void inserir(int x, int pos) {
   int tam = tamanho();
   if(pos < 0 || pos > tam){
    printf("Erro ao inserir posicao  invalida!");
   } else if (pos == 0){
      inserirInicio(x);
   } else if (pos == tam){
      inserirFim(x);
   } else {
      // Caminhar ate a posicao anterior a insercao
      int j;
      Celula* i = primeiro;
      for(j = 0; j < pos; j++, i = i->prox);

      Celula* tmp = novaCelula(x);
      tmp->prox = i->prox;
      i->prox = tmp;
      tmp = i = NULL;
   }
}
int remover(int pos) {
   int resp;
   int tam = tamanho();

   if (primeiro == ultimo){
      printf("Erro ao remover (vazia)!");
   } else if(pos < 0 || pos >= tam){
      printf("Erro ao remover posicao invalida!");
   } else if (pos == 0){
      resp = removerInicio();
   } else if (pos == tam - 1){
      resp = removerFim();
   } else {
      // Caminhar ate a posicao anterior a insercao
      Celula* i = primeiro;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);

      Celula* tmp = i->prox;
      resp = tmp->elemento;
      i->prox = tmp->prox;
      tmp->prox = NULL;
      free(tmp);
      i = tmp = NULL;
   }
   return resp;
}

void mostrar() {
   for (Celula* i = primeiro->prox; i != NULL; i = i->prox) {
      printf("%d ", i->elemento);
   }
   printf("\n");
}

bool pesquisar(int x) {
   bool retorno = false;
   for ( Celula* i = primeiro->prox; i != NULL; i = i->prox) {
      if(i->elemento == x){
         retorno = true;
         i = ultimo;
      }
   }
   return retorno;
}
int main (){
  start();
  for (int i = 0; i < 10; i++) {
    inserirFim(i);
  }
  mostrar();

  return 0;
}
