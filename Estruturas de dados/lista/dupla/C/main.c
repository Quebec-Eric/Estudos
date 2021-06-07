#include <stdio.h>
#include <stdlib.h>

#define bool   short
#define true   1
#define false  0

typedef struct CelulaDupla {
	int elemento;        // Elemento inserido na celula.
	struct CelulaDupla* prox; // Aponta a celula prox.
   struct CelulaDupla* ant;  // Aponta a celula anterior.
} CelulaDupla;


CelulaDupla* novaCelulaDupla(int elemento) {
   CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
   nova->elemento = elemento;
   nova->ant = nova->prox = NULL;
   return nova;
}
CelulaDupla* primeiro;
CelulaDupla* ultimo;

// inicio da nova celula sem nenhum valor
void start () {
   primeiro = novaCelulaDupla(0);
   ultimo = primeiro;
}

void inserirInicio(int x) {
   CelulaDupla* tmp = novaCelulaDupla(x);

   tmp->ant = primeiro;
   tmp->prox = primeiro->prox;
   primeiro->prox = tmp;
   if (primeiro == ultimo) {
      ultimo = tmp;
   } else {
      tmp->prox->ant = tmp;
   }
   tmp = NULL;
}

void inserirFim(int x) {
   ultimo->prox = novaCelulaDupla(x);
   ultimo->prox->ant = ultimo;
   ultimo = ultimo->prox;
}

int removerInicio() {
   if (primeiro == ultimo) {
    printf("Erro ao remover (vazia)!");
   }

   CelulaDupla* tmp = primeiro;
   primeiro = primeiro->prox;
   int resp = primeiro->elemento;
   tmp->prox = primeiro->ant = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}

int removerFim() {
   if (primeiro == ultimo) {
      printf("Erro ao remover (vazia)!");
   }
   int resp = ultimo->elemento;
   ultimo = ultimo->ant;
   ultimo->prox->ant = NULL;
   free(ultimo->prox);
   ultimo->prox = NULL;
   return resp;
}

int tamanho() {
   int tamanho = 0;
   for(CelulaDupla* i = primeiro; i != ultimo; i = i->prox, tamanho++);
   return tamanho;
}

void inserir(int x, int pos) {

   int tam = tamanho();

   if(pos < 0 || pos > tam){
      printf("Erro ao inserir");
   } else if (pos == 0){
      inserirInicio(x);
   } else if (pos == tam){
      inserirFim(x);
   } else {
      // Caminhar ate a posicao anterior a insercao
      CelulaDupla* i = primeiro;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);

      CelulaDupla* tmp = novaCelulaDupla(x);
      tmp->ant = i;
      tmp->prox = i->prox;
      tmp->ant->prox = tmp->prox->ant = tmp;
      tmp = i = NULL;
   }
}
int remover(int pos) {
   int resp;
   int tam = tamanho();

   if (primeiro == ultimo){
      printf("Erro ao remover (vazia)!");
   } else if(pos < 0 || pos >= tam){
      printf("Erro ao inserir");
   } else if (pos == 0){
      resp = removerInicio();
   } else if (pos == tam - 1){
      resp = removerFim();
   } else {
      // Caminhar ate a posicao anterior a insercao
      CelulaDupla* i = primeiro->prox;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);

      i->ant->prox = i->prox;
      i->prox->ant = i->ant;
      resp = i->elemento;
      i->prox = i->ant = NULL;
      free(i);
      i = NULL;
   }

   return resp;
}

void mostrar() {

   for ( CelulaDupla* i = primeiro->prox; i != NULL; i = i->prox) {
      printf("%d ", i->elemento);
   }
   printf("\n");
}

bool pesquisar(int x) {
  bool resp = false;
  for ( CelulaDupla* i = primeiro->prox; i != NULL; i = i->prox) {
      if(i->elemento == x){
         resp = true;
         i = ultimo;
      }
   }
   return resp;
}


int main (){
  start();
  for (int  i = 0; i < 20; i++) {
    inserirFim(i);
  }
  mostrar();
}
