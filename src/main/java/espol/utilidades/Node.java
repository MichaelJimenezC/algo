/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.utilidades;

/**
 *
 * @author Lenovo
 */
public class Node<E> {

    private E content;
    private Node<E> next;

    public Node(E data) {
        this.content = data;
        this.next = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E data) {
        this.content = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
