/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerc.proyecto.estructuras;

import Objetos.Contacto;
import espol.utilidades.DoubleLinkedList;
import java.io.Serializable;

/**
 *
 * @author Michael
 */
public class Usuario implements Serializable{
    private String user;
    private String password;
    private DoubleLinkedList<Contacto> contactos;

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
        this.contactos=new DoubleLinkedList<>();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DoubleLinkedList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(DoubleLinkedList<Contacto> contactos) {
        this.contactos = contactos;
    }
    
    
    
}
