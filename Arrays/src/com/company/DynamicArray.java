package com.company;

import java.util.Arrays;

/**
 * Динамический массив
 */
public class DynamicArray extends StaticArray implements Dynamic {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_FACTOR = 1.5f;

    /**
     * текущая длина массива
     */
    private int size;

    public DynamicArray() {
        super(new int[DEFAULT_CAPACITY]);
        size = 0;
    }

    public DynamicArray(int[] array) {
        super(array);
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    // TODO: добавить элемент в конец массива
    public void add(int value) {
        int[] temporaryArray = new int[size + 1];
        if (size + 1 > array.length) {
            temporaryArray = new int[(int) (array.length * GROW_FACTOR)];
            System.out.println("Capacity added!" + array.length);
        }
        System.arraycopy(array, 0, temporaryArray, 0, size);
        temporaryArray[size] = value;
        size++;
        array = temporaryArray;
    }

    @Override
    public void add(int index, int value) {
        // TODO: добавить элемент в указанный индекс (остальные сдвинуть вправо)
        int[] temporaryArray = new int[size + 1];
        if (size + 1 > array.length) {
            temporaryArray = new int[(int) (array.length * GROW_FACTOR)];
            System.out.println("Capacity added!" + array.length);
        }
        System.arraycopy(array, 0, temporaryArray, 0, index);
        temporaryArray[index] = value;
        System.arraycopy(array, index + 1, temporaryArray, index + 1, size - index - 1);
        size++;
        array = temporaryArray;
    }

    @Override
    public void addAll(Array array) {
        // TODO: конкатенация с переданным массивом
        int[] result = new int[size + array.size()];
        System.arraycopy(this.array, 0, result, 0, size);
        for (int i = size, j = 0; i < result.length; i++) {
            result[i] = array.get(j);
            j++;
        }
        size += array.size();
        this.array = result;
    }


    @Override
    public boolean remove(int value) {
        // TODO: удалить элемент из массива
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == value)
                count++;
        }
        while (count > 0) {
            int[] temporaryArray = new int[size - 1];
            if (this.indexOf(value) == -1) {
                System.out.print("Value not found!\n");
                return false;
            }
            if (array[this.indexOf(value)] == value) {
                System.arraycopy(array, 0, temporaryArray, 0, this.indexOf(value));
                System.arraycopy(array, this.indexOf(value) + 1, temporaryArray, this.indexOf(value), size - this.indexOf(value) - 1);
                array = temporaryArray;
            }
            size--;
            count--;
        }
        return true;
    }

    @Override
    public boolean removeAll(int[] values) {
        for (int current : values) {
            if (!this.contains(current)) {
                System.out.println("Invalid values!");
                return false;
            }
        }
        for (int current : values) {
            if (this.remove(current)) {
                this.remove(current);
            }
        }
        return true;
    }


    @Override
    public int removeOf(int index) {
        // TODO: удалить элемент по индексу
        int[] temporaryArray = new int[size - 1];
        if (index > 0) {
            System.arraycopy(array, 0, temporaryArray, 0, index);
            System.arraycopy(array, index + 1, temporaryArray, index, size - index - 1);
            array = temporaryArray;
            return index;
        } else {
            return -1;
        }

    }
}

