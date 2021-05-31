# Pilha

# A estrutura pilha , e uma estrutura  na qual  o ultimo valor inserido e o primeiro a ser retirado . Basicamente a ilustracao mental da pilha seria de uma pilha inpilhada de pratos onde vc so pode retirar o primeiro(o que esta no topo), por isso o ultimo prato a ser colocado na pilha vira o primeiro prato a ser retirado;


#Class no inicio da pilha , temos o referencial que se refere-se ao topo , onde se quando for feita o chamamento da class sem nenhum valor inserido o topo ira apontar para NULL , e apos a insersao de um novo valor a referencia topo ira apontar para o novo valor(apontando para o local da memoria e nao o valor em si)

#Insersao : Criaremos uma Celula Temporaria para referenciar o novo valor ,  e com isso , faremos a Celula temporaria.proximo apontar para o mesmo local que o Topo esta apontando(NULL) e depois faremos com que o Topo aponte para a mesma referencia que A Celula temporaria esta apontando ;

#Remocao : Iremos confirmar que nossa Pilha tem algum valor ,apos a confirmacao iremos Criar outra celula temporaria na qual ira referenciar o mesmo reparticao da memoria que Topo , com isso iremos fazer com que a referencia Topo referencia a proxima reparticao da memoria de nossa pilha (topo=topo.proxima);

#Mostrar: Iremos fazaer uma estrutura de repeticao na qual iniciaremo-a com uma Celula nova apontando para o topo , e iremos fazer (CelulaNova.proxima) ate ser diferente que Null, pois a nossa ultima celula da pilha esta referenciando um espaco vazio(NULL). Apos terminio o programa ira ter mostrado todos os elementos existentes na pilha;


#IMPORTANTE Como esse programa utiliza de referencias na memoria , lembrar que mesmo em java coletar o lixo , em C e primordial utilizar o free e em java aponta o lixo para NULL
