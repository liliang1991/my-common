package common.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DilatationList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 1;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private int size;
    private Object[] elementData;
    public DilatationList() {
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    public void add(Object e) {
        int minCapacity = size + 1;
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
        elementData[size++] = e;
    }

    /*
     扩容
     */
    public void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        //新的扩容数量
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);

    }
   public E get(int index){
        return (E)elementData[index];
   }
    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr<E> implements Iterator<E> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            int i = cursor;
            Object[] elementData = DilatationList.this.elementData;
            cursor = i + 1;
            return (E) elementData[i];
        }
    }

    public static void main(String[] args) {
        DilatationList dilatationList = new DilatationList();
        dilatationList.add("a");
        dilatationList.add("b");
        dilatationList.add("c");
        for (Object object : dilatationList) {
            System.out.println(object);
        }
        System.out.println(dilatationList.size);
        System.out.println(dilatationList.get(2));
    }
}
