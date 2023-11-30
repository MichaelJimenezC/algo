/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package espol.utilidades;

/**
 *
 * @author sebas
 */
public interface List<E> {
    
    boolean addFirst(E e);
    boolean addLast(E e);
    E getFirst();
    E getLast();
    int indexOf(E e);
    int size();
    boolean removeLast();
    boolean removeFirst();
    boolean insert(int index, E e);
    boolean set(int index, E e);
    boolean isEmpty();
    E get(int index);
    boolean contains(E e);
    boolean remove(int index);   
    
    
    
}
