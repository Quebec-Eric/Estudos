# Quicksort

# O algorítmico Quicksort e um dos melhores algoritomos de ordenacao , esse se baseia na ideia de dividar para conquistar no qual iremos passar para funcao o lado esquedo(0) e o lado direito(tamanho de votor -1) e com isso achamos o pivo , mas eu acho melhro o ato de fazer a mediana de tres elementos aleatorios do array para nao ocorrer o risco de cair no pior caso , e aumentar bem minhas chances de obter o caso medio , que ainda e otimo

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
