package study.Dynamic_Programming.LIS;

import java.util.List;

public class Vector<T> extends java.util.Vector<T> {
    public Vector() {
        super();
    }

    public void setSize(int size, T value) {
        super.setSize(size);
        for (int i = 0; i < size; i++) {
            this.set(i, value);
        }
    }

    public void addElements(T[] array) {
        for (int i = 0; i < array.length; i++) {
            this.addElement(array[i]);
        }
    }
}
