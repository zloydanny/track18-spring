package ru.track.list;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 *
 * Должен иметь 2 конструктора
 * - без аргументов - создает внутренний массив дефолтного размера на ваш выбор
 * - с аргументом - начальный размер массива
 */
public class MyArrayList extends List {

    private int[] list;
    private static final int defaultCapacity = 10;


    public MyArrayList() {
        list = new int[defaultCapacity];
        sizeNum = 0;
    }

    public MyArrayList(int capacity) {
        list = new int[capacity];
        sizeNum = 0;
    }

    @Override
    void add(int item) {
        if (sizeNum == list.length){
            int[] tmp = new int[list.length + defaultCapacity];
            System.arraycopy(list, 0, tmp, 0, list.length);
            list = tmp;
            }

        list[sizeNum++] = item;

    }

    @Override
    int remove(int idx) throws NoSuchElementException {
        if ((idx < 0) || (idx >= sizeNum)){
            throw new NoSuchElementException();
        }

        int removed = list[idx];

        int[] tmp = new int[list.length];
        System.arraycopy(list, 0, tmp, 0, idx);
        System.arraycopy(list, idx + 1, tmp, idx, sizeNum - idx - 1);
        list = tmp;
        sizeNum--;

        return removed;
    }

    //FIXME: Попробовать объединить remove и get;

    @Override
    int get(int idx) throws NoSuchElementException {
        if ((idx < 0) || (idx >= sizeNum)){
            throw new NoSuchElementException();
        }
        return list[idx];
    }


}
