/**
 * Gnome Sort: compara elementos adyacentes y los intercambia si están fuera de orden.
 * Complejidad: O(n^2) promedio y peor caso | O(n) mejor caso (ya ordenado)
 */
public class GnomeSort {

    /**
     * Ordena un arreglo usando Gnome Sort.
     * @param arr arreglo de elementos que implementan Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0) {
                index++;
            } else if (arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                // Intercambiar elementos adyacentes
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}
