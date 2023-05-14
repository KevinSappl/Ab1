package ab1.impl.Kraßnitzer_Santner_Sappl;

import ab1.Sorter;

public class SorterImpl implements Sorter {
    private int capacity = -1;
    public SorterImpl() {
        // quick - sort
    }

    public SorterImpl(int capacity) {
        // heap - sort
        this.capacity = capacity;
    }

    @Override
    public void sort(int[] array) {
        if (capacity != -1) {
            if (array.length > capacity) {
                throw new IllegalArgumentException("Array length is greater than capacity");
            }
            heapSort(array);
        } else {
            int index = 0;
            int length = array.length - 1;
            quickSort(array, index, length);
        }
    }

    public void heapSort(int[] array) {
        int length = array.length;

        // max heap
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);

        for (int i = length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    public void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }

    public void quickSort(int[] array, int index, int length) {
        if (index < length) {
            int partition = createPartition(array, index, length);
            quickSort(array, index, partition - 1);
            quickSort(array, partition + 1, length);
        }
    }

    public int createPartition(int[] array, int index, int length) {
        int pivotElement = array[length];
        int i = (index - 1);
        for (int j = index; j < length; j++) {
            if (array[j] < pivotElement) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[length];
        array[length] = temp;
        return i + 1;
    }
}
