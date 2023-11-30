/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.utilidades;

/**
 *
 * @author sebas
 */
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author sebas
 */
public class ArrayList<E> implements List <E>, Iterable<E>, Serializable {
    private E[] arreglo;
    private int capacidad=100;
    private int tam;
    //private static final long serialVersionUID = 8799656478674716638L;
    
    
    public ArrayList(){
        arreglo=(E[]) new Object[capacidad];
    }
    public ArrayList(int capacidad){
        this.capacidad = capacidad;
        arreglo =  (E[]) new Object[capacidad];
        tam = 0;
    }
    private void crecerArreglo(){
        capacidad = capacidad*2;
        E[] arreglo2 =  (E[]) new Object[capacidad];
        for (int i=0; i<tam; i++){
            arreglo2[i] = arreglo[i];
        }
        arreglo = arreglo2;
    }

    @Override
    public boolean addFirst(E e) {
        if (e==null){
            return false;
        }
        if (tam == 0){
            arreglo[0] = e;
            tam = 1;
            return true;
        }
        if (tam == capacidad){
            crecerArreglo();
        }
        for (int i=tam-1; i>0; i--){
            arreglo[i+1] = arreglo[i];
        }
        arreglo[0] = e;
        tam++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if(e==null){
            return false;
        }
        if (tam == capacidad){
            crecerArreglo();
        }
        if (arreglo[tam]==null){
            arreglo[tam]=e;
            tam++;
        }

        
        return true;
    }

    @Override
    public E getFirst() {
        if (isEmpty()){
            return null;
        }
        return arreglo[0];
    }

    @Override
    public E getLast() {
        if (isEmpty()){
            return null;
        }
        return arreglo[tam-1];
        }

    @Override
    public int indexOf(E e) {
        if (isEmpty()){
            return -1;
        }
        if (e==null){
            return -1;
            
        }
        for (int i =0; i<tam;i++){
            if (arreglo[i]==e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return tam;
    }

    @Override
    public boolean removeLast() {
       if (isEmpty()){
            return false;
        }
        E[] arreglo2 =  (E[]) new Object[capacidad];
        for (int i =0;i<tam-1;i++){
            arreglo2[i]=arreglo[i];
        }
        arreglo=arreglo2;
        tam--;
        return true;
        }

    @Override
    public boolean removeFirst() {
        if (isEmpty()){
            return false;
        }
        E[] arreglo2 =  (E[]) new Object[capacidad];
        for(int i=0;i<tam-1;i++){
            arreglo2[i]=arreglo[i+1];
        }
        arreglo=arreglo2;
        tam--;
        return true;
    }

    @Override
    public boolean insert(int index, E e) {
        if (index<0 || index>tam-1){
            return false;
        }
        if (isEmpty()){
            return false;
        }
        if (e==null){
            return false;
        }
        for(int i=index;i<tam;i++){
            arreglo[i+1]=arreglo[i];
        }
        arreglo[index]=e;
        tam++;
     
    
        return true;
    }

    @Override
    public boolean set(int index, E e) {
        if(e==null){
            return false;
        }
        if (index<0 || index>tam-1){
            System.out.println("indice no válido");
        }
        arreglo[index]=e;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return tam==0;
    }

    @Override
    public E get(int index) {
        if (index<0 || index>tam-1){
            System.out.println("indice no válido");
        }
        return arreglo[index];
    }

    @Override
    public boolean contains(E e) {
       if (e==null){
            return false;
        }
        for (int i=0;i<tam;i++){
            if (Objects.equals(arreglo[i],e)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        if (index<0 || index>tam-1){
            System.out.println("indice no válido");
        }
        for(int i=index;i<tam-1;i++){
          arreglo[i]=arreglo[i+1]; 
        }
        tam--;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> itera = new Iterator(){
            int i=0;
            @Override
            public boolean hasNext() {
                return i<tam && tam >=0;
            }

            @Override
            public Object next() {
                return arreglo[i++];
            }
            
        };
        return itera;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < (tam-1); i++){
            sb.append(this.arreglo[i]).append(",");
        }
        sb.append(this.arreglo[tam]);
        return sb.toString();
    }
    
    public void concatenar(List<E>l2){
        for(int i=0; i<l2.size(); i++){
            this.addLast(l2.get(i));
        }
    
    }
    
 
   


}
