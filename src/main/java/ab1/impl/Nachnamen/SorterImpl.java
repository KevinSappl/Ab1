package ab1.impl.Nachnamen;

import ab1.Sorter;

public class SorterImpl implements Sorter {
    // quick-sort
    @Override
    public void sort(int[] array) {
        int index = 0;
        int length = array.length - 1;
        sortArray(array, index, length);
    }
    public int createQuicksort(int[] array, int index, int length){
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

    public void sortArray(int[] array, int index, int length){
        if (index < length) {
            int partition = createQuicksort(array, index, length);
            sortArray(array, index, partition - 1);
            sortArray(array, partition + 1, length);
        }
    }
}
