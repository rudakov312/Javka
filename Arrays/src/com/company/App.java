package com.company;

import static com.company.ArraySort.BUBBLE;
import static com.company.ArraySort.INSERTION;
import static com.company.ArraySort.SELECTION;


public class App {

    public static void main(String[] args) {
        int[] a = new int[]{9, 3, 1, 5, 5, 6, 7, 10};
        int[] b = new int[]{3, 5};
        int[] c = new int[]{11, 32, 13, 55, 63, 61, 7, 0};
        int[] d = new int[]{-1, 3, 1, -5, -6, -6, -7, 0};

        var staticArray = new StaticArray(a);
//        System.out.println(staticArray);
//        System.out.println(staticArray.set(0,3));
//        System.out.println(staticArray);
//        staticArray.lastIndexOf(1);
//        System.out.println("-------");
//        Array subarr = staticArray.subArray(3,6);
//        System.out.println(subarr);
//        System.out.println(staticArray);
//        System.out.println(staticArray.isAscSorted());
//        staticArray.sort(SELECTION);
//        System.out.println(staticArray);
//        System.out.println(staticArray.isAscSorted());


//
//        System.out.println(staticArray);// до сортировки
//        var sortedArray = new SortedArray(a);//создаем экземпляр массива типа sorted Array
//        SortedArray arr2 = new SortedArray(b);
//        SortedArray arr3 = new SortedArray(c);
//        SortedArray arr4 = new SortedArray(d);
//        SortedArray farr = sortedArray.merge(arr2);
//        System.out.println(farr);//печатаем отсортированный массив
//        array.

//        System.out.println(sortedArray);//печатаем отсортированный массив
//        System.out.println(sortedArray.set(0,3));//печатаем значение замененного элемента
//        System.out.println(sortedArray.lastIndexOf(5));//печатаем значение замененного элемента
//        System.out.println(sortedArray.contains(6));//печатаем значение замененного элемента
//        System.out.println(sortedArray);//печатаем отсортированный массив
//        System.out.println(sortedArray);//печатаем отсортированный массив


        var dynamicArray = new DynamicArray(a);
//        System.out.println(dynamicArray.removeAll(b));
//        dynamicArray.add(3,3);
//        dynamicArray.add(5,23);

//        Array st=staticArray.subArray(3,6);
//        var arr1=new DynamicArray(a);
//        arr1.addAll(st);
//        System.out.println((arr1));


//        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray.removeAll(b));
//        System.out.println(dynamicArray);
    }
}
