package ab1.impl.Nachnamen;

import ab1.Heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapImpl implements Heap {
    private ArrayList<Integer> heap;
    private int capacity;
    public HeapImpl(int capacity) {
        this.capacity = capacity;
        this.heap = new ArrayList<>();
    }

    @Override
    public void clear() {
        heap.clear();
    }

    @Override
    public void add(int key) throws IndexOutOfBoundsException {
        if(heap.size()>=capacity){
            throw new IndexOutOfBoundsException();
        }
        heap.add(key);
        bubbleUp(heap.size()-1);
    }

    @Override
    public int removeMax() throws NoSuchElementException {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }
        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            bubbleDown(0);
        }
        return max;
    }

    @Override
    public int max() throws NoSuchElementException {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.get(0);
    }

    @Override
    public int size() {
        return heap.size();
    }
    //Helper Classes
    private void bubbleDown(int index) {
        int largestChildIndex = index;
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(largestChildIndex)) {
                largestChildIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largestChildIndex)) {
                largestChildIndex = rightChildIndex;
            }
            if (largestChildIndex == index) {
                break;
            }
            swap(index, largestChildIndex);
            index = largestChildIndex;
        }
    }
    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) <= heap.get(parentIndex)) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }
    private void swap(int i, int j) {
        Integer temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    //
}
