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
public class ContactoEmpresa extends Contacto implements Serializable{
    private LinkedList<String> paginaweb;

    public ContactoEmpresa(LinkedList<String> paginaweb, String nombre, DoubleLinkedList<String> foto, LinkedList<String> direccion, LinkedList<String> emailPersonal, LinkedList<String> numerosTelefonicos, LinkedList<String> redesSociales) {
        super(nombre, foto, direccion, emailPersonal, numerosTelefonicos, redesSociales);
        this.paginaweb = paginaweb;
    }

    public LinkedList<String> getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(LinkedList<String> paginaweb) {
        this.paginaweb = paginaweb;
    }

    
    

   
    
}
