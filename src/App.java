import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
     
        // instanciar objetos de las clases necesarias
        Generador generador = new Generador();
        Benchmark benchmark = new Benchmark();
        MetodosSort algoritmo = new MetodosSort();
       
        /*
        * 1 = List <List<Integer>> listas = List.of(lista,1lista2,lista2);
        * 2 = List<Integer>[] listas = new List<Integer>[]{lista1};
        */ 

        // Generar las muestras base con los tres lengths exigidos
        int[] lista1 = generador.generar(10000);
        int[] lista2 = generador.generar(50000);
        int[] lista3 = generador.generar(100000);

        /* Generar copia de los arreglos para cada caso
        *  List<Integer> list2c1 = list2.clone();
        *  List<Integer> list2cri1 = Arrays.copyOf(list2,list2.size());
        */

        // V1 Bubble Sort
        int[] v1s1 = lista1.clone();
        int[] v1s2 = lista2.clone();
        int[] v1s3 = lista3.clone();

        // V2 Merge Sort
        int[] v2s1 = lista1.clone();
        int[] v2s2 = lista2.clone();
        int[] v2s3 = lista3.clone();

        // V3 Array.sort
        int[] v3s1 = lista1.clone();
        int[] v3s2 = lista2.clone();
        int[] v3s3 = lista3.clone();

        // V4 Array.sort con COmparator
        // tipo de dato: <Integer>
        Integer[] v4s1 = new Integer[lista1.length];
        for (int i = 0; i < lista1.length; i++) {   
             v4s1[i] = lista1[i];                                
        }
        Integer[] v4s2 = new Integer[lista2.length];
        for (int i = 0; i < lista2.length; i++) {   
             v4s2[i] = lista2[i];    
        }
        Integer[] v4s3 = new Integer[lista3.length];
        for (int i = 0; i < lista3.length; i++) {   
             v4s3[i] = lista3[i];    
        }

        //Ordenamiento y mediciones (benchkmark) dentro de Runnable
        Results rm1s1 = Benchmark.medir( () -> algoritmo.bubbleSort(v1s1), "Burbuja", "10.000");
        Results rm1s2 = Benchmark.medir( () -> algoritmo.bubbleSort(v1s2), "Burbuja", "50.000");
        Results rm1s3 = Benchmark.medir( () -> algoritmo.bubbleSort(v1s3), "Burbuja", "100.000");

        Results rm2s1 = Benchmark.medir( () -> algoritmo.mergeSort(v2s1), "Mergesort", "10.000");
        Results rm2s2 = Benchmark.medir( () -> algoritmo.mergeSort(v2s2), "Mergesort", "50.000");
        Results rm2s3 = Benchmark.medir( () -> algoritmo.mergeSort(v2s3), "Mergesort", "100.000");

        Results rm3s1 = Benchmark.medir( () -> Arrays.sort(v3s1), "Arraysort", "10.000");
        Results rm3s2 = Benchmark.medir( () -> Arrays.sort(v3s2), "Arraysort", "50.000");
        Results rm3s3 = Benchmark.medir( () -> Arrays.sort(v3s3), "Arraysort", "100.000");

        Results rm4s1 = Benchmark.medir( () -> Arrays.sort(v4s1, (a,b) -> Integer.compare(a,b)), "Arraysort con Comparator", "10.000");
        Results rm4s2 = Benchmark.medir( () -> Arrays.sort(v4s2, (a,b) -> Integer.compare(a,b)), "Arraysort con Comparator", "50.000");
        Results rm4s3 = Benchmark.medir( () -> Arrays.sort(v4s3, (a,b) -> Integer.compare(a,b)), "Arraysort con Comparator", "100.000");


        // Imprimir cada uno de los resultados
        /*System.out.println("Java: " + System.getProperty("java.version"));
          System.out.println("SO: " + System.getProperty("os.name") + " " + System.getProperty("os.arch"));
          System.out.println("Procesador (núcleos lógicos): " + Runtime.getRuntime().availableProcessors());
        */
        System.out.println(rm1s1);
        System.out.println(rm1s2);
        System.out.println(rm1s3);
        System.out.println(rm2s1);
        System.out.println(rm2s2);
        System.out.println(rm2s3);
        System.out.println(rm3s1);
        System.out.println(rm3s2);
        System.out.println(rm3s3);
        System.out.println(rm4s1);
        System.out.println(rm4s2);
        System.out.println(rm4s3);

        /*  long nanoTime = System.nanoTime();
            long currentTimeMillis = System.currentTimeMillis();
            System.out.println("Nano Time: " + nanoTime);
            System.out.println("Current Time" + currentTimeMillis);
        *?

        /*  operaciones para guardar funciones dentro de variables
            Se guarda en una variable una funcion a ejecutar (lambda)
            La funcion solo se ejecuta no puede retornar nada
            Runnable x = () -> System.out.println("Ejectuando Tarea");
            Callable <T> X es para que esa funcion retorne algo
            System.out.println("Ejecucion de la funcion Runnable");
            x.run();
        */

        /*  mas lineas de codigo en la variable

            Runnable y = () -> {
                System.out.println("Ejectuando Tarea 1");
                System.out.println("Ejectuando Tarea 2");
            };
            System.out.println("Ejecucion de la funcion Runnable");
            y.run();
        */

        //List<Integer> list = new ArrayList<>();
        //MetodosOrd m0 = new MetodosOrd();
       
        //m0.burbuja(list); //ejecucion directa de la funcion
        
        //Runnable burbujaOrden = () -> m0.burbuja(list); //se guarda la funcion dentro de variable pero no se ejecuta hasta llamarla
        //burbujaOrden.run();

        
        //List<Integer> lista = g.generate(100000);
        //System.out.println(lista);

        //Runnable x = () ->  g.generate(100);
        // Toda la funcion en x puede ser ingresada como parametro en el metodo .medir()
        // Results benGenList = b.medir(x, "Generacion de Listado", "100");
        //System.out.println(benGenList);

        //Los 3 arreglos bases
        // 10000
        //List<Integer> bubblesort = g.generate(100000);
        // 50000
        //List<Integer> selectionsort = g.generate(100000);
        // 100000
        //List<Integer> insertionsort = g.generate(100000);










}

}
