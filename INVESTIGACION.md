# Investigacion MergeSort

## Explicacion del algoritmo
Merge sort es un algoritmo que aplica el proceso de **divide y vencerás**
1. **Divide: ** El algoritmo empieza por dividir el arreglo, lista en dos mitades creando sublstas. Este proceso lo repite n veces hasta cada sublista contenga un solo elemento.
2. **Vencera: ** Luego el algoritmo  vuelve a unir las sublistas, pero sin antes colocar los valores de menor primero de cada sublista.

Este proceso de dividir y fusionar se realiza por medio de recursividad (llamar al mismo metodo varias veces).

## Identificacion
|Aspecto | Detalle |
|--------|---------|
|Algoritmo | Merge Sort |
| Variante | Clasica de arriba hacia abajo , copia el arreglo original en dos hasta llegar a una|       subarreglo de un elemento y luego fusiona los subarreglos, ordenandolos de menor a mayor.|
| Clase	 | MetodosSort |
| Ruta | src/MetodosSort.java |
| Métodos |	public voi mergeSort(int[] arreglo) y public static void merge(int[] izquierda, int[] derecha, int[] arreglo) |

## Explicacion del codigo
**Codigo: ** ![alt text](evidencias/assets/codigo_MergeSort.png)

### Metodos
-mergeSort(int[] arreglo): es la parte del metodo que divide el arreglo
-merge(izquierda, derecha, arreglo): al estar los dos arreglos ya ordenados, en esta parte el metodo se fusionan para crear el arreglo ordenado

Nota: Al usar una condicional,  si el arreglo es null o tiene 0 o 1 elemento, se termina sin hacer nada, porque un arreglo de tamaño 0 o 1 ya está ordenado.

Pasos de mergeSort para n ≥ 2

Calcular medio = n / 2 (división entera).
Crear arreglo de izquierda con medio elementos y derecha con n - medio elementos.
Copiar arreglo[0..medio-1] a izquierda y arreglo[medio..n-1] a derecha.
Llamar recursivamente a mergeSort(izquierda) y mergeSort(derecha).
Llamar a merge(izquierda, derecha, arreglo), que sobrescribe arreglo con la unión ordenada.

Progreso de la recursión: en cada llamada el tamaño pasa de n a ⌊n/2⌋ y ⌈n/2⌉. Como n ≥ 2, ambos son menores que n, así que la recursión siempre llega  y termina de manera normal. De ahi la complejidad log de base 2 de n veces.

## División, mezcla, arreglo auxiliar y empates
- División: en medio = n / 2. La izquierda recibe ⌊n/2⌋ elementos y la derecha ⌈n/2⌉.
- Mezcla: merge mantiene tres índices (izq, drch e i). Mientras queden elementos en ambas mitades, el menor de las dos sublistas copia al arreglo original. Cuando una mitad se agota, copia el resto de la otra, que ya está ordenado.
- Arreglo auxiliar: en esta implementación los auxiliares son izquierda y derecha, que se crean con new en cada llamada recursiva. Esa reserva ocurre dentro de mergeSort, así que forma parte del tiempo medido de V2. De esta manera la complejidad se vuelve n veces de n log n.
Empates: se usa izquierda[izq] <= derecha[drch]. Si los dos valores son iguales, se toma el de la izquierda, que en el arreglo original estaba antes. Eso conserva el orden relativo.

## Complejidad, memoria y estabilidad

- Cada llamada hace trabajo proporcional a n (copiar las mitades y fusionarlas) más dos llamadas sobre n/2: T(n) = 2·T(n/2) + Θ(n)  ⇒  T(n) = Θ(n log n)

|Caso| Tiempo	| Justificación|
|----|----------|--------------|
|Mejor caso | Θ(n log n) | Siempre se divide, se copia y se recorre cada nivel, aunque el arreglo ya esté ordenado. En ese caso solo bajan el numero de comparaciones, pero no el recorrido. |
| Caso Promedio |	Θ(n log n)| comparar y copiar un int cuesta tiempo constante, y divide la lista entre dos siempre.|
| Peor caso    | Θ(n log n.) |  El peor caso de una fusión ocurre cuando los dos mayores elementos están en mitades distintas. Sin embargo, el numero de recorridos siempre se mantiene |

## Estabilidad

MergeSort es un algoritmo estable. LLas mitades se copian respetando el orden del arreglo original.
Ante un empate, merge usa <= y toma primero el elemento de la izquierda, que estaba antes en el original.
Los elementos de una misma mitad nunca se reordenan entre sí, porque se leen de izquierda a derecha.

Si se cambiara <= por <, los empates tomarían primero el de la derecha y el algoritmo dejaría de ser estable

## Traza Manual [7,2,7,0,4,2]
Regla: se divide cada arreglo en `n / 2` (división entera) hasta llegar a piezas de 1 elemento, que ya están ordenadas. Luego se fusionan de dos en dos, pasando siempre el menor de los dos primeros elementos. Si hay empate (`<=`), pasa el de la izquierda. Primero se procesa toda la mitad izquierda y después la derecha.

### Subdivisiones (en el orden en que ocurren)

| Paso | Arreglo que se divide | Mitad izquierda | Mitad derecha |
|---|---|---|---|
| 1 | [7, 2, 7, 0, 4, 2] | [7, 2, 7] | [0, 4, 2] |
| 2 | [7, 2, 7] | [7] | [2, 7] |
| 3 | [2, 7] | [2] | [7] |
| 4 | [0, 4, 2] | [0] | [4, 2] |
| 5 | [4, 2] | [4] | [2] |

### Resultados intermedios (fusiones en el orden en que ocurren)
| # | Se fusionan | Qué ocurre | Resultado |
|---|---|---|---|
| 1 | [2] y [7] | 2 < 7: sale el 2 y luego el 7 | [2, 7] |
| 2 | [7] y [2, 7] | 7 > 2: sale el 2. Luego 7 = 7: empate, sale el de la izquierda. Sobra el otro 7 | [2, 7, 7] |
| 3 | [4] y [2] | 4 > 2: sale el 2 y luego el 4 | [2, 4] |
| 4 | [0] y [2, 4] | 0 < 2: sale el 0. Sobran 2 y 4 | [0, 2, 4] |
| 5 | [2, 7, 7] y [0, 2, 4] | Ver detalle de la fusión final | [0, 2, 2, 4, 7, 7] |

### Fusión final 
| Comparación | Sale | Arreglo resultante |
|---|---|---|
| 2 y 0 | 0 (derecha) | [0] |
| 2 y 2 | 2 (empate, sale la izquierda) | [0, 2] |
| 7 y 2 | 2 (derecha) | [0, 2, 2] |
| 7 y 4 | 4 (derecha) | [0, 2, 2, 4] |
| La derecha se agotó | se copian los 7 y 7 de la izquierda | [0, 2, 2, 4, 7, 7] |

### Salida final
[0, 2, 2, 4, 7, 7]

Los valores repetidos conservan su orden relativo original, por lo que el algoritmo es estable. Esta traza se verificó ejecutando la implementación real de `mergeSort`.

## Referencias

Oracle. (s. f.). Arrays. En Java Platform, Standard Edition 8 API specification. Recuperado el 21 de noviembre de 2026, de https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html

Sedgewick, R., y Wayne, K. (2022). 2.2 Mergesort [Diapositivas de clase]. COS 226: Algorithms and Data Structures, Princeton University. Recuperado el 21 de noviembre de 2026, de https://www.cs.princeton.edu/courses/archive/spring22/cos226/lectures/22Mergesort.pdf

W3Schools. (s. f.). DSA merge sort. Recuperado el 22 de noviembre de 2026, de https://www.w3schools.com/dsa/dsa_algo_mergesort.php
