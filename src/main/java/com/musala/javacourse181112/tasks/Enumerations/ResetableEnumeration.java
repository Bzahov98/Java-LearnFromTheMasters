package com.musala.javacourse181112.tasks.Enumerations;

import com.sun.istack.internal.NotNull;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Normal implementation
 * @param <T>
 */
public class ResetableEnumeration<T> implements Enumeration {

    private Collection<T> c;
    private Iterator<T> i;

    public ResetableEnumeration(@NotNull Collection<T> c) {
        setCollection(c);
    }

    public void zeroColectionIterator(@NotNull Collection<T> c) {
        if (c != null) {
            this.i = c.iterator();
        }
    }

    @Override
    public boolean hasMoreElements() {
        return i.hasNext();
    }

    @Override
    public Object nextElement() {
        return i.next();
    }

    public void setCollection(@NotNull Collection<T> c) {
        this.c = c;
        zeroColectionIterator(c);
    }


    /**
     * Without Constructor
     * @param <T>
     */
    private class ResetableEnumeration2<T> implements Enumeration {
        private Collection<T> c;
        private Iterator<T> i;

        @Override
        public boolean hasMoreElements() throws NullPointerException {
            if (i == null) {
                throw new NullPointerException();
            }
            return i.hasNext();
        }

        @Override
        public T nextElement() throws NullPointerException {
            if (i == null) {
                throw new NullPointerException();
            }
            return i.next();
        }

        public Collection<T> getCollection() {
            return c;
        }

        public void setCollection(@NotNull Collection<T> c) {
            this.c = c;
            zeroIterator(c);
        }

        public Iterator<T> getIterator() {
            return i;
        }

        public void zeroIterator(@NotNull Collection<T> c) {
            if (c != null) {
                this.i = c.iterator();
            }
        }
    }
}