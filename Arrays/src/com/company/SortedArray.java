package com.company;

/**
 * Сортированный статический массив (по возрастанию).
 * <p>
 * Любая операция должна гарантировать, что массив, по ее окончании, отстортирован
 */
public class SortedArray extends StaticArray {

    public SortedArray(int[] array) {
        super(array);
        if (!isAscSorted()) {
            super.sort();
        }
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value, 0, array.length) != -1;
    }

    @Override
    public int set(int index, int value) {
        // TODO: присовить значение по индексу
        int temporary = array[index];
        array[index] = value;
        if (!isAscSorted()) {
            super.sort();
        }
        ;
        return temporary;
    }

    @Override
    public int indexOf(int value) {
        return binarySearch(value, 0, array.length - 1);
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        if (!isAscSorted()) {
            super.sort();
        }
        ;
        return -1;
    }


    @Override
    public void sort() {

    }

    @Override
    public void sort(ArraySort sort) {
    }

    private int binarySearch(int value, int left, int right) {
        // TODO: реализовать бинарный поиск
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < value) {
                left = mid + 1;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else if (array[mid] == value) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public SortedArray merge(SortedArray other) {
        // TODO: произвести слиянеие двух сортированных массивов
        int[] summary = new int[array.length + other.array.length];
        System.arraycopy(array, 0, summary, 0, array.length);
        System.arraycopy(other.array, 0, summary, array.length, other.array.length);
        SortedArray finalArray = new SortedArray(summary);
        return finalArray;
    }

    public SortedArray mergeAll(SortedArray... others) {
        // TODO: произвести слиянеие N + 1 сортированных массивов
        SortedArray temporary = others[0];
        for (int i = 1; i < others.length; i++) {
            temporary = temporary.merge(others[i]);
        }

        return temporary;
    }
}
