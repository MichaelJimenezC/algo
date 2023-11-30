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
    private DoubleLinkedList foto;
    private LinkedList direccion;
    private LinkedList emailPersonal;
    private LinkedList numerosTelefonicos;
    private LinkedList redesSociales;
    private LinkedList contactosRelacionados;

    public Contacto(String nombre, DoubleLinkedList foto, LinkedList direccion, LinkedList emailPersonal, LinkedList numerosTelefonicos, LinkedList redesSociales ) {
        this.nombre = nombre;
        this.foto = foto;
        this.direccion = direccion;
        this.emailPersonal = emailPersonal;
        this.numerosTelefonicos = numerosTelefonicos;
        this.redesSociales = redesSociales;
        this.contactosRelacionados = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DoubleLinkedList getFoto() {
        return foto;
    }

    public void setFoto(DoubleLinkedList foto) {
        this.foto = foto;
    }

    public LinkedList getDireccion() {
        return direccion;
    }

    public void setDireccion(LinkedList direccion) {
        this.direccion = direccion;
    }

    public LinkedList getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(LinkedList emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public LinkedList getNumerosTelefonicos() {
        return numerosTelefonicos;
    }

    public void setNumerosTelefonicos(LinkedList numerosTelefonicos) {
        this.numerosTelefonicos = numerosTelefonicos;
    }

    public LinkedList getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(LinkedList redesSociales) {
        this.redesSociales = redesSociales;
    }

    public LinkedList getContactosRelacionados() {
        return contactosRelacionados;
    }

    public void setContactosRelacionados(LinkedList contactosRelacionados) {
        this.contactosRelacionados = contactosRelacionados;
    }
    

}
