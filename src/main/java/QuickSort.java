/**
 * Quick Sort: elige un pivote y divide el arreglo en menores/mayores al pivote.
 * Complejidad: O(n log n) promedio | O(n^2) peor caso (arreglo ya ordenado con pivote en extremo)
 */
public class QuickSort {

    /**
     * Ordena un arreglo usando Quick Sort.
     * @param arr arreglo de elementos que implementan Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high]; // Pivote: último elemento
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Colocar pivote en su posición correcta
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
