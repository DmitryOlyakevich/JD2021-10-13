package by.it.antipov.jd01_11;

import java.util.*;

public class ListB <T> implements List<T> {
    private T [] elements = (T[]) new Object[0];
    private int size = 0;
    @Override
    public boolean add(T t) {
        if (size == elements.length){elements= Arrays.copyOf(elements,size*3/2+1);}
        elements[size]=t;
        size++;
        return true;
    }
    @Override
    public T get(int index) {
        return elements[index];
    }
    @Override
    public void add(int index, T element) {
        elements= Arrays.copyOf(elements,size+1);
        for (int i = size-1; i >= index; i--) {
            elements[i+1]=elements[i];
        }
        elements[index]=element;
        size++;
    }
    @Override
    public boolean remove(Object o) {
   /*    int removeIndex = -1;
        for (int i = 0; i < size ; i++) {
            if (elements[i].equals(o)) { removeIndex=i;}}
        if (removeIndex==-1) {return false;}
        for (int j =removeIndex; j < size-1; j++) {
            elements[j]=elements[j+1];
        }
        elements=Arrays.copyOf(elements,size-1);
        size--;*/
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
       Object [] elements2 =c.toArray();
        elements= Arrays.copyOf(elements,size+c.size());
        int j=0;
        for (int i = size; i < elements.length; i++,j++) {
            elements[i]= (T) elements2[j];
        }
        size=size+c.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }



    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }



    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }



    @Override
    public T set(int index, T element) {
        T oldElement=elements[index];
        elements[index]=element;
        return oldElement;
    }


    @Override
    public T remove(int index) {
        T removedElement = elements[index];
        for (int j =index; j < size-1; j++) {
            elements[j]=elements[j+1];
        }
        elements=Arrays.copyOf(elements,size-1);
        size--;
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder out=new StringBuilder();
        out.append("[");
        String delimiter ="";
        for (int j = 0; j <size ; j++) {
            {out.append(delimiter);
                out.append(elements[j]);
                delimiter=", ";
            }
        }
        out.append("]");
        return out.toString();
    }
}


