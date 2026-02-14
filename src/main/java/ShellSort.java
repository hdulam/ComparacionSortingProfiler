/**
 * Shell Sort: mejora de Insertion Sort usando intervalos (gaps) decrecientes.
 * Sort elegido por la pareja — es eficiente, simple y usa la interfaz Comparable.
 * Complejidad: O(n log^2 n) con secuencia de Knuth
 */
public class ShellSort {

    /**
     * Ordena un arreglo usando Shell Sort.
     * @param arr arreglo de elementos que implementan Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;

        // Calcular gap inicial con secuencia de Knuth: 1, 4, 13, 40, 121...
        int gap = 1;
        while (gap < n / 3) {
            gap = gap * 3 + 1;
        }

        // Reducir gap en cada iteración hasta llegar a 1
        while (gap >= 1) {
            for (int i = gap; i < n; i++) {
                T temp = arr[i];
                int j = i;
                // Insertar arr[i] en la posición correcta dentro del subgrupo
                while (j >= gap && arr[j - gap].compareTo(temp) > 0) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 3;
        }
    }
}
