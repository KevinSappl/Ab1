package ab1.impl.Nachnamen;

import ab1.Ab1;
import ab1.Heap;
import ab1.SortedList;
import ab1.Sorter;

public class Ab1Impl implements Ab1 {

    @Override
    public SortedList newSortedList() {
        // Ihre Implementierung
        return new SortedListImpl();
    }

    @Override
    public Sorter newQuickSort() {
        // Ihre Implementierung
        return null;
    }

    @Override
    public Heap newHeap(int capacity) {
        // Ihre Implementierung
        return new HeapImpl(capacity);
    }

    @Override
    public Sorter newHeapSort(int capacity) {
        // Ihre Implementierung
        return null;
    }

}
