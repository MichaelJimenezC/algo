/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import espol.utilidades.DoubleLinkedList;
import espol.utilidades.LinkedList;
import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class ContactoPersona extends Contacto implements Serializable{
        private String apellido;
        private String fechaCumpleanos;

    public ContactoPersona(String apellido, String fechaCumpleanos, String nombre, DoubleLinkedList<String> foto, LinkedList<String> direccion, LinkedList<String> emailPersonal, LinkedList<String> numerosTelefonicos, LinkedList<String> redesSociales) {
        super(nombre, foto, direccion, emailPersonal, numerosTelefonicos, redesSociales);
        this.apellido = apellido;
        this.fechaCumpleanos = fechaCumpleanos;
    }

    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaCumpleanos() {
        return fechaCumpleanos;
    }

    public void setFechaCumpleanos(String fechaCumpleanos) {
        this.fechaCumpleanos = fechaCumpleanos;
    }
    
       
        
        
}
