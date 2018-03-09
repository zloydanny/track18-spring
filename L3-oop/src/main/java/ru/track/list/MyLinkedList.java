package ru.track.list;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 * Односвязный список
 */
public class MyLinkedList extends List {

    /**
     * private - используется для сокрытия этого класса от других.
     * Класс доступен только изнутри того, где он объявлен
     * <p>
     * static - позволяет использовать Node без создания экземпляра внешнего класса
     */


    private Node headNode;
    private Node lastNode;



    private static class Node {
        Node prev;
        Node next;
        int val;

        Node(Node prev, Node next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    @Override
    void add(int item) {

        if (headNode == null) {
            lastNode = headNode = new Node(null, null, item);
        } else {
            lastNode.next = new Node(lastNode, null, item);
            lastNode = lastNode.next;
        }

        sizeNum++;

    }

    @Override
    int remove(int idx) throws NoSuchElementException {

        if ((idx < 0) || (idx >= sizeNum)){
            throw new NoSuchElementException();
        }

        Node tmp;

        /**Садимся в ноду которую нам нужно удалить. Записываем ее в tmp**/
        if (idx == sizeNum - 1){
            tmp = lastNode;
            idx = 0;
            } else {
            tmp = headNode;
            }

            while(idx != 0) {
                tmp = tmp.next;
                idx--;
            }

        /**Вырезаем ноду из списка. На ноду больше не ссылаемся, она убивается мусорщиком.**/
            if (tmp.prev != null) {
                tmp.prev.next = tmp.next;
            }else {
                headNode = tmp.next;
            }

            if (tmp.next != null) {
                tmp.next.prev = tmp.prev;
            } else {
                lastNode = tmp.prev;
            }

            sizeNum--;

        return tmp.val;

    }

    //FIXME: Попробовать объединить remove и get;

    @Override
    int get(int idx) throws NoSuchElementException {

        if ((idx < 0) || (idx >= sizeNum)){
            throw new NoSuchElementException();
        }

        Node tmp;

        if (idx == sizeNum - 1){
            tmp = lastNode;
            idx = 0;
        } else {
            tmp = headNode;
        }

        while(idx != 0) {
            tmp = tmp.next;
            idx--;
        }

        return tmp.val;
    }


}
