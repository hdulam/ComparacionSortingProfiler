/**
 * Merge Sort: divide el arreglo a la mitad recursivamente, luego fusiona las mitades ordenadas.
 * Complejidad: O(n log n) en todos los casos
 */
public class MergeSort {

    /**
     * Ordena un arreglo usando Merge Sort.
     * @param arr arreglo de elementos que implementan Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Object[] leftArr  = new Object[n1];
        Object[] rightArr = new Object[n2];

        for (int i = 0; i < n1; i++) leftArr[i]  = arr[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (((T) leftArr[i]).compareTo((T) rightArr[j]) <= 0) {
                arr[k++] = (T) leftArr[i++];
            } else {
                arr[k++] = (T) rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = (T) leftArr[i++];
        while (j < n2) arr[k++] = (T) rightArr[j++];
    }
}
