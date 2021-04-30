package com.company;

import java.util.Arrays;

/**
 * Обертка над статическим массивом
 */
public class StaticArray implements Array {

    protected int[] array;

    public StaticArray(int[] a) {
        this.array = new int[a.length];
        System.arraycopy(a, 0, this.array, 0, a.length);
    }


    @Override
    public int size() {
        // TODO: вернуть длину массива
        return array.length;
    }

    @Override
    public boolean contains(int value) {
        // TODO: проверить, что элемент есть в массиве
        for (int current : array) {
            if (current == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        // TODO: получить элемент по индексу
        return array[index];
    }

    @Override
    public int set(int index, int value) {
        // TODO: присвоить значение по индексу. Вернуть значение элемента, которое заменили
        int temporary = array[index];
        array[index] = value;
        System.out.println(array[index]);
        return temporary;
    }

    @Override
    public int indexOf(int value) {
        // TODO: получить индекс первого подходящего элемента
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    @Override
    public void reverse() {
        // TODO: перевернуть массив
        for (int i = 0; i < array.length / 2; i++) {
            int temporary = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temporary;
        }
    }

    @Override
    public Array subArray(int fromIndex, int toIndex) {
        // TODO: вернуть подмассив, начиная с индекса fromIndex включительно и заканчивая индексом toIndex невкоючительно
        int[] temporaryArray = new int[toIndex - fromIndex];
        StaticArray temporary = new StaticArray(temporaryArray);
        int j = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            temporary.set(j, array[i]);
            j++;
        }
        return temporary;
    }

    @Override
    public void sort() {
        bubbleSort();
    }

    @Override
    public void sort(ArraySort sort) {
        switch (sort) {
            case BUBBLE:
                bubbleSort();
                break;
            case INSERTION:
                insertionSort();
            case SELECTION:
                selectionSort();
            case MERGE:
                mergeSort();
            case QUICK:
                quickSort();
            default:
                sort();
        }
    }

    @Override
    public String toString() {
        // TODO: вернуть массив в виде строки. Например, [3, 4, 6, -2]
        String str = Arrays.toString(array);
        return str;

    }

    private void bubbleSort() {
        // TODO: сортировка пузырьком (по возрастанию)
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temporary = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                }
    }

    private void insertionSort() {
        //TODO*: сортировка вставками (по возрастанию)
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    private void selectionSort() {
        //TODO*: сортировка выбором (по возрастанию)
        {
            for (int i = 0; i < array.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < array.length; j++)
                    if (array[j] < array[min])
                        min = j;

                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }

    private void mergeSort() {
        //TODO**: сортировка слиянием (по возрастанию)

    }

    private void quickSort() {
        //TODO**: быстрая сортировка (по возрастанию)
    }

    public boolean isAscSorted() {
        // TODO: проверить, что массив отсортирован по возрастанию
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
