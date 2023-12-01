/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import espol.utilidades.ArrayList;
import espol.utilidades.DoubleLinkedList;
import espol.utilidades.LinkedList;
import java.util.Date;
import espol.utilidades.List;
import java.io.Serializable;
/**
 *
 * @author Lenovo
 */
public class Contacto implements Serializable{
    private String nombre;
    private DoubleLinkedList<String> foto;
    private LinkedList<String> direccion;
    private LinkedList<String> emailPersonal;
    private LinkedList<String> numerosTelefonicos;
    private LinkedList<String> redesSociales;
    private LinkedList<Contacto> contactosRelacionados;

    public Contacto(String nombre, DoubleLinkedList<String> foto, LinkedList<String> direccion, LinkedList<String> emailPersonal, LinkedList<String> numerosTelefonicos, LinkedList<String> redesSociales) {
        this.nombre = nombre;
        this.foto = foto;
        this.direccion = direccion;
        this.emailPersonal = emailPersonal;
        this.numerosTelefonicos = numerosTelefonicos;
        this.redesSociales = redesSociales;
        this.contactosRelacionados = new LinkedList<>() ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DoubleLinkedList<String> getFoto() {
        return foto;
    }

    public void setFoto(DoubleLinkedList<String> foto) {
        this.foto = foto;
    }

    public LinkedList<String> getDireccion() {
        return direccion;
    }

    public void setDireccion(LinkedList<String> direccion) {
        this.direccion = direccion;
    }

    public LinkedList<String> getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(LinkedList<String> emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public LinkedList<String> getNumerosTelefonicos() {
        return numerosTelefonicos;
    }

    public void setNumerosTelefonicos(LinkedList<String> numerosTelefonicos) {
        this.numerosTelefonicos = numerosTelefonicos;
    }

    public LinkedList<String> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(LinkedList<String> redesSociales) {
        this.redesSociales = redesSociales;
    }

    public LinkedList<Contacto> getContactosRelacionados() {
        return contactosRelacionados;
    }

    public void setContactosRelacionados(LinkedList<Contacto> contactosRelacionados) {
        this.contactosRelacionados = contactosRelacionados;
    }

    
    

}
