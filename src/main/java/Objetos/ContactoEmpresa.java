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
    private String paginaweb;

    public ContactoEmpresa(String paginaweb, String nombre, DoubleLinkedList foto, LinkedList direccion, LinkedList emailPersonal, LinkedList numerosTelefonicos, LinkedList redesSociales) {
        super(nombre, foto, direccion, emailPersonal, numerosTelefonicos, redesSociales);
        this.paginaweb = paginaweb;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

   
    
}
