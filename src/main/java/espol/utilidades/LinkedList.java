/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.utilidades;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
/**
 *
 * @author Lenovo
 */
public class LinkedList<E> implements List<E>, Iterable<E>, Serializable {

    private Node<E> first, last;

    public LinkedList() {
        first = last = null;
    }

    private Node<E> getPrevious(Node<E> nodo) {
        if (nodo == first) {
            return null;
        }
        for (Node<E> i = first; i != null; i = i.getNext()) {
            if (i.getNext() == nodo) {
                return i;
            }
        }
        return null;
    }
    
    @Override
    public boolean addFirst(E element) {
        Node<E> node = new Node<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            first = last = node;
        } else {
            node.setNext(first);
            first = node;
        }
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node<E> node = new Node<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            first = last = node;
        } else {
            last.setNext(node);
            last = node;
        }
        return true;
    }

    @Override
    public E getFirst() {
        return isEmpty() ? null : first.getContent();
    }

    @Override
    public E getLast() {
        return isEmpty() ? null : last.getContent();
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            return -1;
        }

        int index = 0;
        for (Node<E> node = first; node != null; node = node.getNext()) {
            if (node.getContent().equals(element)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        int count = 0;
        Node<E> node;
        for (node = this.first; node != null; node = node.getNext()) {
            count++;
        }
        return count;
    }

    @Override
    public boolean removeLast() {
        if (isEmpty()) {
            return false;
        } else if (first == last) {
            first = last = null;
        } else {
            Node<E> current = first;
            while (current.getNext() != last) {
                current = current.getNext();
            }
            last = current;
            last.setNext(null);
        }
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        } else if (first == last) {
            first = last = null;
        } else {
            Node<E> tmp = first;
            first = first.getNext();
            tmp.setNext(null);
        }
        return true;
    }

    @Override
    public boolean insert(int index, E element) {
        if (element == null || index < 0 || index >= this.size()) {
            return false;
        } else if (index == 0) {
            addFirst(element);
            return true;
        } else if (index == this.size() - 1) {
            addLast(element);
            return true;
        }

        int i = 0;
        Node<E> node = new Node<>(element);
        for (Node<E> current = first; current != null; current = current.getNext()) {
            if (index - 1 == i) {
                node.setNext(current.getNext());
                current.setNext(node);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        int j = 0;
        for (Node<E> current = first; current != null; current = current.getNext()) {
            if (j == index) {
                return current.getContent();
            }
            j++;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    @Override
    public boolean contains(E element) {
        if (element == null || isEmpty()) {
            return false;
        }
        for (Node<E> current = first; current != null; current = current.getNext()) {
            if (current.getContent().equals(element)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean set(int index, E element) {
        if (element == null || index < 0 || index >= this.size()) {
            return false;
        }

        int j = 0;
        for (Node<E> current = first; current != null; current = current.getNext()) {
            if (j == index) {
                current.setContent(element);
                return true;
            }
            j++;
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= this.size()) {
            return false;
        } else if (index == 0) {
            removeFirst();
            return true;
        } else if (index == this.size() - 1) {
            removeLast();
            return true;
        }

        Node<E> prev = first;
        for (int i = 1; i < index; i++) {
            prev = prev.getNext();
        }

        Node<E> current = prev.getNext();
        prev.setNext(current.getNext());
        current.setNext(null);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isEmpty()) {
            return "[]";
        }
        s.append("[");

        for (Node<E> p = this.first; p != null; p = p.getNext()) {
            if (p != this.last) {
                s.append(p.getContent()).append(",");
            } else {
                s.append(p.getContent()).append("]");
            }
        }
        return s.toString();
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private Node<E> cursor = first;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E tmp = cursor.getContent();
                cursor = cursor.getNext();
                return tmp;
            }
        };

        return it;
    }
    
}