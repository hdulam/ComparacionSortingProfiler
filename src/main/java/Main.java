import java.io.*;
import java.util.*;

/**
 * Main: genera números aleatorios, los guarda en archivo,
 * los lee y mide el tiempo de cada algoritmo de ordenamiento.
 */
public class Main {

    static final String ARCHIVO = "numeros.txt";

    public static void main(String[] args) throws IOException {

        generarNumeros(3000, ARCHIVO);
        System.out.println("Numeros generados y guardados en " + ARCHIVO);
        Integer[] numerosOriginales = leerNumeros(ARCHIVO);
        System.out.println("Leidos " + numerosOriginales.length + " numeros\n");

        //Medir tiempos con datos DESORDENADOS (escenario promedio)
        System.out.println("=== DATOS DESORDENADOS (escenario promedio) ===");
        medirTodos(numerosOriginales, false);

        //Medir tiempos con datos YA ORDENADOS (mejor escenario)
        System.out.println("\n=== DATOS YA ORDENADOS (mejor escenario) ===");
        medirTodos(numerosOriginales, true);
    }

    //Generar números aleatorios y guardarlos

    static void generarNumeros(int cantidad, String archivo) throws IOException {
        Random rand = new Random();
        PrintWriter writer = new PrintWriter(new FileWriter(archivo));
        for (int i = 0; i < cantidad; i++) {
            writer.println(rand.nextInt(100000));
        }
        writer.close();
    }

    //Leer números del archivo

    static Integer[] leerNumeros(String archivo) throws IOException {
        List<Integer> lista = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = reader.readLine()) != null) {
            linea = linea.trim();
            if (!linea.isEmpty()) {
                lista.add(Integer.parseInt(linea));
            }
        }
        reader.close();
        return lista.toArray(new Integer[0]);
    }

    //Ejecutar todos los algoritmos y mostrar tabla de tiempos

    static void medirTodos(Integer[] original, boolean preOrdenar) {
        int[] tamanos = {10, 100, 500, 1000, 1200, 1600, 1800, 2000, 2500, 3000};

        System.out.printf("%-8s %12s %12s %12s %12s %12s%n",
                "Tamano", "Gnome(us)", "Merge(us)", "Quick(us)", "Radix(us)", "Shell(us)");
        System.out.println("-".repeat(70));

        for (int tam : tamanos) {
            if (tam > original.length) break;

            //Sacar subconjunto del tamaño deseado
            Integer[] sub = Arrays.copyOfRange(original, 0, tam);

            //Pre-ordenar si es el escenario "ya ordenado"
            if (preOrdenar) Arrays.sort(sub);

            long tGnome = medirTiempo("gnome", sub);
            long tMerge = medirTiempo("merge", sub);
            long tQuick = medirTiempo("quick", sub);
            long tRadix = medirTiempo("radix", sub);
            long tShell = medirTiempo("shell", sub);

            System.out.printf("%-8d %12d %12d %12d %12d %12d%n",
                    tam, tGnome, tMerge, tQuick, tRadix, tShell);
        }
    }

    //Medir tiempo de un algoritmo en microsegundos

    static long medirTiempo(String algoritmo, Integer[] arr) {
        // Trabajar con copia para no modificar el arreglo original
        Integer[] copia = Arrays.copyOf(arr, arr.length);

        long inicio = System.nanoTime();

        switch (algoritmo) {
            case "gnome": GnomeSort.sort(copia);  break;
            case "merge": MergeSort.sort(copia);  break;
            case "quick": QuickSort.sort(copia);  break;
            case "radix": RadixSort.sort(copia);  break;
            case "shell": ShellSort.sort(copia);  break;
        }

        long fin = System.nanoTime();
        return (fin - inicio) / 1_000; // convertir nanosegundos a microsegundos
    }
}
