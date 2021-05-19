# Quicksort

# O algorítmico Quicksort e um dos melhores algoritmos de ordenação, esse se baseia na idéia de dividir para conquistar no qual iremos passar para função o lado esquerdo(0) e o lado direito(tamanho de votor -1) e com isso achamos o pivô, mas eu acho melhor o ato de fazer a mediana de três elementos aleatórios do array para não ocorrer o risco de cair no pior caso, e aumentar bem minhas chances de obter o caso médio, que ainda e ótimo

#Vantagens
.Extremamente eficiente
.Necessita de apenas uma pequena pilha como memoira auxiliar
.Faz em media Θ(n*log(n)) comparacoes

# Contras
. No pior caso realiza comparacoes quadraticas<br />
. Ele e bem dificl de implementar<br />
. Nao e estável

# Complexidade
. Melhor caso :: só ira fazer uma comparação<br />
. Caso médio :: depende o número de inversões no array<br />
. Pior casos :: array esta ordenado de forma decrescente

# Ω = Melhor caso
# Θ = Caso medio
# O = Pior caso

# Notacao        Ω(n*log(n))  Θ(n *log(n))  O(n^2)
